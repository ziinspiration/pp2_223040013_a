package Sesi6.TugasStudyKasus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataTable extends JFrame {
    private static DefaultTableModel tableModel;

    public DataTable() {
        setTitle("Data Nasabah");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{
                "Nama", "Alamat", "Jenis Kelamin", "Setuju Syarat",
                "Jenis Akun", "Layanan", "Usia", "Penghasilan"
        }, 0);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void addRow(String[] rowData) {
        if (tableModel == null) {
            new DataTable();
        }
        tableModel.addRow(rowData);
    }
}

