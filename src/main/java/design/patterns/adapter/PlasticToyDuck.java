package design.patterns.adapter;

public class PlasticToyDuck implements ToyDuck {

    @Override
    public void squeek() {
        System.out.println("Plastic Tyoy Duck squeek");
    }

}
