package com.nd.amrhal.mvvmlearning.AAC.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;


import java.util.List;

@TypeConverters(DateConverter.class)
@Dao
public interface NotesDAO {

    @Query("SELECT * FROM note")
    LiveData<List<note>> getNotes();

    @Query("SELECT * FROM note where id = :id")
    note getNotebyId(String id);

    @Insert
    void insert(note item);

    @Delete
    void delete(note item);

}
