package Sesi6.TugasStudyKasus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NasabahForm extends JFrame {
    private JTextField namaField;
    private JTextArea alamatArea;
    private JRadioButton priaButton, wanitaButton;
    private JCheckBox syaratCheck;
    private JComboBox<String> jenisAkunCombo;
    private JList<String> layananList;
    private JSlider usiaSlider;
    private JSpinner penghasilanSpinner;

    public NasabahForm(JFrame parentFrame) {
        setTitle("Form Pendaftaran Nasabah");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama:"), gbc);

        namaField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Alamat:"), gbc);

        alamatArea = new JTextArea(3, 20);
        gbc.gridx = 1;
        panel.add(new JScrollPane(alamatArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Jenis Kelamin:"), gbc);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        priaButton = new JRadioButton("Pria");
        wanitaButton = new JRadioButton("Wanita");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(priaButton);
        genderGroup.add(wanitaButton);
        genderPanel.add(priaButton);
        genderPanel.add(wanitaButton);

        gbc.gridx = 1;
        panel.add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Menyetujui Syarat dan Ketentuan:"), gbc);

        syaratCheck = new JCheckBox();
        gbc.gridx = 1;
        panel.add(syaratCheck, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Jenis Akun:"), gbc);

        String[] jenisAkun = {"Tabungan", "Giro", "Deposito"};
        jenisAkunCombo = new JComboBox<>(jenisAkun);
        gbc.gridx = 1;
        panel.add(jenisAkunCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Layanan Tambahan:"), gbc);

        String[] layanan = {"Mobile Banking", "Internet Banking", "Kartu Kredit"};
        layananList = new JList<>(layanan);
        gbc.gridx = 1;
        panel.add(new JScrollPane(layananList), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Usia:"), gbc);

        usiaSlider = new JSlider(18, 65, 25);
        usiaSlider.setMajorTickSpacing(5);
        usiaSlider.setPaintTicks(true);
        usiaSlider.setPaintLabels(true);
        gbc.gridx = 1;
        panel.add(usiaSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Penghasilan Bulanan:"), gbc);

        penghasilanSpinner = new JSpinner(new SpinnerNumberModel(5000000, 1000000, 100000000, 500000));
        gbc.gridx = 1;
        panel.add(penghasilanSpinner, gbc);

        JButton saveButton = new JButton("Simpan");
        saveButton.addActionListener(new SaveButtonListener());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        add(panel);
        setVisible(true);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(NasabahForm.this,
                    "Apakah Anda yakin ingin mengirim data?", "Konfirmasi",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                String nama = namaField.getText();
                String alamat = alamatArea.getText();
                String jenisKelamin = priaButton.isSelected() ? "Pria" : "Wanita";
                boolean setujuSyarat = syaratCheck.isSelected();
                String jenisAkun = (String) jenisAkunCombo.getSelectedItem();
                String layananTambahan = layananList.getSelectedValuesList().toString();
                int usia = usiaSlider.getValue();
                int penghasilan = (int) penghasilanSpinner.getValue();

                if (setujuSyarat) {
                    DataTable.addRow(new String[]{
                            nama, alamat, jenisKelamin, "Ya",
                            jenisAkun, layananTambahan, String.valueOf(usia), String.valueOf(penghasilan)
                    });
                    JOptionPane.showMessageDialog(NasabahForm.this, "Data berhasil disimpan!",
                            "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(NasabahForm.this, "Harap setujui syarat dan ketentuan.",
                            "Gagal", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}

