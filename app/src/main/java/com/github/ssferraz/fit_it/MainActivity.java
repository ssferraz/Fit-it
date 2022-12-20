package com.github.ssferraz.fit_it;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.ssferraz.fit_it.databinding.ActivityMainBinding;
import com.github.ssferraz.fit_it.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //LoginFragment fragmento = new LoginFragment();
        //getSupportFragmentManager().beginTransaction().add(R.id.container_fragment, fragmento).commit();

    }
}