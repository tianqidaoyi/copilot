package com.example.copilottest.service;

import com.example.copilottest.entity.HolidayInformationEntity;

import java.util.List;

public interface HolidayService {
    void insertHolidayInfo(List<HolidayInformationEntity> list);

    Boolean updateHolidayInfo(String countryCode, String countryDesc, String holidayDate, String holidayName);

    void deleteHolidayInfo(String id);

    String getNextYearHolidayInfo(String countryCode);

    String getNextHolidayInfo(String countryCode);

    String checkHoliday(String date);
}
