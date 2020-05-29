package HXL.NEX;

/**
 *
 **/
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.event.WindowListener ;
import java.awt.event.MouseMotionAdapter ;
//import java.awt.event.MouseMotionListener ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
//import java.awt.event.KeyEvent ;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter ;
import java.awt.event.KeyAdapter ;
import java.awt.event.KeyListener ;
//import java.awt.event.MouseListener ;
import javax.swing.*;

public class MyMouse extends JFrame
{
    //JTextArea text = new JTextArea() ;
    public MyMouse()
    {
        super.setTitle("MouseSprit") ;
        super.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseMoved(MouseEvent e)
            {
                System.out.println("x-is>>>:"+e.getX()+"  y-is>>>:"+e.getY()) ;
            }
        }) ;
        super.addWindowListener(new WindowAdapter()
        {
            public void WindowClosing(WindowEvent e)
            {
                System.exit(1) ;
            }
        }) ;

        super.setSize(800,600) ;
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true) ;
    }


} ;

class Tester
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyMouse mhk = new MyMouse() ;
            }
        });

    }
} ;











