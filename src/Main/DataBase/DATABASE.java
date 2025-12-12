package Main.DataBase;

import Main.CONSTANT;
import Main.Role;
import Main.User;
import Main.Action;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class DATABASE {
    public static User AuthenticateUser(String name, String password) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(CONSTANT.SYSTEM_USERS));
        String line;

        while((line = read.readLine()) != null) {
            String []accounts = line.split(",");
            if (accounts[1].equals(name) && accounts[2].equals(password)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                return new User(Integer.parseInt(accounts[0]),accounts[1],accounts[2],accounts[3],accounts[4]);
            }
        }

        read.close();
        return null;
    }

    public static void registerUser(String username, String password, String fullname, String phonenumber)throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(CONSTANT.SYSTEM_USERS, true));

        String nID = String.valueOf(incrementedID(CONSTANT.SYSTEM_USERS));

        writer.write(nID+","+username+","+password+","+fullname+","+phonenumber+","+ Role.USER);
        writer.newLine();

        writer.close();

        JOptionPane.showMessageDialog(null, "Successfuly registered!");
    }

    public static int incrementedID(String file) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(file));

        int LastID = 1000;
        String line;

        while((line = read.readLine()) != null) {
            String []accounts = line.split(",");
            LastID = Integer.parseInt(accounts[0]);
        }

        return (LastID + 1);
    }

    public static void delete(String []ID, String file){
        try {
            String line;
            int i = 0;
            File New = new File(CONSTANT.TEMP);
            File Old = new File(file);
            BufferedWriter write = new BufferedWriter(new FileWriter(CONSTANT.TEMP));
            BufferedReader read = new BufferedReader(new FileReader(file));

                while((line = read.readLine()) != null) {
                    String []row = line.split(",");
                    if(!ID[i].equals(row[0])){
                        write.write(line);
                        write.newLine();
                    }else{
                        i++;
                    }
                }

            write.close();
            read.close();
            New.renameTo(Old);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public static DefaultTableModel getBookList(){
        String[] colum = {"Select","ID", "Title", "Author", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(colum,0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return Boolean.class;
                    default: return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 0;
            }
        };
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.BOOKS));
            while ((line = read.readLine()) != null) {
                String []row = line.split(",");
                model.addRow(new Object[]{
                        false,
                        row[0],
                        row[1],
                        row[2],
                        row[3]
                });
            }
        }catch(IOException ex) {
            throw new RuntimeException(ex);
        }
        return model;
    }

    public static DefaultTableModel getUserList(){
        String[] colum = {"Select", "ID", "Username", "Password", "Fullname", "Phone Number"};
        DefaultTableModel model = new DefaultTableModel(colum,0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return Boolean.class;
                    default: return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 0;
            }
        };
        String []row;
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.SYSTEM_USERS));
            while ((line = read.readLine()) != null) {
                row = line.split(",");
                model.addRow(new Object[]{
                        false,
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        row[4],
                        row[5],
                });
            }
        }catch(IOException ex) {
            throw new RuntimeException(ex);
        }

        return model;
    }

    public static DefaultTableModel getHistoryList(){
        String[] colum = {"User ID", "Book ID", "Request Date", "DueDate", "Status"};
        DefaultTableModel model = new DefaultTableModel(colum,0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    default: return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String []row;
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.HISTORY));
            while ((line = read.readLine()) != null) {
                row = line.split(",");
                model.addRow(new Object[]{
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        row[4],
                });
            }
        }catch(IOException ex) {
            throw new RuntimeException(ex);
        }

        return model;
    }

    public static DefaultTableModel getBorrowRequestList(){
        String[] colum = {"Select" + "History ID", "User ID",  "Book ID", "Book Name" , "Request Date", "DueDate", "Status"};
        DefaultTableModel model = new DefaultTableModel(colum,0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return Boolean.class;
                    default: return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 0;
            }
        };
        String []row;
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.HISTORY));
            while ((line = read.readLine()) != null) {
                row = line.split(",");
                if(row[6].equals(String.valueOf(Action.Pending))) {
                    model.addRow(new Object[]{
                            false,
                            row[0],
                            row[1],
                            row[2],
                            row[3],
                            row[4],
                            row[5],
                            row[6]
                    });
                }
            }
        }catch(IOException ex) {
            throw new RuntimeException(ex);
        }

        return model;
    }

    public static DefaultTableModel getUserHistoryList(User user){
        String[] colum = {"History ID", "Book ID", "Book Name" , "Request Date", "DueDate", "Status"};
        DefaultTableModel model = new DefaultTableModel(colum,0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    default: return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String []row;
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(CONSTANT.HISTORY));
            while ((line = read.readLine()) != null) {
                row = line.split(",");
                if(row[1].equals(String.valueOf(user.getID()))) {
                    model.addRow(new Object[]{
                            row[0],
                            row[2],
                            row[3],
                            row[4],
                            row[5],
                            row[6]
                    });
                }
            }
        }catch(IOException ex) {
            throw new RuntimeException(ex);
        }

        return model;
    }

    public static String []getSelected(DefaultTableModel model){
        int j = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean Selected = (Boolean)model.getValueAt(i, 0);
            if(Selected){
                j++;
            }
        }
        String []SelectedID = new String[j];
        int k = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean Selected = (Boolean)model.getValueAt(i, 0);
            if(Selected){
                SelectedID[k] = model.getValueAt(i, 1).toString();
                k++;
            }
        }

        return  SelectedID;
    }

     public static boolean phoneNumberValidator(String phone){
        return phone.matches("[0-9]{11,11}");
    }

    public static boolean fullnameValidator(String name){
        return name.matches("[A-Za-z ]+");
    }

    public static boolean passwordValidator(String pass){
        boolean hasDigit = false;
        if (pass.length() < 6)
        {
            return false;
        }

        for(char c : pass.toCharArray()){
            if(Character.isDigit(c)){
                hasDigit = true;
                break;
            }
        }
        return hasDigit;
    }

    public static boolean userNameValidator(String text){
        return text.matches("[A-Za-z0-9]*");
    }

    public static boolean userExists(String name) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(CONSTANT.SYSTEM_USERS));
        String line;
        while((line = read.readLine()) != null) {
            String []accounts = line.split(",");
            if (accounts[0].equals(name)) {
                return true;
            }
        }
        read.close();
        return false;
    }
}
