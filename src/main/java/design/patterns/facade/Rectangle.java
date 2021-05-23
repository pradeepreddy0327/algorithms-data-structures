package design.patterns.facade;

import design.patterns.factory.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

}
