package games.collect.logic;

import games.collect.gui.Panel_Collect;
import games.collect.thread.Clock_Collect;
import general.logic.Game;

public class Game_Collect extends Game{
    protected Player_Collect player;
    protected Clock_Collect clock_collect;
    protected int tick;
    protected Point_Collect point_1;
    protected Point_Collect point_2;
    protected Point_Collect point_3;
    protected Point_Collect point_4;
    protected Point_Collect point_5;
    private Difficulty currentDifficulty;

    public enum Difficulty{
        EASY,
        MEDIUM,
        HARD;
    }

    public Game_Collect(Panel_Collect panel) {
        super(panel);
        Map_Collect map = new Map_Collect(this);
        this.player = new Player_Collect(map, this.panel.getImageFactory(), this.panel.getSound());
        this.clock_collect = new Clock_Collect(this, 400);
        this.point_1 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_2 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_3 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_4 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_5 = new Point_Collect(map, this.panel.getImageFactory());
        this.tick = 0;
        this.clock_collect.start();

        this.currentDifficulty = Difficulty.EASY;
    }

    public Game_Collect(Panel_Collect panel, Game_Collect.Difficulty difficulty) {
        super(panel);
        Map_Collect map = new Map_Collect(this);
        this.player = new Player_Collect(map, this.panel.getImageFactory(), this.panel.getSound());
        this.clock_collect = new Clock_Collect(this, 400);
        this.point_1 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_2 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_3 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_4 = new Point_Collect(map, this.panel.getImageFactory());
        this.point_5 = new Point_Collect(map, this.panel.getImageFactory());
        this.tick = 0;
        this.clock_collect.start();

        this.currentDifficulty = difficulty;

    }

    public synchronized void run() {
        tick++;
        point_1.move();
        point_2.move();
        point_3.move();
        point_4.move();
        point_5.move();
        if(tick == 3) {
            point_1.charge();
        }
        if(tick == 6) {
            point_2.charge();
        }
        if(tick == 9) {
            point_3.charge();
        }
        if(tick == 12) {
            point_4.charge();
        }
        if(tick == 15) {
            point_5.charge();
            tick = 0;
        }
    }

    @Override
    public void operate(int operation) {
        switch (operation) {
            case MOVE_LEFT:
                player.moveLeft();
                break;
            case MOVE_RIGHT:
                player.moveRight();
                break;
            default:
                break;
        }
    }

    @Override
    public void addPoints(int points) {

        super.addPoints(points);
        if (currentDifficulty != null){
            switch (currentDifficulty) {
                case EASY:
                    if (this.points % 500 == 0) {
                        addLevel();
                        if (clock_collect.getStep() > 40)
                            clock_collect.setStep(clock_collect.getStep() - 20);
                    }
                    break;
                case MEDIUM:
                    if (this.points % 300 == 0) {
                        addLevel();
                        if (clock_collect.getStep() > 20)
                            clock_collect.setStep(clock_collect.getStep() - 10);
                    }
                    break;
                case HARD:
                    if (this.points % 200 == 0) {
                        addLevel();
                        if (clock_collect.getStep() > 5)
                            clock_collect.setStep(clock_collect.getStep() - 5);
                    }
                    break;
                default:
                    break;
            }}
        else{
            System.out.println("Error");
        }
    }

}