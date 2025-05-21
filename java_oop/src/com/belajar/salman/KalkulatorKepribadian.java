package com.belajar.salman;

import java.util.Scanner;

public class KalkulatorKepribadian {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Kalkulator Kepribadian ===");
        System.out.print("Masukkan nama kamu: ");
        String nama = input.nextLine();

        System.out.print("Masukkan tanggal lahir kamu (1-31): ");
        int tanggal = input.nextInt();

        String kepribadian = hitungKepribadian(tanggal);

        ketik("\nHalo, " + nama + "!\n");
        ketik("Kepribadian kamu adalah: " + kepribadian + "\n");

        input.close();
    }

    public static String hitungKepribadian(int tanggal) {
        int kode = tanggal % 5;
        switch (kode) {
            case 0: return "Pemimpin alami yang percaya diri.";
            case 1: return "Penyayang dan sangat peduli dengan orang lain.";
            case 2: return "Kreatif dan penuh ide-ide unik.";
            case 3: return "Pendiam tapi bijaksana.";
            case 4: return "Lucu, santai, dan bikin suasana jadi seru.";
            default: return "Unik banget, susah ditebak!";
        }
    }

    public static void ketik(String teks) throws InterruptedException {
        for (char ch : teks.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(30); // animasi ketikan
        }
    }
}