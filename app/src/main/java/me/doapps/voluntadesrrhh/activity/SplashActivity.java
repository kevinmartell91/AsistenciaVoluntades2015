package me.doapps.voluntadesrrhh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.doapps.voluntadesrrhh.R;
import me.doapps.voluntadesrrhh.utils.FontUtil;

/**
 * Created by jonathan on 22/04/2015.
 */
public class SplashActivity extends ActionBarActivity implements View.OnClickListener {
    private TextView textSplash;
    private ImageView imageSplash;
    private LinearLayout linearSplash;
    private EditText txtCode;
    private Button btnCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        textSplash = (TextView) findViewById(R.id.textSplash);
        imageSplash = (ImageView) findViewById(R.id.imageSplash);
        linearSplash = (LinearLayout) findViewById(R.id.linearSplash);
        txtCode = (EditText) findViewById(R.id.txtCode);
        btnCode = (Button) findViewById(R.id.btnCode);

        textSplash.setTypeface(FontUtil.setRalewayExtraBold(this));

        btnCode.setOnClickListener(this);

        startAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txtCode.setVisibility(View.VISIBLE);
                btnCode.setVisibility(View.VISIBLE);
            }
        }, 2100);
    }

    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        linearSplash.clearAnimation();
        linearSplash.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();

        textSplash.clearAnimation();
        imageSplash.clearAnimation();
        textSplash.startAnimation(anim);
        imageSplash.startAnimation(anim);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
