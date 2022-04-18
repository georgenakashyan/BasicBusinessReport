package com.georgenakashyan.lab1.homework3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author George Nakashyan
 */
public class PrimaryController {

    @FXML
    private TextField WorkerCountTextField;
    
    @FXML
    private ListView listViewWorkers;
    
    private ObservableList<String> obsListWorkers;
    
    private ArrayList<WorkerWithInsurance> workersWithInsArr;
    
    private Gson gson;
    
    /**
     * Runs on startup.
     * Binds the ObservableList workers to ListView listViewWorkers.
     */
    @FXML
    public void initialize() {
        obsListWorkers = listViewWorkers.getItems();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
    }
    
    /**
     * Opens a file chooser menu to import a JSON file of worker info.
     * @throws FileNotFoundException 
     */
    @FXML
    private void handleMenuItemOpen() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Worker File");
        //Setting starting directory for fileChooser object
        File current = null;
        try {
            current = new File(new File(".").getCanonicalPath()); // Current working directory
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
        //GUI for choosing a JSON file to import.
        fileChooser.setInitialDirectory(current);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(null);
        //Loading the worker names and total worker count onto the observable list and textfield.
        if (selectedFile != null) {
            FileReader fr = new FileReader(selectedFile);
            obsListWorkers.clear();
            workersWithInsArr = gson.fromJson(fr, new TypeToken<ArrayList<WorkerWithInsurance>>(){}.getType());
            for (Worker w : workersWithInsArr) {
                obsListWorkers.add(w.getName());
            }
            WorkerCountTextField.setText(Integer.toString(workersWithInsArr.size()));
        }
    }
    
    /**
     * Opens a file chooser save menu to save the worker array to a text file.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @FXML
    private void handleMenuItemSave() throws FileNotFoundException, IOException {
        //GUI for Saving the .txt file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Worker File");
        File current = new File(new File(".").getCanonicalPath()); // Current working directory
        fileChooser.setInitialDirectory(current);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(null);
        //Formatting and printing the worker array into the file.
        if (selectedFile != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(selectedFile);
                writer.printf("%s\t%18s%10s%10s%10s%10s%10s%10s\n", "Name", "Hours", "Rate", "Ins", "Pay", "Month", "Day", "Year");
                    writer.printf("%s\t%18s%10s%10s%10s%10s%10s%10s\n", "----", "-----", "----", "---", "---", "-----", "---", "----");
                    double h, r, c, total = 0;
                    MyDate d;
                    for (WorkerWithInsurance arrW : workersWithInsArr) {
                        h = arrW.getHours();
                        r = arrW.getRate();
                        c = arrW.getHealthInsCost();
                        d = arrW.getHireDate();
                        total += h;
                        double pay = h * r - c;
                        writer.printf("%-15s\t%10.2f%10.2f%10.2f%10.2f%10d%10d%10d\n", arrW.getName(), h, r, c, pay, d.getMonth(), d.getDay(), d.getYear());
                    }
                    writer.printf("\n%-13s%.2f", "Total Hours:", total);
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Closes the program.
     */
    @FXML
    private void handleMenuItemClose() {
        Platform.exit();
    }
}