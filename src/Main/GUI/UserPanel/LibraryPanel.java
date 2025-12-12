package Main.GUI.UserPanel;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.Library;
import Main.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LibraryPanel extends MainPanel implements ActionListener{
    Library library;
    JButton requestButton;
    JTable table;
    JScrollPane scrollPane;
    User user;
    public LibraryPanel(User user) throws IOException {
        super();
        this.user = user;
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        table = new JTable(DATABASE.getBookList());
        table.setBackground(CONSTANT.COLOR2);
        table.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        table.setShowGrid(false);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CONSTANT.COLOR2);
        scrollPane.setBounds(25, 109, 1062, 550);
        this.add(scrollPane);

        requestButton = new JButton("Request Borrow");
        requestButton.setBackground(CONSTANT.BUTTON_COLOR);
        requestButton.setForeground(Color.BLACK);
        requestButton.setFont(new Font("Inter", Font.BOLD, 15));
        requestButton.setFocusable(false);
        requestButton.setBounds(25,66,125,30);
        requestButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        requestButton.addActionListener(this);
        this.add(requestButton);
    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == requestButton){
            String []selected = DATABASE.getSelected((DefaultTableModel) table.getModel());
            library = new Library();

            library.borrowBooks(selected, user);
        }
    }
}
