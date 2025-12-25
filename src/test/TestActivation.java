package test;
import static org.junit.Assert.*;

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


public class TestActivation {

	
	@Test
	public void test1() throws Exception{
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
	}
	@Test
	public void test2() throws Exception{
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place place = new Place(0);
		Arc arc = new Arc(1,place,transition);
		transition.addArc(arc);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(place.getToken(),0);
	}
	@Test
	public void test3() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place place = new Place(2);
		Arc arc = new Arc(1,place,transition);
		transition.addArc(arc);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(place.getToken(),1);
		
	}
	@Test
	public void test4() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place place = new Place(5);
		Arc arc = new Arc(3,place,transition);
		transition.addArc(arc);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(place.getToken(),2);
		
	}
	@Test
	public void test5() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place place = new Place(0);
		Arc arc = new Arc(1,transition,place);
		transition.addArc(arc);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(place.getToken(),1);
		
	}
	@Test
	public void test6() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place place = new Place(5);
		Arc arc = new Arc(3,transition,place);
		transition.addArc(arc);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(place.getToken(),8);
		
	}
	@Test
	public void test7() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(0);
		Place p2 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(1,transition,p2);
		transition.addArc(a1);
		transition.addArc(a2);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),0);
		
	}
	@Test
	public void test8() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(1);
		Place p2 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(1,transition,p2);
		transition.addArc(a1);
		transition.addArc(a2);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),1);
		
	}
	@Test
	public void test9() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(4);
		Place p2 = new Place(3);
		Arc a1 = new Arc(2,p1,transition);
		Arc a2 = new Arc(3,transition,p2);
		transition.addArc(a1);
		transition.addArc(a2);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),2);
		assertEquals(p2.getToken(),6);
	}
	@Test
	public void test10() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(0);
		Place p2 = new Place(0);
		Place p3 = new Place(0);
		Place p4 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(1,p2,transition);
		Arc a3 = new Arc(1,transition,p3);
		Arc a4 = new Arc(1,transition,p4);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		transition.addArc(a4);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);		
	}
	@Test
	public void test11() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(1);
		Place p2 = new Place(0);
		Place p3 = new Place(0);
		Place p4 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(1,p2,transition);
		Arc a3 = new Arc(1,transition,p3);
		Arc a4 = new Arc(1,transition,p4);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		transition.addArc(a4);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),0);
		assertEquals(p4.getToken(),0);		
	}
	@Test
	public void test12() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(1);
		Place p2 = new Place(1);
		Place p3 = new Place(0);
		Place p4 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(1,p2,transition);
		Arc a3 = new Arc(1,transition,p3);
		Arc a4 = new Arc(1,transition,p4);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		transition.addArc(a4);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),0);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),1);
		assertEquals(p4.getToken(),1);		
	}
	@Test
	public void test13() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(3);
		Place p2 = new Place(2);
		Place p3 = new Place(7);
		Place p4 = new Place(12);
		Arc a1 = new Arc(2,p1,transition);
		Arc a2 = new Arc(2,p2,transition);
		Arc a3 = new Arc(4,transition,p3);
		Arc a4 = new Arc(6,transition,p4);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		transition.addArc(a4);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),0);
		assertEquals(p3.getToken(),11);
		assertEquals(p4.getToken(),18);		
	}
	@Test
	public void test14() throws BadEntryException {
		LinkedList<Transition> transitions = new LinkedList<Transition>();
		Transition transition = new Transition();
		transitions.add(transition);
		Place p1 = new Place(4);
		Place p2 = new Place(0);
		Arc a1 = new Arc(1,p1,transition);
		Arc a2 = new Arc(2,p1,transition);
		Arc a3 = new Arc(1,transition,p2);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		PetriNet petri = new PetriNet(transitions);
		petri.fire();	
		assertEquals(p1.getToken(),1);
		assertEquals(p2.getToken(),1);
	}
	
}
