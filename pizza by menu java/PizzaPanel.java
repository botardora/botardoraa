import javax.swing.*;
import java.awt.*;

public class PizzaPanel extends JPanel {
    private Pizza pizza;

    public PizzaPanel(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (pizza != null) {
            pizza.bake(g);
        }
    }
}
