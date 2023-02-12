package dev.felipesantana.learningspring.data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private long id;

    @Column(name = "ROOM_ID")
    private String roomId;

    @Column(name = "GUEST_ID")
    private String guestId;

    @Column(name = "RES_DATE")
    private Date resDate;
}
