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
import com.example.proj2.databinding.FragmentSecondBinding;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String ChampionName;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        //Get Argument From Frag 1
        Bundle result = getArguments();
        if(result != null){
            this.ChampionName = result.getString("Name");
            Log.d("Succeed",ChampionName);
        }else{
            Log.d("Failed","NULL");
        }

        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Change ChampionName TV
        TextView championNameDisplay = getView().findViewById(R.id.champName);
        championNameDisplay.setText(ChampionName);
        //createChampion();
        //Return button
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