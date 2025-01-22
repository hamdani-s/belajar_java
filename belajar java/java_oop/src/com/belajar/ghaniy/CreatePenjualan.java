package com.belajar.ghaniy;

import java.util.Scanner;

public class CreatePenjualan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Penjualan ===");

        // Input data barang
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan harga barang (Rp): ");
        double hargaBarang = scanner.nextDouble();

        System.out.print("Masukkan jumlah barang: ");
        int jumlahBarang = scanner.nextInt();

        // Menghitung total harga
        double totalHarga = hargaBarang * jumlahBarang;

        // Diskon (contoh: 10% jika total > Rp500.000)
        double diskon = 0;
        if (totalHarga > 500000) {
            diskon = totalHarga * 0.10;
        }

        double totalBayar = totalHarga - diskon;

        // Output hasil
        System.out.println("\n=== Rincian Pembelian ===");
        System.out.println("Nama Barang   : " + namaBarang);
        System.out.println("Harga Satuan  : Rp" + hargaBarang);
        System.out.println("Jumlah Barang : " + jumlahBarang);
        System.out.println("Total Harga   : Rp" + totalHarga);
        System.out.println("Diskon        : Rp" + diskon);
        System.out.println("Total Bayar   : Rp" + totalBayar);

        scanner.close();
    }
}

