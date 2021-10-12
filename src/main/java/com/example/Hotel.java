package com.example;

public class Hotel {
    private String hotelName;
    private int weekDayRate;
    private int weekendDayRate;
    private int rating;
    public Hotel(String hotelName, int weekDayRate, int weekendDayRate,int rating) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekendDayRate = weekendDayRate;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWeekendDayRate() {
        return weekendDayRate;
    }

    public void setWeekendDayRate(int weekendDayRate) {
        this.weekendDayRate = weekendDayRate;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(int weekDayRate) {
        this.weekDayRate = weekDayRate;
    }
}
