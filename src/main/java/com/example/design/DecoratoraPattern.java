/*
Decorator pattern extends properties of the parent class and extends further 
This makes the class creation much more scalable with feature and allows reusability
*/
package com.example.design;

interface Shape {
    String draw();
}

class Triangle implements Shape {

    @Override
    public String draw() {
        // TODO Auto-generated method stub
        return "Triangle";
    }

}

class Circle implements Shape {

    @Override
    public String draw() {
        // TODO Auto-generated method stub
        return "Circle";
    }

}

abstract class ShapeDecorator implements Shape {
    Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }
}

class ColorDecorator extends ShapeDecorator {
    String color;

    public ColorDecorator(Shape shape, String color) {
        super(shape);
        this.color = color;
    }

    @Override
    public String draw() {
        // TODO Auto-generated method stub
        return color + " " + shape.draw();
    }

}

class PatternDecorator extends ShapeDecorator {
    String pattern;

    public PatternDecorator(Shape shape, String pattern) {
        super(shape);
        this.pattern = pattern;
    }

    @Override
    public String draw() {
        // TODO Auto-generated method stub
        return pattern + " " + shape.draw();
    }

}

class Test {
    public static void main(String[] args) {
        Shape circle = new Circle();
        System.out.println(circle.draw());

        Shape redCircle = new ColorDecorator(circle, "red");
        System.out.println(redCircle.draw());

        Shape redCircleWithBorder = new PatternDecorator(redCircle, "with border");
        System.out.println(redCircleWithBorder.draw());
    }
}
