package design.patterns.facade;

public class FacadeDemo {

    public static void main(String[] args) {
        ShapeMaker sm = new ShapeMaker();
        sm.drawCircle();
        sm.drawRectanle();
    }
}
