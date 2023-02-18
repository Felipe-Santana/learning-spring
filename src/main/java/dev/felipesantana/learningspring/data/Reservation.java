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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                ", guestId='" + guestId + '\'' +
                ", resDate=" + resDate +
                '}';
    }
}
