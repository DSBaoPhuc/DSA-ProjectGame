package game.collect.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.collect.logic.Game_Collect;
import general.gui.GamePanel;
import general.logic.Game;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_Collect extends GamePanel{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;
    protected Game_Collect game;

    public Panel_Collect(GUI gui) {
        super(gui, false);
        fileToSavePath = "1_save";
        game = new Game_Collect(this);
        load();
        lblKeyboard.setIcon(gui.getImageFactory().getKeyboard6());
        lblKeyboard.setVisible(true);
    }

    public Panel_Collect(GUI gui, Game_Collect.Difficulty difficulty ) {
        super(gui, false);
        fileToSavePath = "1_save";

        load();
        lblKeyboard.setIcon(gui.getImageFactory().getKeyboard6());
        lblKeyboard.setVisible(true);
        this.game = new Game_Collect(this, difficulty);
    }

    @Override
    public void lose() {
        save();
        gui.setPanel(new GameOverPanel(gui, this, "FINISH", lblScore.getText(), lblTime.getText()));
    }

    @Override
    public void restart() {
        gui.setPanel(new Panel_Collect(gui));
    }

    @Override
    public String getFileToSavePath() {
        return fileToSavePath;
    }

    @Override
    protected void addControls() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(!game.isPause()) {
                    if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                        game.operate(Game.MOVE_LEFT);
                    }
                    if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        game.operate(Game.MOVE_RIGHT);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    game.pause();
                }
            }
        });
    }

    @Override
    public void setDifficulty(Game_Collect.Difficulty difficulty) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}