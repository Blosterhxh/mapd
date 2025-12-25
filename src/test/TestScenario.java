package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.BadEntryException;
import petrinet.Arc;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;

class TestScenario {

    private PetriNet pn;
    
    private Place p1;
    private Place p2;
    private Place p3;
    private Place p4;
    private Place p5;
    
    private Transition t1;
    private Transition t2;
    private Transition t3;
    private Transition t4;

    @BeforeEach
    void setUp() throws BadEntryException {
    	// Initialize the PetriNet, the places, and the transitions
    	
    	//Code CR1
        pn = new PetriNet(new LinkedList<Transition>());
        
        //Code CP1
        p1 = new Place(0);
        
        //Code CP2
        p2 = new Place(1);
        
        //Code CP3
        p3 = new Place(0);
        
        //Code CP4
        p4 = new Place(0);
        
        //Code CP5
        p5 = new Place(1);
        
        //Code CT1
        t1 = new Transition();
        
        //Code CT2
        t2 = new Transition();
        
        //Code CT3
        t3 = new Transition();
        
        //Code CT4
        t4 = new Transition();
    }

    @Test
    void testCreation() throws BadEntryException {
    	// Ensure that the PetriNet and the places are not null
        assertNotNull(pn, "The PetriNet shouldn't be null");
        assertNotNull(p1, "The p1 place shouldn't be null");
        assertNotNull(p2, "The p2 place shouldn't be null");
        assertNotNull(p3, "The p3 place shouldn't be null");
        assertNotNull(p4, "The p4 place shouldn't be null");
        assertNotNull(p5, "The p5 place shouldn't be null");
        assertNotNull(t1, "The t1 transition shouldn't be null");
        assertNotNull(t2, "The t2 transition shouldn't be null");
        assertNotNull(t3, "The t3 transition shouldn't be null");
        assertNotNull(t4, "The t4 transition shouldn't be null");

        //Code CP2e
        assertThrows(BadEntryException.class, () -> new Place(-2), "An exception should be thrown when adding a negative number of tokens");
        
        //Code CA9e
        assertThrows(BadEntryException.class, () -> new Arc(-1, t3, p1), "An exception should be thrown when creating an arc with a negative weight");
    }
    
    @Test
    void testAddPetriNet() throws BadEntryException {
    	
    	//Code CT1
    	pn.addTransition(t1);
    	System.out.println("Result Code CT1");
    	System.out.println(pn.getTransition());
    	
    	//Code CT1e
    	assertThrows(BadEntryException.class, () -> pn.addTransition(t1), "Transition already present in the PetriNet");
    	System.out.println("Result Code CT1e");
    	System.out.println(pn.getTransition());
    	
    	//Code CA1
    	Arc a1 = new Arc(1, p1, t1);
    	t1.addArc(a1);
    	System.out.println("Result Code CA1");
    	System.out.println(t1.getArcs());
    	System.out.println(pn.getTransition());
    
    	//Code CA1e
    	assertThrows(BadEntryException.class, () -> t1.addArc(a1), "Arc already present in the transition t1");
    	System.out.println("Result Code CA1e");
    	System.out.println(t1.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CT2
    	pn.addTransition(t2);
    	System.out.println("Result Code CT2");
    	System.out.println(pn.getTransition());
    	

    	//Code CA2
    	Arc a2 = new Arc(1, t1, p2);
    	t1.addArc(a2);
    	System.out.println("Result Code CA2");
    	System.out.println(t1.getArcs());
    	System.out.println(pn.getTransition());
    	
    	//Code CA3
    	Arc a3 = new Arc(1, p2, t2);
    	t2.addArc(a3);
    	System.out.println("Result Code CA3");
    	System.out.println(t2.getArcs());
    	System.out.println(pn.getTransition());
    	
    	//Code CA4
    	Arc a4 = new Arc(1, t2, p1);
    	t2.addArc(a4);
    	System.out.println("Result Code CA4");
    	System.out.println(t2.getArcs());
    	System.out.println(pn.getTransition());
    	

    	//Code CT3
    	pn.addTransition(t3);
    	System.out.println("Result Code CT3");
    	System.out.println(pn.getTransition());
    	
    	//Code CA5
    	Arc a5 = new Arc(1, p5, t3);
    	t3.addArc(a5);
    	System.out.println("Result Code CA5");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CA6
    	Arc a6 = new Arc(1, t3, p4);
    	t3.addArc(a6);
    	System.out.println("Result Code CA6");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	

    	//Code CT4
    	pn.addTransition(t4);
    	System.out.println("Result Code CT4");
    	System.out.println(pn.getTransition());
    	
    	//Code CA7
    	Arc a7 = new Arc(1, p4, t4);
    	t4.addArc(a7);
    	System.out.println("Result Code CA7");
    	System.out.println(t4.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CA8
    	Arc a8 = new Arc(1, t4, p5);
    	t4.addArc(a8);
    	System.out.println("Result Code CA8");
    	System.out.println(t4.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CA9
    	Arc a9 = new Arc(1, t3, p1);
    	System.out.println("Result Code CA9");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	

    	//Code CA10
      	Arc a10 = new Arc(1, p3, t3);
    	t3.addArc(a10);
    	System.out.println("Result Code CA10");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CA11
      	Arc a11 = new Arc(1, t2, p3);
    	t2.addArc(a11);
    	System.out.println("Result Code CA11");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	
    	
    	//Code CA12
    	Arc a12 = new Arc(1, t4, p3);
    	t4.addArc(a12);
    	System.out.println("Result Code CA12");
    	System.out.println(t3.getArcs());
    	System.out.println(pn.getTransition());
    	
    	//Final
    	System.out.println("Final PetriNet");
    	System.out.println(pn.getTransition());
    	System.out.println(t1.getArcs());
    	System.out.println(t2.getArcs());
    	System.out.println(t3.getArcs());
    	System.out.println(t4.getArcs());
    }
}
