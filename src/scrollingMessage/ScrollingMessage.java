package scrollingMessage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jah Peepee
 */
public class ScrollingMessage extends JPanel implements ActionListener {
    Timer timer;
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
    int y;
    int x;
    Color fgColor;
    Color bgColor;
    char direction;
    
    public ScrollingMessage() {
        y = 0;
        x = WIDTH / 2;
        timer = new Timer(25, this);
        timer.start();
        fgColor = Color.white;
        bgColor = Color.red;
        direction = 'D';
        setPreferredSize(new Dimension(500, 500));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        setColors();
        setBackground(bgColor);
        g.setColor(fgColor);
        Font font = new Font(Frame.font, Font.BOLD, 25);
        FontMetrics metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString(Frame.text, x - metrics.stringWidth(Frame.text)/2, y);
    }
    
    public void setColors() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW, Color.BLACK, Color.WHITE, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.ORANGE, Color.PINK};
        fgColor = colors[Frame.fgIndex];
        bgColor = colors[Frame.bgIndex];
    }
    
    public void moveText() {
        switch(direction) {
            case 'U': 
                y -= Frame.speed;
                if (y <= 0) y = HEIGHT;
                break;
            case 'D': 
                y += Frame.speed;
                if (y > HEIGHT) y = 0;
                break;
            case 'L': 
                x -= Frame.speed;
                if (x <= 0) x = WIDTH;
                break;
            case 'R':
                x += Frame.speed;
                if (x > WIDTH) x = 0;
                break;
        }
        
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) moveText();
    }
    
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = 'R';
                    break;
                case KeyEvent.VK_DOWN:
                    direction = 'D';
                    break;
                case KeyEvent.VK_UP:
                    direction = 'U';
                    break;
            }
        }
    }
    
    
    
}
