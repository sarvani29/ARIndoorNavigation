package com.ustglobal.arcloudanchors;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    public static final String FROM = "from";
    public static final String MODE = "mode";
    public static final String APARTMENT28 = "Apartment28";
    public static final String APARTMENT30 = "Apartment30";
    public String userMode = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_activiy);
        //For background animation
        ConstraintLayout layout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        ImageButton settingsBtn = findViewById(R.id.settings_btn);
        settingsBtn.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getApplicationContext(), v);
            popup.getMenuInflater().inflate(R.menu.menu_main ,popup.getMenu());
            popup.setOnMenuItemClickListener(LauncherActivity.this::onMenuItemClick);
            popup.show();
        });

        ImageButton apartment28Btn = findViewById(R.id.Apartment28_btn);
        ImageButton apartment30Btn = findViewById(R.id.Apartment30_btn);
        apartment28Btn.setOnClickListener(this);
        apartment28Btn.setOnClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                userMode = "user";
                return true;
            case R.id.item2:
                userMode = "admin";
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Apartment28_btn:
                goToCameraActivity(APARTMENT28);
                break;
            case R.id.Apartment30_btn:
                goToCameraActivity(APARTMENT30);
                break;

        }
    }

    private void goToCameraActivity(String Section) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra(FROM, Section);
        i.putExtra(MODE,userMode);
        startActivity(i);
    }
}
