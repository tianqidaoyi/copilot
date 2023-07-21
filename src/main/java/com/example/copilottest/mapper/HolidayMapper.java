package com.example.copilottest.mapper;

import com.example.copilottest.common.utils.CsvUtils;
import com.example.copilottest.entity.HolidayInformationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class HolidayMapper {

    //基于当前时间，获取指定country code下的一年所有的假期信息
    public String getNextYearHolidayInfo(String countryCode) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, +1);
        //获取Calendar实例中的年份并转成字符串
        String nextYearDate = String.valueOf(calendar.get(Calendar.YEAR));

        //Get holiday list
        List<HolidayInformationEntity> list = CsvUtils.getHolidayEntityList();

        List<HolidayInformationEntity> nextYearList = new ArrayList<HolidayInformationEntity>();
        //遍历list，获取指定country code下的指定年份下的所有的假期信息，并返回成一个List
        for (HolidayInformationEntity holidayInformationEntity : list) {
            if (holidayInformationEntity.getCountryCode().equals(countryCode) && holidayInformationEntity.getHolidayDate().contains(nextYearDate)) {
                nextYearList.add(holidayInformationEntity);
            }
        }
        return nextYearList.toString();
    }

    //method check if a given date is holiday or not, result should indicate in country this date is holiday and which country it is not
    public String checkHoliday(String date) {
        //Get holiday list
        List<HolidayInformationEntity> list = CsvUtils.getHolidayEntityList();

        //遍历list
        for (HolidayInformationEntity holidayInformationEntity : list) {
            if (holidayInformationEntity.getHolidayDate().equals(date)) {
                return holidayInformationEntity.getCountryCode();
            }
        }
        return null;
    }

    //基于当前时间，获取指定country code下的下一个假期信息
    public String getNextHolidayInfo(String countryCode) {
        //Get holiday list
        List<HolidayInformationEntity> list = CsvUtils.getHolidayEntityList();

        //遍历list，根据当前的时间获取下一个假期信息
        for (HolidayInformationEntity holidayInformationEntity : list) {
            if (holidayInformationEntity.getCountryCode().equals(countryCode) && holidayInformationEntity.getHolidayDate().compareTo(new Date().toString()) < 0) {
                return holidayInformationEntity.getHolidayDate() + " " + holidayInformationEntity.getHolidayName();
            }
        }
        return null;
    }

    //向CSV文件中插入一条或者多条的假期信息
    public void insertHolidayInfo(List<HolidayInformationEntity> list) {
        //Get holiday list
        List<HolidayInformationEntity> holidayEntityList = CsvUtils.getHolidayEntityList();

        //遍历list，获取指定country code下的指定年份下的所有的假期信息，并判断是否有重复的假期信息，如果有则不插入，并打印出来，如果没有则插入
        for (HolidayInformationEntity holidayInformationEntity : list) {
            boolean flag = false;
            for (HolidayInformationEntity holidayInformationEntity1 : holidayEntityList) {
                if (holidayInformationEntity.getCountryCode().equals(holidayInformationEntity1.getCountryCode()) && holidayInformationEntity.getHolidayDate().equals(holidayInformationEntity1.getHolidayDate())) {
                    flag = true;
                    System.out.println("The holiday information already exists, please check the input information");
                }
            }
            if (!flag) {
                holidayEntityList.add(holidayInformationEntity);
            }
        }

        //将list中的数据写入CSV文件中
        CsvUtils.writeHolidayEntityList(holidayEntityList);
    }

    //更新CSV文件中的一条假期信息,如果不存在则返回false，如果存在则更新并返回true
    public Boolean updateHolidayInfo(String countryCode, String countryDesc, String holidayDate, String holidayName) {
        //Get holiday list
        List<HolidayInformationEntity> holidayEntityList = CsvUtils.getHolidayEntityList();

        //遍历list，获取指定country code下的指定年份下的所有的假期信息，并判断是否有重复的假期信息，如果有则不插入，并打印出来，如果没有则插入
        for (HolidayInformationEntity holidayInformationEntity : holidayEntityList) {
            if (holidayInformationEntity.getCountryCode().equals(countryCode) && holidayInformationEntity.getHolidayDate().equals(holidayDate)) {
                holidayInformationEntity.setCountryDesc(countryDesc);
                holidayInformationEntity.setHolidayName(holidayName);
                //将list中的数据写入CSV文件中
                CsvUtils.writeHolidayEntityList(holidayEntityList);
                return true;
            }
        }
        return false;
    }

    //删除CSV文件中的一条假期信息
    public void deleteHolidayInfo(String id) {
        //Get holiday list
        List<HolidayInformationEntity> holidayEntityList = CsvUtils.getHolidayEntityList();

        List<HolidayInformationEntity> newHolidayEntityList = new ArrayList<HolidayInformationEntity>();
        //遍历list,将不符合条件的数据放入新的list中
        for (HolidayInformationEntity holidayInformationEntity : holidayEntityList) {
            if (!holidayInformationEntity.getId().equals(id)) {
                newHolidayEntityList.add(holidayInformationEntity);
            }
        }

        //将list中的数据写入CSV文件中
        CsvUtils.writeHolidayEntityList(newHolidayEntityList);
    }

}
