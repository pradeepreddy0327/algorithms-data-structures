package design.patterns.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        Bird bird = new Sparrow();
        BirdAdapter birdAdapter = new BirdAdapter(bird);
        birdAdapter.squeek();
    }
}
