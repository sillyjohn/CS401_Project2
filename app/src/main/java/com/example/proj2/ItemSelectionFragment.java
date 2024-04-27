package com.example.proj2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.proj2.Classes.ChampionViewModel;
import com.example.proj2.Classes.ItemViewModel;
import com.example.proj2.databinding.FragmentItemSelectionBinding;
import com.example.proj2.databinding.FragmentSecondBinding;

/**
 * Fragment allowing users to select items.
 */
public class ItemSelectionFragment extends Fragment {
    private FragmentItemSelectionBinding binding;

    /**
     * Creates a new instance of the ItemSelectionFragment.
     *
     * @return A new instance of ItemSelectionFragment.
     */
    public static ItemSelectionFragment newInstance() {
        return new ItemSelectionFragment();
    }

    /**
     * Inflates the layout of the fragment and initializes the ViewModel for handling item data.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state
     *                           as given here.
     * @return The root view of the inflated layout.
     */
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentItemSelectionBinding.inflate(inflater, container, false);
        //Log.d("item selection","fragment");
        //ViewModels
        // Use requireActivity() to ensure the ViewModel is scoped to the host activity
        ItemViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);


        // Set the click listener for items
        Button item1button = binding.button1;
//        ImageButton item2button = view.findViewById(R.id.button2);
//        ImageButton item3button = view.findViewById(R.id.button3);
//        ImageButton item4button = view.findViewById(R.id.button4);
//        ImageButton item5button = view.findViewById(R.id.button5);
//        ImageButton item6button = view.findViewById(R.id.button6);


//        item1button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String itemName = "Doran's Blade";
//                itemViewModel.fetchItemData(itemName);
//            }
//        });

        return binding.getRoot();
    }

    /**
     * Sets up UI elements and click listeners for item selection.
     *
     * @param view               The root view of the fragment's layout.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state
     *                           as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("item selection","fragment");
        //ViewModels
        // Use requireActivity() to ensure the ViewModel is scoped to the host activity
        ItemViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

// Set the click listener for items
        Button item1button = view.findViewById(R.id.button1);;
        Button item2button = view.findViewById(R.id.button2);
        Button item3button = view.findViewById(R.id.button3);
        Button item4button = view.findViewById(R.id.button4);
        Button item5button = view.findViewById(R.id.button5);
        Button item6button = view.findViewById(R.id.button6);


        item1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Doran's Blade";
                Log.d("item selection","Doran's Blade");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();
            }
        });
        item2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Doran's Ring";
                Log.d("item selection","Doran's Ring");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();            }
        });
        item3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Black Cleaver";
                Log.d("item selection","Doran's Ring");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();
            }
        });
        item4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Trinity Force";
                Log.d("item selection","Trinity Force");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();
            }
        });
        item5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Hearthbound Axe";
                Log.d("item selection","Hearthbound Axe");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();
            }
        });
        item6button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Noonquiver";
                Log.d("item selection","Noonquiver");
                itemViewModel.fetchItemData(itemName);
                NavHostFragment.findNavController(ItemSelectionFragment.this)
                        .popBackStack();
            }
        });


    }


}