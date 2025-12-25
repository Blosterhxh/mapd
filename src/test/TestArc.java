package test;

import static org.junit.jupiter.api.Assertions.*;
import petrinet.Arc;
import petrinet.Place;
import petrinet.Transition;

import org.junit.jupiter.api.Test;

import exceptions.BadEntryException;

public class TestArc {

    @Test
    // Test to ensure the Arc constructor works as expected
    void testConstructor() throws BadEntryException {
        
        // Create necessary components for testing
        Transition t1 = new Transition();
        Place p = new Place(1); // Place initialized with 1 token
        Transition t2 = new Transition();

        // Test 1: Create a valid Arc
        Arc a1 = new Arc(1, t1, p);
        assertNotNull(a1, "The Arc should be created successfully with a transition as input and a place as output.");

        // Test 2: Ensure an exception is thrown when the Arc is improperly initialized
        assertThrows(BadEntryException.class, 
            () -> new Arc(1, t1, t2), 
            "An exception should be thrown when attempting to create an Arc with invalid endpoints (e.g., Transition to Transition).");

        // Test 3: Ensure an exception is thrown when the Arc has a negative weight
        assertThrows(BadEntryException.class, 
            () -> new Arc(-1, t1, t2), 
            "An exception should be thrown when attempting to create an Arc with a negative weight.");
    }
}
