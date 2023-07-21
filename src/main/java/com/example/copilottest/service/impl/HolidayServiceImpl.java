package com.example.copilottest.service.impl;

import com.example.copilottest.entity.HolidayInformationEntity;
import com.example.copilottest.mapper.HolidayMapper;
import com.example.copilottest.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayMapper holidayMapper;

    @Override
    public void insertHolidayInfo(List<HolidayInformationEntity> list) {
        holidayMapper.insertHolidayInfo(list);
    }

    @Override
    public Boolean updateHolidayInfo(String countryCode, String countryDesc, String holidayDate, String holidayName) {
        return holidayMapper.updateHolidayInfo(countryCode, countryDesc, holidayDate, holidayName);
    }

    @Override
    public void deleteHolidayInfo(String id) {
        holidayMapper.deleteHolidayInfo(id);
    }

    @Override
    public String getNextYearHolidayInfo(String countryCode) {
        return holidayMapper.getNextYearHolidayInfo(countryCode);
    }

    @Override
    public String getNextHolidayInfo(String countryCode) {
        return holidayMapper.getNextHolidayInfo(countryCode);
    }

    @Override
    public String checkHoliday(String date) {
        return holidayMapper.checkHoliday(date);
    }
}
