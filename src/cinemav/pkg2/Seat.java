package cinemav.pkg2;

public class Seat {
    private String seatNo;
    private SeatStatus seatStatus;

    public Seat(String seatNo, SeatStatus seatStatus) {
        this.seatNo = seatNo;
        this.seatStatus = seatStatus;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatNo() {
        return this.seatNo;
    }
    public SeatStatus getReservationStatus(){
        return this.seatStatus = SeatStatus.NOT_AVAILABLE; 
    }
    public void unreserve(){
        this.seatStatus = SeatStatus.AVAILABLE;
    }
    
    
}
