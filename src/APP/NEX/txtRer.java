package APP.NEX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @author Ticysis.Aimbo
 *
 * @Description This is another Project For Java
 * @JDK JDK11.0
 *
 *
 **/
public class txtRer extends JFrame {
    private int count=10;
    public txtRer(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException| InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            e. getStackTrace();
        }
        this.setSize(366,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                txtRer.this.setVisible(false);
            }
        });
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);

        JLabel jLabel = new JLabel();
        jLabel.setFont(new Font("dialog",20,15));

        JButton jButton = new JButton("Click");
        jButton.setMnemonic('M');
       // jButton.setBounds(20,20,400,350);
        jPanel.add(jButton);
        jPanel.add(jLabel);
        jButton.addActionListener(e -> {
            jLabel.setText("已经点击了:"+count+"次");
            count+=1;
        });
        this.setVisible(true);
    }
    public static void main(String[] args) {
        //new txtRer();
        new MyJFrame(new txtRer());

    }
}
