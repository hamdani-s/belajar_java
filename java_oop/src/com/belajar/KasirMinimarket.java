package com.belajar;
import java.util.ArrayList;
import java.util.Scanner;

class Produk {
    String nama;
    double harga;
    int jumlah;

    public Produk(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
}

public class KasirMinimarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produk> keranjang = new ArrayList<>();

        Produk[] daftarProduk = {
            new Produk("Beras 5kg", 75000, 100),
            new Produk("Minyak Goreng 1L", 20000, 100),
            new Produk("kinder joy 20g", 16000, 100),
            new Produk("es wall's", 36000, 100),
            new Produk("cadbury dairy milk", 27000, 100),
            new Produk("sunlight", 11000, 100),
            new Produk("pop mie", 7000, 100),
            new Produk("blue band", 10000, 100)
            
        };

        while (true) {
            System.out.println("\n=== Daftar Produk ===");
            for (int i = 0; i < daftarProduk.length; i++) {
                System.out.println((i + 1) + ". " + daftarProduk[i].nama + " - Rp " + daftarProduk[i].harga);
            }
            System.out.println("0. Selesai dan Bayar");

            System.out.print("Pilih produk (1-" + daftarProduk.length + ", 0 untuk selesai): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) break;
            if (pilihan < 1 || pilihan > daftarProduk.length) {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            System.out.print("Masukkan jumlah: ");
            int jumlah = scanner.nextInt();
            if (jumlah <= 0 || jumlah > daftarProduk[pilihan - 1].jumlah) {
                System.out.println("Jumlah tidak valid atau stok tidak cukup.");
                continue;
            }

            Produk produkDipilih = daftarProduk[pilihan - 1];
            keranjang.add(new Produk(produkDipilih.nama, produkDipilih.harga, jumlah));
            daftarProduk[pilihan - 1].jumlah -= jumlah;
            System.out.println("Ditambahkan ke keranjang: " + produkDipilih.nama + " x " + jumlah);
        }

        double totalHarga = 0;
        System.out.println("\n=== Keranjang Belanja ===");
        for (Produk p : keranjang) {
            System.out.println(p.nama + " x " + p.jumlah + " = Rp " + (p.harga * p.jumlah));
            totalHarga += p.harga * p.jumlah;
        }
        System.out.println("Total: Rp " + totalHarga);

        System.out.print("Masukkan jumlah uang pembayaran: Rp ");
        double bayar = scanner.nextDouble();
        if (bayar >= totalHarga) {
            System.out.println("Pembayaran berhasil. Kembalian: Rp " + (bayar - totalHarga));
        } else {
            System.out.println("Uang tidak cukup!");
        }

        System.out.println("Terima kasih telah berbelanja di ambatumart!");
        System.out.println("silahkan datng lagi!");
        scanner.close();
    }
}
