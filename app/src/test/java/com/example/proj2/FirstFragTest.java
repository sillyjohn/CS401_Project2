package com.example.proj2;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.example.proj2.FirstFragment;
import com.google.firebase.FirebaseApp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.R)
public class FirstFragTest {
    @Mock
    NavController mockNavController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        FirebaseApp.initializeApp(ApplicationProvider.getApplicationContext());

        FragmentScenario<FirstFragment> scenario = FragmentScenario.launchInContainer(FirstFragment.class);
        scenario.onFragment(fragment -> {

            Navigation.setViewNavController(fragment.requireView(), mockNavController);
        });
    }

    @Test
    public void testChampIconClickListener() {
        // Simulate click event
        FirstFragment fragment = new FirstFragment();
        fragment.onViewCreated(new View(ApplicationProvider.getApplicationContext()), new Bundle());
        fragment.onResume();

        // Verify that correct arguments are passed and navigation is triggered
        verify(mockNavController, times(1)).navigate(anyInt(), any(Bundle.class));
    }
}
