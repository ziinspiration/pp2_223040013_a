package Sesi2.Latihan7Modifikasi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

public class FormPendaftaran extends JFrame implements ActionListener, ItemListener {

    private JTextField kotakNama;
    private JTextField kotakNoHp;
    private JTextArea areaBiodata;
    private JCheckBox checkBoxWNA;
    private JRadioButton radioLaki;
    private JRadioButton radioPerempuan;
    private ButtonGroup bg;
    private boolean isCheckBoxSelected;
    private JList<String> listTabungan;
    private JSlider sliderFrekuensiTransaksi;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JSpinner spinnerTanggalLahir;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuReset;
    private JMenuItem menuExit;

    public FormPendaftaran() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuReset = new JMenuItem("Reset");
        menuExit = new JMenuItem("Exit");
        menu.add(menuReset);
        menu.add(menuExit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        menuReset.addActionListener(e -> resetForm());
        menuExit.addActionListener(e -> System.exit(0));

        JLabel labelNama = new JLabel("Nama:");
        kotakNama = new JTextField(15);

        JLabel labelNoHp = new JLabel("Nomor HP:");
        kotakNoHp = new JTextField(15);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        radioLaki = new JRadioButton("Laki-Laki");
        radioPerempuan = new JRadioButton("Perempuan");
        bg = new ButtonGroup();
        bg.add(radioLaki);
        bg.add(radioPerempuan);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd-MM-yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);

        JLabel labelStatusWNA = new JLabel("Status Warga Negara:");
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.addItemListener(this);

        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        String[] tabunganOptions = {
                "Tabungan Hari Tua",
                "Tabungan Pendidikan",
                "Tabungan Haji",
                "Tabungan Umum"
        };
        listTabungan = new JList<>(tabunganOptions);
        JScrollPane scrollPaneTabungan = new JScrollPane(listTabungan);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneTabungan.setPreferredSize(new Dimension(150, 40));

        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi:");
        sliderFrekuensiTransaksi = new JSlider(0, 100, 0);
        sliderFrekuensiTransaksi.setMajorTickSpacing(10);
        sliderFrekuensiTransaksi.setMinorTickSpacing(10);
        sliderFrekuensiTransaksi.setPaintTicks(true);
        sliderFrekuensiTransaksi.setPaintLabels(true);
        sliderFrekuensiTransaksi.setPreferredSize(new Dimension(300, 50));

        JLabel labelPassword = new JLabel("Password:");
        passwordField = new JPasswordField(15);

        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
        confirmPasswordField = new JPasswordField(15);

        JButton tombol = new JButton("Simpan");
        tombol.addActionListener(this);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(labelNama, gbc);

        gbc.gridx = 1;
        add(kotakNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelNoHp, gbc);

        gbc.gridx = 1;
        add(kotakNoHp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelJenisKelamin, gbc);

        gbc.gridx = 1;
        add(radioLaki, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(radioPerempuan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(labelTanggalLahir, gbc);

        gbc.gridx = 1;
        add(spinnerTanggalLahir, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(labelStatusWNA, gbc);

        gbc.gridx = 1;
        add(checkBoxWNA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(labelTabungan, gbc);

        gbc.gridx = 1;
        add(scrollPaneTabungan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(labelFrekuensi, gbc);

        gbc.gridx = 1;
        add(sliderFrekuensiTransaksi, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(labelPassword, gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(labelConfirmPassword, gbc);

        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        add(tombol, gbc);

        areaBiodata = new JTextArea(12, 20);
        areaBiodata.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaBiodata);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 10;
        gbc.fill = GridBagConstraints.BOTH;
        scrollPane.setPreferredSize(new Dimension(300, 300));
        add(scrollPane, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void resetForm() {
        kotakNama.setText("");
        kotakNoHp.setText("");
        bg.clearSelection();
        checkBoxWNA.setSelected(false);
        listTabungan.clearSelection();
        sliderFrekuensiTransaksi.setValue(0);
        passwordField.setText("");
        confirmPasswordField.setText("");
        spinnerTanggalLahir.setValue(new java.util.Date());
        areaBiodata.setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        isCheckBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = kotakNama.getText();
        String noHp = kotakNoHp.getText();
        String jenisKelamin = radioLaki.isSelected() ? "Laki-Laki" : "Perempuan";
        String wnaStatus = isCheckBoxSelected ? "Warga Negara Asing" : "Warga Negara Indonesia";
        String tabunganTerpilih = listTabungan.getSelectedValue();
        String frekuensiTransaksi = String.valueOf(sliderFrekuensiTransaksi.getValue());
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String passwordStatus;

        if (password.equals(confirmPassword)) {
            passwordStatus = "Pendaftaran Berhasil";
        } else {
            passwordStatus = "Maaf Pendaftaran Gagal, password tidak cocok";
            JOptionPane.showMessageDialog(this, passwordStatus, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String tanggalLahir = dateFormat.format(spinnerTanggalLahir.getValue());

        String biodata = "Nama : " + nama +
                "\nNomor HP : " + noHp +
                "\nJenis Kelamin : " + jenisKelamin +
                "\nTanggal Lahir : " + tanggalLahir +
                "\nStatus Warga Negara : " + wnaStatus +
                "\nJenis Tabungan : " + tabunganTerpilih +
                "\nFrekuensi Transaksi : " + frekuensiTransaksi +
                "\n" + passwordStatus;

        areaBiodata.setText(biodata);
    }

    public static void main(String[] args) {
        new FormPendaftaran();
    }
}
