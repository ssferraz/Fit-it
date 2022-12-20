package com.github.ssferraz.fit_it.ui.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ssferraz.fit_it.R;
import com.github.ssferraz.fit_it.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {

    FragmentMenuBinding binding;
    NavHostFragment navHostFragment;
    NavController navController;

    public MenuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initNavigation();
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    private void initNavigation(){
        navHostFragment = (NavHostFragment) getParentFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
    }
}