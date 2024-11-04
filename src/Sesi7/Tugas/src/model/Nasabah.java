package Sesi7.Tugas.src.model;

public class Nasabah {
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private boolean setujuSyarat;
    private String jenisAkun;
    private String layanan;
    private int usia;
    private int penghasilan;

    public Nasabah(String nama, String alamat, String jenisKelamin, boolean setujuSyarat,
                   String jenisAkun, String layanan, int usia, int penghasilan) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.setujuSyarat = setujuSyarat;
        this.jenisAkun = jenisAkun;
        this.layanan = layanan;
        this.usia = usia;
        this.penghasilan = penghasilan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public boolean isSetujuSyarat() {
        return setujuSyarat;
    }

    public String getJenisAkun() {
        return jenisAkun;
    }

    public String getLayanan() {
        return layanan;
    }

    public int getUsia() {
        return usia;
    }

    public int getPenghasilan() {
        return penghasilan;
    }
}
