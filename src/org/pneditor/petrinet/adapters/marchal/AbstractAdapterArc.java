package org.pneditor.petrinet.adapters.marchal;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import exceptions.BadEntryException;
import petrinet.Arc;
import petrinet.ArcZero;
import petrinet.BouncerArc;

public class AbstractAdapterArc extends AbstractArc{

	Arc a;
	boolean reset;
	boolean inhibitory;
	AbstractNode source;
	AbstractNode destination;
	public AbstractAdapterArc(int weight, AbstractNode source, AbstractNode destination,boolean inhibitory, boolean reset) {
		try {
			if (inhibitory) {
				PlaceAdapter source2 = (PlaceAdapter) source;
				AbstractAdapterTransition destination2 = (AbstractAdapterTransition) destination;
				this.a = new ArcZero(source2.getPlace(),destination2.getTransition());
			}
			if (reset) {
				PlaceAdapter source2 = (PlaceAdapter) source;
				AbstractAdapterTransition destination2 = (AbstractAdapterTransition) destination;
				this.a = new BouncerArc(source2.getPlace(),destination2.getTransition());
			}
			else {
				if (source instanceof PlaceAdapter) {
					System.out.println("placeadapter");
					PlaceAdapter source2 = (PlaceAdapter) source;
					AbstractAdapterTransition destination2 = (AbstractAdapterTransition) destination;
					this.a = new Arc(1,source2.getPlace(),destination2.getTransition());
				}
				else {
					PlaceAdapter destination2 = (PlaceAdapter) destination;
					AbstractAdapterTransition source2 = (AbstractAdapterTransition) source;
					this.a = new Arc(1,source2.getTransition(),destination2.getPlace());
				}
			}
			this.reset = reset;
			this.inhibitory = inhibitory;
			this.source = source;
			this.destination = destination;
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public AbstractNode getSource() {
		return source;
	}

	@Override
	public AbstractNode getDestination() {
		return destination;
	}

	@Override
	public boolean isReset() {
		return this.reset;
	}

	@Override
	public boolean isRegular() {
		return (!this.reset && !this.inhibitory);
	}

	@Override
	public boolean isInhibitory() {
		return this.inhibitory;
		}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return a.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		try {
			a = new Arc(a.getWeight(),a.getIncoming(),a.getOutgoing());
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Arc getArc() {
		return this.a;
	}
	public BouncerArc getBouncerArc() {
		return (BouncerArc) this.a;
	}
	public ArcZero getArcZero() {
		return (ArcZero) this.a;
	}
	

}
