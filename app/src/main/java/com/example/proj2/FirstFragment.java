package com.example.proj2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proj2.databinding.FragmentFirstBinding;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirstFragment extends Fragment {
    private static final String TAG = FirstFragment.class.getSimpleName();

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        view.findViewById(R.id.ChampIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Annie");
                setArguments(result);
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);

                //getParentFragmentManager().setFragmentResult("requestKey", result);
                //Move to Next Frag
                //NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                //String champName = "Annie";
                //FirstFragmentDirections.actionFirstFragmentToSecondFragment();


            }
        });
        view.findViewById(R.id.GarenButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Garen");
                setArguments(result);
                //Navigation
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
        view.findViewById(R.id.MasterYiButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Master Yi");
                setArguments(result);
                //Navigation
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
        view.findViewById(R.id.OlafButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Olaf");
                setArguments(result);
                //Navigation
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
        view.findViewById(R.id.QuinnButton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Quinn");
                setArguments(result);
                //Navigation
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });
        view.findViewById(R.id.ZiggsButton6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing Name to Second Frag
                Bundle result = new Bundle();
                result.putString("Name","Ziggs");
                setArguments(result);
                //Navigation
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, result);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}