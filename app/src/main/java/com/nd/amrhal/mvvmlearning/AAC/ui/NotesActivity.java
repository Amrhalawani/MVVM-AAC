package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.nd.amrhal.mvvmlearning.AAC.data.note;
import com.nd.amrhal.mvvmlearning.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesActivity extends AppCompatActivity {
    // https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0

    ArrayList<note> noteArrayList;
    NotesAdapter adapter;
    private NotesViewModel mNotesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setupRecyclerView();
        setupDatabase();

    }

    private void setupDatabase() {
        mNotesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        mNotesViewModel.getAllNotes().observe(this, new Observer<List<note>>() {
            @Override
            public void onChanged(@Nullable List<note> notes) {
                adapter.updateList(notes);
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        noteArrayList = new ArrayList<>();
//        noteArrayList.add(new note("Hello", "lorem ipsemem ipselorem mlorem em ipsem", new Date()));
//        noteArrayList.add(new note("Main Cycle", "lorem ipsemem ipselorem mlorem em ipsem", new Date()));
//        noteArrayList.add(new note("Recycle", "lorem ipsemem ipselorem mlorem em ipsemm ipselorem " +
//                "mlorem em ipsemm ipselorem mlorem em ipsemm ipselorem mlorem em ipsemm ipselorem" +
//                " mlorem em ipsem", new Date()));

        adapter = new NotesAdapter(noteArrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.updateList(noteArrayList);

    }

    public void add(View view) {
        Intent intent = new Intent(this, addActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            note note1 = new note(data.getStringExtra(addActivity.EXTRA_REPLY_TITLE)
                    ,data.getStringExtra(addActivity.EXTRA_REPLY_BODY)
                    ,new Date());
            mNotesViewModel.insert(note1);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Not Saved",
                    Toast.LENGTH_LONG).show();
        }
    }


}
