package GUI.TEST;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class jdialog extends JFrame implements ActionListener
{
    JPanel jp = new JPanel ();
    JButton jb1 = new JButton("只有ok按钮");
    JButton jb2 = new JButton("Yes/No按钮");
    JButton jb3 = new JButton("YES/No/Cancle3个按钮");
    JButton jb4 = new JButton("YSE/No/Cancle3个按钮（自定义）");
    JButton jb5 = new JButton("输入消息对话框");
    JButton jb6 = new JButton("选项对话框");
    JButton []jbuttonArray = new JButton[]{jb1,jb2,jb3,jb4,jb5,jb6};
    JLabel jl = new JLabel("请依次单击按钮，将得到不同的对话框！");
    public jdialog()
    {
        jp.setLayout(new GridLayout(2,3));
        for(int i=0;i<jbuttonArray.length;i++)
        {
            jp.add(jbuttonArray[i]);
            jbuttonArray[i].addActionListener(this);
        }
        this.add(jp);
        this.add(jl,BorderLayout.SOUTH);
        this.setTitle("JOptionPane对话框");
        this.setBounds(200,200,500,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==jbuttonArray[0])
        {
            JOptionPane.showMessageDialog(this, "欢迎光临本店！","只有OK按钮的消息对话框",JOptionPane.INFORMATION_MESSAGE);
            jl.setText("欢迎，欢迎，热烈欢迎");
        }
        else if(a.getSource()==jbuttonArray[1])
        {
            int index = JOptionPane.showConfirmDialog(this,"您好，您是第一次光临本店吗？","有YES/ON按钮的确认对话框",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            jl.setText("您是"+((index==0)?"新顾客，欢迎":"老顾客了，欢迎。"));
        }
        else if(a.getSource()==jbuttonArray[2])
        {
            Object[] options = {"喜欢","不喜欢"};
            int index = JOptionPane.showOptionDialog(this,"您好，您喜欢吃酸菜鱼吗？","有Yes/No按钮（自定义）的确认对话框",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            jl.setText("我记下了，您"+((index==0)?"喜欢":"不喜欢")+"吃酸菜鱼");
        }
        else if(a.getSource()==jbuttonArray[3])
        {
            Object[] options = {"好啊，给我也来一份","不了，我们菜够多了","给我来份香辣虾"};
            int index = JOptionPane.showOptionDialog(this, "你好，尝尝本店招牌菜酸菜鱼吗？","有Yes/No/CANCEL_OPTION的确认对话框", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options, options[2]);
            String reply = (index == 0)?"稍等，您点的酸菜鱼很快就到了":(index==1)?"好的，有需要再喊我":(index==2)? "好的，你点的香辣虾很快就到了":"对不起，请你点菜！";
            jl.setText(reply);
        }
        else if(a.getSource()==jbuttonArray[4])
        {
            String dishes = JOptionPane.showInputDialog(this,"请输入您最想吃的菜：","输入信息对话框",JOptionPane.PLAIN_MESSAGE);
            jl.setText(dishes);
        }
        else if(a.getSource()==jbuttonArray[5])
        {
            String[] options = new String [] {"香辣虾","酸菜鱼","公安牛肉鱼杂","瓦罐汤"};
            int index = JOptionPane.showOptionDialog(this,"下面是本店免费赠送的菜，请您选一个，默认是瓦罐汤","选项对话框",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[3]);
            String dishes = (index==0)?"香辣虾":(index==1)?"酸菜鱼":(index==2)?"公安牛肉鱼杂":"瓦罐汤";
            jl.setText("您选择了本店赠送的"+dishes+"!");
        }
    }
    public static void main(String args[])
    {
        new jdialog();
    }
}