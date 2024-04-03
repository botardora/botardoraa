import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Salami extends PizzaIngredient{
    private int price = 2;
    private String ingredientName = "szalami";
    private BufferedImage img;

    public Salami(Pizza pizza) {
        super(pizza);
        try {
            this.img = ImageIO.read(new File("img/salami.png"));
        }
        catch (IOException e)
        {
            System.out.println("hiba");
        }
    }

    @Override
    public void bake(Graphics g) {
        super.bake(g);
        g.drawImage(img,0,0,null);
    }

    public int getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", " + ingredientName;
    }
}


