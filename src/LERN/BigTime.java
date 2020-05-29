package LERN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemTray;

import static javax.swing.UIManager.*;

/**
 *
 **/
public class BigTime extends JFrame {
    private static Thread DX;
    private SystemTray systemTray;
    private TrayIcon trayIcon;

    public BigTime() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setTitle("大时钟");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel jp = new JPanel();
        this.getContentPane().add(jp);
        JLabel jt = new JLabel();
        jt.setOpaque(true);
        jt.setBackground(Color.WHITE);
        jt.setForeground(Color.BLACK);//       jt.setLocation(0,200);
        jt.setSize(1200, 400);
        jt.setFont(new Font("dialog", 1, 300));
        jt.setHorizontalAlignment(JLabel.CENTER);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                BigTime.this.setVisible(false);
            }
        });

        try {
            if (SystemTray.isSupported()) {
                PopupMenu pop = new PopupMenu();
                MenuItem op = new MenuItem("Open");
                MenuItem po = new MenuItem("Exit");

                pop.add(op);
                pop.add(po);
                op.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BigTime.this.setVisible(true);
                    }
                });
                po.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                ClassLoader classLoader1 = this.getClass().getClassLoader();
                URL url1 = classLoader1.getResource("Resource/easyicon/1120534.png");
                ImageIcon icon = new ImageIcon(url1);

                trayIcon = new TrayIcon(icon.getImage(), "我是渣渣大时间V2.1", pop);
                trayIcon.setImageAutoSize(true);
                systemTray = SystemTray.getSystemTray();
                systemTray.add(trayIcon);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }

        JLabel ju = new JLabel();
        ju.setOpaque(true);
        ju.setBackground(Color.WHITE);
        ju.setForeground(Color.BLACK);//       jt.setLocation(0,200);
        ju.setSize(1200, 400);
        ju.setFont(new Font("dialog", 1, 300));
        ju.setHorizontalAlignment(JLabel.CENTER);
        DX = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);
                        SimpleDateFormat sp = new SimpleDateFormat("HH:mm:ss");
                        String mt = sp.format(new Date());
                        jt.setText(mt);
                        ju.setText(mt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        DX.start();
        jp.add(jt);
        jp.add(ju);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BigTime();

    }
}
