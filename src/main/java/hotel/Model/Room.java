package hotel.Model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "number", name = "unique_room_number")
})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_seq")
    @SequenceGenerator(name = "rooms_seq", sequenceName = "rooms_seq", allocationSize = 1)
    private Long id;
    @Column(name = "number")
    private int number;
    @Column(name = "price")
    private float price;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "ComfortClass")
    @Enumerated(EnumType.STRING)
    private ComfortClass comfort;
    @Column(name = "area")
    private float area;

    public Room(int number, float price, int capacity, ComfortClass comfort, float area) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.comfort=comfort;
        this.area = area;
    }

    public Room() {

    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Room room))
            return false;
        return Objects.equals(this.id, room.id) && Objects.equals(this.number, room.number)
                && Objects.equals(this.capacity, room.capacity) && Objects.equals(this.comfort, room.comfort)
                && Objects.equals(this.area, room.area);
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComfortClass getComfort() {
        return comfort;
    }

    public float getArea() {
        return area;
    }

    public float getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setComfort(ComfortClass comfort) {
        this.comfort = comfort;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
