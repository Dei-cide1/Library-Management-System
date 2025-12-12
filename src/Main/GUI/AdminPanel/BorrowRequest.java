package Main.GUI.AdminPanel;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.Library;
import Main.Action;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class BorrowRequest extends MainPanel implements ActionListener{
    LibraryAddUpdatePanel libraryAddUpdatePanel;
    Library library;
    JTable table;
    JScrollPane scrollPane;
    JButton AcceptButton;
    JButton RejectButton;
    AdminMainPanel adminMainPanel;
    public BorrowRequest(AdminMainPanel adminMainPanel) throws IOException {
        super();
        this.adminMainPanel = adminMainPanel;
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        table = new JTable(DATABASE.getBorrowRequestList());
        table.setBackground(CONSTANT.COLOR2);
        table.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        table.setShowGrid(false);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CONSTANT.COLOR2);
        scrollPane.setBounds(25, 109, 1062, 550);
        this.add(scrollPane);

        AcceptButton = new JButton("Accept");
        AcceptButton.setBackground(CONSTANT.BUTTON_COLOR);
        AcceptButton.setForeground(Color.BLACK);
        AcceptButton.setFont(new Font("Inter", Font.BOLD, 15));
        AcceptButton.setFocusable(false);
        AcceptButton.setBounds(25,66,125,30);
        AcceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AcceptButton.addActionListener(this);
        this.add(AcceptButton);

        RejectButton = new JButton("Reject");
        RejectButton.setBackground(CONSTANT.BUTTON_COLOR);
        RejectButton.setForeground(Color.BLACK);
        RejectButton.setFont(new Font("Inter", Font.BOLD, 15));
        RejectButton.setFocusable(false);
        RejectButton.setBounds(166,66,125,30);
        RejectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        RejectButton.addActionListener(this);
        this.add(RejectButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        library = new Library();
            if (e.getSource() == AcceptButton) {
                String []selected = DATABASE.getSelected((DefaultTableModel) table.getModel());
                library.actionButton(Action.Accepted, selected);
            } else if (e.getSource() == RejectButton) {

            }

    }
}
