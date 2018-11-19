package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.nd.amrhal.mvvmlearning.AAC.NotesRepository;
import com.nd.amrhal.mvvmlearning.AAC.data.note;

import java.util.List;


public class NotesViewModel extends AndroidViewModel {
    NotesRepository mNoteRepository;
    private LiveData<List<note>> mAllNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        mNoteRepository = new NotesRepository(application);
        mAllNotes = mNoteRepository.getmAllNotes();
    }

    LiveData<List<note>> getAllNotes() {
        return mAllNotes;
    }

    public void insert(note mNote) {
        mNoteRepository.insert(mNote);
    }
}
