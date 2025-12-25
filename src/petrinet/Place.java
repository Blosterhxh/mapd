package petrinet;

import exceptions.BadEntryException;

public class Place {

    private int token;

    // Constructor of the Place class
    public Place(int token) throws BadEntryException {
        if (token < 0) {
            throw new BadEntryException("Negative number of tokens");
        }
        this.token = token;
    }

    // Accessor method that returns the number of tokens
    public int getToken() {
        return this.token;
    }

    // Method that adds a certain number of tokens
    // Useful for places that receive tokens
    public void addToken(int token) throws BadEntryException {
    	System.out.println("addToken");
        if (token < 0) {
            throw new BadEntryException("Negative number of tokens");
        }
        this.token = this.token + token;
    }

    // Method that removes a certain number of tokens
    // Useful for places that give tokens
    public void removeToken(int token) throws BadEntryException {
        if (token < 0) {
            throw new BadEntryException("Negative number of tokens");
        }
        this.token = this.token - token;
    }

    public String toString() {
        return "place " + this.hashCode() + " with " + this.getToken() + " tokens";
    }
}
