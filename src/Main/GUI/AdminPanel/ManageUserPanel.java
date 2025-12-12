package Main.GUI.AdminPanel;

import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ManageUserPanel extends MainPanel implements ActionListener{
    ManageUserPanel manageUserPanel;
    JTable table;
    JScrollPane scrollPane;
    JButton addUserButton;
    JButton updateUserButton;
    JButton deleteUserButton;
    JButton refreshButton;
    UserAddUpdatePanel userAddDeletePanel;
    AdminMainPanel adminMainPanel;
    public ManageUserPanel(AdminMainPanel adminMainPanel) throws IOException {
        super();
        this.adminMainPanel = adminMainPanel;
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        table = new JTable(DATABASE.getUserList());
        table.setBackground(CONSTANT.COLOR2);
        table.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        table.setShowGrid(false);

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CONSTANT.COLOR2);
        scrollPane.setBounds(25, 109, 1062, 550);
        scrollPane.getHorizontalScrollBar();
        this.add(scrollPane);

        addUserButton = new JButton("Add User");
        addUserButton.setBackground(CONSTANT.BUTTON_COLOR);
        addUserButton.setForeground(Color.BLACK);
        addUserButton.setFont(new Font("Inter", Font.BOLD, 15));
        addUserButton.setFocusable(false);
        addUserButton.setBounds(25,66,125,30);
        addUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addUserButton.addActionListener(this);
        this.add(addUserButton);

        updateUserButton = new JButton("Update");
        updateUserButton.setBackground(CONSTANT.BUTTON_COLOR);
        updateUserButton.setForeground(Color.BLACK);
        updateUserButton.setFont(new Font("Inter", Font.BOLD, 15));
        updateUserButton.setFocusable(false);
        updateUserButton.setBounds(166,66,125,30);
        updateUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateUserButton.addActionListener(this);
        this.add(updateUserButton);

        deleteUserButton = new JButton("Delete");
        deleteUserButton.setBackground(CONSTANT.BUTTON_COLOR);
        deleteUserButton.setForeground(Color.BLACK);
        deleteUserButton.setFont(new Font("Inter", Font.BOLD, 15));
        deleteUserButton.setFocusable(false);
        deleteUserButton.setBounds(307,66,125,30);
        deleteUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteUserButton.addActionListener(this);
        this.add(deleteUserButton);

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
            User user;
            //Add Button
            if (e.getSource() == addUserButton) {
                user = null;
                userAddDeletePanel = new UserAddUpdatePanel(adminMainPanel, 1, user);
                this.add(userAddDeletePanel);
                this.setComponentZOrder(userAddDeletePanel,0);
                this.revalidate();
                this.repaint();
                //Update Button
            } else if (e.getSource() == updateUserButton) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Please select a User to update.");
                    return;
                }
                int ID = Integer.parseInt(table.getValueAt(row, 1).toString());
                String username = table.getValueAt(row, 2).toString();
                String password = table.getValueAt(row, 3).toString();
                String fullname = table.getValueAt(row, 4).toString();
                String number = table.getValueAt(row, 5).toString();
                user = new User(ID,username,password,fullname,number);
                userAddDeletePanel = new UserAddUpdatePanel(adminMainPanel,2, user);
                this.add(userAddDeletePanel);
                this.setComponentZOrder(userAddDeletePanel,0);
                this.revalidate();
                this.repaint();
                //delete button
            } else if (e.getSource() == deleteUserButton) {
                String[] selected = DATABASE.getSelected((DefaultTableModel) table.getModel());
                if ((selected.length) == 0) {
                    JOptionPane.showMessageDialog(null, "Please select a User to Delete.");
                }else{
                    DATABASE.delete(selected,CONSTANT.SYSTEM_USERS);
                }
                //refresh button
            } else if (e.getSource() == refreshButton) {
                adminMainPanel.CenterPanel.removeAll();
                adminMainPanel.CenterPanel.add(new ManageUserPanel(adminMainPanel),BorderLayout.CENTER);
                adminMainPanel.CenterPanel.revalidate();
                adminMainPanel.CenterPanel.repaint();
            }
        }catch(IOException e1){
            throw new RuntimeException();
        }
    }
}
