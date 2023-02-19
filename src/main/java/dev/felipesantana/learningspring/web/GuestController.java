package dev.felipesantana.learningspring.web;

import dev.felipesantana.learningspring.business.GuestService;
import dev.felipesantana.learningspring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model) {
        List<Guest> guestList = this.guestService.getAllGuests();
        model.addAttribute("guests", guestList);
        return "guests-list";
    }
}
