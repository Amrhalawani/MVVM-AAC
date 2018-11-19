package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nd.amrhal.mvvmlearning.AAC.data.note;
import com.nd.amrhal.mvvmlearning.R;

import java.util.ArrayList;
import java.util.Date;

public class NotesActivity extends AppCompatActivity {
    // https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0

    ArrayList<note> noteArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        noteArrayList = new ArrayList<>();
        noteArrayList.add(new note("Hello", "lorem ipsemem ipselorem mlorem em ipsem", new Date()));
        noteArrayList.add(new note("Main Cycle", "lorem ipsemem ipselorem mlorem em ipsem", new Date()));
        noteArrayList.add(new note("Recycle", "lorem ipsemem ipselorem mlorem em ipsemm ipselorem " +
                "mlorem em ipsemm ipselorem mlorem em ipsemm ipselorem mlorem em ipsemm ipselorem" +
                " mlorem em ipsem", new Date()));

        final NotesAdapter adapter = new NotesAdapter(noteArrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.updateList(noteArrayList);

    }

    public void add(View view) {
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }


}
