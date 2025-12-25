package petrinet;

import java.util.LinkedList;

import exceptions.BadEntryException;

public class Arc {

    protected int weight; // Weight of the arc
    protected Object incoming; // Starting point of the arc (can be a place or a transition)
    private Object outgoing; // Ending point of the arc (can be a place or a transition)
    
    // Constructor of the class
    public Arc(int poids, Object incoming, Object outgoing) throws BadEntryException {
        
        if(poids < 0) {
            throw new BadEntryException("Negative arc weight");
        }
        this.weight = poids;
        this.incoming = incoming;
        this.outgoing = outgoing;
        if (incoming.getClass().equals(outgoing.getClass())) {
            throw new BadEntryException("Creation of an arc linking two objects of the same class");
        }
    }
    
    // Accessor returning the weight of the arc
    public int getWeight() {
        return this.weight;
    }
    
    // Accessor that adds a given weight to the arc
    public void addWeight(int weight2) {
            this.weight = this.weight + weight2;
    }
    
    // Accessor returning the starting point of the arc
    // It can be either a place or a transition
    public Object getIncoming() {
    return this.incoming;    
    }
    
    // Accessor returning the ending point of the arc
    // It can be either a place or a transition
    public Object getOutgoing() {
        return this.outgoing;
    }
    
    // Method to convert the arc into a string representation
    public String toString() {
        if (this.getIncoming() instanceof Place) {
            Place incoming = (Place) this.getIncoming();
            Transition outgoing = (Transition) this.getOutgoing();
            return "arc " + this.hashCode() + " weight " + this.weight + " place " + incoming.hashCode() + " to transition " + outgoing.hashCode();
        }
        else {
            Place incoming = (Place) this.getOutgoing();
            Transition outgoing = (Transition) this.getIncoming();
            return "arc " + this.hashCode() + " weight " + this.weight + " transition " + outgoing.hashCode() + " to place " + incoming.hashCode();
        }
    }
}
