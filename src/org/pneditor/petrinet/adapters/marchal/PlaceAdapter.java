package org.pneditor.petrinet.adapters.marchal;

import org.pneditor.petrinet.AbstractPlace;

import exceptions.BadEntryException;
import petrinet.Place;

public class PlaceAdapter extends AbstractPlace{
	
	Place p;

	public PlaceAdapter(String label) throws BadEntryException {
		super(label);
		this.p = new Place(1);
		
	}

	@Override
	public void addToken() {
		try {
			this.p.addToken(1);
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeToken() {
		try {
			this.p.removeToken(1);
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getTokens() {
		return this.p.getToken();
	}

	@Override
	public void setTokens(int tokens) {
		try {
			this.p.removeToken(this.p.getToken());
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.p.addToken(tokens);
		} catch (BadEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Place getPlace() {
		return this.p;
	}
	
	

}
