package Prototype.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPanel extends MainPanel{
    JPanel RegisterPanel;
    JLabel LoginLabel;
    JLabel usernameLabel;
    JTextField username;
    JLabel passwordLabel;
    JPasswordField password;
    JLabel reEnterLabel;
    JPasswordField reEnter;
    JLabel fullnameLabel;
    JTextField fullname;
    JLabel phoneLabel;
    JTextField phone;
    JButton loginButton;
    JLabel Signup;
    JLabel Signup2;
    public RegisterPanel(){
        super();

        RegisterPanel = new JPanel();
        RegisterPanel.setBackground(new Color(34, 40, 49));
        RegisterPanel.setBounds(184,59,400,650);
        RegisterPanel.setLayout(null);

        LoginLabel = new JLabel();
        LoginLabel.setText("Sign up to Tachiyomi");
        LoginLabel.setForeground(Color.WHITE);
        LoginLabel.setFont(new Font("Arial",Font.BOLD,20));
        LoginLabel.setVerticalTextPosition(JLabel.TOP);
        LoginLabel.setHorizontalTextPosition(JLabel.CENTER);
        LoginLabel.setVerticalAlignment(JLabel.TOP);
        LoginLabel.setHorizontalAlignment(JLabel.CENTER);
        LoginLabel.setBounds(56,25,238,130);
        RegisterPanel.add(LoginLabel);


        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(20,80,100,40);
        RegisterPanel.add(usernameLabel);

        username = new JTextField();
        username.setBounds(20,110,360,30);
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setBackground(Color.LIGHT_GRAY);
        RegisterPanel.add(username);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20,170,100,40);
        RegisterPanel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(20,200,360,30);
        password.setFont(new Font("Arial", Font.BOLD, 12));
        password.setBackground(Color.LIGHT_GRAY);
        RegisterPanel.add(password);

        reEnterLabel = new JLabel("Re-Enter Password : ");
        reEnterLabel.setFont(new Font("Arial", Font.BOLD, 15));
        reEnterLabel.setForeground(Color.WHITE);
        reEnterLabel.setBounds(20,260,200,40);
        RegisterPanel.add(reEnterLabel);

        reEnter = new JPasswordField();
        reEnter.setBounds(20,290,360,30);
        reEnter.setFont(new Font("Arial", Font.BOLD, 12));
        reEnter.setBackground(Color.LIGHT_GRAY);
        RegisterPanel.add(reEnter);

        fullnameLabel = new JLabel("Fullname : ");
        fullnameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        fullnameLabel.setForeground(Color.WHITE);
        fullnameLabel.setBounds(20,350,100,40);
        RegisterPanel.add(fullnameLabel);

        fullname = new JTextField();
        fullname.setBounds(20,380,360,30);
        fullname.setFont(new Font("Arial", Font.BOLD, 12));
        fullname.setBackground(Color.LIGHT_GRAY);
        RegisterPanel.add(fullname);

        phoneLabel = new JLabel("Phone number : ");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(20,440,150,40);
        RegisterPanel.add(phoneLabel);

        phone = new JTextField();
        phone.setBounds(20,470,360,30);
        phone.setFont(new Font("Arial", Font.BOLD, 12));
        phone.setBackground(Color.LIGHT_GRAY);
        RegisterPanel.add(phone);

        loginButton = new JButton("Sign up");
        loginButton.setBounds(150,550,100,30);
        loginButton.setFocusable(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        RegisterPanel.add(loginButton);

        Signup = new JLabel("Already Have an Account? ");
        Signup.setFont(new Font("Arial", Font.BOLD, 15));
        Signup.setForeground(Color.WHITE);
        Signup.setBounds(64,600,218,40);
        RegisterPanel.add(Signup);

        Signup2 = new JLabel("Sign in");
        Signup2.setFont(new Font("Arial", Font.BOLD, 15));
        Signup2.setForeground(new Color(46,132,191));
        Signup2.setBounds(282,600,54,40);
        Signup2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Signup2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == Signup2){
                    remove(RegisterPanel);
                    add(new LoginPanel(),BorderLayout.CENTER);
                }
            }
        });
        RegisterPanel.add(Signup2);

        this.add(RegisterPanel);
    }
}
