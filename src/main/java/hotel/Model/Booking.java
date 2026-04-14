package hotel.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_seq")
    @SequenceGenerator(name = "bookings_seq", sequenceName = "bookings_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private AppUser user;
    @Column(name = "check_in_date")
    private LocalDate in_date;
    @Column(name = "check_out_date")
    private LocalDate out_date;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public LocalDate getIn_date() {
        return in_date;
    }

    public void setIn_date(LocalDate in_date) {
        this.in_date = in_date;
    }

    public LocalDate getOut_date() {
        return out_date;
    }

    public void setOut_date(LocalDate out_date) {
        this.out_date = out_date;
    }

    public Booking(Room room, AppUser user, LocalDate in_date, LocalDate out_date) {
        this.room = room;
        this.user = user;
        this.in_date = in_date;
        this.out_date = out_date;
    }
}
