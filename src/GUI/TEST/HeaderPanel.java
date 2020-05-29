package GUI.TEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int height = 50;
    private Color bgColor;
    private boolean isShow;
    private String title;
    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        BufferedImage panelImage = createPanelImage();
        g2d.drawImage(panelImage, null, 0, 0);
    }

    private BufferedImage createPanelImage() {
        BufferedImage panelImage = new BufferedImage(getWidth(), height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = panelImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int width = getWidth();
        g2d.setPaint(bgColor);
        g2d.fillRect(0, 0, width, height);
        GradientPaint gradientPaint = new GradientPaint(0, height/2, Color.LIGHT_GRAY, 0, height, Color.DARK_GRAY);
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, height/2, width, height/2);
        java.net.URL imageURL = null;
        if(this.isShow)
        {
            imageURL = this.getClass().getResource("arrow-up-icon.png");
        }
        else
        {
            imageURL = this.getClass().getResource("arrow-down-icon.png");
        }
        java.net.URL titleIconURL = this.getClass().getResource("user.png"); //gallery_5.png
        g2d.setFont(new Font("Serif", Font.BOLD, 24));
        g2d.setPaint(Color.WHITE);
        g2d.drawString(this.title, width/2-40, height-5);
        try {
            g2d.fillArc(width - 42, this.height/2, this.height/2, this.height/2, 0, 360);
            g2d.drawImage(ImageIO.read(imageURL), null, width - 42, this.height/2+2);
            g2d.drawImage(ImageIO.read(titleIconURL), null, 20, 5);
        } catch (IOException e) {
            System.err.println("An error occured when loading the image icon...");
        }

        return panelImage;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.getWidth(), height);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(this.getWidth(), height);
    }

    public HeaderPanel(Color bgColor) {
        this.bgColor = bgColor;
        this.isShow = true;

    }

    public HeaderPanel(Color bgColor, String title) {
        this(bgColor);
        this.title = title;
    }

    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("UI Demo - Gloomyfish");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(new HeaderPanel(Color.BLACK), BorderLayout.CENTER);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}