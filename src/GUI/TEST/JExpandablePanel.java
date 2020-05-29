package GUI.TEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JExpandablePanel extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private HeaderPanel headerPanel;
    private ContentPanel contentPanel;

    public JExpandablePanel()
    {
        super();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        Color theme = Color.BLACK;
        headerPanel = new HeaderPanel(theme, "欢迎登录");
        headerPanel.addMouseListener(new PanelAction());
        contentPanel = new ContentPanel(theme);
        contentPanel.createContent();
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
        setOpaque(false);
    }

    class PanelAction extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            HeaderPanel hp = (HeaderPanel)e.getSource();
            if(contentPanel.isShowing())
            {
                contentPanel.setVisible(false);
                hp.setShow(false);
            }
            else
            {
                contentPanel.setVisible(true);
                hp.setShow(true);
            }
            hp.getParent().validate();
            hp.getParent().repaint();
        }
    }


    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("UI Demo - Gloomyfish");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel[] panels = new JPanel[4]; //
        gbc.insets = new Insets(1,3,0,3);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        for(int j = 0; j < panels.length; j++)
        {
            panels[j] = new JExpandablePanel();
            myPanel.add(panels[j], gbc);
        }
        mainFrame.getContentPane().add(myPanel, BorderLayout.NORTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

}