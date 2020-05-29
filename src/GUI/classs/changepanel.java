package GUI.classs;

import javax.swing.*;
import java.awt.*;

public class changepanel extends JFrame {
    public changepanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        JPanel jPanel = new JPanel(new FlowLayout());
        this.add(jPanel);
        JButton jButton1 = new JButton("white");
        jButton1.setBackground(new Color(0,0,0));
        jButton1.addActionListener(e -> { jPanel.setBackground(new Color(255,255,255));});
        jPanel.add(jButton1);
        JButton jButton2 = new JButton("black");
        jButton2.setBackground(new Color(255,255,255));
        jButton2.addActionListener(e -> {jPanel.setBackground(new Color(0,0,0)); });
        jPanel.add(jButton2);
        this.setVisible(true);
    }
}

class start {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> new changepanel());
    }
}