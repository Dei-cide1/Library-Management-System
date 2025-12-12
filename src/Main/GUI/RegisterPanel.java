package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import Main.CONSTANT;
import Main.DataBase.DATABASE;

public class RegisterPanel extends MainPanel implements ActionListener{
    JPanel RegisterPanel;
    JLabel SignupLabel;
    JLabel usernameLabel;
    JPanel validatorPanel1;
    JLabel userValidatorLabel;
    JTextField username;
    JLabel passwordLabel;
    JPanel validatorPanel2;
    JLabel passwordValidatorLabel;
    JPasswordField password;
    JLabel reEnterLabel;
    JPanel validatorPanel3;
    JLabel reEnterValidatorLabel;
    JPasswordField reEnter;
    JLabel fullnameLabel;
    JPanel validatorPanel4;
    JLabel fullnameValidatorLabel;
    JTextField fullname;
    JLabel phoneLabel;
    JPanel validatorPanel5;
    JLabel phoneValidatorLabel;
    JTextField phone;
    JButton signupButton;
    JLabel Signup;
    JLabel Signup2;
    Myframe frame;
    Boolean validated;
    public RegisterPanel(Myframe frame) throws IOException {
        super();
        validated = false;
        this.frame = frame;
        this.setLayout(new GridBagLayout());
        RegisterPanel = new JPanel();
        RegisterPanel.setBackground(CONSTANT.COLOR2);
        RegisterPanel.setPreferredSize(new Dimension(400,650));
        RegisterPanel.setLayout(null);
        this.add(RegisterPanel, new GridBagConstraints());

        //Tachiyomi
        SignupLabel = new JLabel();
        SignupLabel.setText("Sign up to Tachiyomi");
        SignupLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        SignupLabel.setFont(new Font("Inter",Font.BOLD,20));
        SignupLabel.setVerticalAlignment(JLabel.CENTER);
        SignupLabel.setHorizontalAlignment(JLabel.CENTER);
        SignupLabel.setBounds(81,35,238,30);
        RegisterPanel.add(SignupLabel);

        //username
        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Inter", Font.BOLD, 15));
        usernameLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        usernameLabel.setBounds(20,75,100,40);
        RegisterPanel.add(usernameLabel);
        //username TextField
        username = new JTextField();
        username.setBounds(20,110,360,30);
        username.setFont(new Font("Inter", Font.PLAIN, 15));
        username.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        RegisterPanel.add(username);
        //username Validator
        validatorPanel1 = new JPanel();
        validatorPanel1.setBounds(20,145, 360, 30);
        validatorPanel1.setBackground(CONSTANT.COLOR2);
        validatorPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        RegisterPanel.add(validatorPanel1);
        userValidatorLabel = new JLabel();
        userValidatorLabel.setText("Username may only contain alphanumeric characters.");
        userValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        username.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String user = username.getText().trim();
                try {
                    if(DATABASE.userExists(user)) {
                        userValidatorLabel.setText("User Already Exist.");
                        userValidatorLabel.setForeground(Color.RED);
                        validated = false;
                    }else if(user.isBlank()) {
                        userValidatorLabel.setText("Username cannot be blank.");
                        userValidatorLabel.setForeground(Color.RED);
                        validated = false;
                    }else if(DATABASE.userNameValidator(user)){
                        userValidatorLabel.setText("Username may only contain alphanumeric characters.");
                        userValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                        validated = true;
                    }else {
                        userValidatorLabel.setText("Username may only contain alphanumeric characters.");
                        userValidatorLabel.setForeground(Color.RED);
                        validated = false;
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        userValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        userValidatorLabel.setBounds(20,130,360,40);
        validatorPanel1.add(userValidatorLabel);

        //password
        passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 15));
        passwordLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        passwordLabel.setBounds(20,165,100,40);
        RegisterPanel.add(passwordLabel);
        //password field
        password = new JPasswordField();
        password.setBounds(20,200,360,30);
        password.setFont(new Font("Inter", Font.PLAIN, 15));
        password.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        RegisterPanel.add(password);
        //passwordValidator
        validatorPanel2 = new JPanel();
        validatorPanel2.setBounds(20,235, 360, 30);
        validatorPanel2.setBackground(CONSTANT.COLOR2);
        validatorPanel2.setLayout(new FlowLayout(FlowLayout.LEADING));
        RegisterPanel.add(validatorPanel2);
        passwordValidatorLabel = new JLabel();
        passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
        passwordValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        passwordValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String user = new String(password.getPassword());
                if(DATABASE.passwordValidator(user)){
                    passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
                    passwordValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                }else if(user.isBlank()) {
                    passwordValidatorLabel.setText("Password cannot be blank.");
                    passwordValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }else {
                    passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
                    passwordValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        passwordValidatorLabel.setBounds(20,130,360,40);
        validatorPanel2.add(passwordValidatorLabel);

        //reEnterPassword
        reEnterLabel = new JLabel("Re-Enter Password : ");
        reEnterLabel.setFont(new Font("Inter", Font.BOLD, 15));
        reEnterLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        reEnterLabel.setBounds(20,255,200,40);
        RegisterPanel.add(reEnterLabel);
        //reEnterpasswordfield
        reEnter = new JPasswordField();
        reEnter.setBounds(20,290,360,30);
        reEnter.setFont(new Font("Inter", Font.PLAIN, 15));
        reEnter.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        RegisterPanel.add(reEnter);
        //reEnter Validator
        validatorPanel3 = new JPanel();
        validatorPanel3.setBounds(20,325, 360, 30);
        validatorPanel3.setBackground(CONSTANT.COLOR2);
        validatorPanel3.setLayout(new FlowLayout(FlowLayout.LEADING));
        RegisterPanel.add(validatorPanel3);
        reEnterValidatorLabel = new JLabel();
        reEnterValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        reEnterValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        reEnter.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String reenter = new String(reEnter.getPassword());
                String enter = new String(password.getPassword());
                if(reenter.equals(enter)){
                    reEnterValidatorLabel.setText("");
                    validated = true;
                }else{
                    reEnterValidatorLabel.setText("Password not matching");
                    reEnterValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        reEnterValidatorLabel.setBounds(20,130,360,40);
        validatorPanel3.add(reEnterValidatorLabel);
        //fullname
        fullnameLabel = new JLabel("Fullname : ");
        fullnameLabel.setFont(new Font("Inter", Font.BOLD, 15));
        fullnameLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        fullnameLabel.setBounds(20,345,100,40);
        RegisterPanel.add(fullnameLabel);
        //fullname Textfield
        fullname = new JTextField();
        fullname.setBounds(20,380,360,30);
        fullname.setFont(new Font("Inter", Font.PLAIN, 15));
        fullname.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        RegisterPanel.add(fullname);
        //fullname validator
        validatorPanel4 = new JPanel();
        validatorPanel4.setBounds(20,415, 360, 30);
        validatorPanel4.setBackground(CONSTANT.COLOR2);
        validatorPanel4.setLayout(new FlowLayout(FlowLayout.LEADING));
        RegisterPanel.add(validatorPanel4);
        fullnameValidatorLabel = new JLabel();
        fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
        fullnameValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        fullnameValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        fullname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String name = fullname.getText().trim();
                if(DATABASE.fullnameValidator(name)){
                    fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
                    fullnameValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                }else if(name.isBlank()) {
                    fullnameValidatorLabel.setText("Full Name cannot be blank.");
                    fullnameValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }else{
                    fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
                    fullnameValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        fullnameValidatorLabel.setBounds(20,130,360,40);
        validatorPanel4.add(fullnameValidatorLabel);
        //phone number
        phoneLabel = new JLabel("Phone number : ");
        phoneLabel.setFont(new Font("Inter", Font.BOLD, 15));
        phoneLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        phoneLabel.setBounds(20,435,150,40);
        RegisterPanel.add(phoneLabel);
        //phone number textfield
        phone = new JTextField();
        phone.setBounds(20,470,360,30);
        phone.setFont(new Font("Inter", Font.PLAIN, 15));
        phone.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        RegisterPanel.add(phone);
        //phonenumber validator
        validatorPanel5 = new JPanel();
        validatorPanel5.setBounds(20,505, 360, 30);
        validatorPanel5.setBackground(CONSTANT.COLOR2);
        validatorPanel5.setLayout(new FlowLayout(FlowLayout.LEADING));
        RegisterPanel.add(validatorPanel5);
        phoneValidatorLabel = new JLabel();
        phoneValidatorLabel.setText("Phone number must be 11 digits long.");
        phoneValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        phoneValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        phone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String phonenum = phone.getText().trim();
                if(DATABASE.phoneNumberValidator(phonenum)){
                    phoneValidatorLabel.setText("Phone number must be 11 digits long.");
                    phoneValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                }else if(phonenum.isBlank()) {
                    phoneValidatorLabel.setText("Phone number cannot be blank.");
                    phoneValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }else{
                    phoneValidatorLabel.setText("Invalid Phone Number.");
                    phoneValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        phoneValidatorLabel.setBounds(20,130,360,40);
        validatorPanel5.add(phoneValidatorLabel);
        //signup button
        signupButton = new JButton("Sign up");
        signupButton.setFont(new Font("Inter", Font.BOLD, 15));
        signupButton.setBackground(CONSTANT.BUTTON_COLOR);
        signupButton.setForeground(Color.BLACK);
        signupButton.setBounds(135,550,130,30);
        signupButton.setFocusable(false);
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupButton.addActionListener(this);
        RegisterPanel.add(signupButton);
        //already have an account
        Signup = new JLabel("Already Have an Account? ");
        Signup.setFont(new Font("Inter", Font.BOLD, 15));
        Signup.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        Signup.setBounds(77,600,198,40);
        RegisterPanel.add(Signup);

        Signup2 = new JLabel("Sign in");
        Signup2.setFont(new Font("Inter", Font.BOLD, 15));
        Signup2.setForeground(new Color(46,132,191));
        Signup2.setBounds(275,600,49,40);
        Signup2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Signup2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == Signup2){
                    try {
                            frame.getContentPane().removeAll();
                            frame.add(new LoginPanel(frame), BorderLayout.CENTER);
                            frame.revalidate();
                            frame.repaint();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        RegisterPanel.add(Signup2);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signupButton){
            String user = username.getText();
            String pass = reEnter.getText();
            String name = fullname.getText();
            String phonenumber = phone.getText();

            try {
                if(validated && !user.isBlank() && !pass.isBlank() && !name.isBlank() && !phonenumber.isBlank()) {
                    DATABASE.registerUser(user,pass,name,phonenumber);
                    frame.getContentPane().removeAll();
                    frame.add(new LoginPanel(frame),BorderLayout.CENTER);
                    frame.revalidate();
                    frame.repaint();
                }else{
                    JOptionPane.showMessageDialog(null,"Sign up Failed");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
