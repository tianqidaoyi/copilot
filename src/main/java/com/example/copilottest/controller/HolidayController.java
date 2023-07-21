package com.example.copilottest.controller;

import com.example.copilottest.entity.HolidayInformationEntity;
import com.example.copilottest.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Huang
 */
@RestController
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    //插入一条或多条假期信息
    @PostMapping("/holiday/add")
    public String insertHolidayInfo(@RequestBody List<HolidayInformationEntity> list) {
        //Use holidayService to insert holiday info
        holidayService.insertHolidayInfo(list);
        return "insert holiday info";
    }

    //method take JSON request to update holiday info
    @PostMapping("/holiday/update")
    public String updateHolidayInfo(@RequestBody String countryCode, @RequestBody String countryDesc, @RequestBody String holidayDate, @RequestBody String holidayName) {
        //Use holidayService to update holiday info
        Boolean result = holidayService.updateHolidayInfo(countryCode, countryDesc, holidayDate, holidayName);
        //
        return result.toString();
    }

    //方法：根据Id删除一条假期信息
    @PostMapping("/holiday/delete")
    public String deleteHolidayInfo(@RequestBody String id) {
        //Use holidayService to delete holiday info
        holidayService.deleteHolidayInfo(id);

        return "delete holiday info";
    }


    //method: return next year's holiday info for given country code based on current system date
    @GetMapping("/holiday/nextYear")
    public String getNextYearHolidayInfo(@RequestBody String countryCode) {
        //检查countryCode是否为空或空字符串
        if (countryCode == null || countryCode.equals("")) {
            return "countryCode is null or empty";
        }
        //基于当前时间，获取下一年所有的假期信息
        return holidayService.getNextYearHolidayInfo(countryCode);
    }

    //method：return next holiday info for given country code based on current system date
    @GetMapping("/holiday/next")
    public String getNextHolidayInfo(@RequestBody String countryCode) {
        //基于当前时间，获取下一个假期信息
        return holidayService.getNextHolidayInfo(countryCode);
    }

    //method: check if a given date is holiday or not in any country code
    @GetMapping("/holiday/check")
    public String checkHoliday(@RequestBody String date) {
        //Use holidayService to check if a given date is holiday or not in any country code
        return holidayService.checkHoliday(date);
    }

}
