package com.onlineapteka.testapplication.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.onlineapteka.testapplication.MainActivity;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.util.DateHelper;
import com.yalantis.ucrop.UCrop;

import org.angmarch.views.NiceSpinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageView mProfileImage;
    private EditText mFirstNameEdit;
    private EditText mSecondNameEdit;
    private NiceSpinner mSexSpinner;
    private NiceSpinner mAgeSpinner;
    private Button mVerifyRegisterButton;
    private ProgressBar mProgressBar;
    private RadioGroup mSexRadioGroup;

    private static final String AGE = "age";
    private static final String FIRST_NAME = "name";
    private static final String SECOND_NAME = "second_name";
    private static final String GENDER = "sex";
    private static final String PROFILE = "profileImage";
    private static final String IMAGE_TYPE = "image/*";
    private static final String LOCATION = "avatar/";
    private static final int PICK_CLIENT_IMAGE_CODE = 1;
    private static final String CLIENTS = "clients";
    private static final String TIME = "registrationTime";

    private Uri clientImageUri = null;
    private String gender;
    private String profileImageUri;
    private StorageReference mStorageReference;
    private SharedPreferences.Editor sharedPref;

    private Map<String, Object> clients = new HashMap<>();

    public static void start(Context context){
        Intent intent = new Intent(context,RegistrationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }

    private void initViews() {
//        mSexSpinner = findViewById(R.id.sex_spinner);
        mProfileImage = findViewById(R.id.profile_image);
        mFirstNameEdit = findViewById(R.id.first_name_edit);
        mSecondNameEdit = findViewById(R.id.second_name_edit);
        mSexRadioGroup = findViewById(R.id.radio_sex);
        mAgeSpinner = findViewById(R.id.age_spinner);
        mVerifyRegisterButton = findViewById(R.id.verify_register_button);
        mProgressBar = findViewById(R.id.registry_progress_bar);

        mVerifyRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this,"Pressed",Toast.LENGTH_LONG).show();
                new CountDownTimer(4000,100){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mProgressBar.setVisibility(View.VISIBLE);
                        mVerifyRegisterButton.setClickable(false);
                    }
                    @Override
                    public void onFinish() {
                        initFireBase();
                        saveToFireBase();
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        });


        mProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getClientImageFromStorage();
            }
        });
        initSpinner();
        getDataFromShared();

    }

    private void saveToFireBase() {
        if (mFirstNameEdit.getText().toString().equals("") || mSecondNameEdit.getText().toString().equals("")){
            mFirstNameEdit.setError("Вы не ввели фамилию");
            mSecondNameEdit.setError("Вы не ввели имя");
        }else {
            MainActivity.start(RegistrationActivity.this);
            finish();
        }
    }

    private void initFireBase() {
        getClientSex();
        String age = mAgeSpinner.getSelectedItem().toString().trim();
        String firstName = mFirstNameEdit.getText().toString().trim();
        String secondName = mSecondNameEdit.getText().toString().trim();
        saverToShared(age,firstName,secondName);
        clients.put(AGE,age);
        clients.put(FIRST_NAME,firstName);
        clients.put(SECOND_NAME,secondName);
        clients.put(GENDER,gender);
        clients.put(PROFILE,profileImageUri);

        long time = System.currentTimeMillis();
        clients.put(TIME, DateHelper.convertToDate(String.valueOf(time)));
        String phoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        FirebaseFirestore dataBase = FirebaseFirestore.getInstance();

        dataBase.collection(CLIENTS)
                .document(phoneNumber)
                .set(clients)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    private void saverToShared(String age, String firstName, String secondName) {
        sharedPref = getSharedPreferences(CLIENTS,MODE_PRIVATE).edit();
        sharedPref.putString(AGE,age);
        sharedPref.putString(FIRST_NAME,firstName);
        sharedPref.putString(SECOND_NAME,secondName);
        sharedPref.apply();
    }

    private void getClientImageFromStorage() {
        Intent getImageIntent = new Intent();
        getImageIntent.setType(IMAGE_TYPE);
        getImageIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(getImageIntent, PICK_CLIENT_IMAGE_CODE);
    }

    private void getDataFromShared() {
        SharedPreferences preferences = getSharedPreferences(CLIENTS,MODE_PRIVATE);
        String age = preferences.getString(AGE, null);
        String firstName = preferences.getString(FIRST_NAME, null);
        String secondName = preferences.getString(SECOND_NAME, null);
        mAgeSpinner.setText(age);
        mFirstNameEdit.setText(firstName);
        mSecondNameEdit.setText(secondName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CLIENT_IMAGE_CODE) {
            if (resultCode == RESULT_OK) {
                Uri clientUri = data.getData();
                startCrop(clientUri);
            }
        } else if (requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK) {
            handleCropImage(data);
        }
    }

    private void handleCropImage(Intent data) {
        clientImageUri = UCrop.getOutput(data);
        Glide.with(this)
                .load(clientImageUri)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(mProfileImage);
        compressImageToSaveDataBase();
    }

    private void compressImageToSaveDataBase() {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeFile(profileImageUri);

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), clientImageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 25, bao);
        bitmap.recycle();
        byte[] byteArray = bao.toByteArray();
        uploadClientImageToStorage(byteArray);
    }

    private void uploadClientImageToStorage(byte[] byteArray) {
        mStorageReference = FirebaseStorage.getInstance().getReference(LOCATION);
        if (clientImageUri != null) {
            String number = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
            StorageReference storageReference = mStorageReference.child(number + "." + clientImageExtension(clientImageUri));
            storageReference.putBytes(byteArray)
                    .addOnSuccessListener(taskSnapshot -> {
                        mProgressBar.setVisibility(View.GONE);
                        storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                            if (uri != null) {
                                profileImageUri = uri.toString();
                            } else {
                                Log.d("ololo", "uploadClientImageToStorage: " + uri.toString());
                            }
                        });
                    }).addOnFailureListener(e -> {
                e.getLocalizedMessage();
                Toast.makeText(this, "Не удалось сохранить фото!", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private void startCrop(Uri clientUri) {
        String fileName = "sampleCroping";
        fileName += ".jpg";
        fileName += ".png";
        UCrop uCrop = UCrop.of(clientUri, Uri.fromFile(new File(getCacheDir(), fileName)));
        uCrop.withAspectRatio(1, 1);
        uCrop.withAspectRatio(3, 4);
        uCrop.withAspectRatio(16, 9);
        uCrop.withAspectRatio(2, 3);
        uCrop.withMaxResultSize(900, 900);
        uCrop.withOptions(getOptions());
        uCrop.start(RegistrationActivity.this);
    }


    private UCrop.Options getOptions() {
        UCrop.Options options = new UCrop.Options();
        options.setFreeStyleCropEnabled(true);
        options.setCompressionQuality(70);
        return options;
    }

    private void getClientSex() {
        int radioId = mSexRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);
        gender = radioButton.getText().toString();
    }

    private String clientImageExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap typeMap = MimeTypeMap.getSingleton();
        return typeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private void initSpinner() {
        List<String> sexSet = new LinkedList<>(Arrays.asList("Пол"));

        List<String> dataSet = new LinkedList<>(Arrays.asList("год рождения"));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= 1900; i--) {
            dataSet.add(Integer.toString(i));
        }
        mAgeSpinner.attachDataSource(dataSet);
    }
}