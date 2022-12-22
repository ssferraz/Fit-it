package com.github.ssferraz.fit_it.ui.login;

import androidx.lifecycle.ViewModel;

import com.github.ssferraz.fit_it.data.model.Paciente;
import com.github.ssferraz.fit_it.data.repository.FitItRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {

    static Paciente loggedPaciente;
    FitItRepository repository = FitItRepository.getInstance();

    public boolean logar(Paciente paciente){
        List<Paciente> pacientes = recuperarPacientes();
        for(Paciente p: pacientes){
            if(p.getEmail().equals(paciente.getEmail()) && p.getSenha().equals(paciente.getSenha())){
                loggedPaciente = p;
                return true;
            }
        }
        return false;
    }
    public List<Paciente> recuperarPacientes(){
        return repository.getPacientes();
    }
    public Paciente getLoggedPaciente(){
        return this.loggedPaciente;
    }

}
