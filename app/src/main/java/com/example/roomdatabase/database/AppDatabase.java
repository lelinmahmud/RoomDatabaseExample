package com.example.roomdatabase.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Contact.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract MyDao getDau();
}
