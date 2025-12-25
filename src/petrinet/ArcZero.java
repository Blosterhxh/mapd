package petrinet;

import exceptions.BadEntryException;

public class ArcZero extends Arc {

    // Constructor of the class
    public ArcZero(Object incoming, Object outgoing) throws BadEntryException {
        super(0, incoming, outgoing);
    }

    // Method that checks if the starting place has no tokens
    public boolean isZero() {
        if (((Place) incoming).getToken() == 0) {
            return true; 
        }
        return false;
    }
}
