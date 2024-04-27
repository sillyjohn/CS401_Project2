package com.example.proj2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proj2.Classes.Champion;
import com.example.proj2.Classes.ChampionViewModel;
import com.android.volley.RequestQueue;
import com.example.proj2.Classes.Item;
import com.example.proj2.Classes.ItemViewModel;
import com.example.proj2.databinding.FragmentSecondBinding;

/**
 * Defining the SecondFragment class that extends Fragment
 */
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private static final int ITEM_REQUEST = 1;

    /**
     * Inflates the layout of the fragment and sets up the ViewModel to fetch and display champion data.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state
     *                           as given here.
     * @return The root view of the inflated layout.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        //ViewModel
        ViewModel viewModel = new ViewModelProvider(this).get(ChampionViewModel.class);
        ViewModel itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        ImageButton item1button = binding.item1;
//        ImageButton item2button = view.findViewById(R.id.item2);
//        ImageButton item3 = view.findViewById(R.id.item3);
//        ImageButton item4 = view.findViewById(R.id.item4);
//        ImageButton item5 = view.findViewById(R.id.item5);
//        ImageButton item6 = view.findViewById(R.id.item6);
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
                //Find TV
                TextView championNameDisplay = binding.championName;
                TextView championHPDisplay = binding.champHP;
                TextView championManaDisplay = binding.champMana;
                TextView championArmorDisplay = binding.champArmorValue;
                TextView championMRDisplay = binding.champMR;
                TextView championADDisplay = binding.champAD;
                TextView championAPDisplay = binding.champAP;
                TextView championQabDisplay = binding.abilityQ;
                TextView championWabDisplay = binding.abilityW;
                TextView championEabDisplay = binding.abilityE;
                TextView championRabDisplay = binding.abilityR;
                //Find ImageBTN
                ImageView icon = binding.champIcon;
                //Modify path name
                String imageName = champion.getName().replaceAll("\\s", "").toLowerCase();
                int resourceId = getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
                //Set ImageView
                icon.setImageResource(resourceId);
                //Set TVs
                championNameDisplay.setText(champion.getName());
                championHPDisplay.setText(String.valueOf(champion.getBaseHP()));
                championManaDisplay.setText(String.valueOf(champion.getBaseHP()));
                championArmorDisplay.setText(String.valueOf(champion.getBaseArmor()));
                championMRDisplay.setText(String.valueOf(champion.getBaseSpellBlock()));
                championADDisplay.setText(String.valueOf(champion.getBaseDamage()));
                championAPDisplay.setText(String.valueOf(champion.getAp()));
                if (champion != null && champion.getAbilities().size() >= 4) { // Check that all abilities are loaded
                        // Now it's safe to access the abilities by index
                        championQabDisplay.setText(champion.getAbilities().get(0).getName());
                        championWabDisplay.setText(champion.getAbilities().get(1).getName());
                        championEabDisplay.setText(champion.getAbilities().get(2).getName());
                        championRabDisplay.setText(champion.getAbilities().get(3).getName());
                }else if (champion != null && champion.getAbilities().size() == 0){
                    Log.d("Champion ab",String.valueOf(champion.getAbilities().size()));
                }
            }else{
                Log.d("Failed","failed");
            }
        });



        return binding.getRoot();
    }

    /**
     * Sets up the UI elements and listeners after the view has been created.
     *
     * @param view               The root view of the fragment's layout.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state
     *                           as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //ViewModels
        ViewModel viewModel = new ViewModelProvider(this).get(ChampionViewModel.class);
        // Use requireActivity() to ensure the ViewModel is scoped to the host activity
        ItemViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        itemViewModel.getSelectedItem().observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                int resourceId = getResources().getIdentifier(item.getPngName(), "drawable", getContext().getPackageName());
//                int buttonId = getResources().getIdentifier()
                binding.item1.setImageResource(resourceId);
            }
        });
        // Set the click listener for items
        Button button15 = view.findViewById(R.id.button15);
        ImageButton item1button = view.findViewById(R.id.item1);
        ImageButton item2button = view.findViewById(R.id.item2);
        ImageButton item3button = view.findViewById(R.id.item3);
        ImageButton item4button = view.findViewById(R.id.item4);
        ImageButton item5button = view.findViewById(R.id.item5);
        ImageButton item6button = view.findViewById(R.id.item6);

        //Get data from viewmodels
        ((ChampionViewModel) viewModel).getChampion().observe(getViewLifecycleOwner(), champion -> {
            if (champion != null) {
                String formattedValue = String.format("%.1f", champion.returnCombineDamage());
                TextView combineDMG = binding.combineDamageDisplay;
                combineDMG.setText(formattedValue);
                //ad
                TextView physicalDMG = binding.physicalDamageDisplay;
                formattedValue = String.format("%.1f", champion.returnADDamage());
                //Log.d("ad",String.valueOf(champion.returnADDamage()));
                physicalDMG.setText(formattedValue);
                //ap
                TextView magicalDmG = binding.magicalDamageDisplay;
                formattedValue = String.format("%.1f", champion.returnAPDamage());
                //Log.d("ap",String.valueOf(champion.returnAPDamage()));
                magicalDmG.setText(formattedValue);
            }else{
                Log.d("Failed","failed");
            }
        });

        binding.clothingCard.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );


        item1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });


        item1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });

        item2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });

        item3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });

        item4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });

        item5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });

        item6button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action to navigate to the item_selection page
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ItemSelectionFragment);

            }
        });
    }

    /**
     * Updates the selected item's image displayed on the UI.
     *
     * @param view The root view of the fragment's layout.
     */
    public void updateItem(View view){
        Button button15 = view.findViewById(R.id.button15);
        ImageButton item1button = view.findViewById(R.id.item1);
        ImageButton item2button = view.findViewById(R.id.item2);
        ImageButton item3 = view.findViewById(R.id.item3);
        ImageButton item4 = view.findViewById(R.id.item4);
        ImageButton item5 = view.findViewById(R.id.item5);
        ImageButton item6 = view.findViewById(R.id.item6);
        ViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        ((ItemViewModel) itemViewModel).getSelectedItem().observe(getViewLifecycleOwner(), item -> {
            Log.d("Change item image",item.getPngName());
            if (item != null) {
                Log.d("Change item image",item.getPngName());
                // Update the ImageButton with the new image
                int resourceId = getResources().getIdentifier(item.getPngName(), "drawable", getContext().getPackageName());
                item1button.setImageResource(resourceId);
                // Optionally, update the TextView or other UI elements with details
            } else {
                Log.d("Change item image","failed");
                // Handle case where no item is selected (default state)
                binding.item1.setImageResource(R.drawable.additem);
            }
        });
    }

    /**
     * Cleans up any resources when the fragment's view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}