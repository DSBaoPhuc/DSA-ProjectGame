package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import abstractFactory.AbstractFactory;
import sound.Sound;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    protected AbstractFactory factory;
    protected Sound sound;
    protected JPanel panel;
    protected Font font;

    protected ImageIcon img = new ImageIcon("src/assets/img/light/gui/Egg_icon.png");

    public GUI(AbstractFactory factory, Sound sound) {
        this.factory = factory;
        this.sound = sound;
        this.panel = new JPanel();
        initialize();
        createFont();
    }

    private void initialize() {
        setIconImage(img.getImage());
        setTitle("COLLECT Game");
        setSize((int)factory.getScreenResolution().getWidth() + 16, (int) factory.getScreenResolution().getHeight() + 39);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setPanel(new InitialPanel(this));
    }

    public void setPanel(JPanel p) {
        getContentPane().remove(panel);
        panel = p;
        getContentPane().add(panel);
        panel.requestFocusInWindow();
        validate();
        repaint();
    }

    public AbstractFactory getImageFactory() {
        return factory;
    }

    public void setImageFactory(AbstractFactory factory) {
        this.factory = factory;
    }

    public Sound getSound() {
        return sound;
    }

    private void createFont() { // Since the GUI is created only once, the font is also created only once.
        font = null;
        try {
            InputStream is =  getClass().getResourceAsStream("/assets/font/futurespore.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException ex) {
            System.out.println("ERROR: FONT NOT FOUND");
        }
    }

    public Font getTheFont() {
        return font;
    }

}
