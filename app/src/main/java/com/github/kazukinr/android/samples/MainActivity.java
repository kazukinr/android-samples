package com.github.kazukinr.android.samples;

import com.github.kazukinr.android.samples.level_list_animated_vector.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.levelListAnimatedVector)
    void toLevelListAnimatedVector() {
        startActivity(new Intent(this, Activity.class));
    }
}
