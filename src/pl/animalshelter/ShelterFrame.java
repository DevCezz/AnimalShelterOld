package pl.animalshelter;

import javax.swing.*;
import java.awt.*;

public class ShelterFrame extends JFrame {
    private AboutDialog aboutDialog;
    private AddDialog addAnimalDialog;
    private JDialog deleteAnimalDialog;
    private JMenuBar menuBar;
    private AnimalShelter animalShelter;
    private AnimalList animalList;

    public ShelterFrame() {                      //tworzy główną ramkę
        menuBar = new JMenuBar();
        menuConfig(menuBar);

        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;        //pobiera szerokość i długość ekrranu
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;

        setJMenuBar(menuBar);                               //ustawia menu

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        AnimalList animalList = new AnimalList();
        JScrollPane scrollPane = new JScrollPane(animalList);
        add(scrollPane, new GBC(0,0,1,2));

        addAddButton();
        addDeleteButton();

        pack();
        setBounds((widthScreen - getWidth()) / 2, (heightScreen - getHeight()) / 2, getWidth(), getHeight());   //ustawia ramkę na środku ekranu
        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAddButton() {
        JButton addButton = new JButton("Dodaj zwierzaka");
        add(addButton, new GBC(1,0).setInsets(10));
        addButton.addActionListener(e-> {
            if(animalShelter == null && animalList == null)
            {
                animalShelter = new AnimalShelter();
                animalList = new AnimalList();
            }
            animalList.addAnimal(new Animal("a", "b", 1,null));
            animalShelter.addNewAnimal(new Animal("a", "b", 1,null));
        });
    }

    public void addDeleteButton() {
        JButton deleteButton = new JButton("Oddano zwierzaka");
        add(deleteButton, new GBC(1,1).setInsets(10));
        deleteButton.addActionListener(e-> {
                    if (deleteAnimalDialog == null) deleteAnimalDialog = new JDialog(this, "ODDANO!");
                    deleteAnimalDialog.setVisible(true);
                });
    }

    public void menuConfig(JMenuBar menuBar) {          //wygląd menu
        JMenu main = new JMenu("Plik");

        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(e -> {
            if (aboutDialog == null) aboutDialog = new AboutDialog(this);
            else aboutDialog.setVisible(true);
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> System.exit(0));

        main.add(aboutItem);
        main.addSeparator();
        main.add(exitItem);
        menuBar.add(main);
    }

    public static void main(String[] args) {
        new ShelterFrame();
    }       //test
}
