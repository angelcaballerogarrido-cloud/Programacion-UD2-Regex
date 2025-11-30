package com.raven.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class Scrollbar extends JScrollBar {

    public Scrollbar() {
        setUI(new UIScrollBar());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242, 242));
        setUnitIncrement(20);
    }
}
