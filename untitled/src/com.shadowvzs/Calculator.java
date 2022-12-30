package com.shadowvzs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Calculator extends JFrame implements ActionListener {
    private String[][] buttons = {
        {
            "7", "8", "9", "/"
        },
        {
            "4", "5", "6", "*"
        },
        {
            "1", "2", "3", "-"
        },
        {
            "0", ".", "=", "+"
        }
    };

    private HashMap<JButton, String> buttonMap = new HashMap<JButton, String>();
    private String currentValue = "";
    private String operator = null;
    private double prevValue = 0;
    private JTextField textField;

    Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createInterface();
        this.setSize(300,400);
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void createInterface() {
        this.textField = new JTextField();
        this.textField.setBounds(10, 10, 276, 40);
        this.textField.setBorder(new EmptyBorder(5,5,5,5));
        this.textField.setFocusable(false);
        this.textField.setFont(new Font("Arial", Font.PLAIN,20));
        this.textField.setText("0");
        this.add(textField);

        final int MAX_ROW = this.buttons.length;
        final int MAX_COL = this.buttons[0].length;
        String[] currentRow;
        JButton button;
        String key;

        for (byte row = 0; row < MAX_ROW; row++) {
            currentRow = this.buttons[row];
            for (byte col = 0; col < MAX_COL; col++) {
                key = currentRow[col];
                button = new JButton();
                button.setFocusable(false);
                button.setText(key);
                this.buttonMap.put(button, key);
                button.setBounds(col * 68 + 10, row * 68 + 70, 68, 68);
                button.setBackground(new Color(col == (MAX_COL - 1) ? 0xD0D0D0 : 0xF0F0F0));
                button.addActionListener(this);
                this.add(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.buttonMap.containsKey(e.getSource()) == false) {
            return;
        }
        String key = this.buttonMap.get(e.getSource());
        try {
            Double num = Double.parseDouble(key);
        } catch (NumberFormatException er) {
            if (key == ".") {
                if (this.currentValue.length() == 0) {
                    this.currentValue = "0";
                }
            } else {
                if (key == "=") {
                    System.out.println("prev value: "+this.prevValue);
                    System.out.println("cur value: "+this.currentValue);
                    System.out.println("operator: "+this.operator);
                    if (this.operator == null) { return; }
                    Double currentV = Double.parseDouble(this.currentValue);
                    Double newV = null;
                    if (this.operator == "+") {
                        newV = this.prevValue + currentV;
                    } else if (this.operator == "-") {
                        newV = this.prevValue - currentV;
                    } else if (this.operator == "/") {
                        newV = this.prevValue / currentV;
                    } else if (this.operator == "*") {
                        newV = this.prevValue * currentV;
                    }
                    if (newV != null) {
                        this.prevValue = newV;
                        this.currentValue = "";
                        this.operator = null;
                        DecimalFormat format = new DecimalFormat();
                        format.setMinimumFractionDigits(0);
                        System.out.println(newV.toString());
                        this.textField.setText(format.format(newV));
                    }
                } else {
                    if (this.currentValue.length() > 0) {
                        this.prevValue = Double.parseDouble(this.currentValue);
                        this.currentValue = "";
                    }
                    this.operator = key;
                }
                return;
            }
        }
        this.currentValue += key;
        this.textField.setText(this.currentValue);
    }
}
