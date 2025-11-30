package Prototype.GUI;

import javax.swing.*;
import java.awt.*;

public class Myframe extends JFrame{
    LoginPanel loginPanel;

    public Myframe(){
        ImageIcon icon = new ImageIcon("/home/Deicide/IdeaProjects/Library Book Management System/src/Prototype/PIctures/TIcon.jpeg");
        this.setIconImage(icon.getImage());
        this.setTitle("Tachiyomi");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        loginPanel = new LoginPanel();
        this.add(loginPanel,BorderLayout.CENTER);

        this.pack();

    }


}



//public final int ORIGINAL_TILE_SIZE = 16; //16x16 pixels (game tiles)
//public final int SCALE = 3; //3x scale
//public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48x48 pixels (game tiles)
//public final int MAX_SCREEN_COL = 16; //16 game tiles
//public final int MAX_SCREEN_ROW = 12; //12 game tiles
//public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; //768 pixels (game tiles)
//public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; //576 pixels (game tiles)