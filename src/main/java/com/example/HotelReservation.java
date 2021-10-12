package com.example;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

/* purpose Hostel Reservation System to do the operation of different hotel
 *
 */
public class HotelReservation {
    private List<Hotel> hotelreservation = new ArrayList<>();
    /* method to add the hotel
     * @param hostname, weekDay
     * @return
     */
    public void addHotel(String hotelName,int weekDayRate) throws UserException {
        if (hotelName == null) {
            throw new UserException("Hotel name should not be null");
        }
        hotelreservation.add(new Hotel(hotelName, weekDayRate));
    }
    public static void main() {
        System.out.println("welcome to hotel reservation system");

    }

    public int hotelCount(){
       return hotelreservation.size();
    }
}
