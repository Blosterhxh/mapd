package test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import exceptions.BadEntryException;
import petrinet.Arc;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;


public class TestActivationScenario {


	
	@Test
	public void test1() throws Exception{
		
		//Recronstruction of the PetriNet from the scenario
		
		PetriNet pn;
		
		Place p1;
	    Place p2;
	    Place p3;
	    Place p4;
	    Place p5;
	    
	    Transition t1;
	    Transition t2;
	    Transition t3;
	    Transition t4;
	    
	    pn = new PetriNet(new LinkedList<Transition>());
	    

	    p1 = new Place(0);
	    p2 = new Place(1);
	    p3 = new Place(0);
	    p4 = new Place(0);
	    p5 = new Place(1);
	    
	    t1 = new Transition();
	    t2 = new Transition();
	    t3 = new Transition();
	    t4 = new Transition();
	    
	    //The t1 transition is built
	    
		pn.addTransition(t1);
		
		Arc a1 = new Arc(1, p1, t1);
		t1.addArc(a1);
		
		Arc a2 = new Arc(1, t1, p2);
		t1.addArc(a2);
		
		//The t2 transition is built
	    
		
		pn.addTransition(t2);

		Arc a3 = new Arc(1, p2, t2);
		t2.addArc(a3);

		Arc a4 = new Arc(1, t2, p1);
		t2.addArc(a4);

		//The t3 transition is built
		
		pn.addTransition(t3);
		
		Arc a5 = new Arc(1, p5, t3);
		t3.addArc(a5);
		
		Arc a6 = new Arc(1, t3, p4);
		t3.addArc(a6);

		//The t4 transition is built
		
		pn.addTransition(t4);
		
		Arc a7 = new Arc(1, p4, t4);
		t4.addArc(a7);
		
		Arc a8 = new Arc(1, t4, p5);
		t4.addArc(a8);
		
		//We link the transitions to the main place p3
		
		Arc a9 = new Arc(1, p3, t1);
		t1.addArc(a9);
		
	  	Arc a10 = new Arc(1, p3, t3);
		t3.addArc(a10);
		
		
	  	Arc a11 = new Arc(1, t2, p3);
		t2.addArc(a11);
		
		Arc a12 = new Arc(1, t4, p3);
		t4.addArc(a12);
		
		//Test fire
		pn.showPetriNet();
		System.out.println(t1.toString());
		System.out.println(p3.toString());
		System.out.println(a9.toString());
		t1.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t3.fire();
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t2.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),1);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t1.fire();
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t2.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),1);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t1.fire();
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t3.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t2.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),1);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t3.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),1);
		assertEquals(p5.getToken(),0);
		t4.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),1);
		assertEquals(p4.getToken(),0);
		assertEquals(p5.getToken(),1);
		t3.fire();
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),1);
		assertEquals(p5.getToken(),0);
		t1.fire();	
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),1);
		assertEquals(p5.getToken(),0);
		t2.fire();	
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),1);
		assertEquals(p5.getToken(),0);

	}
}