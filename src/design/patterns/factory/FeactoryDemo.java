package design.patterns.factory;

public class FeactoryDemo {

    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        sf.getShape("Circle").draw();
        sf.getShape("Triangle").draw();
        sf.getShape("Rectangle").draw();
    }

}
