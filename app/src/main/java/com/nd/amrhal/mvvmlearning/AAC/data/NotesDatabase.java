package com.nd.amrhal.mvvmlearning.AAC.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;


@Database(entities = {note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDAO notesDAO();

    private static NotesDatabase instance;

    public static NotesDatabase getInstance(Context context){
        if(instance ==null){
            instance = Room.databaseBuilder(context,NotesDatabase.class,"note_db").build();
            Log.e("Tag","instantiate room database");
        }
            return instance;
    }

}
