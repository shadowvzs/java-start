package com.shadowvzs;

import javax.swing.*;
import javax.swing.border.Border;
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
        this.setSize(300,400);
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.createInterface();
        this.setVisible(true);
    }

    public void createInterface() {

        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(276, 50));
        header.setBorder(new EmptyBorder(5,5,5,5));
        header.setLayout(new FlowLayout());

        JTextField input = new JTextField();
        input = new JTextField();
        input.setBorder(new EmptyBorder(5,15,5,15));
        input.setFocusable(false);
        input.setFont(new Font("Arial", Font.PLAIN,20));
        input.setText("0");
        input.setPreferredSize(new Dimension(224, 40));
        header.add(input);
        this.textField = input;

        JButton resetBtn = this.createBtn("C", new Color(0xF0F0F0));
        resetBtn.setPreferredSize(new Dimension(50, 40));
        header.add(resetBtn);
        this.add(header, BorderLayout.NORTH);

        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(276, 300));
        GridLayout grid = new GridLayout(4, 4);
        grid.setHgap(2);
        grid.setVgap(2);
        main.setLayout(grid);
        main.setBorder(new EmptyBorder(10,10,10,10));
        final int MAX_ROW = this.buttons.length;
        final int MAX_COL = this.buttons[0].length;
        String[] currentRow;
        String key;

        for (byte row = 0; row < MAX_ROW; row++) {
            currentRow = this.buttons[row];
            for (byte col = 0; col < MAX_COL; col++) {
                key = currentRow[col];
                main.add(this.createBtn(key, new Color(col == (MAX_COL - 1) ? 0xD0D0D0 : 0xF0F0F0)));
            }
        }

        this.add(main, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.buttonMap.containsKey(e.getSource()) == false) {
            return;
        }
        String key = this.buttonMap.get(e.getSource());
        this.actionDispatcher(key);
    }

    private void actionDispatcher(String key) {
        try {
            Double num = Double.parseDouble(key);
        } catch (NumberFormatException er) {
            if (key == ".") {
                if (this.currentValue.length() == 0) {
                    this.currentValue = "0";
                }
            } else {
                if (key == "C") {
                    this.prevValue = 0;
                    this.currentValue = "";
                    this.operator = null;
                    this.textField.setText("0");
                } else if (key == "=") {
                    if (this.operator == null || this.currentValue == "") { return; }
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
                        this.textField.setText(format.format(newV));
                    }
                } else {
                    if (this.currentValue.length() > 0) {
                        if (this.operator != null) {
                            this.actionDispatcher("=");
                        } else {
                            this.prevValue = Double.parseDouble(this.currentValue);
                            this.currentValue = "";
                        }
                    }
                    this.operator = key;
                }
                return;
            }
        }
        this.currentValue += key;
        this.textField.setText(this.currentValue);
    }

    public JButton createBtn(String txt, Color col) {
        JButton button = new JButton();
        button.setFocusable(false);
        button.setText(txt);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        this.buttonMap.put(button, txt);
        button.setBackground(col);
        button.addActionListener(this);
        return button;
    }
}
