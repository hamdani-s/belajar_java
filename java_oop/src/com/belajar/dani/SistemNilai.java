package com.belajar.dani;

import java.util.Scanner;

public class SistemNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        // Meminta input nilai dari pengguna
        System.out.print("masukkan nilai anda: ");
        int nilai = scanner.nextInt();

        // menentukan peringkat nilai
        String peringkat;
        if (nilai >= 85 && nilai <= 100) {
            peringkat = "A";
        } else if (nilai >= 80) {
            peringkat = "B";
        } else if (nilai >= 70) {
            peringkat = "C";
        } else if (nilai >= 60) {
            peringkat = "D";
        } else {
            peringkat = "E";
        }

        // menampilkan hasil
        System.out.println("peringkat nilai anda : "  + peringkat);

        scanner.close();

    }
}
