package Main.GUI.UserPanel;

import Main.CONSTANT;
import Main.GUI.MainPanel;
import Main.User;

import javax.swing.*;
import java.awt.*;

public class UserProfilePanel extends MainPanel {

    public UserProfilePanel(User user) {
        super();
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));

        JPanel profileCard = new JPanel();
        profileCard.setBackground(CONSTANT.COLOR2);
        profileCard.setBounds(300, 120, 500, 500);
        profileCard.setLayout(null);
        profileCard.setBorder(BorderFactory.createLineBorder(CONSTANT.BUTTON_COLOR, 2));

        JLabel titleLabel = new JLabel("My Profile");
        titleLabel.setForeground(CONSTANT.BUTTON_COLOR);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 30, 500, 40);
        profileCard.add(titleLabel);

        JLabel iconLabel = new JLabel("👤");
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLabel.setBounds(0, 90, 500, 100);
        profileCard.add(iconLabel);

        // User ID
        JLabel idLabel = new JLabel("User ID:");
        idLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        idLabel.setFont(new Font("Inter", Font.BOLD, 16));
        idLabel.setBounds(80, 210, 150, 30);
        profileCard.add(idLabel);

        JLabel idValue = new JLabel(String.valueOf(user.getID()));
        idValue.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        idValue.setFont(new Font("Inter", Font.PLAIN, 16));
        idValue.setBounds(230, 210, 200, 30);
        profileCard.add(idValue);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        userLabel.setFont(new Font("Inter", Font.BOLD, 16));
        userLabel.setBounds(80, 250, 150, 30);
        profileCard.add(userLabel);

        JLabel userValue = new JLabel(user.getUsername());
        userValue.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        userValue.setFont(new Font("Inter", Font.PLAIN, 16));
        userValue.setBounds(230, 250, 200, 30);
        profileCard.add(userValue);

        // Full Name
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        nameLabel.setFont(new Font("Inter", Font.BOLD, 16));
        nameLabel.setBounds(80, 290, 150, 30);
        profileCard.add(nameLabel);

        JLabel nameValue = new JLabel(user.getFullname());
        nameValue.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        nameValue.setFont(new Font("Inter", Font.PLAIN, 16));
        nameValue.setBounds(230, 290, 200, 30);
        profileCard.add(nameValue);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        phoneLabel.setFont(new Font("Inter", Font.BOLD, 16));
        phoneLabel.setBounds(80, 330, 150, 30);
        profileCard.add(phoneLabel);

        JLabel phoneValue = new JLabel(user.getPhonenumber());
        phoneValue.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        phoneValue.setFont(new Font("Inter", Font.PLAIN, 16));
        phoneValue.setBounds(230, 330, 200, 30);
        profileCard.add(phoneValue);

        // Status
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setForeground(CONSTANT.SECONDARYTEXT_COLOR);
        statusLabel.setFont(new Font("Inter", Font.BOLD, 16));
        statusLabel.setBounds(80, 370, 150, 30);
        profileCard.add(statusLabel);

        JLabel statusValue = new JLabel(user.getStatus());
        Color statusColor = user.getStatus().equals("Active") ? Color.decode("#4CAF50") : Color.decode("#F44336");
        statusValue.setForeground(statusColor);
        statusValue.setFont(new Font("Inter", Font.BOLD, 16));
        statusValue.setBounds(230, 370, 200, 30);
        profileCard.add(statusValue);

        this.add(profileCard);
    }
}