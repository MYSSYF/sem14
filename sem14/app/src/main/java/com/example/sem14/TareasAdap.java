package com.example.sem14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.HashMap;

public class TareasAdap extends ArrayAdapter {
    private String nose;

    public TareasAdap(Context context, ArrayList<Task> taskes) {
        super(context, 0, taskes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task task = (Task) getItem(position);

        LayoutInflater vore = LayoutInflater.from(getContext());
        convertView = vore.inflate(R.layout.content, parent, false);

        TextView TITULO = convertView.findViewById(R.id.TAR);
        TextView DESCRIP = convertView.findViewById(R.id.DESC);
        TextView ESTATE = convertView.findViewById(R.id.EST);
        Button DEAD = convertView.findViewById(R.id.ELI);
        Button AVAN = convertView.findViewById(R.id.B_EST);
        nose = "COMPLETADA";

        DEAD.setOnClickListener((view) -> {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference lidtarea = db.getReference("task/" + task.getId());
            DatabaseReference lidtarea2 = db.getReference("task/" + task.getProgreso());

            lidtarea.setValue(null);
            lidtarea2.setValue(null);
        });

        AVAN.setOnClickListener((view) -> {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference lidtarea = db.getReference("task/" + task.getId());
            HashMap mope = new HashMap();
            mope.put("progreso", nose);
            lidtarea.updateChildren(mope).addOnSuccessListener(o -> Toast.makeText(getContext(), "KEY GEN *SONIDOS DE CELEBRACION*", Toast.LENGTH_SHORT).show());
        });

        TITULO.setText(task.getTask_name());
        DESCRIP.setText(task.getTask_desc());
        ESTATE.setText(task.getProgreso());


        return convertView;
    }
}
