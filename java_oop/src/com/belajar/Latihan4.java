package com.belajar;
import java.util.Scanner;
public class Latihan4 {
    public static void main(String[] args) {
        // Menggunakan Class Scanner
        int idPasien;
        String namaPasien, alamatPasien, keluhan;
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Input Data Pasien");
            System.out.println("-----------------");
            System.err.println("Id Pasien : ");
            idPasien = keyboard.nextInt();
            System.err.println("Nama Pasien : ");
            namaPasien = keyboard.next();
            System.err.println("Alamat Pasien : ");
            alamatPasien = keyboard.next();
            System.err.println("Keluhan : ");
            keluhan = keyboard.next();
        }
        //Menampilkan Data Pasien
        System.err.println("Output Data Pasien");
        System.err.println("------------------");
        System.err.println("Id Pasien :" + idPasien);
        System.err.println("Nama Pasien :" + namaPasien);
        System.err.println("Alamat Pasien :" + alamatPasien);
        System.err.println("Keluhan :" + keluhan);
        


    }
}