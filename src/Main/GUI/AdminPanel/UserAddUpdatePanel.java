package Main.GUI.AdminPanel;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.Library;
import Main.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class UserAddUpdatePanel extends MainPanel implements ActionListener {
    JPanel centerPanel;
    JLabel closeButton;
    JLabel actionLabel;
    JLabel usernameLabel;
    JPanel validatorPanel1;
    JLabel userValidatorLabel;
    JTextField username;
    JLabel passwordLabel;
    JPanel validatorPanel2;
    JLabel passwordValidatorLabel;
    JTextField password;
    JLabel reEnterLabel;
    JPanel validatorPanel3;
    JLabel reEnterValidatorLabel;
    JTextField reEnter;
    JLabel fullnameLabel;
    JPanel validatorPanel4;
    JLabel fullnameValidatorLabel;
    JTextField fullname;
    JLabel phoneLabel;
    JPanel validatorPanel5;
    JLabel phoneValidatorLabel;
    JTextField phone;
    JButton actionButton;
    Boolean validated;
    AdminMainPanel adminMainPanel;
    int action;
    User user;

    public UserAddUpdatePanel(AdminMainPanel adminMainPanel, int action, User user) throws IOException {
        super();
        this.user = user;
        this.action = action;
        this.adminMainPanel = adminMainPanel;
        validated = false;
        this.addMouseListener(new MouseAdapter() {
        });
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        this.setBackground(new Color(18, 19, 24, 150));
        this.setBounds(0, 0, 600, 768);
        centerPanel = new JPanel();
        centerPanel.setBackground(CONSTANT.COLOR2);
        centerPanel.setBounds(100, 59, 400, 650);
        centerPanel.setBorder(BorderFactory.createLineBorder(CONSTANT.BUTTON_COLOR, 2));
        centerPanel.setLayout(null);

        //Tachiyomi
        actionLabel = new JLabel();
        if (action == 1) {
            actionLabel.setText("Add User");
        } else {
            actionLabel.setText("Update User");
        }
        actionLabel.setForeground(CONSTANT.BUTTON_COLOR);
        actionLabel.setFont(new Font("Inter", Font.BOLD, 20));
        actionLabel.setVerticalAlignment(JLabel.CENTER);
        actionLabel.setHorizontalAlignment(JLabel.CENTER);
        actionLabel.setBounds(125, 15, 150, 30);
        centerPanel.add(actionLabel);

        closeButton = new JLabel("×");
        closeButton.setFont(new Font("Inter", Font.BOLD, 40));
        closeButton.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        closeButton.setBounds(355, 15, 30, 30);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    adminMainPanel.CenterPanel.removeAll();
                    adminMainPanel.CenterPanel.add(new ManageUserPanel(adminMainPanel), BorderLayout.CENTER);
                    adminMainPanel.CenterPanel.revalidate();
                    adminMainPanel.CenterPanel.repaint();
                } catch (IOException e1) {
                    throw new RuntimeException();
                }
            }
        });
        centerPanel.add(closeButton);

        //username
        usernameLabel = new JLabel("Username : ");
        usernameLabel.setFont(new Font("Inter", Font.BOLD, 15));
        usernameLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        usernameLabel.setBounds(20, 75, 100, 40);
        centerPanel.add(usernameLabel);
        //username TextField
        username = new JTextField();
        username.setBounds(20, 110, 360, 30);
        if (action == 2) {
            username.setText(user.getUsername());
        }
        username.setFont(new Font("Inter", Font.PLAIN, 15));
        username.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        centerPanel.add(username);
        //username Validator
        validatorPanel1 = new JPanel();
        validatorPanel1.setBounds(20, 145, 360, 30);
        validatorPanel1.setBackground(CONSTANT.COLOR2);
        validatorPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        centerPanel.add(validatorPanel1);
        userValidatorLabel = new JLabel();
        userValidatorLabel.setText("Username may only contain alphanumeric characters.");
        userValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        username.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String user = username.getText().trim();
                try {
                    if (DATABASE.userExists(user)) {
                        userValidatorLabel.setText("User Already Exist.");
                        userValidatorLabel.setForeground(Color.RED);
                        validated = false;
                    } else if (user.isBlank()) {
                        userValidatorLabel.setText("Username cannot be blank.");
                        userValidatorLabel.setForeground(Color.RED);
                        validated = false;
                    } else if (DATABASE.userNameValidator(user)) {
                        userValidatorLabel.setText("Username may only contain alphanumeric characters.");
                        userValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                        validated = true;
                    } else {
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
        userValidatorLabel.setBounds(20, 130, 360, 40);
        validatorPanel1.add(userValidatorLabel);

        //password
        passwordLabel = new JLabel("Password : ");
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 15));
        passwordLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        passwordLabel.setBounds(20, 165, 100, 40);
        centerPanel.add(passwordLabel);
        //password field
        password = new JTextField();
        password.setBounds(20, 200, 360, 30);
        if (action == 2) {
            password.setText(user.getPassword());
        }
        password.setFont(new Font("Inter", Font.PLAIN, 15));
        password.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        centerPanel.add(password);
        //passwordValidator
        validatorPanel2 = new JPanel();
        validatorPanel2.setBounds(20, 235, 360, 30);
        validatorPanel2.setBackground(CONSTANT.COLOR2);
        validatorPanel2.setLayout(new FlowLayout(FlowLayout.LEADING));
        centerPanel.add(validatorPanel2);
        passwordValidatorLabel = new JLabel();
        passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
        passwordValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        passwordValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String user = password.getText();
                if (DATABASE.passwordValidator(user)) {
                    passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
                    passwordValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                } else if (user.isBlank()) {
                    passwordValidatorLabel.setText("Password cannot be blank.");
                    passwordValidatorLabel.setForeground(Color.RED);
                    validated = false;
                } else {
                    passwordValidatorLabel.setText("Password should be at least 6 characters including a number.");
                    passwordValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        passwordValidatorLabel.setBounds(20, 130, 360, 40);
        validatorPanel2.add(passwordValidatorLabel);

        //reEnterPassword
        reEnterLabel = new JLabel("Re-Enter Password : ");
        reEnterLabel.setFont(new Font("Inter", Font.BOLD, 15));
        reEnterLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        reEnterLabel.setBounds(20, 255, 200, 40);
        centerPanel.add(reEnterLabel);
        //reEnterpasswordfield
        reEnter = new JTextField();
        reEnter.setBounds(20, 290, 360, 30);
        if (action == 2) {
            reEnter.setText(user.getPassword());
        }
        reEnter.setFont(new Font("Inter", Font.PLAIN, 15));
        reEnter.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        centerPanel.add(reEnter);
        //reEnter Validator
        validatorPanel3 = new JPanel();
        validatorPanel3.setBounds(20, 325, 360, 30);
        validatorPanel3.setBackground(CONSTANT.COLOR2);
        validatorPanel3.setLayout(new FlowLayout(FlowLayout.LEADING));
        centerPanel.add(validatorPanel3);
        reEnterValidatorLabel = new JLabel();
        reEnterValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        reEnterValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        reEnter.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String reenter = reEnter.getText();
                String enter = password.getText();
                if (reenter.equals(enter)) {
                    reEnterValidatorLabel.setText("");
                    validated = true;
                } else {
                    reEnterValidatorLabel.setText("Password not matching");
                    reEnterValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        reEnterValidatorLabel.setBounds(20, 130, 360, 40);
        validatorPanel3.add(reEnterValidatorLabel);
        //fullname
        fullnameLabel = new JLabel("Fullname : ");
        fullnameLabel.setFont(new Font("Inter", Font.BOLD, 15));
        fullnameLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        fullnameLabel.setBounds(20, 345, 100, 40);
        centerPanel.add(fullnameLabel);
        //fullname Textfield
        fullname = new JTextField();
        fullname.setBounds(20, 380, 360, 30);
        if (action == 2) {
            fullname.setText(user.getFullname());
        }
        fullname.setFont(new Font("Inter", Font.PLAIN, 15));
        fullname.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        centerPanel.add(fullname);
        //fullname validator
        validatorPanel4 = new JPanel();
        validatorPanel4.setBounds(20, 415, 360, 30);
        validatorPanel4.setBackground(CONSTANT.COLOR2);
        validatorPanel4.setLayout(new FlowLayout(FlowLayout.LEADING));
        centerPanel.add(validatorPanel4);
        fullnameValidatorLabel = new JLabel();
        fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
        fullnameValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        fullnameValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        fullname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String name = fullname.getText().trim();
                if (DATABASE.fullnameValidator(name)) {
                    fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
                    fullnameValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                } else if (name.isBlank()) {
                    fullnameValidatorLabel.setText("Full Name cannot be blank.");
                    fullnameValidatorLabel.setForeground(Color.RED);
                    validated = false;
                } else {
                    fullnameValidatorLabel.setText("Full Name should contain only letters and spaces.");
                    fullnameValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        fullnameValidatorLabel.setBounds(20, 130, 360, 40);
        validatorPanel4.add(fullnameValidatorLabel);
        //phone number
        phoneLabel = new JLabel("Phone number : ");
        phoneLabel.setFont(new Font("Inter", Font.BOLD, 15));
        phoneLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        phoneLabel.setBounds(20, 435, 150, 40);
        centerPanel.add(phoneLabel);
        //phone number textfield
        phone = new JTextField();
        phone.setBounds(20, 470, 360, 30);
        if (action == 2) {
            phone.setText(user.getPhonenumber());
        }
        phone.setFont(new Font("Inter", Font.PLAIN, 15));
        phone.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        centerPanel.add(phone);
        //phonenumber validator
        validatorPanel5 = new JPanel();
        validatorPanel5.setBounds(20, 505, 360, 30);
        validatorPanel5.setBackground(CONSTANT.COLOR2);
        validatorPanel5.setLayout(new FlowLayout(FlowLayout.LEADING));
        centerPanel.add(validatorPanel5);
        phoneValidatorLabel = new JLabel();
        phoneValidatorLabel.setText("Phone number must be 11 digits long.");
        phoneValidatorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        phoneValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        phone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String phonenum = phone.getText().trim();
                if (DATABASE.phoneNumberValidator(phonenum)) {
                    phoneValidatorLabel.setText("Phone number must be 11 digits long.");
                    phoneValidatorLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
                    validated = true;
                } else if (phonenum.isBlank()) {
                    phoneValidatorLabel.setText("Phone number cannot be blank.");
                    phoneValidatorLabel.setForeground(Color.RED);
                    validated = false;
                } else {
                    phoneValidatorLabel.setText("Invalid Phone Number.");
                    phoneValidatorLabel.setForeground(Color.RED);
                    validated = false;
                }
            }
        });
        phoneValidatorLabel.setBounds(20, 130, 360, 40);
        validatorPanel5.add(phoneValidatorLabel);
        //signup button
        actionButton = new JButton();
        if (action == 1) {
            actionButton.setText("Add User");
        } else if (action == 2) {
            actionButton.setText("Update User");
        }
        actionButton.setFont(new Font("Inter", Font.BOLD, 15));
        actionButton.setBackground(CONSTANT.BUTTON_COLOR);
        actionButton.setForeground(Color.BLACK);
        actionButton.setBounds(135, 550, 130, 30);
        actionButton.setFocusable(false);
        actionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionButton.addActionListener(this);
        centerPanel.add(actionButton);

        this.add(centerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actionButton) {
            try {
                String userName = username.getText();
                String pass = password.getText();
                String rePass = reEnter.getText();
                String name = fullname.getText();
                String phonenumber = phone.getText();
                Library library = new Library();


                if (action == 1) {
                    //add User
                    if (validated && !userName.isBlank() && !pass.isBlank() && !name.isBlank() && !phonenumber.isBlank()) {
                        DATABASE.registerUser(userName, rePass, name, phonenumber);
                        adminMainPanel.CenterPanel.removeAll();
                        adminMainPanel.CenterPanel.add(new ManageUserPanel(adminMainPanel), BorderLayout.CENTER);
                        adminMainPanel.CenterPanel.revalidate();
                        adminMainPanel.CenterPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "Add User Failed");
                    }
                } else if (action == 2) {
                    //Update User
                    user.setUsername(userName);
                    user.setPassword(rePass);
                    user.setPhonenumber(phonenumber);
                    user.setFullname(name);
                    library.updateUser(user);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
