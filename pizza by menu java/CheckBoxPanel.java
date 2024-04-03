import javax.swing.*;
import java.awt.*;

public class CheckBoxPanel extends JPanel {
    private JCheckBox cornCheckBox, mushroomCheckBox, salamiCheckBox, tomatoCheckBox, oliveCheckBox;

    public CheckBoxPanel(JCheckBox cornCheckBox, JCheckBox mushroomCheckBox, JCheckBox salamiCheckBox, JCheckBox tomatoCheckBox, JCheckBox oliveCheckBox) {
        this.cornCheckBox = cornCheckBox;
        this.mushroomCheckBox = mushroomCheckBox;
        this.salamiCheckBox = salamiCheckBox;
        this.tomatoCheckBox = tomatoCheckBox;
        this.oliveCheckBox = oliveCheckBox;
        this.setLayout(new GridLayout(5,1));
        this.add(cornCheckBox);
        this.add(mushroomCheckBox);
        this.add(salamiCheckBox);
        this.add(tomatoCheckBox);
        this.add(oliveCheckBox);
    }
}
