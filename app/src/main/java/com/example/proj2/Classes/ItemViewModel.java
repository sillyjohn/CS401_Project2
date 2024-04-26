package com.example.proj2.Classes;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ItemViewModel extends ViewModel {
    private MutableLiveData<Item> selectedItem = new MutableLiveData<>();
    private MutableLiveData<String> itemName = new MutableLiveData<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

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
    public LiveData<Item> getSelectedItem() {
        return selectedItem;
    }

    public void selectItem(Item item) {
        Log.d("Posted","Yes");
        selectedItem.postValue(item);
    }

    public LiveData<String> getItemName() {
        return itemName;
    }

    public void setItemName(String info) {
        itemName.setValue(info);
    }
}
