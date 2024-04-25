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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChampionViewModel extends ViewModel {
    private MutableLiveData<Champion> championData = new MutableLiveData<>();
    private RequestQueue queue;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    enum qwer{Qability,Wability,Eability,Rability};
    public LiveData<Champion> getChampion() {
        return championData;
    }
    public void fetchChampionAbility(String championName, Champion champ){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        for(int i =0; i<4;i++){
            String abilitySlot = "";
            switch (i){
                case 0:
                    abilitySlot = "Qability";
                    break;
                case 1:
                    abilitySlot = "Wability";
                    break;
                case 2:
                    abilitySlot = "Eability";
                    break;
                case 3:
                    abilitySlot = "Rability";
                    break;
                default:
                    break;
            }

            //Getting data from database
            DocumentReference docRef = db.collection("championAbility")
                    .document(championName).collection(abilitySlot).document("data");

            // Asynchronously retrieve the document
            docRef.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        // Log the document snapshot data
                        Log.d("Print", "DocumentSnapshot data: " + document.getData());

                        // Convert the document snapshot to Ability object
                        Ability ability = document.toObject(Ability.class);

                        if (ability != null) {
                            // Since we only fetched Qability, let's add it to a new list of abilities
                            ArrayList<Ability> abilities = new ArrayList<>();
                            abilities.add(ability);

                            // Set the abilities in the Champion object
                            champ.setAbilities(abilities);

                            // For debugging, log the name of the ability and the damage array
                            Log.d("Ability", "Name: " + ability.getName());
                            Log.d("Ability", "Damage: " + ability.getDamage().toString());
                        } else {
                            Log.d("Firestore Conversion", "Failed to convert document to Ability object.");
                        }
                    } else {
                        Log.d("Firestore Fetch", "No such document");
                    }
                } else {
                    Log.d("Firestore Fetch", "get failed with ", task.getException());
                }
            });
        }

    }
    public void fetchChampionAbilities(String championName, Champion champ) {

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
                        ArrayList<Ability> abilities = new ArrayList<>();
                        final int[] abilitiesFetchedCount = {0};

                        for (qwer abilitySlot : qwer.values()) {
                            String collectionPath = abilitySlot.toString();
                            DocumentReference docRef = db.collection("championAbility")
                                    .document(championName.replaceAll("\\s", "").toLowerCase()).collection(collectionPath).document("data");

                            docRef.get().addOnCompleteListener(task -> {
                                abilitiesFetchedCount[0]++;
                                if (task.isSuccessful() && task.getResult().exists()) {
                                    Ability ability = task.getResult().toObject(Ability.class);
                                    if (ability != null) {
                                        Log.d("Ability added", "Name: " + ability.getName());
                                        abilities.add(ability);
                                    }
                                } else {
                                    Log.d("Firestore Fetch", "Error fetching ability: " + collectionPath, task.getException());
                                }

                                if (abilitiesFetchedCount[0] == qwer.values().length) {
                                    Log.d("Ability post", "Posted");
                                    champ.setAbilities(abilities);
                                    championData.postValue(champ);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );
        queue.add(stringRequest);
    }
}
