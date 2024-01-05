package game.collect.logic;

import abstractFactory.AbstractFactory;
import general.logic.Cell;
import general.logic.GraphicCell;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Point_Collect {
    protected Cell point;
    protected GraphicCell representation;
    protected Map_Collect map;
    protected AbstractFactory imageFactory;
    private Queue<Integer> availableColumns;

    public Point_Collect(Map_Collect map, AbstractFactory imageFactory) {
        this.map = map;
        this.imageFactory = imageFactory;
        this.representation = new GraphicCell(this.imageFactory.getCircle(), this.map.getFreeCell().getBackground());
    }

    public void move() {
        boolean posible = true;

        if(point != null && !point.isFree()) {
            if(point.getRow() == 1) {
                if(!map.getCell(point.getRow() - 1, point.getColumn()).isFree()) {
                    point.clear();
                    map.addPoints(100);
                }
                else
                    posible = false;
            }
            else {
                point.clear();
                point = map.getCell(point.getRow() - 1, point.getColumn());
                point.put(representation);
            }
        }
        if (!posible) {
            map.lose();
        }

    }

    public void charge() {
        Integer[] columnIndex = {0, 1, 2, 3, 4, 5,6,7,8};
        availableColumns = new LinkedList<>();
        for (int column : columnIndex) {
            availableColumns.offer(column);}
        if (!availableColumns.isEmpty()) {
            int randomColumn = getRandomColumn();
            point = map.getCell(15, randomColumn);
            point.put(representation);
        } else {
            System.out.println("ERROR");
        }
    }

    private int getRandomColumn() {
        int randomIndex = new Random().nextInt(availableColumns.size());
        int selectedColumn = 0;

        for (int i = 0; i <= randomIndex; i++) {
            selectedColumn = availableColumns.poll();
//            System.out.println(selectedColumn);
        }

        return selectedColumn;
    }

}