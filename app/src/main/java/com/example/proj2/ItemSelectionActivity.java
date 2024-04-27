package com.example.proj2;

// Import statements for required Android classes and libraries
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.proj2.Classes.Ability;
import com.example.proj2.Classes.ChampionViewModel;
import com.example.proj2.Classes.Item;
import com.example.proj2.Classes.ItemViewModel;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Defining the ItemSelectionActivity class that extends AppCompatActivity
 */
public class ItemSelectionActivity extends AppCompatActivity {

    // Initialize Firestore database reference
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    /**
     * Sets up the layout and initializes the ViewModel for handling item data.
     *
     * @param savedInstanceState If non-null, this activity is being re-constructed from a previous saved state
     *                           as given here.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selection);

        // Initialize ViewModel for handling item data
        ViewModel viewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        // Find buttons in the layout
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);

        // Observe changes in selected item data
        ((ItemViewModel) viewModel).getSelectedItem().observe(this, item -> {
            // This block of code will execute when the item is fetched successfully
            if (item != null) {
                // Data is available, now finish the Activity to return to the Fragment
                Log.d("Item Fetched!",item.getName());
                finish();
            }
        });

        // Set click listeners for each button to fetch corresponding item data
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Doran's Blade";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Doran's Ring";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Black Cleaver";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Trinity Force";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Hearthbound Axe";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Noonquiver";
                ((ItemViewModel) viewModel).fetchItemData(itemName);
            }
        });
    }
}
