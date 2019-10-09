package com.example.roomdatabase.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.database.AppDatabase;
import com.example.roomdatabase.database.Contact;

public class AddContact extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        button=findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.getDau().addContact(new Contact(name.getText().toString(),email.getText().toString(),0));


                  Toast.makeText(AddContact.this, "Data added", Toast.LENGTH_SHORT).show();
                  email.setText("");
                  name.setText("");
            }
        });


    }
}
