package design.patterns.adapter;

public class Sparrow implements Bird {

    @Override
    public void fly() {

    }

    @Override
    public void makeSound() {
        System.out.println("Sparrow Making Sound");
    }

}
