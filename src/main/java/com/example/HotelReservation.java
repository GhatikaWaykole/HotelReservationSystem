package com.example;

import org.w3c.dom.stylesheets.LinkStyle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* purpose Hostel Reservation System to do the operation of different hotel
 *
 */
public class HotelReservation {
    private List<Hotel> hotelreservation = new ArrayList<>();
    /* method to add the hotel
     * @param hostname, weekDay
     * @return
     */
    public void addHotel(String hotelName,int weekDayRate,int weekendDayRate,int rating){
        hotelreservation.add(new Hotel(hotelName, weekDayRate,weekendDayRate,rating));
    }
    /* method to count the add the hotel in the arraylist data
     * @param hotelreservation check data
     */
    public int hotelCount(){
       return hotelreservation.size();
    }
    public boolean checkWeekend(DayOfWeek day){
        switch (day){
            case SATURDAY:
               return true;
            case SUNDAY:
                return true;
        }
        return false;
    }
    /* method to find the cheaphotel
     * @param lowerRange , upperRange
     * @return cheapHotel data
     */
    public String cheapHotelName(String lowerRange,String upperRange){
        HashMap<Hotel,Integer> hotelRateMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        Hotel cheapHotel = null;
        String cheapHotelName = null;
        int maxRating =0;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate lower = LocalDate.parse(lowerRange, format);
        LocalDate upper = LocalDate.parse(upperRange, format);
        int numDays = Period.between(lower, upper).getDays();
        List<LocalDate> list = Stream.iterate(lower, local -> local.plusDays(1)).limit(numDays).collect(Collectors.toList());
        for(Hotel hotel: hotelreservation) {
            int totalRate = 0;
            for (LocalDate localDate : list){
                if(checkWeekend(localDate.getDayOfWeek())){
                    totalRate += hotel.getWeekendDayRate();
                }
                else{
                    totalRate += hotel.getWeekDayRate();
                }
            }
            hotelRateMap.put(hotel,totalRate);
        }
        for (Map.Entry map : hotelRateMap.entrySet()) {
            if (min > (int) map.getValue()) {
                min = (int) map.getValue();
                cheapHotel = (Hotel) map.getKey();
                maxRating = cheapHotel.getRating();
                cheapHotelName = cheapHotel.getHotelName();
            } else if (min == (int) map.getValue()) {
                cheapHotel = (Hotel) map.getKey();
                if (maxRating < cheapHotel.getRating()) {
                    maxRating = cheapHotel.getRating();
                    min = (int) map.getValue();
                    cheapHotelName = cheapHotel.getHotelName();
                }
            }
        }
        return cheapHotelName;
    }
}