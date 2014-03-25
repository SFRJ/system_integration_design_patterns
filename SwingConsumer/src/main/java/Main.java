import gui.RenderingDelegate;

import javax.swing.*;

public class Main {

    private JFrame outerFrame;

    public Main() {
        outerFrame = new JFrame("SwingConsumer");
        new RenderingDelegate(outerFrame);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
