package com.belajar.dani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "apaaja"; // Sesuaikan dengan username database Anda
        String password = "123"; // Sesuaikan dengan password database Anda

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Perintah SQL untuk membuat database
            String sql = "CREATE DATABASE demo_db";
            stmt.executeUpdate(sql);
            System.out.println("Database berhasil dibuat!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}