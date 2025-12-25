package petrinet;

import exceptions.BadEntryException;

public class BouncerArc extends Arc {

    // Constructor of the class
    // The weight of an emptying arc is set to 0 by convention
    public BouncerArc(Object incoming, Object outgoing) throws BadEntryException {
        super(0, incoming, outgoing);
    }

    // Method that removes all tokens from the entry place
    public void empty() throws BadEntryException {
        ((Place) this.incoming).removeToken(((Place) this.incoming).getToken());
    }

    // Method to check if the entry place is empty (no tokens left)
    public boolean isEmpty() {
        return ((Place) this.incoming).getToken() == 0;
    }
}
