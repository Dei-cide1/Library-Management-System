package Main.GUI.AdminPanel;

import Main.CONSTANT;
import Main.GUI.LoginPanel;
import Main.GUI.Myframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AdminMainPanel extends JPanel{
    JLabel tachiyomi;
    JLabel HeaderLabel;
    JPanel sideBar;
    JLabel Library;
    JLabel BorrowRequest;
    JLabel BorrowedBooks;
    JLabel ManageUser;
    JLabel UserInfo;
    JLabel SidePanelAdminLabel;
    JButton LogoutButton;
    JPanel CenterPanel;
    AdminMainPanel adminMainPanel;
    Myframe myframe;
    public AdminMainPanel(Myframe frame) {
        adminMainPanel = this;
        this.myframe = frame;
        this.setBackground(CONSTANT.COLOR1);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(CONSTANT.WIDTH,CONSTANT.HEIGHT));

        //center Panel
        CenterPanel = new JPanel();
        CenterPanel.setBackground(CONSTANT.COLOR1);
        CenterPanel.setLayout(new BorderLayout());
        CenterPanel.setBounds(168,0,(CONSTANT.WIDTH-168),CONSTANT.HEIGHT);
        try {
            CenterPanel.add(new LibraryPanel(this), BorderLayout.CENTER);
        }catch (IOException e){
            throw new RuntimeException();
        }
        this.add(CenterPanel);

        //sidebar
        sideBar = new JPanel();
        sideBar.setBackground(CONSTANT.COLOR2);
        sideBar.setLayout(null);
        sideBar.setBounds(0,0,168,768);
        this.add(sideBar);

        tachiyomi = new JLabel();
        tachiyomi.setText("TACHIYOMI");
        tachiyomi.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        tachiyomi.setFont(new Font("Inter",Font.BOLD,25));
        tachiyomi.setVerticalAlignment(JLabel.TOP);
        tachiyomi.setHorizontalAlignment(JLabel.CENTER);
        tachiyomi.setBounds(0,15,168,28);
        HeaderLabel = new JLabel();
        HeaderLabel.setText("Admin Panel");
        HeaderLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        HeaderLabel.setFont(new Font("Inter",Font.BOLD,18));
        HeaderLabel.setVerticalAlignment(JLabel.TOP);
        HeaderLabel.setHorizontalAlignment(JLabel.CENTER);
        HeaderLabel.setBounds(0,50,168,28);
        JPanel linePanel = new JPanel();
        linePanel.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        linePanel.setBounds(10,88,148,3);
        sideBar.add(linePanel);
        sideBar.add(tachiyomi);
        sideBar.add(HeaderLabel);

        Library = new JLabel("Library");
        Library.setBounds(0,150,168,30);
        Library.setFont(new Font("Inter", Font.BOLD, 15));
        Library.setBackground(CONSTANT.COLOR3);
        Library.setOpaque(true);
        Library.setForeground(Color.WHITE);
        Library.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Library.setVerticalAlignment(JLabel.CENTER);
        Library.setHorizontalAlignment(JLabel.CENTER);
        Library.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource() ==  Library) {
                    Library.setBackground(CONSTANT.COLOR3);
                    ManageUser.setBackground(CONSTANT.COLOR2);
                    UserInfo.setBackground(CONSTANT.COLOR2);
                    CenterPanel.removeAll();
                    try {
                        CenterPanel.add(new LibraryPanel(adminMainPanel), BorderLayout.CENTER);
                    }catch (IOException ex){
                        throw new RuntimeException();
                    }
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }
        });
        sideBar.add(Library);

        BorrowRequest = new JLabel("Borrow Request");
        BorrowRequest.setBounds(0,190,168,30);
        BorrowRequest.setFont(new Font("Inter", Font.BOLD, 15));
        BorrowRequest.setBackground(CONSTANT.COLOR2);
        BorrowRequest.setOpaque(true);
        BorrowRequest.setForeground(Color.WHITE);
        BorrowRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BorrowRequest.setVerticalAlignment(JLabel.CENTER);
        BorrowRequest.setHorizontalAlignment(JLabel.CENTER);
        BorrowRequest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource() ==  BorrowRequest) {
                    BorrowRequest.setBackground(CONSTANT.COLOR3);
                    ManageUser.setBackground(CONSTANT.COLOR2);
                    UserInfo.setBackground(CONSTANT.COLOR2);
                    CenterPanel.removeAll();
                    try {
                        CenterPanel.add(new BorrowRequest(adminMainPanel), BorderLayout.CENTER);
                    }catch (IOException ex){
                        throw new RuntimeException();
                    }
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }
        });
        sideBar.add(BorrowRequest);

        BorrowedBooks = new JLabel("Borrowed Books");
        BorrowedBooks.setBounds(0,230,168,30);
        BorrowedBooks.setFont(new Font("Inter", Font.BOLD, 15));
        BorrowedBooks.setBackground(CONSTANT.COLOR2);
        BorrowedBooks.setOpaque(true);
        BorrowedBooks.setForeground(Color.WHITE);
        BorrowedBooks.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BorrowedBooks.setVerticalAlignment(JLabel.CENTER);
        BorrowedBooks.setHorizontalAlignment(JLabel.CENTER);
        BorrowedBooks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource() ==  BorrowedBooks) {
                    BorrowedBooks.setBackground(CONSTANT.COLOR3);
                    ManageUser.setBackground(CONSTANT.COLOR2);
                    UserInfo.setBackground(CONSTANT.COLOR2);
                    CenterPanel.removeAll();
                    try {
                        CenterPanel.add(new LibraryPanel(adminMainPanel), BorderLayout.CENTER);
                    }catch (IOException ex){
                        throw new RuntimeException();
                    }
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }
        });
        sideBar.add(BorrowedBooks);

        ManageUser = new JLabel("User Management");
        ManageUser.setBounds(0,270,168,30);
        ManageUser.setFont(new Font("Inter", Font.BOLD, 15));
        ManageUser.setBackground(CONSTANT.COLOR2);
        ManageUser.setOpaque(true);
        ManageUser.setForeground(Color.WHITE);
        ManageUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ManageUser.setVerticalAlignment(JLabel.CENTER);
        ManageUser.setHorizontalAlignment(JLabel.CENTER);
        ManageUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource() == ManageUser) {
                    try {
                        Library.setBackground(CONSTANT.COLOR2);
                        ManageUser.setBackground(CONSTANT.COLOR3);
                        UserInfo.setBackground(CONSTANT.COLOR2);
                        CenterPanel.removeAll();
                        CenterPanel.add(new ManageUserPanel(adminMainPanel),BorderLayout.CENTER);
                        CenterPanel.revalidate();
                        CenterPanel.repaint();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        sideBar.add(ManageUser);

        UserInfo = new JLabel("Profile");
        UserInfo.setBounds(0,310,168,30);
        UserInfo.setFont(new Font("Inter", Font.BOLD, 15));
        UserInfo.setBackground(CONSTANT.COLOR2);
        UserInfo.setOpaque(true);
        UserInfo.setForeground(Color.WHITE);
        UserInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        UserInfo.setVerticalAlignment(JLabel.CENTER);
        UserInfo.setHorizontalAlignment(JLabel.CENTER);
        UserInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource() ==  UserInfo) {
                    Library.setBackground(CONSTANT.COLOR2);
                    ManageUser.setBackground(CONSTANT.COLOR2);
                    UserInfo.setBackground(CONSTANT.COLOR3);
                    CenterPanel.removeAll();
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }
        });
        sideBar.add(UserInfo);


        SidePanelAdminLabel = new JLabel("Admin");
        SidePanelAdminLabel.setBounds(0,678,168,30);
        SidePanelAdminLabel.setFont(new Font("Inter", Font.BOLD, 13));
        SidePanelAdminLabel.setForeground(Color.WHITE);
        SidePanelAdminLabel.setVerticalAlignment(JLabel.CENTER);
        SidePanelAdminLabel.setHorizontalAlignment(JLabel.CENTER);
        sideBar.add(SidePanelAdminLabel);

        LogoutButton = new JButton("Logout");
        LogoutButton.setBackground(CONSTANT.COLOR3);
        LogoutButton.setForeground(Color.BLACK);
        LogoutButton.setFont(new Font("Inter", Font.BOLD, 15));
        LogoutButton.setFocusable(false);
        LogoutButton.setBounds(22,728,125,30);
        LogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.getContentPane().removeAll();
                    frame.add(new LoginPanel(frame),BorderLayout.CENTER);
                    frame.revalidate();
                    frame.repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        sideBar.add(LogoutButton);
    }
}
