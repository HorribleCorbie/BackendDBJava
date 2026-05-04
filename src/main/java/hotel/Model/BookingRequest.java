package hotel.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BookingRequest {
    private int roomId;
    private String login;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate in_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate out_date;
    private String price;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
