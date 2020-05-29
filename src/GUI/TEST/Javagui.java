package GUI.TEST;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Javagui {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new menubar();
            }            
        });
    }
}

class menubar extends JFrame{

    public menubar(){       
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        this.setTitle("MenuBar");    //常规设置
        this.setSize(1024,512);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int n = JOptionPane.showConfirmDialog(menubar.this,"你要退出吗？","询问",JOptionPane.YES_NO_OPTION);
                if (n==JOptionPane.YES_OPTION){
                    System.out.println("执行了退出指令");
                    System.exit(0);
                }
            }
        });

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        this.getContentPane().add(jPanel);
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(500,150));
        jPanel2.setPreferredSize(new Dimension(500,150));
        jPanel1.setBorder(BorderFactory.createTitledBorder("TICYSIS"));
        jPanel2.setBorder(BorderFactory.createTitledBorder("My Next"));
        jPanel.add(jPanel1);
        jPanel.add(jPanel2);

        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setPreferredSize(new Dimension(500,150));
        JPanel jPanelleft = new JPanel();
        JPanel jPanelright = new JPanel();
        jSplitPane.setLeftComponent(jPanelleft);
        jSplitPane.setRightComponent(jPanelright);
        jPanel.add(jSplitPane);

        JButton jButton = new JButton("双击测试");
        jPanel1.add(jButton);
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int times = e.getClickCount();
                if(times==2){
                    System.out.println("鼠标双击了");
                }

            }
        });

        JLabel checkLabel = new JLabel();
        jPanel2.add(checkLabel);
        Thread checkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        System.out.println("checkThread出错了");
                    }
                    ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                    int noThreads = threadGroup.activeCount();
                    Thread[] lstThreads = new Thread[noThreads];
                    threadGroup.enumerate(lstThreads);
                    for (int i = 0; i < noThreads; i++) {
                        System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
                    }
                    checkLabel.setText("当前运行线程数>>"+noThreads+"<<");
                }
            }
        }); checkThread.start();






        JMenuBar jmb = new JMenuBar();
        this.setJMenuBar(jmb);
        JMenu jm1 = new JMenu("文件");
        jmb.add(jm1);
        JMenu jm2 = new JMenu("打开");
        jmb.add(jm2);
        JMenu jm3 = new JMenu("视图");
        jmb.add(jm3);
        JMenu jm5 = new JMenu("设置");
        jmb.add(jm5);
        JMenu jm4 = new JMenu("关于");
        jmb.add(jm4);
        
        JMenuItem jmi11 = new JMenuItem("开始");
        jm1.add(jmi11);
        JMenuItem jmi12 = new JMenuItem("保存");
        jm1.add(jmi12);
        JMenuItem jmi13 = new JMenuItem("组件");
        jm1.add(jmi13);
        JMenuItem jmi14 = new JMenuItem("退出");
        jm1.add(jmi14);
        jmi14.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }          
        });
        JMenuItem jmi21 = new JMenuItem("打开新文件");
        jm2.add(jmi21);    
        jmi21.addActionListener(new openAction());

        JMenuItem jmi52 = new JMenuItem("开启始终置顶");
        jm5.add(jmi52);
        jmi52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menubar.this.setAlwaysOnTop(true);
            }
        });
        JMenuItem jmi51 = new JMenuItem("关闭始终置顶");
        jm5.add(jmi51);
        jmi51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menubar.this.setAlwaysOnTop(false);
            }
        });
        JMenuItem jmi53 = new JMenuItem("更改风格");
        jm5.add(jmi53);



        JMenuItem jmi41 = new JMenuItem("关于");
        jm4.add(jmi41);
        jmi41.addActionListener(new ActionListener() {   //按钮事件
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"···这是测试用窗口\n来自：Ticysis","关于",JOptionPane.CLOSED_OPTION);
            }
        });
        
        this.setVisible(true);
    }
}

 class openAction implements ActionListener{    //按钮事件，选择文件
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if(file.isDirectory()){
                System.out.println("文件夹:"+file.getAbsolutePath());
            }else if(file.isFile()){
                System.out.println("文件:"+file.getAbsolutePath());
            }
            System.out.println(jfc.getSelectedFile().getName());       
    }
}



