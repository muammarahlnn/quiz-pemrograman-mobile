package com.ardnn.quizmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BiodataActivity extends AppCompatActivity implements View.OnClickListener {

    Animation leftToRight, rightToLeft, topToBottom;
    ImageButton btnBack, btnExit;
    ImageView ivPerson;
    View vCircle;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        leftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        topToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);

        linearLayout = findViewById(R.id.linearLayout);
        ivPerson = findViewById(R.id.iv_person);
        vCircle = findViewById(R.id.v_circle);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnExit = findViewById(R.id.btn_exit_biodata);
        btnExit.setOnClickListener(this);

        btnBack.startAnimation(leftToRight);
        btnExit.startAnimation(rightToLeft);
        linearLayout.startAnimation(topToBottom);
        vCircle.startAnimation(topToBottom);
        ivPerson.startAnimation(topToBottom);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_exit_biodata:
                MainActivity.alertExit(this);
                break;
        }
    }
}