package dev.felipesantana.learningspring.business;

import dev.felipesantana.learningspring.data.Guest;
import dev.felipesantana.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();

        guests.forEach(guestList::add);

        guestList.sort((guest1, guest2) -> {
            if (guest1.getLastName().equals(guest2.getLastName())) {
                return guest1.getFirstName().compareTo(guest2.getFirstName());
            }
            return guest1.getLastName().compareTo(guest2.getLastName());
        });

        return guestList;
    }

    public void createGuest(Guest guest) {
        if (guest == null) {
            throw new RuntimeException("Guest cannot be null");
        }
        this.guestRepository.save(guest);
    }
}
