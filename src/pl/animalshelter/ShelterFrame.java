package pl.animalshelter;

import javax.swing.*;
import java.awt.*;

public class ShelterFrame extends JFrame {
    private AboutDialog aboutDialog;
    private AddDialog addAnimalDialog;
    private DeleteDialog deleteAnimalDialog;
    private JMenuBar menuBar;
    private AnimalList animalList;
    private DrawInfomation drawInfomation;
    private JButton deleteButton;

    public ShelterFrame() {                      //tworzy główną ramkę
        menuBar = new JMenuBar();
        menuConfig(menuBar);

        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;        //pobiera szerokość i długość ekrranu
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;

        setJMenuBar(menuBar);                               //ustawia menu
        setLayout(new GridBagLayout());

        drawInfomation = new DrawInfomation();
        drawInfomation.setPreferredSize(new Dimension(200,350));
        add(drawInfomation, new GBC(1,0,1,8));

        addAddButton();
        addDeleteButton();

        animalList = new AnimalList(drawInfomation);
        animalList.setPreferredSize(new Dimension(200,450));
        JScrollPane scrollPane = new JScrollPane(animalList);
        scrollPane.setPreferredSize(new Dimension(250,460));
        add(scrollPane, new GBC(0,0,1,10).setWeight(10,10));

        pack();
        setBounds((widthScreen - getWidth()) / 2, (heightScreen - getHeight()) / 2, getWidth(), getHeight());   //ustawia ramkę na środku ekranu
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAddButton() {
        JButton addButton = new JButton("Dodaj zwierzaka");
        addButton.setPreferredSize(new Dimension(150,30));
        add(addButton, new GBC(1,8,1,1).setInsets(10));
        addButton.addActionListener(e-> {
            if (addAnimalDialog == null) addAnimalDialog = new AddDialog(this);
            addAnimalDialog.getTypeAge().setText("");
            addAnimalDialog.getTypeKind().setText("");
            addAnimalDialog.getTypeName().setText("");
            addAnimalDialog.setVisible(true);

            String name = addAnimalDialog.getTypeName().getText();
            String kind = addAnimalDialog.getTypeKind().getText();
            int age = Integer.parseInt(addAnimalDialog.getTypeAge().getText());
            if(name != "" && kind != "" && age != 0)
                animalList.addAnimal(new Animal(name, kind, age,null));
        });
    }

    public void addDeleteButton() {
        deleteButton = new JButton("Oddano zwierzaka");
        deleteButton.setPreferredSize(new Dimension(150,30));
        add(deleteButton, new GBC(1,9,1,1).setInsets(10));
        deleteButton.addActionListener(e-> {
            if (deleteAnimalDialog == null) deleteAnimalDialog = new DeleteDialog(this);
                deleteAnimalDialog.setVisible(true);
                ((DefaultListModel)animalList.getModel()).removeElement(drawInfomation.getAnimal());
                drawInfomation.updateInformation(null);
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
