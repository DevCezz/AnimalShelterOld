package pl.animalshelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShelterFrame extends JFrame {
    private AboutDialog aboutDialog;
    private AddDialog addAnimalDialog;
    private DeleteDialog deleteAnimalDialog;
    private NoAnimalDialog noAnimalDialog;
    private NoChosenDialog noChosenDialog;
    private JMenuBar menuBar;
    private AnimalList animalList;
    private DrawInfomation drawInfomation;
    private JButton deleteButton;
    private DataBase dataBase;

    public ShelterFrame() {                      //tworzy główną ramkę
        dataBase = new DataBase();
        dataBase.connection();

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

        animalList = new AnimalList(drawInfomation, dataBase.getDatabase());
        animalList.setPreferredSize(new Dimension(200,450));
        JScrollPane scrollPane = new JScrollPane(animalList);
        scrollPane.setPreferredSize(new Dimension(250,460));
        add(scrollPane, new GBC(0,0,1,10).setWeight(10,10));

        pack();
        setBounds((widthScreen - getWidth()) / 2, (heightScreen - getHeight()) / 2, getWidth(), getHeight());   //ustawia ramkę na środku ekranu
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dataBase.disconnect();
            }
        });
    }

    public void addAddButton() {
        JButton addButton = new JButton("Dodaj zwierzaka");
        addButton.setPreferredSize(new Dimension(150,30));
        add(addButton, new GBC(1,8,1,1).setInsets(10));
        addButton.addActionListener(e -> {
            if (addAnimalDialog == null) addAnimalDialog = new AddDialog(this);
            addAnimalDialog.getTypeAge().setText("");
            addAnimalDialog.getTypeName().setText("");
            addAnimalDialog.setVisible(true);

            String name = addAnimalDialog.getTypeName().getText();
            String kind = addAnimalDialog.getOptionKindKind();
            int age = Integer.parseInt(addAnimalDialog.getTypeAge().getText());
            if(name != "" && kind != "" && age != 0) {
                Animal animal = new Animal(name, kind, age,null);
                animalList.addAnimal(animal);
                dataBase.add(animal);
            }
        });
    }

    public void addDeleteButton() {
        deleteButton = new JButton("Oddać do adopcji");
        deleteButton.setPreferredSize(new Dimension(150,30));
        add(deleteButton, new GBC(1,9,1,1).setInsets(10));
        deleteButton.addActionListener(e-> {
            if(animalList.getModel().getSize() == 0) {
                if (noAnimalDialog == null) noAnimalDialog = new NoAnimalDialog(this);
                noAnimalDialog.setVisible(true);
            }
            else {
                if (drawInfomation.getAnimal() == null) {
                    if (noChosenDialog == null) noChosenDialog = new NoChosenDialog(this);
                    noChosenDialog.setVisible(true);
                }
                else {
                    if (deleteAnimalDialog == null) deleteAnimalDialog = new DeleteDialog(this);
                    deleteAnimalDialog.setVisible(true);
                    dataBase.delete(drawInfomation.getAnimal());
                    int i = drawInfomation.getAnimal().getId_animal();
                    for(int j = i; j < animalList.getModel().getSize(); j++) {
                        animalList.getModel().getElementAt(j).setId_animal(j);
                        dataBase.updateID(j);
                    }
                    Animal.setNext_id(animalList.getModel().getSize());

                }
                ((DefaultListModel)animalList.getModel()).removeElement(drawInfomation.getAnimal());
                drawInfomation.updateInformation(null);
                drawInfomation.setAnimal(null);
            }});
    }

    public void menuConfig(JMenuBar menuBar) {          //wygląd menu
        JMenu main = new JMenu("Plik");

        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(e -> {
            if (aboutDialog == null) aboutDialog = new AboutDialog(this);
            else aboutDialog.setVisible(true);
        });

        JMenuItem toCSV = new JMenuItem("Import do CSV");
        toCSV.addActionListener(e -> {
            new WriterToCSV(animalList.getActualAnimals());
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> {
            dataBase.disconnect();
            System.exit(0);
        });

        main.add(aboutItem);
        main.add(toCSV);
        main.addSeparator();
        main.add(exitItem);
        menuBar.add(main);
    }

    public static void main(String[] args) {
        new ShelterFrame();
    }       //test
}
