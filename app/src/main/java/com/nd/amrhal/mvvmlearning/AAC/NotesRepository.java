package com.nd.amrhal.mvvmlearning.AAC;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.nd.amrhal.mvvmlearning.AAC.data.NotesDAO;
import com.nd.amrhal.mvvmlearning.AAC.data.NotesDatabase;
import com.nd.amrhal.mvvmlearning.AAC.data.note;

import java.util.List;

public class NotesRepository {
    private static NotesRepository instance;
    private static NotesDAO mNotesDAO;
    private static LiveData<List<note>> mAllNotes;

    private NotesRepository() {

    }

    public static NotesRepository getInstance(Application application) {
        if ( instance == null) {
            instance = new NotesRepository();
            NotesDatabase db = NotesDatabase.getInstance(application);
            mNotesDAO = db.notesDAO();
            mAllNotes = mNotesDAO.getNotes();

            Log.e("Tag", "instantiate NotesRepository");
        }
        return instance;
    }


    public LiveData<List<note>> getmAllNotes() {
        return mAllNotes;
    }

    public void insert(note note) {
        new insertAsyncTask(mNotesDAO).execute(note);
    }

    private static class insertAsyncTask extends AsyncTask<note, Void, Void> {
        NotesDAO mNotesDAO;

        public insertAsyncTask(NotesDAO mNotesDAO) {
            this.mNotesDAO = mNotesDAO;
        }

        @Override
        protected Void doInBackground(note... notes) {
            mNotesDAO.insert(notes[0]);
            return null;
        }
    }
}