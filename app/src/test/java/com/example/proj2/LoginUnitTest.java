package com.example.proj2;

import android.os.Bundle;
import android.widget.Button;

import com.example.proj2.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class LoginUnitTest {
    private LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.buildActivity(LoginActivity.class).create().visible().get();
    }

    @Test
    public void testActivityNotNull() {
        assertNotNull(loginActivity);
    }

    @Test
    public void testLoginButton() {
        Button loginButton = loginActivity.findViewById(R.id.btn_login);
        assertNotNull(loginButton);
    }

    @Test
    public void testRegisterButton() {
        Button registerButton = loginActivity.findViewById(R.id.btn_register);
        assertNotNull(registerButton);
    }

    @Implements(LoginActivity.class)
    public static class ShadowLoginActivity {
        @Implementation
        protected void onCreate(Bundle savedInstanceState) {
            // Mock the onCreate method if needed
        }
    }
}
