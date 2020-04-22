package cinemav.pkg2;

import java.util.ArrayList;

public class Row {
    private ArrayList<Seat> seats;
    private static int rowNo = 1;
    private int rowClass;
    private int seatCount;
    private String rowId;

    public Row(String rowId, int rowClass, int seatCount) {
        this.rowId = rowId;
        this.rowClass = rowClass;
        this.seatCount = seatCount;
        this.seats = new ArrayList<Seat>();
        createSeats(this.seatCount);
    }
    public void setRowClass(int rowClass){
        this.rowClass = rowClass;
    }
    public int getRowClass(){
        return this.rowClass;
    }
    public int getRowNumber(){
        return rowNo;
    }
   public void createSeats(int seatCount){
       for (int i = 0; i <= seatCount; i++) {
          seats.add(new Seat("Seat No. "+rowNo++, SeatStatus.AVAILABLE)); 
       }
   }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
   
    
    
}
