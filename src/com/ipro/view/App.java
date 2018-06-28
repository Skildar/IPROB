package com.ipro.view;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class App extends JFrame {
    private JFrame _owner;
    private JTextArea textArea1;
    private JButton button1;

    public App(JFrame owner) {
        _owner = owner;
        _owner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        textArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("ouah tu sais cliquer!");
            }
        });
        pack();
    }

    public void show() {
        constructDialog();
        textArea1.setVisible(true);
    }

    private void constructDialog()
    {
        // constructs the dialog and sets all instance variables
    }

    public static void createAndShowGUI() {
        // Check for a graph name
        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Show the window.
        frame.pack();
        frame.setVisible(true);
    }
}
