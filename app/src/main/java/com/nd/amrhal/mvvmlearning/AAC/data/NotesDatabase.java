package com.nd.amrhal.mvvmlearning.AAC.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Date;


@Database(entities = {note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDAO notesDAO();

    private static NotesDatabase instance;

    public static NotesDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, NotesDatabase.class, "note_db").addCallback(sRoomDatabaseCallback).build();
            Log.e("Tag", "instantiate room database");
        }
        return instance;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(instance).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final NotesDAO mDao;

        PopulateDbAsync(NotesDatabase db) {
            mDao = db.notesDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            note mnote = new note("Hello Room", "this is first test of this db", new Date());
            mDao.insert(mnote);
            mnote = new note("Hello Room2", "this is sec test of this db", new Date());
            mDao.insert(mnote);
            return null;
        }
    }
}
