package com.example.copilottest.entity;

//Entity class for holiday information include No, country code, country desc, holiday date, holiday name
public class HolidayInformationEntity {
    //No
    private String Id;

    //country code
    private String countryCode;

    //country desc
    private String countryDesc;

    //holiday date
    private String holidayDate;

    //holiday name
    private String holidayName;

    //get Id
    public String getId() {
        return Id;
    }

    //set Id
    public void setId(String Id) {
        this.Id = Id;
    }



    //get country code
    public String getCountryCode() {
        return countryCode;
    }

    //set country code
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    //get country desc
    public String getCountryDesc() {
        return countryDesc;
    }

    //set country desc
    public void setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
    }

    //get holiday date
    public String getHolidayDate() {
        return holidayDate;
    }

    //set holiday date
    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    //get holiday name
    public String getHolidayName() {
        return holidayName;
    }

    //set holiday name
    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    //constructor
    public HolidayInformationEntity(String countryCode, String countryDesc, String holidayDate, String holidayName) {
        this.countryCode = countryCode;
        this.countryDesc = countryDesc;
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    //constructor
    public HolidayInformationEntity() {
    }

    //constructor
    public HolidayInformationEntity(String Id, String countryCode, String countryDesc, String holidayDate, String holidayName) {
        this.Id = Id;
        this.countryCode = countryCode;
        this.countryDesc = countryDesc;
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    //equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HolidayInformationEntity) {
            HolidayInformationEntity holidayInformationEntity = (HolidayInformationEntity) obj;
            return this.countryCode.equals(holidayInformationEntity.countryCode) && this.countryDesc.equals(holidayInformationEntity.countryDesc) && this.holidayDate.equals(holidayInformationEntity.holidayDate) && this.holidayName.equals(holidayInformationEntity.holidayName);
        }
        return false;
    }

    //toString method
    @Override
    public String toString() {
        return "HolidayInformationEntity{" +
                "Id='" + Id + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryDesc='" + countryDesc + '\'' +
                ", holidayDate='" + holidayDate + '\'' +
                ", holidayName='" + holidayName + '\'' +
                '}';
    }




}
