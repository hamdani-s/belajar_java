package com.belajar.dani;

import java.util.Scanner;

public class biodata {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data dari user
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Umur: ");
        int umur = input.nextInt();
        input.nextLine(); // Membersihkan buffer

        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char jenisKelamin = input.next().charAt(0);
        input.nextLine(); // Membersihkan buffer

        System.out.print("Masukkan Alamat: ");
        String alamat = input.nextLine();

        System.out.print("Masukkan Asal Sekolah: ");
        String asalSekolah = input.nextLine();

        System.out.print("Masukkan Hobi: ");
        String hobi = input.nextLine();

        System.out.print("Masukkan Cita-cita: ");
        String citaCita = input.nextLine();

        input.close();

        // Menampilkan biodata
        System.out.println("\n=== Biodata Anda ===");
        System.out.println("Nama         : " + nama);
        System.out.println("Umur         : " + umur + " tahun");
        System.out.println("Jenis Kelamin: " + (jenisKelamin == 'L' ? "Laki-laki" : "Perempuan"));
        System.out.println("Alamat       : " + alamat);
        System.out.println("Asal Sekolah : " + asalSekolah);
        System.out.println("Hobi         : " + hobi);
        System.out.println("Cita-cita    : " + citaCita);
    }
} 
    

