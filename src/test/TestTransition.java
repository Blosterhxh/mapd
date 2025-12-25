package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import petrinet.Transition;

public class TestTransition {

    // Instance of Transition to be used in tests
    Transition transition = new Transition();

    @Test
    // Test to ensure the constructor behaves correctly
    void testConstructeur() {
        // Verify that the Transition object is created successfully
        assertNotNull(transition, "The Transition should be created.");
    }
}
