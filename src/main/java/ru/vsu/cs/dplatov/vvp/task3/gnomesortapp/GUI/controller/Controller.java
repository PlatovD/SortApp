package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.FullSortData;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.factory.SortFactory;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.DataType;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.SortType;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.view.View;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.task.Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Controller {
    private final View view;
    private boolean isActive = false;
    private FullSortData fullSortData = null;
    private int currentIndex = 0;


    public Controller(View view) {
        this.view = view;
        setButtonsHandlers();
    }

    private <T> void setButtonsHandlers() {
        view.getStart().setOnAction(e -> startBtnHandler());
        view.getStop().setOnAction(e -> stopBtnHandler());

        view.getNext().setOnAction(e -> nextBtnHandler());
        view.getPrev().setOnAction(e -> prevBtnHandler());

        view.getStartAnimated().setOnAction(e -> animatedBtnHandler());

        view.getAddFromFile().setOnAction(e -> addFromFileHandler());

        view.getAddEl().setOnAction(e -> addElButtonHandler());
        view.getDeleteEl().setOnAction(e -> deleteElButtonHandler());
    }

    private void animatedBtnHandler() {
        if (isActive) {
            return;
        }

        prepareToView();
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            private int cnt = fullSortData.states.size();
            private final long interval = (view.getTimeAnimationSpinner().getValue() * 1_000_000_000L);

            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now;
                }

                if (now - lastUpdate >= interval) {
                    nextBtnHandler();
                    cnt--;
                    lastUpdate = now;
                }

                if (cnt <= 0) {
                    stopBtnHandler();
                    this.stop();
                }
            }
        };
        animationTimer.start();
    }

    private void prepareToView() {
        try {
            isActive = true;
            view.getArrayView().changeEditable();

            DataType dataType = view.getChoiceDataType().getValue();
            SortType sortType = view.getChoiceSortType().getValue();

            Sort<Object> sort = SortFactory.createSort(sortType);
            Object[] arr = Arrays.stream(view.getArrayView().parseInput()).map(dataType.getPayload().converter).toArray();

            fullSortData = sort.sortWithData(arr, dataType.getPayload().comparator);
            view.getArrayView().reinitColoredFromArray(fullSortData.states.get(currentIndex).arr, fullSortData.states.get(currentIndex).importantIndexes);

            fillInfo();
        } catch (ClassCastException e) {
            throw new ClassCastException("Invalid datatype in array " + e.getMessage());
        }
    }

    private void deleteElButtonHandler() {
        if (isActive) {
            return;
        }
        view.getArrayView().removeLast();
    }

    private void addElButtonHandler() {
        if (isActive) {
            return;
        }
        view.getArrayView().add("", false);
    }

    private void startBtnHandler() {
        if (isActive) {
            return;
        }
        prepareToView();
    }

    private void stopBtnHandler() {
        if (!isActive) {
            return;
        }
        clearData();
    }

    private void nextBtnHandler() {
        if (!isActive) {
            return;
        }
        if (!(fullSortData.states.size() - 1 > currentIndex)) {
            return;
        }
        currentIndex++;
        view.getArrayView().reinitColoredFromArray(fullSortData.states.get(currentIndex).arr, fullSortData.states.get(currentIndex).importantIndexes);
    }

    private void prevBtnHandler() {
        if (!isActive) {
            return;
        }
        if (!(currentIndex - 1 > -1)) {
            return;
        }
        currentIndex--;
        view.getArrayView().reinitColoredFromArray(fullSortData.states.get(currentIndex).arr, fullSortData.states.get(currentIndex).importantIndexes);
    }

    private void clearData() {
        view.getArrayView().changeEditable();
        if (fullSortData != null)
            view.getArrayView().reinitFromArray(fullSortData.states.get(currentIndex).arr);
        currentIndex = 0;
        isActive = false;
        fullSortData = null;
        view.getInfo().getChildren().clear();
        view.getTimings().getChildren().clear();

    }

    private void fillInfo() {
        view.getInfo().getChildren().addAll(
                new Label("Размер исходного массива " + fullSortData.arrSize),
                new Label("Кол-во итераций " + fullSortData.cntIterations),
                new Label("Кол-во обменов " + fullSortData.cntReplaces),
                new Label("Скорость работы (миллисекунд) " + fullSortData.workingTime)
        );
//        view.getTimings() {
//
//        }
    }

    private void addFromFileHandler() {
        if (isActive) {
            return;
        }
        clearData();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл с матрицей");

        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

        File selectedFile = fileChooser.showOpenDialog(view.getStage());
        if (selectedFile == null) {
            System.out.println("Файл не выбран.");
        }
        view.getArrayView().reinitFromArray(parseValues(selectedFile));
    }

    private Object[] parseValues(File file) {
        List<String> nums;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            nums = Arrays.stream(bufferedReader.readLine().trim().split("\\s+")).toList();
        } catch (IOException e) {
            throw new RuntimeException("Wrong file");
        }
        return nums.toArray();
    }
}
