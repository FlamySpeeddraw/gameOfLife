package com.flamingamaranth.gameoflife;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.flamingamaranth.util.Coordinate2D;

public class Board {
    private HashSet<Coordinate2D> alivedCells;
    private int cols;
    private int lines;
    private int currentGeneration;

    public Board(int cols, int lines) {
        this.cols = cols;
        this.lines = lines;
        this.currentGeneration = 0;
        this.alivedCells = new HashSet<>();
    }

    public HashMap<Coordinate2D,Boolean> getCellsToCheck() {
        HashMap<Coordinate2D,Boolean> cellsToCheck = new HashMap<>();

        for (Coordinate2D cell : this.alivedCells) {
            for (Coordinate2D neighBourCell : this.getNeighbour((cell))) {
                if (!alivedCells.contains(neighBourCell)) cellsToCheck.put(neighBourCell, false);
            }
            cellsToCheck.put(cell,true);
        }

        return cellsToCheck;
    }

    public HashSet<Coordinate2D> getAlivedCells() {
        HashSet<Coordinate2D> cellsSet = new HashSet<>();
        cellsSet.addAll(this.alivedCells);
        
        return cellsSet;
    }

    public void setAlivedCells(HashSet<Coordinate2D> alivedCells) {
        this.alivedCells = alivedCells;
    }

    public int getNbAlivedNeighbourCells(Coordinate2D middleCell) {
        int result = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == 0 && j == 0) && this.alivedCells.contains(new Coordinate2D(middleCell.getX()+j, middleCell.getY()+i))) result++;
            }
        }

        return result;
    }

    public HashSet<Coordinate2D> getNeighbour(Coordinate2D middleCell) {
        HashSet<Coordinate2D> cellsSet = new HashSet<>();
        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == 0 && j == 0)) cellsSet.add(new Coordinate2D(middleCell.getX()+j, middleCell.getY()+i));
            }
        }

        return cellsSet;
    }

    public int getCols() {
        return this.cols;
    }

    public void setCols(int nb) {
        this.cols = nb;
    }

    public int getLines() {
        return this.lines;
    }

    public void setLines(int nb) {
        this.lines = nb;
    }

    public int getCurrentGeneration() {
        return this.currentGeneration;
    }

    public void die(Coordinate2D cell) {
        alivedCells.remove(cell);
    }

    public void birth(Coordinate2D cell) {
        alivedCells.add(cell);
    }

    public void displayBoardOnConsole() {
        for (int i = 0; i < this.lines; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print((this.alivedCells.contains(new Coordinate2D(j, i))) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        HashSet<Coordinate2D> alivedCellsCopy = new HashSet<>();
        int nbAlivedNeighbourCells;

        alivedCellsCopy.addAll(this.alivedCells);

        for (Map.Entry<Coordinate2D,Boolean> entry : this.getCellsToCheck().entrySet()) {
            nbAlivedNeighbourCells = this.getNbAlivedNeighbourCells(entry.getKey());

            if (entry.getValue() && !(nbAlivedNeighbourCells == 2|| nbAlivedNeighbourCells == 3)) {
                alivedCellsCopy.remove(entry.getKey());
            } else if (!(entry.getValue()) && nbAlivedNeighbourCells == 3) {
                alivedCellsCopy.add(entry.getKey());
            }
        }

        alivedCells.clear();
        alivedCells.addAll(alivedCellsCopy);
        alivedCellsCopy.clear();
        this.currentGeneration++;
    }
}
