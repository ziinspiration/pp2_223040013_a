package Sesi7.Tugas.src.view;

import Sesi7.Tugas.src.dao.NasabahDao;
import Sesi7.Tugas.src.model.Nasabah;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DataTable extends JFrame {
    private static DefaultTableModel tableModel;

    public DataTable() {
        setTitle("Data Nasabah");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[] {
                "Nama", "Alamat", "Jenis Kelamin", "Setuju Syarat",
                "Jenis Akun", "Layanan", "Usia", "Penghasilan"
        }, 0);

        loadData();

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table));
        setVisible(true);
    }

    private void loadData() {
        NasabahDao nasabahDao = new NasabahDao();
        List<Nasabah> nasabahList = nasabahDao.getAllNasabah();
        tableModel.setRowCount(0); // Clear existing rows

        for (Nasabah nasabah : nasabahList) {
            System.out.println("Memuat data nasabah ke tabel: " + nasabah.getNama());
            tableModel.addRow(new Object[] {
                    nasabah.getNama(),
                    nasabah.getAlamat(),
                    nasabah.getJenisKelamin(),
                    nasabah.isSetujuSyarat() ? "Ya" : "Tidak",
                    nasabah.getJenisAkun(),
                    nasabah.getLayanan(),
                    nasabah.getUsia(),
                    nasabah.getPenghasilan()
            });
        }
    }

    public static void addRow(String[] rowData) {
        if (tableModel == null) {
            new DataTable();
        }
        tableModel.addRow(rowData);
    }
}
