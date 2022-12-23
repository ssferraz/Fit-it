package com.github.ssferraz.fit_it.ui.cadastro;

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
import androidx.navigation.fragment.NavHostFragment;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.data.model.Paciente;
import com.github.ssferraz.fit_it.databinding.FragmentCadastroBinding;

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

                    NavHostFragment finalHost = NavHostFragment.create(R.navigation.menu_nav_graph);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, finalHost)
                            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
                            .commit();
                    //NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                    //navController.navigate(R.id.menu_home);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}