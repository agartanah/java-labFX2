package geometry2d;

import exceptions.NoDataException;
import exceptions.ZeroValueException;
import javafx.scene.paint.Color;

public class Circle implements Figure {
    double radius;
    double positionX = 0;
    double positionY = 0;
    Color color;
    javafx.scene.shape.Circle circleFX;

    public javafx.scene.shape.Circle getCircleFX() {
        return circleFX;
    }

    public void setCircleFX(javafx.scene.shape.Circle circleFX) {
        this.circleFX = circleFX;
        this.radius = circleFX.getRadius();
        this.positionX = circleFX.getTranslateX();
        this.positionY = circleFX.getTranslateY();
        this.color = (Color) circleFX.getFill();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        circleFX.setFill(color);
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
        circleFX.setTranslateX(positionX);
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
        circleFX.setTranslateY(positionY);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ZeroValueException {
        if (radius <= 0) {
            throw new ZeroValueException("Radius cannot be zero");
        }

        this.radius = radius;
        circleFX.setRadius(radius);
    }

    public Circle(double radius) {
        if (radius <= 0) {
            throw new ZeroValueException("Radius cannot be zero");
        }

        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        if (radius <= 0) {
            throw new NoDataException("No data to display");
        }

        return "Circle with Radius = " + radius;
    }
}
