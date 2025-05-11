package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.ArrayView;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.DataType;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils.SortType;

import java.util.Arrays;

public class View {
    private final Stage stage;

    private Scene scene;

    private VBox root;

    private ToolBar toolBarMain;
    private Button start = new Button();
    private Button next = new Button();
    private Button prev = new Button();
    private Button stop = new Button();
    private Button startAnimated = new Button();
    private Spinner<Integer> timeAnimationSpinner = new Spinner<>(0, 10, 1);
    private ChoiceBox<DataType> choiceDataType;
    private ChoiceBox<SortType> choiceSortType;
    private Button addFromFile = new Button();

    private ToolBar toolBarArray;
    private Button addEl = new Button();
    private Button deleteEl = new Button();

    private final ArrayView arrayView = new ArrayView();

    private final HBox allInfo = new HBox();

    private final VBox info = new VBox();
    private final VBox timings = new VBox();

    public View(Stage stage) {
        this.stage = stage;
        prepareButtons();
        prepareSpinner();
        prepareChoiceBoxes();
        prepareToolbarMain();
        prepareToolbarArray();
        prepareAllInfo();
        initDefault(5);
        buildScene();
        addOnStage();
    }

    private void prepareButtons() {
        addGraphicOnButton(start, "start.png", 30);
        addGraphicOnButton(next, "next.png", 30);
        addGraphicOnButton(prev, "prev.png", 30);
        addGraphicOnButton(stop, "stop.png", 30);
        addGraphicOnButton(startAnimated, "playAnimated.png", 30);
        addGraphicOnButton(addFromFile, "folder.png", 30);

        addGraphicOnButton(addEl, "plus.png", 12);
        addGraphicOnButton(deleteEl, "minus.png", 12);
    }

    private void prepareSpinner() {
        timeAnimationSpinner.setEditable(true);
    }

    private void prepareChoiceBoxes() {
        choiceDataType = new ChoiceBox<>();
        choiceDataType.getItems().addAll(DataType.values());
        choiceDataType.setValue(DataType.INTEGER);
        choiceSortType = new ChoiceBox<>();
        choiceSortType.getItems().addAll(SortType.values());
        choiceSortType.setValue(SortType.GNOMESORT);
    }

    private void prepareAllInfo() {
        allInfo.getChildren().addAll(info, timings);
    }

    private void prepareToolbarMain() {
        Region spacer1 = new Region();
        spacer1.setMinWidth(30);
        Region spacer2 = new Region();
        spacer2.setMinWidth(30);
        Region spacer3 = new Region();
        spacer3.setMinWidth(30);
        Region spacer4 = new Region();
        spacer4.setMinWidth(30);
        Region spacer6 = new Region();
        spacer6.setMinWidth(30);
        Region spacer5 = new Region();
        spacer5.setMinWidth(40);
        Region spacer7 = new Region();
        spacer7.setMinWidth(30);
        Region spacer8 = new Region();
        spacer8.setMinWidth(30);
        toolBarMain = new ToolBar(start, spacer1, prev, spacer2, next, spacer3, stop, spacer6, startAnimated, spacer7, timeAnimationSpinner, spacer4, choiceSortType, spacer8, choiceDataType, spacer5, addFromFile);
    }

    private void prepareToolbarArray() {
        Region spacer1 = new Region();
        spacer1.setMinWidth(20);
        Region spacer2 = new Region();
        spacer2.setMinWidth(20);
        toolBarArray = new ToolBar(addEl, spacer1, deleteEl, spacer2);
    }

    private void initDefault(int size) {
        String[] arr = new String[size];
        Arrays.fill(arr, "");
        arrayView.reinitFromArray(arr);
    }

    private void buildScene() {
        ScrollPane scrollPane = new ScrollPane(arrayView);
        scrollPane.setMinHeight(60);
        root = new VBox(toolBarMain, toolBarArray, scrollPane, allInfo);
        scene = new Scene(root);
    }

    private void addOnStage() {
        stage.setScene(scene);
    }

    private static void addGraphicOnButton(Button button, String imgName, int size) {
        Image image = new Image(View.class.getResourceAsStream("/img/" + imgName));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        button.setGraphic(imageView);
        button.setStyle("-fx-background:transparent;");
    }

    public Button getStart() {
        return start;
    }

    public Button getNext() {
        return next;
    }

    public Button getPrev() {
        return prev;
    }

    public Button getAddFromFile() {
        return addFromFile;
    }

    public Button getStop() {
        return stop;
    }

    public Button getAddEl() {
        return addEl;
    }

    public Button getDeleteEl() {
        return deleteEl;
    }

    public ChoiceBox<DataType> getChoiceDataType() {
        return choiceDataType;
    }

    public ArrayView getArrayView() {
        return arrayView;
    }

    public VBox getInfo() {
        return info;
    }

    public VBox getTimings() {
        return timings;
    }

    public ChoiceBox<SortType> getChoiceSortType() {
        return choiceSortType;
    }

    public Stage getStage() {
        return stage;
    }

    public Button getStartAnimated() {
        return startAnimated;
    }

    public Spinner<Integer> getTimeAnimationSpinner() {
        return timeAnimationSpinner;
    }
}
