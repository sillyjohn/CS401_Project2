package com.example.proj2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proj2.Classes.Champion;
import com.example.proj2.Classes.HTTP_Request;
import com.example.proj2.databinding.FragmentFirstBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
        view.findViewById(R.id.AnnieButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("first", "Ada");
                user.put("last", "Lovelace");
                user.put("born", 1815);

// Add a new document with a generated ID
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
                //HTTP Request testing
//                HTTP_Request.requestURL();

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
        view.findViewById(R.id.GarenButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });
        view.findViewById(R.id.MasterYiButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.OlafButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.QuinnButton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Champion champ = new Champion();
                Toast myToast = Toast.makeText(getActivity(), champ.name, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.ZiggsButton6).setOnClickListener(new View.OnClickListener() {
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