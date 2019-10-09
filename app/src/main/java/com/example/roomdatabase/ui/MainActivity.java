package com.example.roomdatabase.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.adapter.ContactAdapter;
import com.example.roomdatabase.database.AppDatabase;
import com.example.roomdatabase.database.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private FloatingActionButton button;
    private String email;
    private String name;
    private String m_Text2 = "";
    public static AppDatabase database;
    private RecyclerView recyclerView;
    private List<Contact> contactList;
    ContactAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button=findViewById(R.id.addContact);
        recyclerView=findViewById(R.id.recyclerviewId);
        recyclerView.setHasFixedSize(true);
        contactList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        database= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"contactdb").allowMainThreadQueries().build();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddContact.class));
                //database.getDau().addContact(new Contact("lelin","lein@gmail.com",1));
                //Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();

            }
        });


        contactList=database.getDau().getAllcontact();
        adapter=new ContactAdapter(contactList,MainActivity.this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item,menu);

        return true;
    }



}
