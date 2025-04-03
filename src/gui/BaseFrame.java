package src.gui;

import javax.swing.*;

import java.awt.BorderLayout;

public class BaseFrame extends JFrame{

    public BaseFrame(int width, int height, String title, ImageIcon logo)
    {   
        System.out.println("Library app");
        this.setTitle(title);
        this.setSize(width,height);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
