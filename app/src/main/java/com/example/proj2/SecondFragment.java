package com.example.proj2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
                TextView championNameDisplay = binding.champName;
                championNameDisplay.setText(champion.getName());
                // Update other views based on champion data
            }else{
                Log.d("Failed","failed");
            }
        });



        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}