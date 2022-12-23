package com.github.ssferraz.fit_it.ui.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.databinding.FragmentLoginBinding;
import com.github.ssferraz.fit_it.databinding.FragmentMenuBinding;
import com.github.ssferraz.fit_it.ui.clinicas.ListaClinicasFragment;
import com.github.ssferraz.fit_it.ui.home.HomeFragment;
import com.github.ssferraz.fit_it.ui.reserva.ListaReservasFragment;
import com.github.ssferraz.fit_it.ui.settings.SettingsFragment;

public class MenuFragment extends Fragment {

    FragmentMenuBinding binding;

    public MenuFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentMenuBinding.bind(view);
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.menu_search:
                    replaceFragment(new ListaClinicasFragment());
                    break;
                case R.id.menu_reserva:
                    replaceFragment(new ListaReservasFragment());
                    break;
                case R.id.menu_configuracao:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

}