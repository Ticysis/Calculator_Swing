package APP.LTS;

import java.awt.*; //导入包awt
import java.awt.event.*;
import java.net.URL;
import java.awt.SystemTray;//导入包
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import APP.NEX.MyJFrame;

/**
 * @author Ticysis
 * @Version v1.0//v2.0.1
 * @By ???
 * @From CSDN
 * @Descript This is the calculator changed by Ticysis
 * @since JDK 11.0
 * #########
 * @Version 1.0  ->>  仿照网上笔记编写并且做了适当改动
 * @Version 2.1  ->>  加入了新的布局和时间显示(Thread),加入了托盘图标
 * @Version 3.1  ->>  创建了多个线程，添加了新的布局，添加了菜单栏
 * @Version 4.2  ->>  新动作-贴合隐藏。合并部分线程
 * #########
 */

public class CaluaV2 extends JFrame { //类Calua继承了JFrame类（窗口类）
    private static final long serialVersionUID = 1L; //？？？喵喵喵？？？//适用于Java的序列化机制

    private double version = 4.1;

    private StringBuilder sBuilder = new StringBuilder(); //存放计算式子
    private Double a; //存储中间变量-第一个数
    private Double b; //存储中间变量-第二个数
    private Double result; //存储结果
    private Integer ip; //表示加减乘除
    private SystemTray systemTray; //托盘
    private TrayIcon trayIcon; //托盘图标
    private static Thread t;  //传说中的多线程
    private int markIcon = 0;

