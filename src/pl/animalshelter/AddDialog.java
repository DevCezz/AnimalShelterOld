package pl.animalshelter;

import javax.swing.*;
import java.awt.*;

public class AddDialog extends JDialog {
    private JTextField typeName;
    private JTextField typeKind;
    private JTextField typeAge;

    public AddDialog(JFrame owner) {
        super(owner, "Nowy podopieczny", true);
        setLayout(new GridBagLayout());

        JLabel name = new JLabel("Imię: ");
        add(name, new GBC(0, 0).setInsets(10));

        typeName = new JTextField(12);
        add(typeName, new GBC(1, 0).setInsets(5));

        JLabel kind = new JLabel("Rodzaj: ");
        add(kind, new GBC(0, 1).setInsets(10));

        typeKind = new JTextField(12);
        add(typeKind, new GBC(1, 1).setInsets(5));

        JLabel age = new JLabel("Wiek: ");
        add(age, new GBC(0, 2).setInsets(10));

        typeAge = new JTextField(12);
        add(typeAge, new GBC(1, 2).setInsets(5));

        JButton buttonOk = new JButton("Super!");
        buttonOk.addActionListener(e ->setVisible(false));
        add(buttonOk, new GBC(0, 3, 2, 1).setInsets(5));

        pack();
        setLocation(owner.getLocation().x + (owner.getWidth() - getWidth()) / 2, owner.getLocation().y +
                (owner.getHeight() - getHeight()) / 2);

        setResizable(false);
    }

    public JTextField getTypeKind() {
        return typeKind;
    }

    public JTextField getTypeAge() {
        return typeAge;
    }

    public JTextField getTypeName() {
        return typeName;
    }
}
