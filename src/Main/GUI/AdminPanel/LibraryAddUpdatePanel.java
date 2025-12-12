package Main.GUI.AdminPanel;

import Main.Book;
import Main.CONSTANT;
import Main.DataBase.DATABASE;
import Main.GUI.MainPanel;
import Main.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LibraryAddUpdatePanel extends MainPanel implements ActionListener {
    Library library;
    JLabel actionLabel;
    Book book;
    JPanel centerPanel;
    JLabel BookTitleLabel;
    JTextField bookTitle;
    JLabel BookAuthorLabel;
    JTextField bookAuthor;
    JLabel BookQuantityLabel;
    JTextField bookQuantity;
    JButton actionButton;
    JLabel closeButton;
    AdminMainPanel adminMainPanel;
    int action;
    public LibraryAddUpdatePanel(AdminMainPanel adminMainPanel, int action, Book book) {
        super();
        this.action = action;
        this.book = book;
        this.adminMainPanel = adminMainPanel;
        this.addMouseListener(new MouseAdapter() {});
        this.setPreferredSize(new Dimension((CONSTANT.WIDTH-168),CONSTANT.HEIGHT));
        this.setBackground(new Color(18, 19, 24, 150));
        this.setBounds(0,0,(CONSTANT.WIDTH-168),CONSTANT.HEIGHT);
        centerPanel = new JPanel();
        centerPanel.setBackground(CONSTANT.COLOR2);
        centerPanel.setBounds(100,109,400,550);
        centerPanel.setBorder(BorderFactory.createLineBorder(CONSTANT.BUTTON_COLOR,2));
        centerPanel.setLayout(null);
        this.add(centerPanel);

        actionLabel = new JLabel();
        if(action == 1) {
            actionLabel.setText("Add Book");
        }else{
            actionLabel.setText("Update book");
        }
        actionLabel.setForeground(CONSTANT.BUTTON_COLOR);
        actionLabel.setFont(new Font("Inter",Font.BOLD,20));
        actionLabel.setVerticalAlignment(JLabel.CENTER);
        actionLabel.setHorizontalAlignment(JLabel.CENTER);
        actionLabel.setBounds(125,15,150,30);
        centerPanel.add(actionLabel);

        closeButton = new JLabel("×");
        closeButton.setFont(new Font("Inter", Font.BOLD, 40));
        closeButton.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        closeButton.setBounds(355,15,30,30);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    adminMainPanel.CenterPanel.removeAll();
                    adminMainPanel.CenterPanel.add(new LibraryPanel(adminMainPanel), BorderLayout.CENTER);
                    adminMainPanel.CenterPanel.revalidate();
                    adminMainPanel.CenterPanel.repaint();
                }catch(IOException e1){
                    throw new RuntimeException();
                }
            }
        });
        centerPanel.add(closeButton);

        BookTitleLabel = new JLabel("Book Title : ");
        BookTitleLabel.setFont(new Font("Inter", Font.BOLD, 15));
        BookTitleLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        BookTitleLabel.setBounds(20,100,100,40);
        centerPanel.add(BookTitleLabel);

        bookTitle = new JTextField();
        if(action == 2){
            bookTitle.setText(book.getTitle());
        }
        bookTitle.setFont(new Font("Inter", Font.PLAIN, 15));
        bookTitle.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        bookTitle.setBounds(20,135,360,30);
        centerPanel.add(bookTitle);

        BookAuthorLabel = new JLabel("Book Author : ");
        BookAuthorLabel.setFont(new Font("Inter", Font.BOLD, 15));
        BookAuthorLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        BookAuthorLabel.setBounds(20,190,100,40);
        centerPanel.add(BookAuthorLabel);

        bookAuthor = new JTextField();
        if(action == 2){
            bookAuthor.setText(book.getAuthor());
        }
        bookAuthor.setFont(new Font("Inter", Font.PLAIN, 15));
        bookAuthor.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        bookAuthor.setBounds(20,225,360,30);
        centerPanel.add(bookAuthor);

        BookQuantityLabel = new JLabel("Book Quantity : ");
        BookQuantityLabel.setFont(new Font("Inter", Font.BOLD, 15));
        BookQuantityLabel.setForeground(CONSTANT.PRIMARYTEXT_COLOR);
        BookQuantityLabel.setBounds(20,280,150,40);
        centerPanel.add(BookQuantityLabel);

        bookQuantity = new JTextField();
        if(action == 2){
            bookQuantity.setText(String.valueOf(book.getCopies()));
        }
        bookQuantity.setFont(new Font("Inter", Font.PLAIN, 15));
        bookQuantity.setBackground(CONSTANT.PRIMARYTEXT_COLOR);
        bookQuantity.setBounds(20,315,360,30);
        centerPanel.add(bookQuantity);

        actionButton = new JButton();
        if(action == 1){
            actionButton.setText("Add Book");
        }else if(action == 2){
            actionButton.setText("Update Book");
        }
        actionButton.setFont(new Font("Inter", Font.BOLD, 15));
        actionButton.setBackground(CONSTANT.BUTTON_COLOR);
        actionButton.setForeground(Color.BLACK);
        actionButton.setBounds(135,450,130,30);
        actionButton.setFocusable(false);
        actionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionButton.addActionListener(this);
        centerPanel.add(actionButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == actionButton){
            try {
                String title = bookTitle.getText();
                String Author = bookAuthor.getText();
                int Quantity = Integer.parseInt(bookQuantity.getText());
                library = new Library();
                if(action == 1) {
                    //Add Book
                    Book bookc = new Book(bookTitle.getText(), bookAuthor.getText(), Integer.parseInt(bookQuantity.getText()));
                    bookc.setID(DATABASE.incrementedID(CONSTANT.BOOKS));

                    library.AddBook(bookc);

                    bookTitle.setText("");
                    bookAuthor.setText("");
                    bookQuantity.setText("");
                }else if(action == 2){
                    //Update
                    book.setTitle(title);
                    book.setAuthor(Author);
                    book.setCopies(Quantity);
                    library.updateBook(book);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
