package GUI.TEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContentPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ContentPanel(Color theme)
    {
        this.setBorder(BorderFactory.createLineBorder(theme, 5));
    }

    public void createContent()
    {
        JPanel userPanel = new JPanel(new GridLayout(2,2));
        userPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        userPanel.add(new JLabel("”√ªß√˚£∫"));
        JTextField txtField = new JTextField("", 10);
        userPanel.add(txtField);
        userPanel.add(new JLabel("√‹¬Î£∫"));
        JTextField pwdField = new JTextField("", 10);
        userPanel.add(pwdField);
        JButton okeBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(okeBtn);
        btnPanel.add(cancelBtn);
        this.setLayout(new BorderLayout());
        this.add(userPanel, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);
    }

}