package APP.NEX;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * ÊµÏÖ´°Ìå¿¿ÏÔÊ¾Æ÷±ßÒþ²ØµÄÀà
 * ´°ÌåÔÚÆÁÄ»±ßÔµÒþ²Ø
 * @author formssi
 *
 */
public class MyJFrame implements ActionListener
{
    private Rectangle rect;
    private int left;
    private int right;
    private int screenXX;
    private int top;
    private int width;
    private int height;
    private Point point;
    private Timer timer = new Timer(10,this);
    private int xx,yy;
    private boolean isDraging = false;

    //	private JFrame jFrame = new JFrame();
    private JFrame jFrame;

    public MyJFrame(JFrame jFrame)
    {
        super();
        this.jFrame = jFrame;
        timer.start();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setAlwaysOnTop(false);
        jFrame.setVisible(true);
        moveFrame();
    }

    private void moveFrame()
    {
        jFrame.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                isDraging = true;
                xx = e.getX();
                yy = e.getY();

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isDraging = false;
            }
        });

        jFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(isDraging)
                {
                    int left = jFrame.getLocation().x;
                    int top = jFrame.getLocation().y;
                    jFrame.setLocation(left + e.getX() - xx, top + e.getY() - yy);
                    jFrame.repaint();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        left = jFrame.getLocationOnScreen().x;
        top = jFrame.getLocationOnScreen().y;
        width = jFrame.getWidth();
        height = jFrame.getHeight();
        screenXX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        right = screenXX - left - width;

        rect = new Rectangle(0,0,width,height);

        point = jFrame.getMousePosition();

        if(left < 0 && isPtlnRect(rect,point))
        {
            jFrame.setLocation(0, top);
        }
        else if(left > -5 && left < 5 && !(isPtlnRect(rect,point)))
        {
            jFrame.setLocation(left - width + 1, top);
        }
        else if(top < 0 && left < 0 && isPtlnRect(rect,point))
        {
            jFrame.setLocation(0, 0);
        }
        else if((top > -5 && top < 5) && (left >-5 && left < 5)
                && !(isPtlnRect(rect,point)))
        {
            jFrame.setLocation(left - width + 1, 1);
        }
        else if((top < 0) && isPtlnRect(rect,point))
        {
            jFrame.setLocation(left, 0);
        }
        else if(top > -5 && top < 5 && !(isPtlnRect(rect,point)))
        {
            jFrame.setLocation(left, 1 - height);
        }
        else if(right < 0 && isPtlnRect(rect,point))
        {
            jFrame.setLocation(screenXX - width + 1, top);
        }
        else if(right > -5 && right < 5 && !(isPtlnRect(rect,point)))
        {
            jFrame.setLocation(screenXX - 1, top);
        }
        else if(right < 0 && top < 0 && isPtlnRect(rect,point))
        {
            jFrame.setLocation(screenXX - width + 1, 0);
        }
        else if((right > -5 && right < 5) && (top > -5 && top < 5)
                && !(isPtlnRect(rect,point)))
        {
            jFrame.setLocation(screenXX - 1, 1);
        }
    }

    private boolean isPtlnRect(Rectangle rect2, Point point2)
    {
        if(rect != null )
        {
            int x0 = rect.x;
            int y0 = rect.y;
            int x1 = rect.width;
            int y1 = rect.height;
            int x = 1024;
            int y = 768;

            if(point2 != null)
            {
                x = point2.x;
                y = point2.y;
            }

            return x >= x0 && x < x1 && y >= y0 && y < y1;
        }
        return false;
    }

}
