package com.ista.codingChallenge.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class CSVReader {

    public  List<List<String>> readCSVFile(String filePath) {
        List<List<String>> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            reader.readLine();  // Skip first line
            while ((line = reader.readLine()) != null) {
                List<String> lineElements = new ArrayList<>();
                String[] singleEntry = line.split(";");
                Collections.addAll(lineElements, singleEntry);
                lines.add(lineElements);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
