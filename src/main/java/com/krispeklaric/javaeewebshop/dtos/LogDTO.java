/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.dtos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kris
 */
public class LogDTO {

    private static final String DELMITER = "|";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private LocalDateTime dateTime;
    private String username;
    private String ipAddress;

    public LogDTO() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        String formattedTime = dateFormatter.format(this.dateTime);
        return formattedTime + this.DELMITER + this.username + this.DELMITER + this.ipAddress;
    }

    public LogDTO parseLog(String line) {
        LogDTO logDTO = new LogDTO();
        String[] temp = line.split(this.DELMITER);
        logDTO.dateTime = LocalDateTime.parse(temp[0],dateFormatter);
        logDTO.username = temp[1];
        logDTO.ipAddress = temp[2];

        return logDTO;
    }
}
