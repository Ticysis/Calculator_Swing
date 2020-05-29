package LERN.CLAS;

/**
 *
 **/
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thinker
 */
public class buJu {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setSize(800 ,600);
        jf.setLocationRelativeTo(null);
        JPanel mainjp1 = new JPanel();
        JPanel mainjp2 = new JPanel();
        JPanel subjp1 = new JPanel();
        JPanel subjp2 = new JPanel();
        JPanel subjp3 = new JPanel();
        JLabel lb1 = new JLabel("第一个页面");
        JLabel lb2 = new JLabel("第二个页面");
        JLabel lb3 = new JLabel("第三个页面");
        JButton btn1 = new JButton("上一页");
        JButton btn2 = new JButton("下一页");

        jf.setLayout(new GridLayout(2, 1));
        mainjp1.setLayout(new CardLayout());
        mainjp2.setLayout(new FlowLayout());
        subjp1.setBackground(Color.orange);
        subjp2.setBackground(Color.pink);
        subjp3.setBackground(Color.lightGray);

        subjp1.add(lb1, "1");
        subjp2.add(lb2, "2");
        subjp3.add(lb3, "3");
        mainjp1.add(subjp1);
        mainjp1.add(subjp2);
        mainjp1.add(subjp3);
        mainjp2.add(btn1);
        mainjp2.add(btn2);
        jf.add(mainjp1);
        jf.add(mainjp2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)mainjp1.getLayout()).previous(mainjp1);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)mainjp1.getLayout()).next(mainjp1);
            }
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
