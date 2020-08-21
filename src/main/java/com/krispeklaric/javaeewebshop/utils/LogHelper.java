/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.utils;

import com.krispeklaric.javaeewebshop.dtos.LogDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kris
 */
public class LogHelper {

    private static final String[] HEADERS_TO_TRY = {
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"};

    private static final String LOG_FILE_NAME = "logs.txt";

    public static void writeLog(String message) throws IOException {
        File file = new File(LOG_FILE_NAME);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(message);
            fileWriter.flush();
        }
    }

    public static List<LogDTO> readLogs() throws IOException {
        List<LogDTO> logs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_NAME));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                LogDTO log = new LogDTO();
                log = log.parseLog(line);
                logs.add(log);
            }
        } finally {
            br.close();
        }

        return logs;
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getRemoteAddr();
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }

        return request.getRemoteAddr();
    }
}
