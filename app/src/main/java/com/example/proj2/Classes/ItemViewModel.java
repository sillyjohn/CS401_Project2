package com.example.proj2.Classes;

import android.util.Log;
import android.widget.ImageButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * The ItemViewModel class is a ViewModel responsible for managing item data.
 * It provides methods to fetch item data from Firestore, select items.
 */
public class ItemViewModel extends ViewModel {
    private MutableLiveData<Item> selectedItem = new MutableLiveData<>();
    private MutableLiveData<Integer> slot = new MutableLiveData<>();
    private MutableLiveData<Map<Integer, Integer>> slotResourceMap = new MutableLiveData<>(new HashMap<>());

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    /**
     * Fetches item data from Firestore based on the given item name.
     *
     * @param itemName The name of the item to fetch
     */
    public void fetchItemData(String itemName) {
        DocumentReference docRef = db.collection("Items").document(itemName);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult().exists()) {
                Item item = task.getResult().toObject(Item.class);
                selectedItem.postValue(item); // Assume selectedItem is LiveData in ViewModel
            } else {
                Log.d("Error", "No such item found");
            }
        });
    }

    /**
     * Gets the LiveData object representing the selected item.
     *
     * @return The LiveData object representing the selected item
     */
    public LiveData<Item> getSelectedItem() {
        return selectedItem;
    }

    /**
     * Sets the selected item.
     *
     * @param item The item to be selected
     */
    public void selectItem(Item item) {
        Log.d("Posted","Yes");
        selectedItem.postValue(item);
    }

    /**
     * Gets the LiveData object representing the ImageButton.
     *
     * @return The LiveData object representing the ImageButton's ID
     */
    public LiveData<Integer> getSlot() {
        return slot;
    }

    /**
     * Sets the item name.
     *
     * @param btnID The ImageButton's ID to set
     */
    public void setSlot(int btnID) {
        slot.postValue(btnID);
    }
    public void setItemImageResource(int slotId, int resourceId) {
        Map<Integer, Integer> currentMap = slotResourceMap.getValue();
        if (currentMap == null) {
            currentMap = new HashMap<>();
        }
        currentMap.put(slotId, resourceId);
        slotResourceMap.setValue(currentMap);
    }

    public LiveData<Map<Integer, Integer>> getSlotResourceMap() {
        return slotResourceMap;
    }
}
