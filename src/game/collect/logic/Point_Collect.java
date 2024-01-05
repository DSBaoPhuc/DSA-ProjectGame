package game.collect.logic;

import abstractFactory.AbstractFactory;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.utilities.NRandom;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Point_Collect {
    protected Cell point;
    protected GraphicCell representation;
    protected Map_Collect map;
    protected AbstractFactory imageFactory;

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

//    public void charge() {
//        point = map.getCell(15, Math.abs(NRandom.getInstance().nextInt() % 9));
//        point.put(representation);
//    }

    public void charge() {
        Queue<Integer> availableColumns = new LinkedList<>();

        Random random = new Random();
        int randomIndex = random.nextInt(9);  availableColumns.offer(randomIndex);

        int selectedColumn = availableColumns.poll();

        point = map.getCell(15, selectedColumn);
        point.put(representation);
    }

}