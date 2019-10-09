package com.example.roomdatabase.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface MyDao {

    @Insert
    public void addContact(Contact contact);


//    @Update
//    public void updateContact(Contact contact);
//
//    @Delete
//    public void deleteContact(Contact contact);
//
    @Query("select * from contacts")
    public List<Contact> getAllcontact();
//
//
//    @Query("select * from contacts where id==:idContact")
//    public Contact getSingleContact(String idContact);
}
