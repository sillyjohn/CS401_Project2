package com.example.proj2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proj2.Classes.Champion;
import com.example.proj2.Classes.ChampionViewModel;
import com.example.proj2.databinding.FragmentSecondBinding;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONObject;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Champion currChamp;
    private String ChampionName;
    private RequestQueue queue;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        //ViewModel
        ViewModel viewModel = new ViewModelProvider(this).get(ChampionViewModel.class);
        //Bundle
        Bundle result = getArguments();
        //Fetch to viewmodel
        if (result != null) {
            String championName = result.getString("Name");
            ((ChampionViewModel) viewModel).fetchChampionData(getContext(), championName);
        } else {
            Log.d("Failed", "NULL");
        }
        ((ChampionViewModel) viewModel).getChampion().observe(getViewLifecycleOwner(), champion -> {
            if (champion != null) {
                TextView championNameDisplay = binding.championName;
                TextView championHPDisplay = binding.champHP;
                TextView championManaDisplay = binding.champMana;
                TextView championArmorDisplay = binding.champArmorValue;
                TextView championMRDisplay = binding.champMR;
                TextView championADDisplay = binding.champAD;
                TextView championAPDisplay = binding.champAP;
                TextView championQabDisplay = binding.abilityQ;
                TextView championWabDisplay = binding.abilityW;
                TextView championEabDisplay = binding.abilityE;
                TextView championRabDisplay = binding.abilityR;

                championNameDisplay.setText(champion.getName());
                championHPDisplay.setText(String.valueOf(champion.getBaseHP()));
                championManaDisplay.setText(String.valueOf(champion.getBaseHP()));
                championArmorDisplay.setText(String.valueOf(champion.getBaseArmor()));
                championMRDisplay.setText(String.valueOf(champion.getBaseSpellBlock()));
                championADDisplay.setText(String.valueOf(champion.getBaseDamage()));
                championAPDisplay.setText(String.valueOf(champion.getAp()));
                if (champion != null && champion.getAbilities().size() >= 4) { // Check that all abilities are loaded
                        // Now it's safe to access the abilities by index
                        championQabDisplay.setText(champion.getAbilities().get(0).getName());
                        championWabDisplay.setText(champion.getAbilities().get(1).getName());
                        championEabDisplay.setText(champion.getAbilities().get(2).getName());
                        championRabDisplay.setText(champion.getAbilities().get(3).getName());
                }else if (champion != null && champion.getAbilities().size() == 0){
                    Log.d("Champion ab",String.valueOf(champion.getAbilities().size()));
                }
//                while(true){
//                    if (champion != null && champion.getAbilities().size() >= 4) { // Check that all abilities are loaded
//                        // Now it's safe to access the abilities by index
//                        championQabDisplay.setText(champion.getAbilities().get(0).getName());
//                        championWabDisplay.setText(champion.getAbilities().get(1).getName());
//                        championEabDisplay.setText(champion.getAbilities().get(2).getName());
//                        championRabDisplay.setText(champion.getAbilities().get(3).getName());
//                        break;
//                    }
//                }

                // Update other views based on champion data
            }else{
                Log.d("Failed","failed");
            }
        });

        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.clothingCard.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );


        // Set the click listener for button15
        Button button15 = view.findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                Intent intent = new Intent(getActivity(), Item_selection.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}