package com.belajar;
//Latihan method non void
public class Mobilku {
   String warna1;
   int tahun_produksi;
   int nomorMesin; 
   int nomorRangka;
   //method mengisi variabel instance
   void isi (String warna1, int tahun_produksi, int nomorMesin, int nomorRangka){
    this.warna1 = warna1;
    this.tahun_produksi = tahun_produksi;
    this.nomorMesin = nomorMesin;
    this.nomorRangka = nomorRangka;
   }
   //Method menampilkan isi variabel
   String ambil_warna (){
    return warna1;
   }
   int ambil_tahun_produksi (){
    return tahun_produksi;
   }
    int ambil_nomorMesin (){
    return nomorMesin;
   }
    int ambil_nomorRangka (){
        return nomorRangka;
    }
    public static void main(String[] args) {
        Mobilku mobilNiaga = new Mobilku();
        //proses pemanggilan method void
        mobilNiaga.isi("putih", 2018, 23456, 89567);
        System.out.println("warna : " + mobilNiaga.ambil_warna());
        System.out.println("tahun produksi : " + mobilNiaga.ambil_tahun_produksi());
        System.out.println("nomor mesin : " + mobilNiaga.ambil_nomorMesin());
        System.out.println("nomor rangka " + mobilNiaga.ambil_nomorRangka());

    }
   }

