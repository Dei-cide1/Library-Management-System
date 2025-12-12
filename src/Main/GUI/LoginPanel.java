package Main.GUI;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.AdminPanel.AdminMainPanel;
import Main.GUI.UserPanel.UserMainPanel;
import Main.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoginPanel extends MainPanel implements ActionListener{
    JPanel LoginPanel;
    JLabel LoginLabel;
    JLabel usernameLabel;
    JTextField username;
    JLabel passwordLabel;
    JPasswordField password;
    JButton loginButton;
    JLabel Signin;
    JLabel Signin2;
    Myframe frame;
    public LoginPanel(Myframe frame) throws IOException{
        super();
        this.frame =  frame;
        this.setLayout(new GridBagLayout());
        LoginPanel = new JPanel();
        LoginPanel.setBackground(CONSTANT.COLOR2);
        LoginPanel.setPreferredSize(new Dimension(400,550));
        LoginPanel.setLayout(null);
        this.add(LoginPanel, new GridBagConstraints());

        LoginLabel = new JLabel();
        ImageIcon icon = new ImageIcon("/home/Deicide/IdeaProjects/Library Book Management System/src/Main/PIctures/TachiyomiIcons.png");
        LoginLabel.setText("Sign in to Tachiyomi");
        LoginLabel.setIcon(icon);
        LoginLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        LoginLabel.setFont(new Font("Inter",Font.BOLD,20));
        LoginLabel.setVerticalTextPosition(JLabel.BOTTOM);
        LoginLabel.setHorizontalTextPosition(JLabel.CENTER);
        LoginLabel.setIconTextGap(10);
        LoginLabel.setVerticalAlignment(JLabel.CENTER);
        LoginLabel.setHorizontalAlignment(JLabel.CENTER);
        LoginLabel.setBounds(85,30,231,130);
        LoginPanel.add(LoginLabel);


        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Inter", Font.BOLD, 15));
        usernameLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        usernameLabel.setBounds(20,175,100,40);
        LoginPanel.add(usernameLabel);

        username = new JTextField();
        username.setBounds(20,210,360,30);
        username.setFont(new Font("Inter", Font.PLAIN, 15));
        username.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        LoginPanel.add(username);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 15));
        passwordLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        passwordLabel.setBounds(20,265,100,40);
        LoginPanel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(20,300,360,30);
        password.setFont(new Font("Inter", Font.PLAIN, 15));
        password.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        LoginPanel.add(password);

        loginButton = new JButton("Sign in");
        loginButton.setBackground(CONSTANT.BUTTON_COLOR);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Inter", Font.BOLD, 15));
        loginButton.setFocusable(false);
        loginButton.setBounds(135,380,130,30);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        LoginPanel.add(loginButton);

        Signin = new JLabel("New to Tachiyomi? ");
        Signin.setFont(new Font("Inter", Font.BOLD, 15));
        Signin.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        Signin.setBounds(60,500,143,40);
        LoginPanel.add(Signin);

        Signin2 = new JLabel("Create an Account");
        Signin2.setFont(new Font("Inter", Font.BOLD, 15));
        Signin2.setForeground(new Color(46,132,191));
        Signin2.setBounds(203,500,138,40);
        Signin2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Signin2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == Signin2){
                    try {
                        frame.getContentPane().removeAll();
                        frame.add(new RegisterPanel(frame),BorderLayout.CENTER);
                        frame.revalidate();
                        frame.repaint();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        LoginPanel.add(Signin2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user;
        String name = username.getText();
        String pass = new String(password.getPassword());

        try {
            user = DATABASE.AuthenticateUser(name, pass);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if(user != null) {
            frame.getContentPane().removeAll();
            frame.add(new UserMainPanel(frame,user));
            frame.revalidate();
            frame.repaint();
        }else if(name.equals("Admin") && pass.equals("Admin")){
            frame.getContentPane().removeAll();
            frame.add(new AdminMainPanel(frame));
            frame.revalidate();
            frame.repaint();
        }else{
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
    }
}
