package Main.GUI.AdminPanel;

import Main.Book;
import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LibraryPanel extends MainPanel implements ActionListener{
    LibraryAddUpdatePanel libraryAddUpdatePanel;
    JTable table;
    JScrollPane scrollPane;
    JButton addBookButton;
    JButton updateBookButton;
    JButton deleteBookButton;
    JButton refreshButton;
    AdminMainPanel adminMainPanel;
    public LibraryPanel(AdminMainPanel adminMainPanel) throws IOException {
        super();
        this.adminMainPanel = adminMainPanel;
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        table = new JTable(DATABASE.getBookList());
        table.setBackground(CONSTANT.COLOR2);
        table.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        table.setShowGrid(false);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CONSTANT.COLOR2);
        scrollPane.setBounds(25, 109, 1062, 550);
        this.add(scrollPane);

        addBookButton = new JButton("Add Book");
        addBookButton.setBackground(CONSTANT.BUTTON_COLOR);
        addBookButton.setForeground(Color.BLACK);
        addBookButton.setFont(new Font("Inter", Font.BOLD, 15));
        addBookButton.setFocusable(false);
        addBookButton.setBounds(25,66,125,30);
        addBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBookButton.addActionListener(this);
        this.add(addBookButton);

        updateBookButton = new JButton("Update");
        updateBookButton.setBackground(CONSTANT.BUTTON_COLOR);
        updateBookButton.setForeground(Color.BLACK);
        updateBookButton.setFont(new Font("Inter", Font.BOLD, 15));
        updateBookButton.setFocusable(false);
        updateBookButton.setBounds(166,66,125,30);
        updateBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateBookButton.addActionListener(this);
        this.add(updateBookButton);

        deleteBookButton = new JButton("Delete");
        deleteBookButton.setBackground(CONSTANT.BUTTON_COLOR);
        deleteBookButton.setForeground(Color.BLACK);
        deleteBookButton.setFont(new Font("Inter", Font.BOLD, 15));
        deleteBookButton.setFocusable(false);
        deleteBookButton.setBounds(307,66,125,30);
        deleteBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteBookButton.addActionListener(this);
        this.add(deleteBookButton);

        refreshButton = new JButton("Refresh");
        refreshButton.setBackground(CONSTANT.BUTTON_COLOR);
        refreshButton.setForeground(Color.BLACK);
        refreshButton.setFont(new Font("Inter", Font.BOLD, 15));
        refreshButton.setFocusable(false);
        refreshButton.setBounds(448,66,125,30);
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshButton.addActionListener(this);
        this.add(refreshButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Book book;
            //Add Book button
            if (e.getSource() == addBookButton) {
                book = null;
                libraryAddUpdatePanel = new LibraryAddUpdatePanel(adminMainPanel, 1, book);
                this.add(libraryAddUpdatePanel);
                this.setComponentZOrder(libraryAddUpdatePanel, 0);
                this.revalidate();
                this.repaint();
                //Update Book Button
            } else if (e.getSource() == updateBookButton) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Please select a book to update.");
                    return;
                }

                int ID = Integer.parseInt(table.getValueAt(row, 1).toString());
                String title = table.getValueAt(row, 2).toString();
                String author = table.getValueAt(row, 3).toString();
                int quantity = Integer.parseInt(table.getValueAt(row, 4).toString());

                book = new Book(ID, title, author, quantity);
                libraryAddUpdatePanel = new LibraryAddUpdatePanel(adminMainPanel, 2, book);

                this.add(libraryAddUpdatePanel);
                this.setComponentZOrder(libraryAddUpdatePanel, 0);
                this.revalidate();
                this.repaint();
                //Delete Button
            } else if (e.getSource() == deleteBookButton) {
                String[] selected = DATABASE.getSelected((DefaultTableModel) table.getModel());
                if ((selected.length) == 0) {
                    JOptionPane.showMessageDialog(this, "Please select a book to Delete.");
                } else {
                    DATABASE.delete(selected, CONSTANT.BOOKS);
                }
                //Refresh Button
            } else if (e.getSource() == refreshButton) {
                adminMainPanel.CenterPanel.removeAll();
                adminMainPanel.CenterPanel.add(new LibraryPanel(adminMainPanel), BorderLayout.CENTER);
                adminMainPanel.CenterPanel.revalidate();
                adminMainPanel.CenterPanel.repaint();
            }
        }catch(IOException e1){
            throw new RuntimeException();
        }
    }
}
