import com.example.HotelReservation;
import com.example.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class HotelReservationSystemTest {
    HotelReservation hotelReservation = new HotelReservation();
    //Test method to check if hotel added properly
    @Before
    public void CheckIfHotelAddedProperly() {
            hotelReservation.addHotel("BridegWood", 160);
            hotelReservation.addHotel("RidgeWood", 160);
            hotelReservation.addHotel("LakeWood", 120);
            int hotelCount = hotelReservation.hotelCount();
            Assert.assertEquals(3, hotelCount);
    }
    //Test to check the cheapHotel data
    @Test
    public void givenDataHotel_WhenCheapPrice_ShouldReturnTrue(){
        String cheapHotel = hotelReservation.cheapHotelName("12Sep2020","15Sep2020");
        Assert.assertEquals("LakeWood",cheapHotel);
    }
}
