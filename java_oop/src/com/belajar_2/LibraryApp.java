package com.belajar_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

class Buku {
    String id, judul, pengarang, kategori;
    int tahunTerbit;

    public Buku(String id, String judul, String pengarang, int tahunTerbit, String kategori) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
    }
}

class Peminjaman {
    String namaPeminjam, idBuku;
    String tanggalPinjam, tanggalKembali;

    public Peminjaman(String nama, String pinjam, String kembali, String idBuku) {
        this.namaPeminjam = nama;
        this.tanggalPinjam = pinjam;
        this.tanggalKembali = kembali;
        this.idBuku = idBuku;
    }
}

public class LibraryApp extends JFrame {
    ArrayList<Buku> daftarBuku = new ArrayList<>();
    ArrayList<Peminjaman> daftarPinjam = new ArrayList<>();
    DefaultTableModel bukuModel, pinjamModel;

    public LibraryApp() {
        setTitle("Aplikasi Perpustakaan");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        // ========== PANEL BUKU ==========
        JPanel bukuPanel = new JPanel(new BorderLayout());
        JPanel inputBuku = new JPanel(new GridLayout(7, 2));
        JTextField idField = new JTextField();
        JTextField judulField = new JTextField();
        JTextField pengarangField = new JTextField();
        JTextField tahunField = new JTextField();
        JTextField kategoriField = new JTextField();

        inputBuku.add(new JLabel("ID Buku:"));
        inputBuku.add(idField);
        inputBuku.add(new JLabel("Judul:"));
        inputBuku.add(judulField);
        inputBuku.add(new JLabel("Pengarang:"));
        inputBuku.add(pengarangField);
        inputBuku.add(new JLabel("Tahun Terbit:"));
        inputBuku.add(tahunField);
        inputBuku.add(new JLabel("Kategori:"));
        inputBuku.add(kategoriField);

        // Tombol Buku
        JButton tambahBuku = new JButton("Tambah");
        JButton editBuku = new JButton("Edit");
        JButton simpanBuku = new JButton("Simpan");
        JButton hapusBuku = new JButton("Hapus");

        inputBuku.add(tambahBuku);
        inputBuku.add(editBuku);
        inputBuku.add(simpanBuku);
        inputBuku.add(hapusBuku);

        bukuModel = new DefaultTableModel(new String[]{"ID", "Judul", "Pengarang", "Tahun", "Kategori"}, 0);
        JTable bukuTable = new JTable(bukuModel);

        tambahBuku.addActionListener(e -> {
            try {
                Buku buku = new Buku(
                    idField.getText(),
                    judulField.getText(),
                    pengarangField.getText(),
                    Integer.parseInt(tahunField.getText()),
                    kategoriField.getText()
                );
                daftarBuku.add(buku);
                bukuModel.addRow(new Object[]{buku.id, buku.judul, buku.pengarang, buku.tahunTerbit, buku.kategori});
                clearBukuFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tahun harus berupa angka.");
            }
        });

        editBuku.addActionListener(e -> {
            int selected = bukuTable.getSelectedRow();
            if (selected >= 0) {
                idField.setText((String) bukuModel.getValueAt(selected, 0));
                judulField.setText((String) bukuModel.getValueAt(selected, 1));
                pengarangField.setText((String) bukuModel.getValueAt(selected, 2));
                tahunField.setText(bukuModel.getValueAt(selected, 3).toString());
                kategoriField.setText((String) bukuModel.getValueAt(selected, 4));
            }
        });

        simpanBuku.addActionListener(e -> {
            int selected = bukuTable.getSelectedRow();
            if (selected >= 0) {
                try {
                    Buku buku = new Buku(
                        idField.getText(),
                        judulField.getText(),
                        pengarangField.getText(),
                        Integer.parseInt(tahunField.getText()),
                        kategoriField.getText()
                    );
                    daftarBuku.set(selected, buku);
                    bukuModel.setValueAt(buku.id, selected, 0);
                    bukuModel.setValueAt(buku.judul, selected, 1);
                    bukuModel.setValueAt(buku.pengarang, selected, 2);
                    bukuModel.setValueAt(buku.tahunTerbit, selected, 3);
                    bukuModel.setValueAt(buku.kategori, selected, 4);
                    clearBukuFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Tahun harus berupa angka.");
                }
            }
        });

        hapusBuku.addActionListener(e -> {
            int selected = bukuTable.getSelectedRow();
            if (selected >= 0) {
                daftarBuku.remove(selected);
                bukuModel.removeRow(selected);
            }
        });

        bukuPanel.add(inputBuku, BorderLayout.NORTH);
        bukuPanel.add(new JScrollPane(bukuTable), BorderLayout.CENTER);
        tabs.add("Data Buku", bukuPanel);

        // ========== PANEL PEMINJAMAN ==========
        JPanel pinjamPanel = new JPanel(new BorderLayout());
        JPanel inputPinjam = new JPanel(new GridLayout(6, 2));
        JTextField namaField = new JTextField();
        JTextField pinjamField = new JTextField();
        JTextField kembaliField = new JTextField();
        JTextField idBukuPinjamField = new JTextField();

        inputPinjam.add(new JLabel("Nama Peminjam:"));
        inputPinjam.add(namaField);
        inputPinjam.add(new JLabel("Tanggal Pinjam:"));
        inputPinjam.add(pinjamField);
        inputPinjam.add(new JLabel("Tanggal Kembali:"));
        inputPinjam.add(kembaliField);
        inputPinjam.add(new JLabel("ID Buku:"));
        inputPinjam.add(idBukuPinjamField);

        JButton tambahPinjam = new JButton("Pinjam");
        JButton editPinjam = new JButton("Edit");
        JButton simpanPinjam = new JButton("Simpan");
        JButton hapusPinjam = new JButton("Hapus");

        inputPinjam.add(tambahPinjam);
        inputPinjam.add(editPinjam);
        inputPinjam.add(simpanPinjam);
        inputPinjam.add(hapusPinjam);

        pinjamModel = new DefaultTableModel(new String[]{"Nama", "Pinjam", "Kembali", "ID Buku"}, 0);
        JTable pinjamTable = new JTable(pinjamModel);

        tambahPinjam.addActionListener(e -> {
            if (kembaliField.getText().compareTo(pinjamField.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam.");
                return;
            }
            Peminjaman pinjam = new Peminjaman(
                namaField.getText(),
                pinjamField.getText(),
                kembaliField.getText(),
                idBukuPinjamField.getText()
            );
            daftarPinjam.add(pinjam);
            pinjamModel.addRow(new Object[]{pinjam.namaPeminjam, pinjam.tanggalPinjam, pinjam.tanggalKembali, pinjam.idBuku});
            clearPinjamFields();
        });

        editPinjam.addActionListener(e -> {
            int selected = pinjamTable.getSelectedRow();
            if (selected >= 0) {
                namaField.setText((String) pinjamModel.getValueAt(selected, 0));
                pinjamField.setText((String) pinjamModel.getValueAt(selected, 1));
                kembaliField.setText((String) pinjamModel.getValueAt(selected, 2));
                idBukuPinjamField.setText((String) pinjamModel.getValueAt(selected, 3));
            }
        });

        simpanPinjam.addActionListener(e -> {
            int selected = pinjamTable.getSelectedRow();
            if (selected >= 0) {
                if (kembaliField.getText().compareTo(pinjamField.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam.");
                    return;
                }
                Peminjaman pinjam = new Peminjaman(
                    namaField.getText(),
                    pinjamField.getText(),
                    kembaliField.getText(),
                    idBukuPinjamField.getText()
                );
                daftarPinjam.set(selected, pinjam);
                pinjamModel.setValueAt(pinjam.namaPeminjam, selected, 0);
                pinjamModel.setValueAt(pinjam.tanggalPinjam, selected, 1);
                pinjamModel.setValueAt(pinjam.tanggalKembali, selected, 2);
                pinjamModel.setValueAt(pinjam.idBuku, selected, 3);
                clearPinjamFields();
            }
        });

        hapusPinjam.addActionListener(e -> {
            int selected = pinjamTable.getSelectedRow();
            if (selected >= 0) {
                daftarPinjam.remove(selected);
                pinjamModel.removeRow(selected);
            }
        });

        pinjamPanel.add(inputPinjam, BorderLayout.NORTH);
        pinjamPanel.add(new JScrollPane(pinjamTable), BorderLayout.CENTER);
        tabs.add("Peminjaman", pinjamPanel);

        add(tabs);
        setVisible(true);
    }

    // Fungsi bantu untuk membersihkan field buku
    private void clearBukuFields() {
        for (Component comp : ((Container) getContentPane().getComponent(0)).getComponents()) {
            if (comp instanceof JPanel) {
                for (Component field : ((JPanel) comp).getComponents()) {
                    if (field instanceof JTextField) {
                        ((JTextField) field).setText("");
                    }
                }
            }
        }
    }

    // Fungsi bantu untuk membersihkan field peminjaman
    private void clearPinjamFields() {
        for (Component comp : ((Container) getContentPane().getComponent(1)).getComponents()) {
            if (comp instanceof JPanel) {
                for (Component field : ((JPanel) comp).getComponents()) {
                    if (field instanceof JTextField) {
                        ((JTextField) field).setText("");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new LibraryApp();
    }
}
