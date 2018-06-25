package com.ipro.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * We have to provide our own glass pane so that it can paint.
 */
public class MyGlassPane extends JComponent
        implements ItemListener {
    Point point;

    //React to change button clicks.
    public void itemStateChanged(ItemEvent e) {
        setVisible(e.getStateChange() == ItemEvent.SELECTED);
    }

    protected void paintComponent(Graphics g) {
        if (point != null) {
            g.setColor(Color.red);
            g.fillOval(point.x - 10, point.y - 10, 20, 20);
        }
    }

    public void setPoint(Point p) {
        point = p;
    }

    public MyGlassPane(AbstractButton aButton,
                       JMenuBar menuBar,
                       Container contentPane) {
        CBListener listener = new CBListener(aButton, menuBar,
                this, contentPane);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
}