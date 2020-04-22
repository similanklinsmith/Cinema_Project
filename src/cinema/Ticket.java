package cinema;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Ticket {
    private LocalTime buyTime;
    private String ticketId;
    private static int runningId = 1;

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
        this.buyTime = LocalTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Ticket : "+ticketId);
       sb.append("  "+buyTime);
       return sb.toString();
    }
    
    
    
}
