package Prototype.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends MainPanel{
    JPanel LoginPanel;
    JLabel LoginLabel;
    JLabel usernameLabel;
    JTextField username;
    JLabel passwordLabel;
    JPasswordField password;
    JButton loginButton;
    JLabel Signin;
    JLabel Signin2;
    public LoginPanel(){
        super();

        LoginPanel = new JPanel();
        LoginPanel.setBackground(new Color(34, 40, 49));
        LoginPanel.setBounds(184,109,400,550);
        LoginPanel.setLayout(null);

        LoginLabel = new JLabel();
        ImageIcon icon = new ImageIcon("/home/Deicide/IdeaProjects/Library Book Management System/src/Prototype/PIctures/TachiyomiIcons.png");
        LoginLabel.setText("Sign in to Tachiyomi");
        LoginLabel.setIcon(icon);
        LoginLabel.setForeground(Color.WHITE);
        LoginLabel.setFont(new Font("Arial",Font.BOLD,20));
        LoginLabel.setVerticalTextPosition(JLabel.BOTTOM);
        LoginLabel.setHorizontalTextPosition(JLabel.CENTER);
        LoginLabel.setIconTextGap(10);
        LoginLabel.setVerticalAlignment(JLabel.CENTER);
        LoginLabel.setHorizontalAlignment(JLabel.CENTER);
        LoginLabel.setBounds(85,30,231,130);
        LoginPanel.add(LoginLabel);


        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(20,180,100,40);
        LoginPanel.add(usernameLabel);

        username = new JTextField();
        username.setBounds(20,210,360,30);
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setBackground(Color.LIGHT_GRAY);
        LoginPanel.add(username);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20,270,100,40);
        LoginPanel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(20,300,360,30);
        password.setFont(new Font("Arial", Font.BOLD, 12));
        password.setBackground(Color.LIGHT_GRAY);
        LoginPanel.add(password);

        loginButton = new JButton("Sign in");
        loginButton.setBounds(150,380,100,30);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LoginPanel.add(loginButton);

        Signin = new JLabel("New to Tachiyomi? ");
        Signin.setFont(new Font("Arial", Font.BOLD, 15));
        Signin.setForeground(Color.WHITE);
        Signin.setBounds(43,500,160,40);
        LoginPanel.add(Signin);

        Signin2 = new JLabel("Create an Account");
        Signin2.setFont(new Font("Arial", Font.BOLD, 15));
        Signin2.setForeground(new Color(46,132,191));
        Signin2.setBounds(203,500,155,40);
        Signin2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Signin2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == Signin2){
                    remove(LoginPanel);
                    add(new RegisterPanel(),BorderLayout.CENTER);
                }
            }
        });
        LoginPanel.add(Signin2);

        this.add(LoginPanel);
    }
}
