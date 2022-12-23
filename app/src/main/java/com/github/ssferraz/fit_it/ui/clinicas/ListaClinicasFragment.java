package com.github.ssferraz.fit_it.ui.clinicas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.ui.settings.SettingsFragment;

public class ListaClinicasFragment extends Fragment {

    public static ListaClinicasFragment newInstance() {
        ListaClinicasFragment fragment = new ListaClinicasFragment();
        return fragment;
    }

    public ListaClinicasFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_clinicas, container, false);
    }
}