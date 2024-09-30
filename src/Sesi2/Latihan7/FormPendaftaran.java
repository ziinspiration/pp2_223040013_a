package Sesi2.Latihan7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormPendaftaran extends JFrame implements ActionListener, ItemListener {

    private JTextField kotakNama;
    private JTextField kotakNoHp;
    private JButton tombol;
    private JTextArea areaBiodata;
    private JCheckBox checkBoxWNA;
    private JRadioButton radioLaki;
    private JRadioButton radioPerempuan;
    private ButtonGroup bg;
    private boolean isCheckBoxSelected;

    public FormPendaftaran() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 100, 30);
        kotakNama = new JTextField();
        kotakNama.setBounds(15, 50, 300, 30);

        JLabel labelNoHp = new JLabel("Nomor HP:");
        labelNoHp.setBounds(15, 90, 120, 30);
        kotakNoHp = new JTextField();
        kotakNoHp.setBounds(15, 120, 300, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(15, 160, 100, 30);
        radioLaki = new JRadioButton("Laki-Laki");
        radioLaki.setBounds(15, 190, 120, 30);
        radioPerempuan = new JRadioButton("Perempuan");
        radioPerempuan.setBounds(15, 220, 120, 30);
        bg = new ButtonGroup();
        bg.add(radioLaki);
        bg.add(radioPerempuan);

        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 250, 200, 30);
        checkBoxWNA.addItemListener(this);

        tombol = new JButton("Simpan");
        tombol.setBounds(15, 290, 100, 30);
        tombol.addActionListener(this);

        areaBiodata = new JTextArea();
        areaBiodata.setBounds(15, 330, 450, 120);
        areaBiodata.setEditable(false);

        add(labelNama);
        add(kotakNama);
        add(labelNoHp);
        add(kotakNoHp);
        add(labelJenisKelamin);
        add(radioLaki);
        add(radioPerempuan);
        add(checkBoxWNA);
        add(tombol);
        add(areaBiodata);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        isCheckBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = kotakNama.getText();
        String noHp = kotakNoHp.getText();
        String jenisKelamin = "";

        if (radioLaki.isSelected()) {
            jenisKelamin = radioLaki.getText();
        } else if (radioPerempuan.isSelected()) {
            jenisKelamin = radioPerempuan.getText();
        }

        String wnaStatus = isCheckBoxSelected ? "WNA : Ya" : "WNA : Bukan";

        String biodata = "Nama : " + nama + "\nNomor HP : " + noHp + "\nJenis Kelamin : " + jenisKelamin + "\n" + wnaStatus + "\n" + "=".repeat(30) + "\n";

        areaBiodata.append(biodata);

        kotakNama.setText("");
        kotakNoHp.setText("");
        bg.clearSelection();
        checkBoxWNA.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPendaftaran());
    }
}
