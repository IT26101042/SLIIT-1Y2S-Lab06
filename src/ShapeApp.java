// Q03

// a)
class Shape {
    protected String shapeName;

    // a)
    public Shape() {
        this("Unknown Shape");
    }


    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }


    public void displayShapeDetails() {
        System.out.println("Shape Name: " + shapeName);
    }

    // b)
    public double calculateArea() {
        return 0.0;
    }

    // b)
    public double calculateArea(double factor) {
        return calculateArea() * factor;
    }
}

// c)
class Rectangle extends Shape {
    private double length;
    private double width;


    public Rectangle() {
        this("Rectangle", 0.0, 0.0);
    }


    public Rectangle(String shapeName, double length, double width) {
        super(shapeName);
        this.length = length;
        this.width = width;
    }


    @Override
    public double calculateArea() {
        return length * width;
    }

    // c)
    @Override
    public void displayShapeDetails() {
        super.displayShapeDetails();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
    }
}

//  d)
class Triangle extends Shape {
    private double base;
    private double height;


    public Triangle() {
        this("Triangle", 0.0, 0.0);
    }


    public Triangle(String shapeName, double base, double height) {
        super(shapeName);
        this.base = base;
        this.height = height;
    }


    @Override
    public double calculateArea() {
        return (base * height) / 2.0;
    }


    @Override
    public void displayShapeDetails() {
        super.displayShapeDetails();
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        System.out.println("Area: " + calculateArea());
    }
}

// e)
public class ShapeApp {
    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle();


        Triangle triangle = new Triangle("Triangle", 10.0, 6.0);

        System.out.println("Rectangle");


        rectangle.displayShapeDetails();


        System.out.println("Original Area: " + rectangle.calculateArea());
        System.out.println("Scaled Area (factor 2): "
                + rectangle.calculateArea(2.0));

        System.out.println();
        System.out.println("Triangle");


        triangle.displayShapeDetails();


        System.out.println("Original Area: " + triangle.calculateArea());
        System.out.println("Scaled Area (factor 2): "
                + triangle.calculateArea(2.0));
    }
}