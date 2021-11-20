package com.example.sem14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LaLista extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText tarea;
    private EditText explicacion;
    private Button agregar;
    private Button actu;
    private String silly;
    private ListView wawic;
    private ArrayList<Task> taskes;
    private TareasAdap leSecu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_lista);

        tarea = findViewById(R.id.TAREA);
        explicacion = findViewById(R.id.EXP);
        agregar = findViewById(R.id.AGRE);
        actu =findViewById(R.id.ACTUALIZAR);
        wawic = findViewById(R.id.LIST);
        taskes = new ArrayList<Task>();
        leSecu = new TareasAdap(this, taskes);
        wawic.setAdapter(leSecu);

        wawic.setOnItemClickListener((lista, item, indice, duracion) -> {
            Task T = this.taskes.get(indice);
            Toast.makeText(this, "lo mando: " + T.getCreator(), Toast.LENGTH_SHORT).show();
        });

        db = FirebaseDatabase.getInstance();
        silly = getIntent().getExtras().getString("user");


        agregar.setOnClickListener((view) -> {

            DatabaseReference task = db.getReference("task");
            DatabaseReference newTask = task.push();
            Task tasque = new Task(
                    tarea.getText().toString(),
                    explicacion.getText().toString(),
                    silly,
                    newTask.getKey(),
                    "pendiente"
            );
            mirarusuarios();
            newTask.setValue(tasque);
        });
        actu.setOnClickListener((view)->{
            mirarusuarios();
        });
        mirarusuarios();
    }

    public void mirarusuarios() {
        DatabaseReference tareasRef = db.getReference("task");
        tareasRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot taskes) {
                actualizar(taskes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void actualizar(DataSnapshot taskes) {

        this.taskes.clear();

        for (DataSnapshot dataSnapshot : taskes.getChildren()) {
            Task op = dataSnapshot.getValue(Task.class);
            this.taskes.add(op);
            leSecu.notifyDataSetChanged();
        }
    }
}