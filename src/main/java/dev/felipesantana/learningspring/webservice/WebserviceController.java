package dev.felipesantana.learningspring.webservice;

import dev.felipesantana.learningspring.business.GuestService;
import dev.felipesantana.learningspring.business.ReservationService;
import dev.felipesantana.learningspring.business.RoomReservation;
import dev.felipesantana.learningspring.business.RoomService;
import dev.felipesantana.learningspring.data.Guest;
import dev.felipesantana.learningspring.data.Room;
import dev.felipesantana.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final GuestService guestService;
    private final RoomService roomService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService, RoomService roomService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    @GetMapping("/reservations")
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return this.guestService.getAllGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuest(@RequestBody Guest guest) {
        this.guestService.createGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return this.roomService.getAllRooms();
    }
}
