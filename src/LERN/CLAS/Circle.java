package LERN.CLAS;

/**
 *
 **/
public class Circle extends Figure {
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius){
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }

    @Override
    public double gegPerimeter() {
        return 2*3.14*radius;
    }
}
