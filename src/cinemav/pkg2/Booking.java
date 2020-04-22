package cinemav.pkg2;

public class Booking {
    private int cost;
    private Customer customer;
    private Show show;
    private int rowNo;
    private int seatNo;

    public Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
    }

    public int getRowNo() {
        return rowNo;
    }
    
    
    public int getCost(){
        if (show.getTheatre().getRows().get(rowNo).getRowClass() == 1) {
            return cost +=120;
        }else{
            return cost +=100;
        }
    }
    public void setRowNo(){
        this.rowNo = rowNo;
    }
    public void setSeatNumber(int seatNo){
        this.seatNo  = seatNo;
    }
    public boolean reserveSeat(int selectedRow, int selectedSeat)

	{

		if (show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).getReservationStatus())

    	{  		

    		return false;

    	}

    	else {

    		show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();

    		setRowNumber(selectedRow);

    		setSeatNumber(selectedSeat);

    		return true;

    	}

	}
}
