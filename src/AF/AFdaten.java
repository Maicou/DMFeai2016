/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AF;

import dmfeai2016.Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Mancuso
 */
public class AFdaten {

    public AFdaten() {

        try {
            String csvFile = "./src/AF/Messung.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] messung = line.split(cvsSplitBy);
                int numOfWords = messung.length;
                for (int i = 0; i < numOfWords; i++) {
                    System.out.println(messung[i]);
                }
                System.out.println("\n");

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AFdaten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AFdaten.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
