package scrollingMessage;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import javax.swing.*;

/**
 *
 * @author Jah Peepee
 */
public class ScrollingMessage extends JPanel implements ActionListener {
    Timer timer;
    int y;
    Color fgColor;
    Color bgColor;
    
    public ScrollingMessage() {
        y = 0;
        timer = new Timer(25, this);
        timer.start();
        fgColor = Color.white;
        bgColor = Color.red;
        setPreferredSize(new Dimension(500, 500));
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        setColors();
        setBackground(bgColor);
        g.setColor(fgColor);
        Font font = new Font(Frame.font, Font.BOLD, 25);
        FontMetrics metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString(Frame.text, (500 - metrics.stringWidth(Frame.text))/2, y);
    }
    
    public void setColors() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW, Color.BLACK, Color.WHITE, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.ORANGE, Color.PINK};
        fgColor = colors[Frame.fgIndex];
        bgColor = colors[Frame.bgIndex];
    }
    
    public void moveText() {
        y += Frame.speed;
        if (y > getSize().getHeight()) y = 0;
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) moveText();
    }
    
}
