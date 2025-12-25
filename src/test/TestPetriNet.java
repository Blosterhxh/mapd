package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import petrinet.PetriNet;
import petrinet.Transition;
public class TestPetriNet {

    // Create an instance of PetriNet for testing
    PetriNet p = new PetriNet(new LinkedList<Transition>());

    @Test
    // Test to ensure that the PetriNet constructor works as expected
    void testConstructor() {
        // Check that the PetriNet instance is successfully created
        assertNotNull(p, "The PetriNet should be created successfully.");
    }
}
