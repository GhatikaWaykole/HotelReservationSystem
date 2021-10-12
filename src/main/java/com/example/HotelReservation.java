package com.example;

import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* purpose Hostel Reservation System to do the operation of different hotel
 *
 */
public class HotelReservation {
    private List<Hotel> hotelreservation = new ArrayList<>();
    /* method to add the hotel
     * @param hostname, weekDay
     * @return
     */
    public void addHotel(String hotelName,int weekDayRate,int weekendDayRate){
        hotelreservation.add(new Hotel(hotelName, weekDayRate,weekendDayRate));
    }
    /* method to count the add the hotel in the arraylist data
     * @param hotelreservation check data
     */
    public int hotelCount(){
       return hotelreservation.size();
    }
    /* method to find the cheaphotel
     * @param lowerRange , upperRange
     * @return cheapHotel data
     */
    public String cheapHotelName(String lowerRange,String upperRange){
        HashMap<String,Integer> hotelRateMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        String cheapHotel = null;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate lower = LocalDate.parse(lowerRange, format);
        LocalDate upper = LocalDate.parse(upperRange, format);
        int numDays = Period.between(lower, upper).getDays();

        for(Hotel hotel: hotelreservation) {
            int totalRate = 0;
            for(int i=0;i<numDays;i++) {
                totalRate += hotel.getWeekDayRate();
            }
            hotelRateMap.put(hotel.getHotelName(),totalRate);
        }
        for (Map.Entry map : hotelRateMap.entrySet()) {
            if(min > (int)map.getValue()) {
                min = (int)map.getValue();
                cheapHotel = (String)map.getKey();
            }
        }
        return cheapHotel;
    }
}