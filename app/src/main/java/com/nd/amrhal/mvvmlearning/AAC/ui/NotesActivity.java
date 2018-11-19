package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.nd.amrhal.mvvmlearning.R;

public class NotesActivity extends AppCompatActivity {
    // https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Notes);
    }

    public void add(View view) {
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }
}
