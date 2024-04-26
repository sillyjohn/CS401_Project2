package com.example.proj2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class UserAccountTest {
    @Test
    public void testGetSetIdToken() {
        UserAccount user = new UserAccount();
        String idToken = "exampleIdToken";
        user.setIdToken(idToken);
        assertEquals(idToken, user.getIdToken());
    }

    @Test
    public void testGetSetEmailId() {
        UserAccount user = new UserAccount();
        String emailId = "example@example.com";
        user.setEmailId(emailId);
        assertEquals(emailId, user.getEmailId());
    }

    @Test
    public void testGetSetPassword() {
        UserAccount user = new UserAccount();
        String password = "examplePassword";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

}