    public CaluaV2() { //构造方法
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { //设置UI风格
            e.printStackTrace();
        }
        this.setTitle("一个或许是辣鸡计算器");//设置标题
        this.setSize(310, 650);//设置大小
        this.setLocationRelativeTo(null);//设置默认位置-居中
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置关闭方式(原来是Exit.ON.CLOSE)
                this.setResizable(false); //不能拖动窗体大小
                ClassLoader classLoader2 = this.getClass().getClassLoader();
                URL url2 = classLoader2.getResource("Resource/easyicon/1226431.png");
                Image image = Toolkit.getDefaultToolkit().getImage(url2); //Can`t use ImageIcon Because awt=/=swing
                this.setIconImage(image);
                this.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        CaluaV2.this.setVisible(false);
                    }
                });


                try {
                    if (SystemTray.isSupported()) {
                        PopupMenu pop = new PopupMenu();
                        MenuItem mai = new MenuItem("Open Main Windows");
                        MenuItem exitalready = new MenuItem("Exit Without Asking");
                MenuItem exit = new MenuItem("Exit The Programme");
                pop.add(mai);
                pop.add(exitalready);
                pop.add(exit);
                mai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CaluaV2.this.setVisible(true);
                    }
                });
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int exNum = JOptionPane.showConfirmDialog(null, "\u771f\u7684\u8981\u9000\u51fa\u5417\u003f", "Exit Question", JOptionPane.YES_NO_OPTION);
                        if (exNum == JOptionPane.YES_OPTION) {   //真的要退出吗?
                            System.exit(0);
                        }
                    }
                });
                exitalready.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("运行了直接退出程序");
                        System.exit(0);
                    }
                });


                ClassLoader classLoader1 = this.getClass().getClassLoader();  //ClassLoader加载图标
                URL url1 = classLoader1.getResource("Resource/easyicon/1120534.png");
                ImageIcon imageIcon1 = new ImageIcon(url1);

                trayIcon = new TrayIcon(imageIcon1.getImage(), "我是渣渣计算器V2.0", pop); //系统托盘图标
                trayIcon.setImageAutoSize(true);
                systemTray = SystemTray.getSystemTray();  //系统托盘
                trayIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(2==e.getClickCount()){
                            CaluaV2.this.setVisible(true);
                        }
                    }
                });
                systemTray.add(trayIcon);

            }

        } catch (AWTException e) {
            System.out.println("AwtException发生了");
        }

        JMenuBar jMenuBar = new JMenuBar();  //==============================菜==========单=========栏=============================
        this.setJMenuBar(jMenuBar);
        JMenu jMenuFile = new JMenu("文件(F)");
        JMenu jMenuEdit = new JMenu("窗口(W)");
        JMenu jMenuSet  = new JMenu("设置(S)");
        JMenu jMenuAbout= new JMenu("关于(A)");
        jMenuBar.add(jMenuFile);
        JMenuItem jMenuItemExit = new JMenuItem("直接退出");
        jMenuItemExit.addActionListener(e -> System.exit(0));
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuEdit);

        jMenuBar.add(jMenuSet);
        ClassLoader classLoader3 = this.getClass().getClassLoader();
        URL url3 = classLoader3.getResource("Resource/select.png");
        ImageIcon imageIcon3 = new ImageIcon(url3);
        JMenuItem jMenuItemOpenTop = new JMenuItem("开启始终置顶");
        jMenuItemOpenTop.addActionListener(e -> {
            System.out.println("点击了始终置顶");
            this.setAlwaysOnTop(true);
            markIcon=1;
        });
        JMenuItem jMenuItemClosTop = new JMenuItem("关闭始终置顶");
        jMenuItemClosTop.addActionListener(e -> {
            System.out.println("点击了取消始终置顶");
            this.setAlwaysOnTop(false);
            markIcon=0;
        });


        jMenuSet.add(jMenuItemOpenTop);
        jMenuSet.add(jMenuItemClosTop);
        jMenuBar.add(jMenuAbout);


        JPanel panel = new JPanel();//new一个面板=======================================面==板==标==签==设==置==================================
        JPanel pane2 = new JPanel();//new第二个面板
        JPanel paneLabel = new JPanel(); //添加用作显示处的面板
        JPanel paneNum = new JPanel(); //显示数字键的面板
        paneNum.setLayout(new GridLayout(6,3));

        this.getContentPane().add(panel);//添加面板到窗口
        this.add(paneLabel,BorderLayout.NORTH);
        this.add(paneNum,BorderLayout.CENTER);
        this.add(pane2,BorderLayout.SOUTH);
        panel.setLayout(null);//设置布局管理器-null

        JLabel checkLabel = new JLabel(); //创建监控用标签

        JLabel label1 = new JLabel();//new一个标签
        label1.setBounds(0, 0, 300, 50);//设置label的范围
        label1.setFont(new Font("dialog", 1, 30));//设置字体
        label1.setOpaque(true);//设置不透明为true
        label1.setBackground(Color.WHITE);//设置背景为白色
        paneLabel.setPreferredSize(new Dimension(300,70));
        paneLabel.setBorder(BorderFactory.createTitledBorder("当前版本："+version));
        paneLabel.add(label1);//向面板添加label

        Thread maMOThread = new Thread(new Runnable() {  //======================================监控与守护=====================================
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("当前markIcon状态>>>"+markIcon);
                        Thread.sleep(450);
                        if(markIcon==1){
                            jMenuItemOpenTop.setIcon(imageIcon3);
                            jMenuItemClosTop.setIcon(null);
                        }
                        if(markIcon==0){
                            jMenuItemClosTop.setIcon(imageIcon3);
                            jMenuItemOpenTop.setIcon(null);
                        }

                    }catch (Exception e){
                        System.out.println("图标切换出错了");
                    }

                    try {
                        while (true) {
                            Thread.sleep(500);
                            System.out.println("label1.length>>>>>" + label1.getText().length());
                            if (label1.getText().length() >= 15) {
                                JOptionPane.showMessageDialog(null, "超出了15个字符的限制", "警告", JOptionPane.WARNING_MESSAGE);
                                label1.setText("");
                            }
                        }
                    }catch (Exception e){
                        System.out.println("字符监视线程出错了");
                        System.out.println("下面是原因>>>>>>>");
                        e.printStackTrace();
                        System.out.println("<<<<<<<输出完成！");
                    }
                }
            }
        });
        maMOThread.setName("监控与守护程序");
        maMOThread.start();


        JLabel label2 = new JLabel();
        Font labelFont = new Font("楷体",1,15);
        label2.setPreferredSize(new Dimension(300,55));
       // label2.setBounds(0, 400, 300, 50);
        label2.setFont(labelFont);
        label2.setOpaque(true);
       // label2.setBackground(Color.WHITE);
        label2.setForeground(Color.BLACK);


        JButton b1 = new JButton("1");//创建一个按钮，显示文本为1
        JButton b2 = new JButton("2");//创建一个按钮，显示文本为2
        JButton b3 = new JButton("3");//创建一个按钮，显示文本为3
        JButton b4 = new JButton("4");//创建一个按钮，显示文本为4
        JButton b5 = new JButton("5");//创建一个按钮，显示文本为5
        JButton b6 = new JButton("6");//创建一个按钮，显示文本为6
        JButton b7 = new JButton("7");//创建一个按钮，显示文本为7
        JButton b8 = new JButton("8");//创建一个按钮，显示文本为8
        JButton b9 = new JButton("9");//创建一个按钮，显示文本为9
        JButton b0 = new JButton("0");//创建一个按钮，显示文本为0
        JButton ad = new JButton("+");//创建一个按钮，显示文本为+
        JButton mn = new JButton("-");//创建一个按钮，显示文本为-
        JButton xs = new JButton("*");//创建一个按钮，显示文本为*
        JButton cu = new JButton("÷");//创建一个按钮，显示文本为÷
        JButton eq = new JButton("=");//创建一个按钮，显示文本为=
        JButton po = new JButton(".");//创建一个按钮，显示文本为.
        JButton bk = new JButton("←");//创建一个按钮，显示文本为←
        JButton cl = new JButton("C");//创建一个按钮，显示文本为C

        b1.setBounds(0, 50, 100, 60);            //按钮1设置位置大小
        b1.setFont(new Font("dialog", 1, 30));     //设置字体
        paneNum.add(b1);                                              //面板添加b1按钮
        b1.setMnemonic('Q');                                            //为按钮绑定数字键(测试)===========================施工标记=======================================
        b2.setBounds(100, 50, 100, 60);
        b2.setFont(new Font("dialog", 1, 30));
        paneNum.add(b2);
        b3.setBounds(200, 50, 100, 60);
        b3.setFont(new Font("dialog", 1, 30));
        paneNum.add(b3);
        b4.setBounds(0, 110, 100, 60);
        b4.setFont(new Font("dialog", 1, 30));
        paneNum.add(b4);
        b5.setBounds(100, 110, 100, 60);
        b5.setFont(new Font("dialog", 1, 30));
        paneNum.add(b5);
        b6.setBounds(200, 110, 100, 60);
        b6.setFont(new Font("dialog", 1, 30));
        paneNum.add(b6);
        b7.setBounds(0, 170, 100, 60);
        b7.setFont(new Font("dialog", 1, 30));
        paneNum.add(b7);
        b8.setBounds(100, 170, 100, 60);
        b8.setFont(new Font("dialog", 1, 30));
        paneNum.add(b8);
        b9.setBounds(200, 170, 100, 60);
        b9.setFont(new Font("dialog", 1, 30));
        paneNum.add(b9);
        b0.setBounds(100, 230, 100, 60);
        b0.setFont(new Font("dialog", 1, 30));
        paneNum.add(b0);
        ad.setBounds(0, 230, 100, 60);
        ad.setFont(new Font("dialog", 1, 30));
        paneNum.add(ad);
        mn.setBounds(200, 230, 100, 60);
        mn.setFont(new Font("dialog", 1, 30));
        paneNum.add(mn);
        xs.setBounds(0, 290, 100, 60);
        xs.setFont(new Font("dialog", 1, 30));
        paneNum.add(xs);
        cu.setBounds(200, 290, 100, 60);
        cu.setFont(new Font("dialog", 1, 30));
        paneNum.add(cu);
        eq.setBounds(100, 290, 100, 60);
        eq.setFont(new Font("dialog", 1, 30));
        paneNum.add(eq);
        po.setBounds(0, 350, 100, 60);
        po.setFont(new Font("dialog", 1, 30));
        paneNum.add(po);
        bk.setBounds(200, 350, 100, 60);
        bk.setFont(new Font("dialog", 1, 30));
        paneNum.add(bk);
        cl.setBounds(100, 350, 100, 60);
        cl.setFont(new Font("dialog", 1, 30));
        paneNum.add(cl);

        b0.addActionListener(new ActionListener() {            //b0按钮添加事件监听--匿名函数
            @Override
            public void actionPerformed(ActionEvent e) {       //事件处理
                System.out.println("按下按钮0");                //控制台打印
                sBuilder.append("0");                        //sBuilder字符串添加“0”
                label1.setText(sBuilder.toString());         //标签文本设置为sBuilder的String
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮1");
                sBuilder.append("1");
                label1.setText(sBuilder.toString());
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮2");
                sBuilder.append("2");
                label1.setText(sBuilder.toString());
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮3");
                sBuilder.append("3");
                label1.setText(sBuilder.toString());
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮4");
                sBuilder.append("4");
                label1.setText(sBuilder.toString());
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮5");
                sBuilder.append("5");
                label1.setText(sBuilder.toString());
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮6");
                sBuilder.append("6");
                label1.setText(sBuilder.toString());
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮7");
                sBuilder.append("7");
                label1.setText(sBuilder.toString());
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮8");
                sBuilder.append("8");
                label1.setText(sBuilder.toString());
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮9");
                sBuilder.append("9");
                label1.setText(sBuilder.toString());
            }
        });

        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮加号");
                a = Double.parseDouble(sBuilder.toString());
                sBuilder = new StringBuilder();
                label1.setText("+");
                ip = 0;      //将0作为加法的标志
            }
        });
        mn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮减号");
                a = Double.parseDouble(sBuilder.toString());
                sBuilder = new StringBuilder();
                label1.setText("-");
                ip = 1;     //将1作为减法的标志
            }
        });
        xs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮乘号");
                a = Double.parseDouble(sBuilder.toString());
                sBuilder = new StringBuilder();
                label1.setText("*");
                ip = 2;    //将2作为乘法的标志
            }
        });
        cu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮除号");
                a = Double.parseDouble(sBuilder.toString());
                sBuilder = new StringBuilder();
                label1.setText("÷");
                ip = 3;         //将3作为除法的标志
            }
        });
        eq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     //这里是算法
                System.out.println("按下按钮等于号");
                if (!"".equals(sBuilder.toString()) && (!(a == 0))) {   //当sBuilder不是空字符串且不为0时的if
                    b = Double.parseDouble(sBuilder.toString());  //将b作为除数
                    if (ip == 0) {            //ip为0时-加法标志
                        result = a + b;     //结果计算
                        label1.setText(result.toString());//标签设置为结果
                        sBuilder = new StringBuilder();//充值sBuilder
                        sBuilder.append(result);//将结果附加到sBuilder上
                    } else if (ip == 1) {
                        result = a - b;
                        label1.setText(result.toString());
                        sBuilder = new StringBuilder();
                        sBuilder.append(result);
                    } else if (ip == 2) {
                        result = a * b;
                        label1.setText(result.toString());
                        sBuilder = new StringBuilder();
                        sBuilder.append(result);
                    } else if (ip == 3) {
                        result = a / b;
                        label1.setText(result.toString());
                        sBuilder = new StringBuilder();
                        sBuilder.append(result);
                    } else {
                        label1.setText(sBuilder.toString());
                    }
                }
            }
        });
        po.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮小数点");
                sBuilder.append(".");//添加一个-点-号
                label1.setText(sBuilder.toString());
            }
        });
        cl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮清除键");
                sBuilder = new StringBuilder();//充值sBuilder
                label1.setText("");//将标签设置为空字符
            }
        });
        bk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下按钮删除键");
                if (!"".equals(sBuilder.toString())) {//将sBuilder不为空字符串时
                    sBuilder.deleteCharAt(sBuilder.length() - 1);//sBuilder删除最后一位
                    label1.setText(sBuilder.toString());//重置标签
                }
            }
        });

        this.setVisible(true);//设置窗口为可见--所有组件绘制完成后设置窗口可见

        t = new Thread(new Runnable() {   //关于时间显示的多线程
            @Override

            public void run() {
                while (true) {
                    try {

                        Thread.sleep(500);
                        SimpleDateFormat dat = new SimpleDateFormat(" 当前时间:yyyy-MM-dd  " + "HH:mm:ss");
                        String Tome = dat.format(new Date());
                        label2.setText(Tome);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
        });
        t.setName("时间显示线程");
        t.start();  //启动线程

        checkLabel.setPreferredSize(new Dimension(300,15));
        checkLabel.setFont(labelFont);
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
                    checkLabel.setText("  当前运行线程数>>>"+noThreads+"<<<");
                }
            }
        });
        checkThread.setName("线程检测程序");
        checkThread.start();


        pane2.add(checkLabel);
        pane2.add(label2);






    }




    public static void main(String[] args) {   //JAVA的main方法
//        Calua A =new Calua();
//        new Thread(A).start();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyJFrame(new CaluaV2());  //实例化Calua方法
            }
        });


    }


}



//==============================================================================================================

//class asd implements Runnable {  //额外的多线程类
//    @Override
//    public void run() {
//        while (true) {
//            try {
//
//                Thread.sleep(1000);  //休眠1s
//                SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd" + "HH:mm:ss");//格式
//                String Tome = dat.format(new Date());//格式化时间
//                System.out.println(Tome);//打印
//            } catch (InterruptedException e) {  //捕捉异常
//                e.printStackTrace();
//
//            }
//        }
//
//
//    }
//}