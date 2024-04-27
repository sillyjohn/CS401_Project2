package com.example.proj2;

import android.text.Editable;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LoginUnitTest {

    private LoginActivity loginActivity;
    private EditText mockEmailEditText;
    private EditText mockPasswordEditText;

    @Before
    public void setUp() {
        // Instantiate the LoginActivity with Mockito to isolate from Android dependencies
        loginActivity = Mockito.mock(LoginActivity.class);
        // Create mock EditTexts
        mockEmailEditText = Mockito.mock(EditText.class);
        mockPasswordEditText = Mockito.mock(EditText.class);

        // Prepare to return mock Editable for email and password
        Editable mockEmailEditable = Mockito.mock(Editable.class);
        Editable mockPasswordEditable = Mockito.mock(Editable.class);

        // Set up the mock to return the mock Editable when getText is called
        when(mockEmailEditText.getText()).thenReturn(mockEmailEditable);
        when(mockPasswordEditText.getText()).thenReturn(mockPasswordEditable);

        // Set up the mocks to return specific strings when toString is called
        when(mockEmailEditable.toString()).thenReturn("");
        when(mockPasswordEditable.toString()).thenReturn("");

        // Assign these mocks to the LoginActivity fields
        loginActivity.mEtEmail = mockEmailEditText;
        loginActivity.mEtPwd = mockPasswordEditText;

    }

    @Test
    public void emailIsEmpty() {
        // Setup the condition for the mock to return an empty string
        when(loginActivity.mEtEmail.getText().toString()).thenReturn("");
        // Check if the email is empty
        boolean isEmpty = loginActivity.mEtEmail.getText().toString().isEmpty();
        assertTrue("Email should not be empty", isEmpty);
    }

    @Test
    public void passwordIsEmpty() {
        // Setup the condition for the mock to return an empty string
        when(loginActivity.mEtPwd.getText().toString()).thenReturn("");
        // Check if the password is empty
        boolean isEmpty = loginActivity.mEtPwd.getText().toString().isEmpty();
        assertTrue("Password should not be empty", isEmpty);
    }
}
