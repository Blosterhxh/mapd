package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import petrinet.Place;
import exceptions.BadEntryException;

public class TestPlace {

    @Test
    // Test to ensure the constructor behaves correctly
    void testConstructeur() throws BadEntryException {
        // Test valid Place creation
        Place p1 = new Place(1);
        assertNotNull(p1, "The Place should be created with a positive number of tokens.");
        
        // Test exception for invalid negative token count
        assertThrows(BadEntryException.class, 
                     () -> new Place(-1), 
                     "An exception should be thrown when a Place is created with a negative number of tokens.");
    }
    
    @Test
    // Test to ensure token management functions correctly
    void testJeton() throws BadEntryException {
        // Create a Place with 1 token
        Place p1 = new Place(1);

        // Add a token and verify the count
        p1.addToken(1);
        assertEquals(2, p1.getToken(), "The number of tokens should be 2 after adding 1 token.");

        // Test exception for adding a negative number of tokens
        assertThrows(BadEntryException.class, 
                     () -> p1.addToken(-1), 
                     "An exception should be thrown when trying to add a negative number of tokens.");
        
        // Remove a token and verify the count
        p1.removeToken(1);
        assertEquals(1, p1.getToken(), "The number of tokens should be 1 after removing 1 token.");

        // Test exception for removing a negative number of tokens
        assertThrows(BadEntryException.class, 
                     () -> p1.removeToken(-1), 
                     "An exception should be thrown when trying to remove a negative number of tokens.");
    }
}
