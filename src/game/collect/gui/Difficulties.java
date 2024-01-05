package game.collect.gui;

import javax.swing.JPanel;
import game.collect.logic.Game_Collect;
import general.gui.GamePanel;
import general.gui.GeneralPanel;

import general.utilities.InternalBorderRound;
import gui.ConfigurationPanel;
import gui.GUI;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Difficulties extends GeneralPanel{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;
    protected JButton[][] matrix;
    protected JButton btnConfiguration;
    protected JPanel panel;
    protected GamePanel gamePanel;
    
    
    public Difficulties(GUI gui) {
        super(gui);
        matrix = new JButton[3][3];
        panel = new JPanel();
        createPanel();
        putBottons();
        setBackground(this.gui.getImageFactory().getColorDefault());
    }

    private void createPanel() {
        int x = (int) Math.round(((1920 - 600) / 2) * scaleFactor);
        int y = (int) Math.round(((1080 - 600) / 2) * scaleFactor);
        int w = (int) Math.round(600 * scaleFactor);
        int h = (int) Math.round(600 * scaleFactor);
        panel.setBounds(x,y,w,h);

        panel.setLayout(new GridLayout(matrix.length, matrix[0].length));
        panel.setBackground(gui.getImageFactory().getColorDefault());
        add(panel);
    }

    private void putBottons() {
        int borderSize = (int) Math.round(10 * scaleFactor);
        int borderRadius = (int) Math.round(96 * scaleFactor);
        int fontSize = (int) Math.round(50 * scaleFactor);

        btnConfiguration = new JButton(gui.getImageFactory().getConfiguration());
        btnConfiguration.setBackground(gui.getImageFactory().getDefaultMarkColor());
        btnConfiguration.setFocusable(false);
        btnConfiguration.addMouseListener(getMouseAdapter());
        btnConfiguration.addActionListener(e -> gui.setPanel(new ConfigurationPanel(this.gui)));
        btnConfiguration.setBounds(0, 0, (int) Math.round(200 * scaleFactor), (int) Math.round(200 * scaleFactor));
        btnConfiguration.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        add(btnConfiguration);


        //create easy level button
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        easyButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        easyButton.setFocusable(false);
        easyButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        easyButton.addMouseListener(getMouseAdapter());
        easyButton.addActionListener(e -> {
            setDifficulty(Game_Collect.Difficulty.EASY);
            gui.setPanel(new Panel_Collect(this.gui, Game_Collect.Difficulty.EASY ));
        });
        panel.add(easyButton);

        //create medium level button
        JButton medButton = new JButton("Medium");
        medButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        medButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        medButton.setFocusable(false);
        medButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        medButton.addMouseListener(getMouseAdapter());
        medButton.addActionListener(e -> {
            setDifficulty(Game_Collect.Difficulty.MEDIUM);
            gui.setPanel(new Panel_Collect(this.gui,Game_Collect.Difficulty.MEDIUM));
        });
        panel.add(medButton);

        //create hard level button
        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        hardButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        hardButton.setFocusable(false);
        hardButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        hardButton.addMouseListener(getMouseAdapter());
        hardButton.addActionListener(e -> {
            setDifficulty(Game_Collect.Difficulty.HARD);
            gui.setPanel(new Panel_Collect(this.gui,Game_Collect.Difficulty.HARD));
        });
        panel.add(hardButton);
    }

    private MouseAdapter getMouseAdapter(){
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(gui.getImageFactory().getDefaultMarkColor().brighter());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(gui.getImageFactory().getDefaultMarkColor());
            }

        };
    }
    
 public void setDifficulty(Game_Collect.Difficulty difficulty) {
}

}