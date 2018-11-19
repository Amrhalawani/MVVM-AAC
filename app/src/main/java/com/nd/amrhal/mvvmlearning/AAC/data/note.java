package com.nd.amrhal.mvvmlearning.AAC.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String body;
    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "ModifiedDate")
    private Date date;

    public note(String title, String body, Date date) {
        this.title = title;
        this.body = body;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

