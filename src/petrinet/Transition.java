package petrinet;

import java.util.LinkedList;

import exceptions.BadEntryException;

public class Transition {

    private LinkedList<Arc> arcs;

    // Constructor of the class
    public Transition() {
        this.arcs = new LinkedList<Arc>();
    }

    // Accessor method to get the arcs connected to the transition
    public LinkedList<Arc> getArcs() {
        return this.arcs;
    }

    // Method to add an arc to the list of arcs
    public void addArc(Arc arc) throws BadEntryException {
        if (arcs.contains(arc)) {
            throw new BadEntryException("Arc already exists");
        }
        // Part of the code that handles the notion of duplicate arcs
        for (Arc arcx : arcs) {
            if (arcx.getIncoming() == arc.getIncoming()) {
                if (arcx.getOutgoing() == arc.getOutgoing()) {
                    arcx.addWeight(arc.getWeight());
                    return;
                }
            }
        }
        this.arcs.add(arc);
    }

    // Method to check if the transition is ready to fire
    public boolean fireready() {

        for (Arc arc : this.arcs) {

            Object incoming = arc.getIncoming();
            Object outgoing = arc.getOutgoing();
            if (incoming instanceof Place) {
                int weight = arc.getWeight();
                Place incomingp = (Place) incoming;
                int tokens = incomingp.getToken();
                if (tokens < weight) {

                    return false;
                }
            }
            if (arc instanceof ArcZero) {

                if (((ArcZero) arc).isZero() != true) {

                    return false;
                }
            }

            if (arc instanceof BouncerArc) {

                if (((BouncerArc) arc).isEmpty()) {

                    return false;
                }
            }
        }
        return true;
    }

    // Method to fire the transition
    public void fire() throws BadEntryException {
        if (fireready() == false) {
            return;
        }
        for (Arc arc : this.arcs) {

            int weight = arc.getWeight();
            Object incoming = arc.getIncoming();
            if (incoming instanceof Place) {

                if (arc instanceof BouncerArc) {
                    ((BouncerArc) arc).empty();
                } else {

                    Place place = (Place) incoming;
                    int jeton = place.getToken();
                    place.removeToken(weight);
                }
            } else {

                Object outgoing = arc.getOutgoing();
                Place place = (Place) outgoing;
                place.addToken(weight);
            }
        }
    }

    public String toString() {
        int incomingarc = 0;
        int outgoingarc = 0;
        for (Arc arc : this.getArcs()) {
            if (arc.getIncoming() instanceof Place) {
                incomingarc += 1;
            } else {
                outgoingarc += 1;
            }
        }
        return "transition " + this.hashCode() + " " + incomingarc + " incoming arc(s), " + outgoingarc + " outgoing arc(s)";
    }
}
