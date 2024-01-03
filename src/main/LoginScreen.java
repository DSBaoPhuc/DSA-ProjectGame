package main;

import abstractFactory.DarkFactory;
import gui.GUI;
import sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    protected ImageIcon img = new ImageIcon("src/assets/img/light/gui/Egg_icon.png");

    public LoginScreen() {
        setIconImage(img.getImage());
        setTitle("COLLECT Login Screen");
        setLocationRelativeTo(null);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
        panel.add(loginButton);
    }

    private void onLogin() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        JDialog loginDialog = new JDialog(this, "Login Result", true);

        loginDialog.setLocationRelativeTo(null);

        if (username.equals("phuc") && password.equals("phuc") ||
                username.equals("duc") && password.equals("duc") ||
                username.equals("nam") && password.equals("nam") ||
                username.equals("long") && password.equals("long")) {

            JOptionPane.showMessageDialog(loginDialog, "Login successful!");

            GUI gui = new GUI(new DarkFactory(new Dimension(1280, 720)), new Sound());
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);

            loginDialog.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(loginDialog, "Login failed. Please try again.");
            loginDialog.setVisible(false);
        }
    }

    public static void run(){
        new LoginScreen();
    }
}

