package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model;

import java.util.ArrayList;
import java.util.List;

public class FullSortData {
    public int arrSize;
    public int cntReplaces = 0;
    public int cntIterations = 0;
    public double workingTime;
    public List<SortState> states = new ArrayList<>();
}
