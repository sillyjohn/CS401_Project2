package com.example.proj2;

// Import statements for required Android classes and libraries
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.proj2.databinding.FragmentFirstBinding;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Defining the FirstFragment class that extends Fragment
 *  allowing users to select different champions.
 */
public class FirstFragment extends Fragment {
    private static final String TAG = FirstFragment.class.getSimpleName(); // TAG for logging

    private FragmentFirstBinding binding; // Binding object for the fragment's layout


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment using the binding object
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     *
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize Firebase Firestore database
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Set click listeners for each champion button
        view.findViewById(R.id.ChampIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a bundle to pass data to the next fragment
                Bundle result = new Bundle();
                result.putString("Name","Annie");
                setArguments(result);
                // Navigate to the SecondFragment using the NavController
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
/**
 * Similar click listeners for other champion buttons
 */
        // Garen
        view.findViewById(R.id.GarenButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Name","Garen");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });

        // Nasus
        view.findViewById(R.id.NasusButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Name","Nasus");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });

        // Olaf
        view.findViewById(R.id.OlafButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Name","Olaf");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });

        // Quinn
        view.findViewById(R.id.QuinnButton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Name","Quinn");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });

        // Ziggs
        view.findViewById(R.id.ZiggsButton6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Name","Ziggs");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up binding object to avoid memory leaks
        binding = null;
    }
}
