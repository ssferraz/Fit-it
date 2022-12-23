package com.github.ssferraz.fit_it.ui.cadastro;

import androidx.lifecycle.ViewModel;

import com.github.ssferraz.fit_it.data.model.Paciente;
import com.github.ssferraz.fit_it.data.repository.FitItRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroViewModel extends ViewModel {

    Paciente paciente;
    FitItRepository repository = FitItRepository.getInstance();


    public boolean cadastrarPaciente(Paciente paciente){
        if(validaEmail(paciente.getEmail()) && paciente.getSenha() != null && paciente.getSenha().length() > 0 && validaNome(paciente.getNome())){
           repository.cadastrar(paciente);
            return true;
        }
        return false;
    }
    public boolean validaNome(String nome) {
        boolean valido = false;
        if (nome != null && nome.length() > 0) {
            if (nome.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$")) {
                valido = true;
            }
        }
        return valido;
    }
    public boolean validaEmail(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                valido = true;
            }
        }
        return valido;
    }

}

