package com.example.intent_and_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.intent_and_fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChat.setOnClickListener(view -> {
           handleFragment(new ChatFragment(),"chat");
        });

        binding.btnStatus.setOnClickListener(view -> {
            handleFragment(new StatusFragment(),"status");
        });
    }

    private void handleFragment(Fragment fragment,String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame,fragment,tag)
                .commit();
    }





    // here we set binding = null to avoid causing memory league;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;  // remove binding   (important step)
    }

}

