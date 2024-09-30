package Sesi2.Latihan4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MFrame extends JFrame implements ActionListener {
    private JTextField inputNama;
    private JTextField inputNoTelp;
    private JButton tombolSimpan;
    private JTextArea areaHasil;

    public MFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(null);

        JLabel labelNama = new JLabel("Masukkan Nama :");
        labelNama.setBounds(50, 20, 120, 30);
        inputNama = new JTextField();
        inputNama.setBounds(180, 20, 180, 30);

        JLabel labelNoTelp = new JLabel("Masukkan Nomor Telepon :");
        labelNoTelp.setBounds(50, 60, 160, 30);
        inputNoTelp = new JTextField();
        inputNoTelp.setBounds(180, 60, 180, 30);

        tombolSimpan = new JButton("Simpan Data");
        tombolSimpan.setBounds(180, 100, 120, 30);
        tombolSimpan.addActionListener(this);

        areaHasil = new JTextArea();
        areaHasil.setBounds(50, 150, 300, 250);
        areaHasil.setEditable(false);

        add(labelNama);
        add(inputNama);
        add(labelNoTelp);
        add(inputNoTelp);
        add(tombolSimpan);
        add(areaHasil);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = inputNama.getText();
        String noTelp = inputNoTelp.getText();

        String hasilBiodata = "Nama: " + nama + "\nNomor Telepon: " + noTelp + "\n" + "-".repeat(30) + "\n";

        areaHasil.append(hasilBiodata);

        inputNama.setText("");
        inputNoTelp.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MFrame();
        });
    }
}
