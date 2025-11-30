package com.raven.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UIScrollBar extends BasicScrollBarUI {

    private static final int THUMB_SIZE = 8;
    private static final int ALPHA_NORMAL = 50;
    private static final int ALPHA_ROLLOVER = 100;
    private static final Color THUMB_COLOR = Color.BLACK;

    public UIScrollBar() {
        
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createInvisibleButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createInvisibleButton();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
      
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int alpha = isThumbRollover() ? ALPHA_ROLLOVER : ALPHA_NORMAL;
        int orientation = scrollbar.getOrientation();
        int x = thumbBounds.x;
        int y = thumbBounds.y;

      
        int width = (orientation == JScrollBar.VERTICAL) ? THUMB_SIZE : thumbBounds.width;
        int height = (orientation == JScrollBar.VERTICAL) ? thumbBounds.height : THUMB_SIZE;

        
        width = Math.max(width, THUMB_SIZE);
        height = Math.max(height, THUMB_SIZE);

        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
        graphics2D.fillRect(x, y, width, height);
        graphics2D.dispose();
    }

    
    private JButton createInvisibleButton() {
        JButton btn = new JButton();
        btn.setOpaque(false);
        btn.setFocusable(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        return btn;
    }
}
