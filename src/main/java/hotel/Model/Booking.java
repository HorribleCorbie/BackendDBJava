package hotel.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private AppUser client;
    @Column(name = "check_in_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate in_date;
    @Column(name = "check_out_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate out_date;
    @Column(name = "price")
    private float price;

    public Booking() {
    }

    public Booking(Long id, Room room, AppUser client, LocalDate in_date, LocalDate out_date, float price) {
        this.id = id;
        this.room = room;
        this.client = client;
        this.in_date = in_date;
        this.out_date = out_date;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public AppUser getUser() {
        return client;
    }

    public void setUser(AppUser client) {
        this.client = client;
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

    public Booking(Room room, AppUser client, LocalDate in_date, LocalDate out_date,float price) {
        this.room = room;
        this.client = client;
        this.in_date = in_date;
        this.out_date = out_date;
        this.price=price;
    }
}
