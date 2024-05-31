package com.movie.moviebackend.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityTest {
    @Test
    @DisplayName("Username krijgen en role")
    public void testAuthorityGetters() {

        //Arrange
        String username = "testUser";
        String authority = "ROLE_USER";
        String authorityAdmin = "ROLE_ADMIN";

        Authority authorityObj = new Authority(username, authority);
        // Act

        assertEquals(username, authorityObj.getUsername());
        assertEquals(authority, authorityObj.getAuthority());

    }

    @Test
    @DisplayName("Username en authority Role instellen")
    public void testAuthoritySetter() {

    //Arrange
        Authority authorityObj = new Authority();
        String username = "testUser";
        String authority = "ROLE_USER";
    // Act
        authorityObj.setUsername(username);
        authorityObj.setAuthority(authority);

    // Assert
        assertEquals(username, authorityObj.getUsername());
        assertEquals(authority, authorityObj.getAuthority());
    }





}