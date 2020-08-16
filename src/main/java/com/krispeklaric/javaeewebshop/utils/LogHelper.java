/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.utils;

import com.krispeklaric.javaeewebshop.dtos.LogDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kris
 */
public class LogHelper {

    private static final String LOG_FILE_NAME = "webapps/logs.txt";

    private static void writeLog(String message) throws IOException {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_NAME, true)) {
            fileWriter.append(message);
            fileWriter.flush();
        }
    }

    private static List<LogDTO> readLogs() throws IOException {
        List<LogDTO> logs = new ArrayList<LogDTO>();
        BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_NAME));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                LogDTO log = new LogDTO();
                log.parseLog(line);
                logs.add(log);
            }
        } finally {
            br.close();
        }

        return logs;
    }
}
