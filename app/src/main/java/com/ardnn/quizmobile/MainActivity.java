package com.ardnn.quizmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Animation leftToRight, rightToLeft, bottomToTop, splashLogo;
    ImageButton btnHome, btnMessage, btnExit;
    ImageView ivLogo;
    TextView tvBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        bottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
        splashLogo = AnimationUtils.loadAnimation(this, R.anim.splash_logo);

        // initialize widget
        btnHome = findViewById(R.id.btn_home);
        btnMessage = findViewById(R.id.btn_message);
        btnExit = findViewById(R.id.btn_exit);
        tvBiodata = findViewById(R.id.tv_biodata);
        ivLogo = findViewById(R.id.iv_logo);

        // set click listener
        btnHome.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        tvBiodata.setOnClickListener(this);

        // run animation
        btnHome.startAnimation(leftToRight);
        btnMessage.startAnimation(rightToLeft);
        btnExit.startAnimation(bottomToTop);
        ivLogo.startAnimation(splashLogo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                Uri homeUri = Uri.parse("google.navigation:q=btn+minasa+upa+blok+ab9/18");
                Intent goToMaps = new Intent(Intent.ACTION_VIEW, homeUri);
                goToMaps.setPackage("com.google.android.apps.maps");
                startActivity(goToMaps);
                break;
            case R.id.btn_message:
                Intent goToSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:08981822289"));
                goToSMS.putExtra("sms_body", "Hai Muammar Ahlan Abimanyu.\nSelamat anda diterima kerja di Google Indonesia!");
                startActivity(goToSMS);
                break;
            case R.id.btn_exit:
                alertExit(this);
                break;
            case R.id.tv_biodata:
                Intent goToBiodata = new Intent(MainActivity.this, BiodataActivity.class);
                startActivity(goToBiodata);
                break;
        }
    }

    public static void alertExit(Activity activity) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Seriuski mau keluar?");

        alertDialog.setPositiveButton("Iye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        alertDialog.setNegativeButton("Ndaji", null);

        alertDialog.show();
    }
}