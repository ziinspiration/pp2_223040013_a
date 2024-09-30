package Sesi2.Latihan2;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloInput extends JFrame {
    public HelloInput() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Nama: ");
        labelInput.setBounds(130, 40, 100, 10);

        JTextField textField = new JTextField();
        textField.setBounds(130, 60, 100, 30);

        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);

        JLabel labelOutput = new JLabel("");
        labelOutput.setBounds(130, 150, 100, 10);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                labelOutput.setText("Hello " + nama);
            }
        });

        this.add(labelInput);
        this.add(textField);
        this.add(button);
        this.add(labelOutput);

        this.setSize(400, 300);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloInput h = new HelloInput();
                h.setVisible(true);
            }
        });
    }
}