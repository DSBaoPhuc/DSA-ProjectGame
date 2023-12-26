package abstractFactory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;

public class LightFactory extends AbstractFactory{
    private Icon triangle;
    private Icon circle;

    public LightFactory(Dimension resolution) {
        super(resolution);

        colorDefault = new Color(82, 190, 128);
        colorForeground = new Color(0, 0, 0, 150);

        createCommonIcons();
    }

    public LightFactory(Dimension resolution, Color colorDefault) {
        super(resolution);

        this.colorDefault = colorDefault;
        colorForeground = new Color(0, 0, 0, 150);

        createCommonIcons();
    }

    public void setScreenResolution(Dimension resolution) {
        super.setScreenResolution(resolution);
        createCommonIcons();
    }

    private void createCommonIcons() {
        triangle = getTheIcon("/assets/img/dark/gameImages/common/triangle.png");
        circle = getTheIcon("/assets/img/dark/gameImages/common/circle.png");
    }

    public Color getColorDefault() {
        return colorDefault;
    }

    public Color getColorForeground() {
        return colorForeground;
    }

    public Color getDefaultMarkColor() {
        Color res = colorDefault;
        int r = colorDefault.getRed();
        int g = colorDefault.getGreen();
        int b = colorDefault.getBlue();
        boolean editable = false;
        if(r - 20 >= 0) {
            r -= 20;
            editable = true;
        }
        if(g - 20 >= 0) {
            g -= 20;
            editable = true;
        }
        if(b - 20 >= 0) {
            b -= 20;
            editable = true;
        }
        if(editable)
            res = new Color(r, g, b);
        return res;
    }

    public Icon getGameIcon(String name) {
        return getTheIcon("/assets/img/dark/gameIcons/"+name+".png");
    }

    public Icon getKeyboard6() {
        return getTheIcon("/assets/img/dark/gui/keyboard6.png");
    }

    public Icon getRestart() {
        return getTheIcon("/assets/img/dark/gui/restart.png");
    }

    public Icon getHome() {
        return getTheIcon("/assets/img/dark/gui/home.png");
    }

    public Icon getExit() {
        return getTheIcon("/assets/img/dark/gui/exit.png");
    }

    public Icon getConfiguration() {
        return getTheIcon("/assets/img/dark/gui/configuration.png");
    }

    public Icon getEmpty() {
        return null;
    }

    public Icon getTriangle() {
        return triangle;
    }

    public Icon getCircle() {
        return circle;
    }

}
