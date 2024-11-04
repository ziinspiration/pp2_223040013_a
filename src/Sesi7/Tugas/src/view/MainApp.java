package Sesi7.Tugas.src.view;

import javax.swing.*;
import java.awt.*;

import Sesi6.TugasStudyKasus.MenuBar;
import Sesi7.Tugas.src.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aplikasi Pendaftaran Nasabah Bank");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            frame.setJMenuBar(new MenuBar(frame));

            JPanel welcomePanel = new JPanel();
            welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
            welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel welcomeLabel = new JLabel("Selamat Datang di Aplikasi Pendaftaran Nasabah Bank");
            welcomeLabel.setFont(new Font("Serif", Font.BOLD, 28));
            welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel descriptionLabel = new JLabel("<html><div style='text-align: center;'>"
                    + "Silakan gunakan menu di atas untuk mendaftarkan nasabah baru atau melihat data nasabah yang terdaftar."
                    + "</div></html>");
            descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
            descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            welcomePanel.add(welcomeLabel);
            welcomePanel.add(Box.createRigidArea(new Dimension(0, 10)));
            welcomePanel.add(descriptionLabel);

            frame.add(welcomePanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
