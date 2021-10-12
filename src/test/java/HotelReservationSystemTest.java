import com.example.HotelReservation;
import com.example.UserException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class HotelReservationSystemTest {
    HotelReservation hotelReservation = new HotelReservation();

    @Test
    public void CheckIfHotelAddedProperly() {
        try {
            hotelReservation.addHotel("BrideWood", 160);
            hotelReservation.addHotel("BridegWood", 160);
            hotelReservation.addHotel("LakeWood", 120);
            int hotelCount = hotelReservation.hotelCount();
            Assert.assertEquals(3, hotelCount);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
