package GUI.classs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class twoPoint {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClaFrame();
            }
        });
    }
}
class ClaFrame extends JFrame{
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public ClaFrame(){
        this.setSize(1900,1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("快加上路费");
        JPanel panel = new JPanel(new FlowLayout());
        this.add(panel);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                System.out.println();

            }
        });


        this.setVisible(true);
    }
}
