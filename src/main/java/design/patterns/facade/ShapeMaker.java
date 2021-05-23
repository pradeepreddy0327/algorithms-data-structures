package design.patterns.facade;

public class ShapeMaker {

    private Circle circle;
    private Rectangle rectangle;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectanle() {
        rectangle.draw();
    }
}
