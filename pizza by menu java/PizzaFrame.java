import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PizzaFrame extends JFrame {
    private PizzaPanel panel;
    private CheckBoxPanel checkBoxPanel;
    private JLabel price, ingredients;
    private JCheckBox cornCheckBox, mushroomCheckBox, salamiCheckBox, tomatoCheckBox, oliveCheckBox;

    public PizzaFrame() {
        setTitle("Pizzazo");
        setBounds(200, 200, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pizza pizza = new PizzaBase();
        panel = new PizzaPanel(pizza);
        add(panel);
        cornCheckBox = new JCheckBox("Kukorica");
        mushroomCheckBox = new JCheckBox("Gomba");
        salamiCheckBox = new JCheckBox("Szalámi");
        tomatoCheckBox = new JCheckBox("Paradicsom");
        oliveCheckBox = new JCheckBox("Olajbogyó");

        cornCheckBox.addActionListener(e -> createPizzaFromIngredients());
        mushroomCheckBox.addActionListener(e -> createPizzaFromIngredients());
        salamiCheckBox.addActionListener(e -> createPizzaFromIngredients());
        tomatoCheckBox.addActionListener(e -> createPizzaFromIngredients());
        oliveCheckBox.addActionListener(e -> createPizzaFromIngredients());

        checkBoxPanel = new CheckBoxPanel(cornCheckBox, mushroomCheckBox, salamiCheckBox, tomatoCheckBox, oliveCheckBox);
        panel = new PizzaPanel(new PizzaBase());
        JPanel textboxPanel = new JPanel();
        textboxPanel.setLayout(new GridLayout());
        price = new JLabel();
        ingredients = new JLabel();

        textboxPanel.add(price);
        textboxPanel.add(ingredients);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(textboxPanel, BorderLayout.NORTH);
        add(checkBoxPanel, BorderLayout.WEST);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");
        JMenuItem saveMenuItem = new JMenuItem("Mentes");
        JMenuItem loadMenuItem = new JMenuItem("Betoltes");

        saveMenuItem.addActionListener(l -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(selectedFile)) {
                    writer.println(panel.getPizza().getIngredients());
                    writer.println(panel.getPizza().getPrice());
                } catch (IOException e) {
                    System.out.println("Hiba tortent a mentesnel!");
                }
            }
        });
        loadMenuItem.addActionListener(l -> {
            cornCheckBox.setSelected(false);
            mushroomCheckBox.setSelected(false);
            oliveCheckBox.setSelected(false);
            salamiCheckBox.setSelected(false);
            tomatoCheckBox.setSelected(false);
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                try {
                    BufferedReader ready = new BufferedReader(new FileReader(selectedFile));

                    if (ready.ready()) {
                        String ingrbuild = ready.readLine();
                        String[] ing = ingrbuild.split(", ");
                        for (String ingredient : ing) {
                            switch (ingredient.trim()) {
                                case "kukorica":
                                    cornCheckBox.setSelected(true);
                                    break;
                                case "gomba":
                                    mushroomCheckBox.setSelected(true);
                                    break;
                                case "szalami":
                                    salamiCheckBox.setSelected(true);
                                    break;
                                case "paradicsom":
                                    tomatoCheckBox.setSelected(true);
                                    break;
                                case "oliva":
                                    oliveCheckBox.setSelected(true);
                                    break;

                                default:
                                    break;
                            }
                        }
                        createPizzaFromIngredients();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Hiba tortent a betoltesnel!");
                }
            }
        });

        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        setVisible(true);

    }
    public Pizza createPizzaFromIngredients() {

        Pizza pizza = new PizzaBase(); //csak a teszta

        if (salamiCheckBox.isSelected()) {
            pizza = new Salami(pizza);
        }
        if (tomatoCheckBox.isSelected()) {
            pizza = new Tomato(pizza);
        }
        if (oliveCheckBox.isSelected()) {
            pizza = new Olive(pizza);
        }
        if (mushroomCheckBox.isSelected()) {
            pizza = new Mushroom(pizza);
        }
        if (cornCheckBox.isSelected()) {
            pizza = new Corn(pizza);
        }
        this.panel.setPizza(pizza);
        panel.repaint();
        price.setText(Integer.toString(panel.getPizza().getPrice()));
        ingredients.setText(panel.getPizza().getIngredients());
        return pizza;

    }
    public static void main(String[] args) {
        new PizzaFrame();
    }
}
