package petrinet;

import java.util.LinkedList;

import exceptions.BadEntryException;

public class PetriNet {

    private LinkedList<Transition> transitions;

    // Constructor of the class
    public PetriNet(LinkedList<Transition> transitions) {
        this.transitions = transitions;
    }

    // Accessor method that returns the list of transitions
    // Our solution assumes that the PetriNet is composed only of transitions
    public LinkedList<Transition> getTransition() {
        return this.transitions;
    }

    // Method that adds a specific transition to the PetriNet's list of transitions
    public void addTransition(Transition transition) throws BadEntryException {
        if (this.transitions.contains(transition)) {
            throw new BadEntryException("Transition already exists");
        }
        this.transitions.add(transition);
    }

    // Method that fires the different transitions in the PetriNet
    public void fire() throws BadEntryException {
        for (Transition transition : this.transitions) {
            transition.fire();
        }
    }

    // Method that displays the PetriNet
    public void showPetriNet() {
        System.out.println("Petri Net:\n");
        for (Transition transition : transitions) {
            System.out.println("Transition " + transition.hashCode() + " :\n");
            System.out.println(transition.toString() + "\n");
            for (Arc arc : transition.getArcs()) {
                System.out.println("Arc " + arc.hashCode() + " of transition " + transition.hashCode() + " : \n");
                System.out.println(arc.toString() + "\n");
                if (arc.getIncoming() instanceof Place) {
                    System.out.println("Place " + ((Place) arc.getIncoming()).hashCode() + " of arc " + arc.hashCode() + " : \n");
                    System.out.println(((Place) arc.getIncoming()).toString() + "\n");
                } else {
                    System.out.println("Place " + ((Place) arc.getOutgoing()).hashCode() + " of arc " + arc.hashCode() + " : \n");
                    System.out.println(((Place) arc.getOutgoing()).toString() + "\n");
                }
            }
        }
    }
}
