package com.github.ssferraz.fit_it.data.repository;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.github.ssferraz.fit_it.data.model.Clinica;
import com.github.ssferraz.fit_it.data.model.Paciente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class FitItRepository {
    private static FitItRepository fitItRepository;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference documentReference;
    public static Task<QuerySnapshot> docRef;
    public List<Paciente> pacientes = new ArrayList<>();

    public synchronized static FitItRepository getInstance() {
        if (fitItRepository == null) {
            if (fitItRepository == null) {
                fitItRepository = new FitItRepository();
            }
        }
        return fitItRepository;
    }

    public ArrayList<Clinica> getClinicas() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        documentReference = firebaseDatabase.getReference("clinicas");
        ArrayList<Clinica> clinicas = new ArrayList<>();
        documentReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Clinica clinica = dataSnapshot.getValue(Clinica.class);
                    clinicas.add(clinica);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println(error.getMessage());
            }
        });

        return clinicas;
    }

    public void cadastrar(Paciente paciente) {
        db.collection("pacientes")
                .add(paciente)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        pacientes.add(paciente);
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public List<Paciente> getPacientes() {
        MutableLiveData<List<Paciente>> dados = new MutableLiveData<List<Paciente>>();
        docRef =
                db.collection("pacientes")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @SuppressLint("RestrictedApi")
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        Paciente paciente = new Paciente();
                                        paciente.setCidade(document.getString("cidade"));
                                        paciente.setTelefone(document.getString("telefone"));
                                        paciente.setNome(document.getString("nome"));
                                        paciente.setEmail(document.getString("email"));
                                        paciente.setSenha(document.getString("senha"));

                                        pacientes.add(paciente);

                                        Log.d(TAG, document.getId() + " => " + document.getData());

                                    }

                                    dados.setValue(pacientes);
                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());
                                }
                            }
                        });
        return pacientes;
    }

}
