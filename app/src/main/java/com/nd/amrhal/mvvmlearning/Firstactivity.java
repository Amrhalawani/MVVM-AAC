package com.nd.amrhal.mvvmlearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nd.amrhal.mvvmlearning.databinding.ActivityFirstactivityBinding;
import com.nd.amrhal.mvvmlearning.mvvmwithrecycler.MainActivity;

public class Firstactivity extends AppCompatActivity {
    ActivityFirstactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_firstactivity);
        binding.textview.setText("This just to test databinding lib and mvvm arch design");

    }

    public void btn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "buttton pressed", Toast.LENGTH_SHORT).show();
    }
}
