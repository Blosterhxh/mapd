package org.pneditor.petrinet.adapters.marchal;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;

import exceptions.BadEntryException;
import petrinet.*;

public class PetriNetAdapter extends PetriNetInterface {

	@Override
	public AbstractPlace addPlace() {
		try {
			return new PlaceAdapter("place");
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public AbstractTransition addTransition() {
		return new AbstractAdapterTransition("transition");
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if (destination instanceof AbstractTransition) {
			System.out.println("true");
			AbstractAdapterTransition transition2 = (AbstractAdapterTransition) destination;
			AbstractAdapterArc a = new AbstractAdapterArc(1,source,destination,false,false);
			System.out.println(a.getArc().toString());
			transition2.addRegularArc(a);
			System.out.println(transition2.getTransition().toString());
			return a;
		}
		else {
			AbstractAdapterTransition transition2 = (AbstractAdapterTransition) source;
			AbstractAdapterArc a = new AbstractAdapterArc(1,source,destination,false,false);
			transition2.addRegularArc(a);
			return a;
			
		}
		
		
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		AbstractAdapterTransition transition2 = (AbstractAdapterTransition) transition;
		AbstractAdapterArc a = new AbstractAdapterArc(1,place,transition,true,false);
		transition2.addInhibitoryArc(a);
		return a;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		AbstractAdapterTransition transition2 = (AbstractAdapterTransition) transition;
		AbstractAdapterArc a = new AbstractAdapterArc(1,place,transition,false,true);
		transition2.addResetArc(a);
		return a;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		place = null;
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		transition = null;
	}

	@Override
	public void removeArc(AbstractArc arc) {
		arc = null;
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		AbstractAdapterTransition transition2 = (AbstractAdapterTransition) transition;
		return transition2.getTransition().fireready();
		
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		AbstractAdapterTransition transition2 = (AbstractAdapterTransition) transition;
		try {
			System.out.println("fire");
			transition2.getTransition().fire();
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
