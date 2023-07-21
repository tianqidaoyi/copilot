package com.example.copilottest.common.utils;

import com.example.copilottest.entity.HolidayInformationEntity;
import liquibase.util.csv.CSVReader;
import liquibase.util.csv.CSVWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static void main(String[] args) {
        CsvUtils.getHolidayEntityList();
    }

    private static final String holidayFilePath = "holiday.csv";

    //util method: to get holiday entity list from CSV file
    public static List<HolidayInformationEntity> getHolidayEntityList() {
        List<HolidayInformationEntity> holidayEntityList = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource(holidayFilePath);
            //read CSV file from resource folder
            CSVReader reader = new CSVReader(new FileReader(resource.getFile()));

            String[] nextLine;
            //read each line
            while ((nextLine = reader.readNext()) != null) {
                HolidayInformationEntity holidayInformationEntity = new HolidayInformationEntity();
                //set No
                holidayInformationEntity.setId(nextLine[0]);
                //set country code
                holidayInformationEntity.setCountryCode(nextLine[1]);
                //set country desc
                holidayInformationEntity.setCountryDesc(nextLine[2]);
                //set holiday date
                holidayInformationEntity.setHolidayDate(nextLine[3]);
                //set holiday name
                holidayInformationEntity.setHolidayName(nextLine[4]);
                //add to list
                holidayEntityList.add(holidayInformationEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidayEntityList;
    }

    public static void writeHolidayEntityList(List<HolidayInformationEntity> holidayEntityList) {
        Resource resource = new ClassPathResource(holidayFilePath);
        //read CSV file from resource folder
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(resource.getFile()));

        //write each line
        for (HolidayInformationEntity holidayInformationEntity : holidayEntityList) {
            String[] nextLine = new String[5];
            //set No
            nextLine[0] = holidayInformationEntity.getId();
            //set country code
            nextLine[1] = holidayInformationEntity.getCountryCode();
            //set country desc
            nextLine[2] = holidayInformationEntity.getCountryDesc();
            //set holiday date
            nextLine[3] = holidayInformationEntity.getHolidayDate();
            //set holiday name
            nextLine[4] = holidayInformationEntity.getHolidayName();
            //add to list
            writer.writeNext(nextLine);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
