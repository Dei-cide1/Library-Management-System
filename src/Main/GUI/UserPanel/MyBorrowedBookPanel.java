package Main.GUI.UserPanel;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.Library;
import Main.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyBorrowedBookPanel extends MainPanel {
    Library library;
    JButton requestButton;
    JTable table;
    JScrollPane scrollPane;
    User user;
    public MyBorrowedBookPanel(User user) throws IOException {
        super();
        this.user = user;
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        table = new JTable(DATABASE.getUserHistoryList(user));
        table.setBackground(CONSTANT.COLOR2);
        table.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        table.setShowGrid(false);

        table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String status = value.toString();

                if (status.equalsIgnoreCase("Pending")) {
                    c.setForeground(Color.ORANGE);
                } else if (status.equalsIgnoreCase("Approved")) {
                    c.setForeground(Color.GREEN.darker());
                } else if (status.equalsIgnoreCase("Rejected")) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.WHITE);
                }

                return c;
            }
        });


        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CONSTANT.COLOR2);
        scrollPane.setBounds(25, 109, 1062, 550);
        this.add(scrollPane);

    }
}
