/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapbuilder;

/**
 *
 * @author Eric
 */
public class GameMap {

    private int x;
    private int y;
    private IMapCell[][] cells;
    private Pair<Integer, Integer> entry = null;
    private Pair<Integer, Integer> exit = null;

    public GameMap(int x, int y) {
        this.x = x;
        this.y = y;
        cells = new IMapCell[x][y];
    }

    public GameMap(GameMap map) {
        this.x = map.getX();
        this.y = map.getY();
        this.entry = map.getEntry();
        this.exit = map.getExit();
        cells = new IMapCell[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                setCell(i, j, map.getCell(i, j));
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public IMapCell getCell(int x, int y) {
        return cells[x][y];
    }
    
    public IMapCell getCell(Pair<Integer, Integer> tile){
        return getCell(tile.getFirst(), tile.getSecond());
    }

    public void setCell(int x, int y, IMapCell cell) {
        cells[x][y] = cell;
    }
    
    public void setCell(Pair<Integer, Integer> tile, IMapCell cell){
        setCell(tile.getFirst(), tile.getSecond(), cell);
    }

    public void fillMap(IMapCell cell) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                setCell(i, j, cell);
            }
        }
    }

    public void fillMap(int x1, int y1, int x2, int y2, IMapCell cell) {
        if (Math.min(x1, x2) < 0) {
            throw new RuntimeException("X coordinate is less than zero");
        }
        if (Math.min(y1, y2) < 0) {
            throw new RuntimeException("Y Coordinate is less than zero");
        }
        if (Math.max(x1, x2) > this.getX() - 1) {
            throw new RuntimeException("X Coordinate is greater than getX()-1");
        }
        if (Math.max(y1, y2) > this.getY() - 1) {
            throw new RuntimeException("Y Coordinate is greater than getX()-1");
        }
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
            for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
                setCell(i, j, cell);
            }
        }
    }

    public boolean nextToCell(int x, int y, IMapCell cell) {
        int xL = x - 1;
        int xR = x + 1;
        int yL = y - 1;
        int yR = y + 1;

        if (xL >= 0 && getCell(xL, y).equals(cell)) {
            return true;
        }
        if (xR < getX() && getCell(xR, y).equals(cell)) {
            return true;
        }
        if (yL >= 0 && getCell(x, yL).equals(cell)) {
            return true;
        }
        if (yR < getY() && getCell(x, yR).equals(cell)) {
            return true;
        }
        return false;
    }

    public Pair<Integer, Integer> getEntry() {
        return entry;
    }

    public Pair<Integer, Integer> getExit() {
        return exit;
    }

    public void setEntry(Pair<Integer, Integer> entry) {
        this.entry = entry;
    }

    public void setExit(Pair<Integer, Integer> exit) {
        this.exit = exit;
    }

    public boolean validTile(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= this.getX() || y >= this.getY()) {
            return false;
        }
        return true;
    }
    
    public boolean validTile(Pair<Integer, Integer> tile){
        return validTile(tile.getFirst(), tile.getSecond());
    }
}
