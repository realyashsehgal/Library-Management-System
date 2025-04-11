package src.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class BaseBufferedImage extends BufferedImage{

    public BaseBufferedImage(String imgPath)
    {
        super(1, 1, BufferedImage.TYPE_INT_ARGB);

        ImageIcon icon = new ImageIcon(imgPath);
        Image image = icon.getImage();
        
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        
        Graphics2D g2d = this.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
    }
    
}
