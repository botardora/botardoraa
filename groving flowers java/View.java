import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JPanel {
    private Controller controller;
    private Color hatterSzin = Color.GRAY; //a hatter szine, csunya de ez van

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(hatterSzin);
        List<Virag> viragok = controller.getViragok();
        for (int i = 0; i < viragok.size(); i++) {
            int x = 50 * (i + 1);
            int y = 300 - viragok.get(i).getAktualisMeret();
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 10, viragok.get(i).getAktualisMeret());
            List<Color> szirmok = viragok.get(i).getSzirmok();
            for (int j = 1; j < szirmok.size(); j++) {
                g.setColor(szirmok.get(j));
                g.fillOval(x - 5, y - j * 7, 20, 10);
            }
        }
    }
}


