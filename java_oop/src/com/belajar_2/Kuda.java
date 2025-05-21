package com.belajar_2;

public class Kuda extends Binatang {
    public void bersuara() {
        System.out.println("Ngieeeh");
    
    }
    public static void main(String[] args) {
        Binatang kuda_poni = new Binatang();
        kuda_poni.bersuara();
    }
}
