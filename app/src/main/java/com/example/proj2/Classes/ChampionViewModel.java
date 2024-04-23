package com.example.proj2.Classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import android.content.Context;

import java.io.File;

public class ChampionViewModel extends ViewModel {
    private MutableLiveData<Champion> championData = new MutableLiveData<>();
    private RequestQueue queue;

    public LiveData<Champion> getChampion() {
        return championData;
    }

    public void fetchChampionData(Context context, String championName) {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }
        String urlTemplate = "https://raw.communitydragon.org/14.5/game/data/characters/";
        String urlInsert = championName.replaceAll("\\s", "").toLowerCase();
        String actualURL = urlTemplate + urlInsert + "/" + urlInsert + ".bin.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, actualURL,
                response -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode rootNode = objectMapper.readTree(response);
                        String pathName = "Characters/" + championName + "/CharacterRecords/Root";
                        Champion champ = new Champion(
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
                        championData.postValue(champ);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );
        queue.add(stringRequest);
    }
}
