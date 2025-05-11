package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Set;

public class ArrayView extends HBox {
    private final String[] COLORS = new String[]{};

    public void reinitFromArray(Object[] arr) {
        getChildren().clear();
        for (Object value : arr) {
            add(value, false);
        }
    }

    public void reinitColoredFromArray(Object[] arr, Set<Integer> coloredIndexes) {
        getChildren().clear();
        for (int i = 0; i < arr.length; i++) {
            add(arr[i], coloredIndexes.contains(i));
        }
    }

    public <T> void add(T value, boolean isColored) {
        TextField textField;
        if (isColored) {
            textField = makeArrayEl(String.valueOf(value), true);
        } else {
            textField = makeArrayEl(String.valueOf(value));
        }
        getChildren().add(textField);
    }

    public void removeLast() {
        if (getChildren().isEmpty()) {
            return;
        }
        getChildren().remove(getChildren().size() - 1);
    }

    private static <T> TextField makeArrayEl(T value) {
        return makeArrayEl(value, false);
    }

    private static <T> TextField makeArrayEl(T value, boolean isColored) {
        TextField textField = new TextField(String.valueOf(value));
        String color = isColored ? "#F08080;" : "#ffffff;";
        textField.setStyle(
                "-fx-background-color: " + color +
                        "-fx-border-color: #000;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 0;" +
                        "-fx-background-radius: 0;" +
                        "-fx-font-family: 'Roboto', sans-serif;" +
                        "-fx-font-size: 12px;" +
                        "-fx-text-fill: #2c3e50;" +
                        "-fx-alignment: center;" +
                        "-fx-effect: dropshadow(one-pass-box, rgba(58,123,213,0.3), 4, 0, 0, 2);" +
                        "-fx-pref-width: 60px;" +
                        "-fx-pref-height: 30px;"
        );
        textField.setEditable(true);
        return textField;
    }


    public String[] parseInput() {
        String[] arr = new String[getChildren().size()];
        for (int i = 0; i < arr.length; i++) {
            Node node = getChildren().get(i);
            if (node instanceof TextField textField) {
                try {
                    arr[i] = textField.getText().strip();
                } catch (NumberFormatException e) {
                    arr[i] = "";
                }

            }
        }
        return arr;
    }

    public void changeEditable() {
        for (Node node : getChildren()) {
            if (node instanceof TextField textField) {
                textField.setEditable(!textField.isEditable());
            }
        }
    }
}
