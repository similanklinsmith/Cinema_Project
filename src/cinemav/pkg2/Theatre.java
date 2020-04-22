package cinemav.pkg2;

import java.util.ArrayList;

public class Theatre {

    private String theatreId;
    private static int runningId = 1;
    private int rowCount;
    private ArrayList<Row> rows;

    public Theatre(String theatreId) {
        this.theatreId = theatreId;

    }

    public void createRows(int rowClass, int seatCount, int rowCount) {
        for (int i = 0; i <= this.rowCount; i++) {
            rows.add(new Row("Row "+runningId++, rowClass, seatCount));
        }
        this.rowCount += rowClass;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void printSeatPlan() {
        System.out.println();
        int maxSeatsPerRow = 0;
        for (Row row : rows) {
            if (row.getSeat().length > maxSeatsPerRow) {
                maxSeatsPerRow = row.getSeat().length;
            }
        }
        System.out.println("    |");
        for (int i = 0; i <= maxSeatsPerRow; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        System.out.print("---------");
        for (int i = 0; i <= maxSeatsPerRow; i++) {
            if (i > 9) {
                System.out.print("---");
            } else {
                System.out.print("--");
            }
        }
        System.out.println("");
        for (Row row : getRows()) {
            if (row.getRowNumber() > 9) {
                System.out.print(row.getRowNumber() + " | ");
            } else {
                System.out.print(row.getRowNumber() + " | ");
            }
            for (Seat seat : row.getSeat()) {
                if (seat.getReservationStatus() == SeatStatus.NOT_AVAILABLE) {
                    System.out.print("X");
                }else{
                    System.out.println(seat.getSeatNo()+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
