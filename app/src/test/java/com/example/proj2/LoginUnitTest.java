package com.example.proj2; // Package declaration indicating the location of the test class

// Import necessary Android and testing libraries
import android.os.Bundle;
import android.widget.Button;
import com.example.proj2.LoginActivity; // Import the LoginActivity class being tested
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for LoginActivity
 */
@RunWith(RobolectricTestRunner.class) // Use RobolectricTestRunner for testing
@Config(manifest=Config.NONE) // Specify that there is no Android manifest file for this test
public class LoginUnitTest {
    private LoginActivity loginActivity; // Instance of LoginActivity for testing

    @Before
    public void setUp() throws Exception {
        // Create an instance of LoginActivity using Robolectric for testing
        loginActivity = Robolectric.buildActivity(LoginActivity.class).create().visible().get();
    }

    @Test
    public void testActivityNotNull() {
        // Test if LoginActivity instance is not null
        assertNotNull(loginActivity);
    }

    @Test
    public void testLoginButton() {
        // Test if the login button in LoginActivity is not null
        Button loginButton = loginActivity.findViewById(R.id.btn_login);
        assertNotNull(loginButton);
    }

    @Test
    public void testRegisterButton() {
        // Test if the register button in LoginActivity is not null
        Button registerButton = loginActivity.findViewById(R.id.btn_register);
        assertNotNull(registerButton);
    }

    // Shadow class to mock LoginActivity if needed
    @Implements(LoginActivity.class)
    public static class ShadowLoginActivity {
        @Implementation
        protected void onCreate(Bundle savedInstanceState) {
            // Mock the onCreate method if needed for testing
        }
    }
}
