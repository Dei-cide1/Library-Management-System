package Main;

import Main.DataBase.DATABASE;
import Main.GUI.AdminPanel.LibraryPanel;
import Main.GUI.UserPanel.UserMainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Library {

    public void AddBook(Book book){
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(CONSTANT.BOOKS, true));

        writer.write(book.getID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getCopies());
        writer.newLine();

        writer.close();

        JOptionPane.showMessageDialog(null, "Successfuly Added "+book.getTitle()+" to Library!");
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void updateBook(Book book){
        try{
        File New = new File(CONSTANT.TEMP);
        File Old = new File(CONSTANT.BOOKS);
        BufferedWriter write = new BufferedWriter(new FileWriter(CONSTANT.TEMP, true));
        BufferedReader read = new BufferedReader(new FileReader(CONSTANT.BOOKS));
        String line;
        while ((line = read.readLine()) != null) {
            String []row = line.split(",");
            int ID = Integer.parseInt(row[0]);
            if(ID == book.getID()) {
                write.write(book.getID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getCopies());
            }else{
                write.write(line);
            }
            write.newLine();
        }
        write.close();
        read.close();

        New.renameTo(Old);

        JOptionPane.showMessageDialog(null, "Successfuly Updated "+book.getTitle());
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void updateUser(User user){
        try{
        File New = new File(CONSTANT.TEMP);
        File Old = new File(CONSTANT.SYSTEM_USERS);
        BufferedWriter write = new BufferedWriter(new FileWriter(CONSTANT.TEMP, true));
        BufferedReader read = new BufferedReader(new FileReader(CONSTANT.SYSTEM_USERS));
        String line;
        while ((line = read.readLine()) != null) {
            String []row = line.split(",");
            int ID = Integer.parseInt(row[0]);
            if(ID == user.getID()) {
                write.write(user.getID() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getFullname() + "," + user.getPhonenumber() + "," + Role.USER);
            }else{
                write.write(line);
            }
            write.newLine();
        }
        write.close();
        read.close();

        New.renameTo(Old);

        JOptionPane.showMessageDialog(null, "Successfuly Updated "+user.getUsername());
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void borrowBooks(String []ID, User user) {
        if(ID.length == 0){
            return;
        }

        try {
//            File New = new File(CONSTANT.TEMP);
//            File Old = new File(CONSTANT.HISTORY);
            BufferedWriter write = new BufferedWriter(new FileWriter(CONSTANT.HISTORY, true));
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.BOOKS));

            LocalDateTime date = LocalDateTime.now();
            LocalDateTime ddate = date.plusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
            String dateNow = date.format(formatter);
            String dueDate = ddate.format(formatter);

            String line;

            for(String id : ID) {
                while ((line = read.readLine()) != null) {
                    String[] row = line.split(",");

                    int Id = DATABASE.incrementedID(CONSTANT.HISTORY);

                    if (row[0].equals(id)) {
                        write.write(Id + "," + user.getID() + "," + row[0] + "," + row[1] + "," + dateNow + "," + dueDate + "," + Action.Pending);
                        write.newLine();
                        break;
                    }
                }
            }

            read.close();
            write.close();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public void actionButton(Action action, String []Selected){
        try {
            File New = new File(CONSTANT.TEMP);
            File Old = new File(CONSTANT.HISTORY);
            BufferedWriter write = new BufferedWriter(new FileWriter(CONSTANT.TEMP, true));
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.HISTORY));

            String line;
            for(String selected : Selected){
                while ((line = read.readLine()) != null) {
                    String []row = line.split(",");
                    if (row[0].equals(selected)) {
                        write.write(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5] + "," + action);
                    }else {
                        write.write(line);
                    }
                    write.newLine();
                }
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
