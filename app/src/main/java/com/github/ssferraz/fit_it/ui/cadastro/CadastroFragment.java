package com.github.ssferraz.fit_it.ui.cadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.databinding.FragmentCadastroBinding;

public class CadastroFragment extends Fragment {

    FragmentCadastroBinding binding;

    public CadastroFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}