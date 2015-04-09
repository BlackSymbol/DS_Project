package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Denis on 29.3.2015.
 */
public class StartScreen extends JPanel {
    private JTextField loginField;                  //user's e-mail
    private JPasswordField passwordField;           //user's password
    private final int labelLength = 75;             //preferred width of labels positioned before fields
    private final int minFieldLength = 150;         //minimum width of fields
    private final int maxComponentHeight = 50;      //maximum height of labels/fields

    /**
     * @param mainFrame parent frame (final because is used in button listeners to load certain parent methods)
     */
    public StartScreen(final MainFrame mainFrame)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //info panel
        JPanel infoPanel = new JPanel();
        JLabel infoLabel = new JLabel("Please login");
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);
        infoPanel.add(infoLabel);
        infoPanel.setMaximumSize(new Dimension(infoPanel.getMaximumSize().width, maxComponentHeight+50));

        //login panel
        JPanel loginPanel = new JPanel();
        JLabel loginLabel = new JLabel("E-mail");
        loginLabel.setPreferredSize(new Dimension(labelLength, loginLabel.getPreferredSize().height));
        loginPanel.add(loginLabel);
        loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(minFieldLength, loginField.getPreferredSize().height));
        loginPanel.setMaximumSize(new Dimension(loginPanel.getMaximumSize().width, maxComponentHeight));
        loginPanel.add(loginField);

        //password field panel
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(labelLength, passwordLabel.getPreferredSize().height));
        passwordPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(minFieldLength, passwordField.getPreferredSize().height));
        passwordPanel.setMaximumSize(new Dimension(passwordPanel.getMaximumSize().width, maxComponentHeight));
        passwordPanel.add(passwordField);

        //register panel
        JPanel registerPanel = new JPanel();
        JButton registerButton = new JButton("Register / Forgot password");
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerPanel.add(registerButton);


        //control buttons panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton quitButton = new JButton("Quit");
        JButton loginButton = new JButton("Login");
        controlPanel.add(quitButton);
        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(loginButton);
        controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        //overall view construction
        add(Box.createVerticalGlue());
        add(infoPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(loginPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(passwordPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(registerPanel);
        add(Box.createVerticalGlue());
        add(controlPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));

        //button listeners
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                TODO:
                - check if some field is empty
                - check email-password pair
                - if matches -> get usergroup
                - if usergroup == "Admin" -> call admin interface
                - if usergroup == "User" -> call standard user interface
                 */
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.goToRegisterScreen();
            }
        });
    }
}