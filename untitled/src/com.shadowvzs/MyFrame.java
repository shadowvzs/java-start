package com.shadowvzs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("JFrame Sample");
        this.setSize(420, 420);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(1f,0f,0f, 0.2f)); // or Color.CYAN
    }

    public void createFrame() {
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        JLabel label = new JLabel();
        label.setText("Some text");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0xff44ff));
        label.setBackground(new Color(0x114411));
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBorder(border);
        label.setBounds(50, 0, 250, 50);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250, 250);

        JFrame frame = new JFrame(); // create a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("JFrame Sample");
        frame.setSize(420, 420);
        frame.setVisible(true);
        frame.setLayout(null);

        // ImageIcon image = new ImageIcon("logo.png");
        // frame.setIconImage(image);

        frame.getContentPane().setBackground(new Color(1f,0f,0f, 0.2f)); // or Color.CYAN
        frame.add(label);
        frame.add(redPanel);

        // if label bound and frame layout not setted then this auto size the frame
        // must be after all component added into frame
        // frame.pack();

        // dialog - popup
        // JOptionPane.showConfirmDialog("dialog text", "dialog popup title");
    }
}
