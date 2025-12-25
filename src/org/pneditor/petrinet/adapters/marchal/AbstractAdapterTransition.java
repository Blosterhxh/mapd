package org.pneditor.petrinet.adapters.marchal;

import org.pneditor.petrinet.AbstractTransition;

import exceptions.BadEntryException;
import petrinet.Transition;

public class AbstractAdapterTransition extends AbstractTransition{
	
	protected Transition t;
	
	public AbstractAdapterTransition(String label) {
		super(label);
		this.t = new Transition();
		
	}
	public Transition getTransition() {
		return this.t;
	}
	
	public void addRegularArc(AbstractAdapterArc arc) {
		try {
			this.t.addArc(arc.getArc());
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addResetArc(AbstractAdapterArc arc) {
		try {
			this.t.addArc(arc.getArcZero());
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addInhibitoryArc(AbstractAdapterArc arc) {
		try {
			this.t.addArc(arc.getBouncerArc());
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
