package Sesi7.Tugas.src.dao;

import Sesi7.Tugas.src.db.DatabaseConnection;
import Sesi7.Tugas.src.model.Nasabah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NasabahDao {

    public void saveNasabah(Nasabah nasabah) {
        String sql = "INSERT INTO nasabah (nama, alamat, jenis_kelamin, setuju_syarat, jenis_akun, layanan, usia, penghasilan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nasabah.getNama());
            pstmt.setString(2, nasabah.getAlamat());
            pstmt.setString(3, nasabah.getJenisKelamin());
            pstmt.setBoolean(4, nasabah.isSetujuSyarat());
            pstmt.setString(5, nasabah.getJenisAkun());
            pstmt.setString(6, nasabah.getLayanan());
            pstmt.setInt(7, nasabah.getUsia());
            pstmt.setInt(8, nasabah.getPenghasilan());
            pstmt.executeUpdate();
            System.out.println("Data berhasil disimpan: " + nasabah.getNama());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Nasabah> getAllNasabah() {
        List<Nasabah> nasabahList = new ArrayList<>();
        String sql = "SELECT * FROM nasabah";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Nasabah nasabah = new Nasabah(
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("jenis_kelamin"),
                        rs.getBoolean("setuju_syarat"),
                        rs.getString("jenis_akun"),
                        rs.getString("layanan"),
                        rs.getInt("usia"),
                        rs.getInt("penghasilan"));
                nasabahList.add(nasabah);
                System.out.println("Data Nasabah diambil: " + nasabah.getNama());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nasabahList;
    }
}