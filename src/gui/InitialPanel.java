package gui;
import javax.swing.JPanel;

import game.collect.gui.Difficulties;
import game.collect.gui.Panel_Collect;

import general.gui.GeneralPanel;
import general.utilities.InternalBorderRound;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InitialPanel extends GeneralPanel{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;
    protected JButton[][] matrix;
    protected JButton btnConfiguration;
    protected JPanel panel;
    public InitialPanel(GUI gui) {
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
        int fontSize = (int) Math.round(50 * scaleFactor); //change size of Button

        btnConfiguration = new JButton(gui.getImageFactory().getConfiguration());
        btnConfiguration.setBackground(gui.getImageFactory().getDefaultMarkColor());
        btnConfiguration.setFocusable(false);
        btnConfiguration.addMouseListener(getMouseAdapter());
        btnConfiguration.addActionListener(e -> gui.setPanel(new ConfigurationPanel(this.gui)));
        btnConfiguration.setBounds(0, 0, (int) Math.round(200 * scaleFactor), (int) Math.round(200 * scaleFactor));
        btnConfiguration.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        add(btnConfiguration);

        //create play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        playButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        playButton.setFocusable(false);
        playButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        playButton.addMouseListener(getMouseAdapter());
        playButton.addActionListener(e -> gui.setPanel(new Panel_Collect(this.gui)));
        panel.add(playButton);

        //create select level button
        JButton lvButton = new JButton("Select Difficulty");
        lvButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        lvButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        lvButton.setFocusable(false);
        lvButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        lvButton.addMouseListener(getMouseAdapter());
        lvButton.addActionListener(e -> gui.setPanel(new Difficulties(this.gui)));
        panel.add(lvButton);

        //create escape button
        JButton escapeButton = new JButton("Escape");
        escapeButton.setFont(new Font("ALGERIAN", Font.PLAIN, fontSize));
        escapeButton.setBackground(gui.getImageFactory().getDefaultMarkColor());
        escapeButton.setFocusable(false);
        escapeButton.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
        escapeButton.addMouseListener(getMouseAdapter());
        escapeButton.addActionListener(e -> System.exit(0));
        escapeButton.setIcon(gui.getImageFactory().getExit());
        panel.add(escapeButton);
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
}