package GUI.classs;
import javax.swing.*;
import java.awt.*;


public class changeimg {
    public static void main(String[] args){
        JFrame jFrame = new JFrame("Just Case");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,300);
        jFrame.setLocationRelativeTo(null);
       // jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JButton jButton1  =new JButton("上一张");
        JButton jButton2  =new JButton("下一张");

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jFrame.add(new MyGraphics());
       // jPanel.add(new MyGraphics());
        jFrame.setVisible(true);

    }
}

class MyGraphics extends JPanel{
    //Image image;

    public void paint(Graphics g) {
        Toolkit tool = this.getToolkit();
        Image image = tool.getImage("C:/Users/23923/Pictures/1.jpg");
        g.drawImage(image,150,70,200,100,this);




//        this.setTitle("Just Title");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(400,200);
//        this.setLocationRelativeTo(null);
//        JPanel panel = new JPanel();
//        this.add(panel);
//        JButton jButton1 = new JButton("上一张");
//        jButton1.setBounds(100,150,40,20);
//        JButton jButton2 = new JButton("下一张");
//        jButton2.setBounds(300,150,40,20);
//        panel.add(jButton1);
//        panel.add(jButton2);
//
//        JPanel jPanel2 = new JPanel();
//        panel.add(jPanel2,BorderLayout.CENTER);
//        Image image = Toolkit.getDefaultToolkit().getImage("C:/Users/23923/Pictures/1.jpg");
//        paint(g,image);
//
//
//        this.setVisible(true);
//    }


//    public void paint(Graphics g,Image image){
//            g.drawImage(image,100,70,200,100,this);
//
//         }
    }
   }

