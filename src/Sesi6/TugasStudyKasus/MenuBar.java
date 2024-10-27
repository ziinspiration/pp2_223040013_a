package Sesi6.TugasStudyKasus;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(JFrame frame) {
        JMenu menu = new JMenu("Menu");

        JMenuItem nasabahForm = new JMenuItem("Pendaftaran Nasabah");
        nasabahForm.addActionListener(e -> new NasabahForm(frame));
        menu.add(nasabahForm);

        JMenuItem dataNasabah = new JMenuItem("Data Nasabah");
        dataNasabah.addActionListener(e -> new DataTable());
        menu.add(dataNasabah);

        this.add(menu);
    }
}

