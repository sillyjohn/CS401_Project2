package com.example.proj2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proj2.Classes.Champion;
import com.example.proj2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

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

        view.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
                Bundle result = new Bundle();
                result.putString("Key","Annie");
                getParentFragmentManager().setFragmentResult("requestKey", result);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });
        view.findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.imageView6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}