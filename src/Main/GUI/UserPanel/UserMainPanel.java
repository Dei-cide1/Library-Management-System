package Main.GUI.UserPanel;

import Main.CONSTANT;
import Main.GUI.LoginPanel;
import Main.GUI.Myframe;
import Main.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class UserMainPanel extends JPanel {
    User user;
    JLabel tachiyomi = new JLabel();
    JPanel sideBar;
    JLabel Library;
    JLabel BorrowedBooks;
    JLabel UserInfo;
    JLabel SidePanelUserLabel;
    JButton LogoutButton;
    public JPanel CenterPanel;
    Myframe frame;
    public UserMainPanel(Myframe frame, User user) {
        this.frame = frame;
        this.user = user;
        this.setBackground(CONSTANT.COLOR1);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(CONSTANT.WIDTH, CONSTANT.HEIGHT));

        //center Panel
        CenterPanel = new JPanel();
        CenterPanel.setBackground(CONSTANT.COLOR1);
        CenterPanel.setLayout(new BorderLayout());
        CenterPanel.setBounds(168, 0, (CONSTANT.WIDTH - 168), 768);
        try {
            CenterPanel.add(new LibraryPanel(user), BorderLayout.CENTER);
        }catch (IOException e){
            throw new RuntimeException();
        }
        this.add(CenterPanel);

        //sidebar
        sideBar = new JPanel();
        sideBar.setBackground(CONSTANT.COLOR2);
        sideBar.setLayout(null);
        sideBar.setBounds(0, 0, 168, 768);
        this.add(sideBar);

        tachiyomi = new JLabel();
        tachiyomi.setText("TACHIYOMI");
        tachiyomi.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        tachiyomi.setFont(new Font("Inter", Font.BOLD, 25));
        tachiyomi.setVerticalAlignment(JLabel.TOP);
        tachiyomi.setHorizontalAlignment(JLabel.CENTER);
        tachiyomi.setBounds(0, 15, 168, 28);
        JPanel linePanel = new JPanel();
        linePanel.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        linePanel.setBounds(10, 58, 148, 3);
        sideBar.add(linePanel);
        sideBar.add(tachiyomi);

        Library = new JLabel("Library");
        Library.setBounds(0, 90, 168, 30);
        Library.setFont(new Font("Inter", Font.BOLD, 15));
        Library.setBackground(CONSTANT.COLOR3);
        Library.setOpaque(true);
        Library.setForeground(Color.WHITE);
        Library.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Library.setVerticalAlignment(JLabel.CENTER);
        Library.setHorizontalAlignment(JLabel.CENTER);
        Library.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Library) {
                    Library.setBackground(CONSTANT.COLOR3);
                    BorrowedBooks.setBackground(CONSTANT.COLOR2);
                    UserInfo.setBackground(CONSTANT.COLOR2);
                    CenterPanel.removeAll();
                    try {
                        CenterPanel.add(new LibraryPanel(user), BorderLayout.CENTER);
                    } catch (IOException ex) {
                        throw new RuntimeException();
                    }
                    CenterPanel.revalidate();
                    CenterPanel.repaint();
                }
            }


        });
        sideBar.add(Library);

        BorrowedBooks = new JLabel("My Borrowed Books");
        BorrowedBooks.setBounds(-7, 130, 180, 30);
        BorrowedBooks.setFont(new Font("Inter", Font.BOLD, 15));
        BorrowedBooks.setBackground(CONSTANT.COLOR2);
        BorrowedBooks.setOpaque(true);
        BorrowedBooks.setForeground(Color.WHITE);
        BorrowedBooks.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BorrowedBooks.setVerticalAlignment(JLabel.CENTER);
        BorrowedBooks.setHorizontalAlignment(JLabel.CENTER);
        BorrowedBooks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Library.setBackground(CONSTANT.COLOR2);
                BorrowedBooks.setBackground(CONSTANT.COLOR3);
                UserInfo.setBackground(CONSTANT.COLOR2);
                CenterPanel.removeAll();
                try {
                    CenterPanel.add(new MyBorrowedBookPanel(user), BorderLayout.CENTER);
                } catch (IOException ex) {
                    throw new RuntimeException();
                }
                CenterPanel.revalidate();
                CenterPanel.repaint();
            }
        });
        sideBar.add(BorrowedBooks);

        UserInfo = new JLabel("Profile");
        UserInfo.setBounds(0, 170, 168, 30);
        UserInfo.setFont(new Font("Inter", Font.BOLD, 15));
        UserInfo.setBackground(CONSTANT.COLOR2);
        UserInfo.setOpaque(true);
        UserInfo.setForeground(Color.WHITE);
        UserInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        UserInfo.setVerticalAlignment(JLabel.CENTER);
        UserInfo.setHorizontalAlignment(JLabel.CENTER);
        UserInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Library.setBackground(CONSTANT.COLOR2);
                BorrowedBooks.setBackground(CONSTANT.COLOR2);
                UserInfo.setBackground(CONSTANT.COLOR3);
            }
        });
        sideBar.add(UserInfo);

        SidePanelUserLabel = new JLabel(user.getFullname());
        SidePanelUserLabel.setBounds(0, 678, 168, 30);
        SidePanelUserLabel.setFont(new Font("Inter", Font.BOLD, 13));
        SidePanelUserLabel.setForeground(Color.WHITE);
        SidePanelUserLabel.setVerticalAlignment(JLabel.CENTER);
        SidePanelUserLabel.setHorizontalAlignment(JLabel.CENTER);
        sideBar.add(SidePanelUserLabel);

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
