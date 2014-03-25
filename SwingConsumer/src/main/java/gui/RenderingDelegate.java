package gui;


import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RenderingDelegate {

    private final Dimension screenSize = getDefaultToolkit().getScreenSize();

    public RenderingDelegate(JFrame frame) {
        setup(frame);
    }

    private void setup(JFrame frame) {
        if(!frame.isShowing())
            initializeFrame(frame);
    }

    private void initializeFrame(JFrame frame) {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new CommandsBoard().init());
        centerInScreen(frame);
        prepareSize(frame);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void centerInScreen(JFrame frame) {
        int locationX = (screenSize.width / 2 - frame.getSize().width / 2)
                - (screenSize.width / 2 - frame.getSize().width / 2)/2;
        int locationY = (screenSize.height / 2 - frame.getSize().height / 2)
                - (screenSize.height / 2 - frame.getSize().height / 2)/2;
        frame.setLocation(locationX,locationY);
    }

    private void prepareSize(JFrame frame) {
        int witdh = (int) (screenSize.width * 0.08);
        int height =(int) (screenSize.height * 0.06);
        frame.setPreferredSize(new Dimension(witdh,height));
    }
}
