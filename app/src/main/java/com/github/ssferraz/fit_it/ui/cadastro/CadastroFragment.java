package com.github.ssferraz.fit_it.ui.cadastro;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.data.model.Paciente;
import com.github.ssferraz.fit_it.databinding.FragmentCadastroBinding;
import com.google.android.material.snackbar.Snackbar;

public class CadastroFragment extends Fragment {

    FragmentCadastroBinding binding;
    CadastroViewModel viewModel;
    Paciente paciente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CadastroViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentCadastroBinding.bind(view);
        binding.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paciente = new Paciente();
                paciente.setNome(binding.editTextNome.getText().toString());
                paciente.setCidade(binding.editTextCidade.getText().toString());
                paciente.setTelefone(binding.editTextTelefone.getText().toString());
                paciente.setEmail(binding.editTextEmail.getText().toString());
                paciente.setSenha(binding.editTextPassword.getText().toString());
                boolean retorno = viewModel.cadastrarPaciente(paciente);
                if(retorno == true) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Cadastrado com sucesso!", Snackbar.LENGTH_LONG)
                            .setActionTextColor(Color.BLUE)
                            .show();
                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                    navController.navigate(R.id.action_cadastroFragment_to_loginFragment);
                } else{
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Erro ao cadastrar!", Snackbar.LENGTH_LONG)
                            .setActionTextColor(Color.RED)
                            .show();
                }
            }
        });

        binding.textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_cadastroFragment_to_loginFragment);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}