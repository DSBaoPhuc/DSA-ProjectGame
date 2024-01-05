package abstractFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class AbstractFactory {
    protected int screenWidth;
    protected int screenHeight;
    public static final int DEFAULT_WIDTH = 1920;
    public static final int DEFAULT_HEIGHT = 1080;
    protected Color colorDefault;
    protected Color colorForeground;

    public AbstractFactory(Dimension resolution) {
        screenWidth = (int) resolution.getWidth();
        screenHeight = (int) resolution.getHeight();
    }

    public void setColorDefault(Color colorDefault) {
        this.colorDefault = colorDefault;
    }

    public void setScreenResolution(Dimension resolution) {
        screenWidth = (int) resolution.getWidth();
        screenHeight = (int) resolution.getHeight();
    }

    public Dimension getScreenResolution() {
        return new Dimension(screenWidth, screenHeight);
    }

    protected ImageIcon getTheIcon(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        return scale(icon);
    }

    protected ImageIcon scale(ImageIcon imageIcon) {
        double h = screenHeight;
        double scaleFactor = h / DEFAULT_HEIGHT;

        int width = (int) Math.round(imageIcon.getIconWidth() * scaleFactor);
        int height = (int) Math.round(imageIcon.getIconHeight() * scaleFactor);
        return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

    public abstract Color getColorDefault();

    public abstract Color getColorForeground();

    public abstract Color getDefaultMarkColor();

    public abstract Icon getConfiguration();

    public abstract Icon getRestart();

    public abstract Icon getHome();

    public abstract Icon getExit();

    public abstract Icon getGameIcon(String name);

    public abstract Icon getKeyboard6();

    public abstract Icon getEmpty();

    public abstract Icon getTriangle();

    public abstract Icon getCircle();
}
