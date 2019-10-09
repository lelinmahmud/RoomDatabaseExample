package com.example.roomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.database.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Holer> {

    private List<Contact> contactList;
    private Context context;

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_recylerview,parent,false);

        return new Holer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holer holder, int position) {

        holder.phone.setText(contactList.get(position).getName());
        holder.email.setText(contactList.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class Holer extends RecyclerView.ViewHolder {
        TextView email,phone;
        public Holer(@NonNull View itemView) {
            super(itemView);

            email=itemView.findViewById(R.id.emailRecid);
            phone=itemView.findViewById(R.id.nameRecId);
        }
    }
}
