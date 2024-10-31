package geometry2d;

import exceptions.NoDataException;
import exceptions.ZeroValueException;
import javafx.scene.paint.Color;

public class Rectangle implements Figure {
    double width;
    double height;
    double positionX;
    double positionY;
    Color color;
    javafx.scene.shape.Rectangle rectangleFX;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        rectangleFX.setFill(color);
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
        rectangleFX.setTranslateX(positionX);
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
        rectangleFX.setTranslateY(positionY);
    }

    public javafx.scene.shape.Rectangle getRectangleFX() {
        return rectangleFX;
    }

    public void setRectangleFX(javafx.scene.shape.Rectangle rectangleFX) {
        this.rectangleFX = rectangleFX;
        this.height = rectangleFX.getHeight();
        this.width = rectangleFX.getWidth();
        this.positionX = rectangleFX.getTranslateX();
        this.positionY = rectangleFX.getTranslateY();
        this.color = (Color) rectangleFX.getFill();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new ZeroValueException("Width cannot be zero");
        }

        this.width = width;
        rectangleFX.setWidth(width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (width <= 0) {
            throw new ZeroValueException("Hate cannot be zero");
        }

        this.height = height;
        rectangleFX.setHeight(height);
    }

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new ZeroValueException("Width or Height cannot be zero");
        }

        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public String toString() {
        if (width <= 0 || height <= 0) {
            throw new NoDataException("No data to display");
        }

        return "Rectangle with Width = " + width + " and Height = " + height;
    }
}
