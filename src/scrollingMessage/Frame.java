/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scrollingMessage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jah Peepee
 */
public class Frame {
    public static int speed = 5;
    public static String text = "Default Text";
    public static String font = "Comic Sans MS";
    public static int fgIndex = 7;
    public static int bgIndex = 0;
    
    public static void main(String[] args) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JPanel content = new ScrollingMessage();
        JPanel menu = new Menu();
        main.add(content);
        main.add(menu);
        JFrame frame = new JFrame();
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Scrolling Message");
        frame.pack();
        frame.setVisible(true);
    }
    
}
