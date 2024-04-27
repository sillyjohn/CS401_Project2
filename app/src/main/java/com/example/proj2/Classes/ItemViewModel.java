package com.example.proj2.Classes;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * The ItemViewModel class is a ViewModel responsible for managing item data.
 * It provides methods to fetch item data from Firestore, select items.
 */
public class ItemViewModel extends ViewModel {
    private MutableLiveData<Item> selectedItem = new MutableLiveData<>();
    private MutableLiveData<String> itemName = new MutableLiveData<>();
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
     * Gets the LiveData object representing the item name.
     *
     * @return The LiveData object representing the item name
     */
    public LiveData<String> getItemName() {
        return itemName;
    }

    /**
     * Sets the item name.
     *
     * @param info The name of the item to set
     */
    public void setItemName(String info) {
        itemName.setValue(info);
    }
}
