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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        //Get Argument From Frag 1
        Bundle result = getArguments();
        if(result != null){
            this.ChampionName = result.getString("Name");
            Log.d("Succeed",ChampionName);
        }else{
            Log.d("Failed","NULL");
        }
        createChampionObject();

        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Change ChampionName TV
        TextView championNameDisplay = getView().findViewById(R.id.champName);
        championNameDisplay.setText(ChampionName);
        //Log.d("Testing2",currChamp.getName());
        //Return button
        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );


    }
    public void createChampionObject(){
        //Base Template
        String urlTemplate = "https://raw.communitydragon.org/14.5/game/data/characters/";
        //Modify string for URL usage
        String urlInsert = ChampionName.replaceAll("\\s", "").toLowerCase();
        String actualURL = urlTemplate+urlInsert+"/"+urlInsert+".bin.json";
        queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, actualURL,
                response -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode rootNode = objectMapper.readTree(response);
                        String pathName = "Characters/" + ChampionName + "/CharacterRecords/Root";
                        currChamp = new Champion(
                                rootNode.path(pathName).path("mCharacterName").asText(),
                                rootNode.path(pathName).path("baseHP").asDouble(),
                                rootNode.path(pathName).path("hpPerLevel").asDouble(),
                                rootNode.path(pathName).path("baseDamage").asDouble(),
                                rootNode.path(pathName).path("damagePerLevel").asDouble(),
                                rootNode.path(pathName).path("baseArmor").asDouble(),
                                rootNode.path(pathName).path("armorPerLevel").asDouble(),
                                rootNode.path(pathName).path("baseSpellBlock").asDouble(),
                                rootNode.path(pathName).path("spellBlockPerLevel").asDouble(),
                                rootNode.path(pathName).path("baseMoveSpeed").asDouble(),
                                rootNode.path(pathName).path("attackSpeed").asDouble(),
                                rootNode.path(pathName).path("attackSpeedRatio").asDouble(),
                                rootNode.path(pathName).path("attackSpeedPerLevel").asDouble()
                        );
                        Log.d("Testing",currChamp.getName());
                        // Handle UI updates or further processing here
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    error.printStackTrace();
                });
        //Log.d("Testing2",currChamp.getName());
        queue.add(stringRequest);
        Log.d("Succeed","Succeed");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}