package com.github.ssferraz.fit_it.data.repository;

import androidx.annotation.NonNull;

import com.github.ssferraz.fit_it.data.model.Clinica;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FitItRepository {
    private static FitItRepository fitItRepository;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference documentReference;

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
        ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
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

}
