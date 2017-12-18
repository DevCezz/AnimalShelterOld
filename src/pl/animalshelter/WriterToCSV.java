package pl.animalshelter;

import com.csvreader.CsvWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WriterToCSV {
    public WriterToCSV(ArrayList<Animal> animals) {
        String output = "animals.csv";
        try {
            CsvWriter csvWriter = new CsvWriter(new FileWriter(output, true), ',');

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            csvWriter.write(formatter.format(localDateTime));
            csvWriter.endRecord();
            csvWriter.write("ID, Imie, Rodzaj, Wiek");
            csvWriter.endRecord();
            for (Animal a : animals) {
                csvWriter.write("" + a.getId_animal());
                csvWriter.write(a.getName());
                csvWriter.write(a.getKindOfAnimal());
                csvWriter.write("" + a.getAge());
                csvWriter.endRecord();
            }

            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


