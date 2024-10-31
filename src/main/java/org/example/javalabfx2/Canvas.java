package org.example.javalabfx2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Canvas {
    @FXML
    private StackPane figureContainer;
    @FXML
    private Label cordX, cordY;

    private double initialX = 0, initialY = 0;

    private final Color[] colors = new Color[] {
        Color.BLUE, // 1
        Color.RED, // 2
        Color.BLACK, // 3
        Color.GREEN, // 4
        Color.YELLOW, // 5
        Color.PURPLE, // 6
        Color.AQUA // 7
    };
    private final Random random = new Random();

    @FXML
    public void initialize() {
        Rectangle clip = new Rectangle(figureContainer.getPrefWidth(), figureContainer.getPrefHeight());

        figureContainer.setClip(clip);
    }

    @FXML
    private void drawCircle() {
        geometry2d.Circle circle = generateCircle();

        circle.getCircleFX().setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) {
                Color color;
                do {
                    color = colors[random.nextInt(7)];
                } while(circle.getColor().equals(color));

                circle.setColor(color);
            }

            if (event.isPrimaryButtonDown()) {
                initialX = event.getX();
                initialY = event.getY();

                cordX.setText("X: " + initialX + " " + circle.getPositionX() + " " + event.getSceneX());
                cordY.setText("Y: " + initialY + " " + circle.getPositionY() + " " + event.getSceneY());

                circle.getCircleFX().toFront();
            }
        });

        circle.getCircleFX().setOnMouseDragged(event -> {
            if (event.isPrimaryButtonDown()) {
                double offsetX = event.getX() - initialX;
                double offsetY = event.getY() - initialY;

                circle.setPositionX(circle.getPositionX() + offsetX);
                circle.setPositionY(circle.getPositionY() + offsetY);

                cordX.setText("X: " + initialX + " " + circle.getPositionX() + " " + event.getSceneX());
                cordY.setText("Y: " + initialY + " " + circle.getPositionY() + " " + event.getSceneY());
            }
        });

        figureContainer.getChildren().add(circle.getCircleFX());
    }

    private geometry2d.Circle generateCircle() {
        geometry2d.Circle circle = new geometry2d.Circle(random.nextInt(151) + 50);
        circle.setCircleFX(new Circle(circle.getRadius()));

        circle.setColor(colors[random.nextInt(7)]);

        circle.setPositionX(random.nextInt(901) - 450);
        circle.setPositionY(random.nextInt(501) - 250);

        return circle;
    }

    @FXML
    private void drawRectangle() {
        geometry2d.Rectangle rectangle = generateRectangle();

        rectangle.getRectangleFX().setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) {
                Color color;
                do {
                    color = colors[random.nextInt(7)];
                } while(rectangle.getColor().equals(color));

                rectangle.setColor(color);
            }

            if (event.isPrimaryButtonDown()) {
                initialX = event.getX();
                initialY = event.getY();

                cordX.setText("X: " + initialX + " " + rectangle.getPositionX() + " " + event.getSceneX());
                cordY.setText("Y: " + initialY + " " + rectangle.getPositionY() + " " + event.getSceneY());

                rectangle.getRectangleFX().toFront();
            }
        });

        rectangle.getRectangleFX().setOnMouseDragged(event -> {
            if (event.isPrimaryButtonDown()) {
                double offsetX = event.getX() - initialX;
                double offsetY = event.getY() - initialY;

                rectangle.setPositionX(rectangle.getPositionX() + offsetX);
                rectangle.setPositionY(rectangle.getPositionY() + offsetY);

                cordX.setText("X: " + initialX + " " + rectangle.getPositionX() + " " + event.getSceneX());
                cordY.setText("Y: " + initialY + " " + rectangle.getPositionY() + " " + event.getSceneY());
            }
        });

        figureContainer.getChildren().add(rectangle.getRectangleFX());
    }

    private geometry2d.Rectangle generateRectangle() {
        geometry2d.Rectangle rectangle = new geometry2d.Rectangle(
                random.nextInt(151) + 50,
                random.nextInt(151) + 50
        );
        rectangle.setRectangleFX(new Rectangle(rectangle.getWidth(), rectangle.getHeight()));

        rectangle.setColor(colors[random.nextInt(7)]);

        rectangle.setPositionX(random.nextInt(901) - 450);
        rectangle.setPositionY(random.nextInt(501) - 250);

        return rectangle;
    }
}