package com.belajar.ghaniy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "apaaja";
        String password = "123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Perintah SQL untuk membuat tabel
            String sql = "CREATE TABLE users (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
                         "name VARCHAR(100), " +
                         "email VARCHAR(100), " +
                         "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.executeUpdate(sql);
            System.out.println("Tabel berhasil dibuat!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}