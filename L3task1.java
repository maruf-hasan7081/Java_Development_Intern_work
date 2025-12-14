//Task 1: Library Management System with JDBC
// Description: Develop a Library Management System using Java and JDBC for database connectivity. The system should allow adding, borrowing, and returning books.
// Objectives:
//Set up a database (e.g., MySQL) with tables for Books,Users, and Transactions.
 //Implement CRUD operations using JDBC for managing books and users.
 //Handle transactions when books are borrowed or returned.

import java.sql.*;
import java.time.LocalDate;

public class L3task1 {

    private static final String URL =
            "jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, true)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();
            System.out.println("Book added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    static void addUser(String name) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("User added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    static void borrowBook(int bookId, int userId) {
        String checkBook = "SELECT available FROM books WHERE id=?";
        String updateBook = "UPDATE books SET available=false WHERE id=?";
        String insertTransaction =
                "INSERT INTO transactions (book_id, user_id, issue_date) VALUES (?, ?, ?)";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(checkBook)) {
                ps1.setInt(1, bookId);
                ResultSet rs = ps1.executeQuery();

                if (rs.next() && rs.getBoolean("available")) {

                    try (PreparedStatement ps2 = con.prepareStatement(updateBook);
                         PreparedStatement ps3 = con.prepareStatement(insertTransaction)) {

                        ps2.setInt(1, bookId);
                        ps2.executeUpdate();

                        ps3.setInt(1, bookId);
                        ps3.setInt(2, userId);
                        ps3.setDate(3, Date.valueOf(LocalDate.now()));
                        ps3.executeUpdate();

                        con.commit();
                        System.out.println("Book borrowed successfully.");
                    }
                } else {
                    System.out.println("Book not available.");
                }
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    static void returnBook(int bookId) {
        String updateBook = "UPDATE books SET available=true WHERE id=?";
        String updateTransaction =
                "UPDATE transactions SET return_date=? WHERE book_id=? AND return_date IS NULL";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(updateBook);
                 PreparedStatement ps2 = con.prepareStatement(updateTransaction)) {

                ps1.setInt(1, bookId);
                ps1.executeUpdate();

                ps2.setDate(1, Date.valueOf(LocalDate.now()));
                ps2.setInt(2, bookId);
                ps2.executeUpdate();

                con.commit();
                System.out.println("Book returned successfully.");

            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public static void main(String[] args) {

        addBook("The Great Gatsby", "F. Scott Fitzgerald");
        addUser("Maruf");

        borrowBook(1, 1);
        returnBook(1);
    }
}
