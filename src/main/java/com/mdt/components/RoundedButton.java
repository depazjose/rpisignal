package com.mdt.components;

import java.awt.*;

public class RoundedButton extends javax.swing.JButton {


    public RoundedButton(Dimension size) {
        setPreferredSize(size);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        paintComponent((java.awt.Graphics2D) g.create());
    }

    protected void paintComponent(java.awt.Graphics2D g) {
        if (getModel().isArmed()) {
            g.setColor(java.awt.Color.darkGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
                java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paintComponent(g);

        repaint();
        revalidate();
        g.dispose();
    }

    transient java.awt.Shape shape;

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new java.awt.geom.Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }


}
