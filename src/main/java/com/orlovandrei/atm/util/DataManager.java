package com.orlovandrei.atm.util;

import com.orlovandrei.atm.annotation.Utility;
import com.orlovandrei.atm.exception.DataReadException;
import com.orlovandrei.atm.exception.DataWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.orlovandrei.atm.util.Messages.ERROR_READING_CARD_DATA;
import static com.orlovandrei.atm.util.Messages.ERROR_WRITING_CARD_DATA;

@Utility
public class DataManager {
    private static DataManager instance;
    private static final String FILE_PATH = "src/main/resources/card_data.txt";

    private DataManager() {}

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<String[]> readDataFromFile() {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                dataList.add(data);
            }
        } catch (IOException e) {
            throw new DataReadException(ERROR_READING_CARD_DATA, e);
        }
        return dataList;
    }

    public void writeDataToFile(List<String[]> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String[] data : dataList) {
                writer.write(String.join(" ", data));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DataWriteException(ERROR_WRITING_CARD_DATA, e);
        }
    }
}


