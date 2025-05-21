package com.belajar_2;

// Kelas induk
class Hewan {
    void suara() {
        System.out.println("Hewan membuat suara");
    }
}

// Kelas turunan
class harimau extends Hewan {
    @Override
    void suara() {
        System.out.println("harimau mengeong");
    }
}

// Kelas utama untuk menjalankan program
public class kebab {
    public static void main(String[] args) {
        Hewan h = new Hewan();     // Objek dari kelas induk
        Hewan k = new harimau();    // Polimorfisme: objek harimau tapi direferensikan sebagai Hewan
    

        h.suara(); // Output: Hewan membuat suara
        k.suara(); // Output: harimau mengeong (metode overriding dijalankan)
    }
}
