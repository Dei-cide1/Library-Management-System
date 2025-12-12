package Main.GUI;

import Main.CONSTANT;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Myframe extends JFrame {
    LoginPanel loginPanel;

    public Myframe() throws IOException {
        ImageIcon icon = new ImageIcon("/home/Deicide/IdeaProjects/Library Book Management System/src/Main/PIctures/TIcon.jpeg");
        this.setIconImage(icon.getImage());
        this.setTitle("Tachiyomi");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //1280x768
        this.setSize(CONSTANT.WIDTH,CONSTANT.HEIGHT);
        this.setLocationRelativeTo(null);

        loginPanel = new LoginPanel(this);
        this.add(loginPanel,BorderLayout.CENTER);

//        AdminMainPanel adminPanel = new AdminMainPanel();
//        this.add(adminPanel,BorderLayout.CENTER);

        this.pack();
    }
}