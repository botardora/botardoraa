import javax.swing.*;

public class KertFrame extends JFrame {
    private Controller controller;

    public KertFrame(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setTitle("Viragos kert");

        View view = new View(controller);
        add(view);
        setVisible(true);

        novekedesSzalInditas();
    }

    private void novekedesSzalInditas() {
        Thread szal = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500); // varakozas fel mp-t
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                controller.novekedes();
                repaint(); // ujrarajzolas a novekedes utan
            }
        });
        szal.start();
    }

}
