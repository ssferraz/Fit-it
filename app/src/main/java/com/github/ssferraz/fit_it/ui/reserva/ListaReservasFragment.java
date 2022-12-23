package com.github.ssferraz.fit_it.ui.reserva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ssferraz.fit_it.R;

public class ListaReservasFragment extends Fragment {

    public static ListaReservasFragment newInstance() {
        ListaReservasFragment fragment = new ListaReservasFragment();
        return fragment;
    }

    public ListaReservasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_reservas, container, false);
    }
}