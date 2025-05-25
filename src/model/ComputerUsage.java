package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComputerUsage implements Serializable {
    private int computerNumber;
    private String clientName;
    private String date;
    private String startTime;
    private String endTime;

    public ComputerUsage(int computerNumber, String clientName, String date,
                         String startTime, String endTime) {
        this.computerNumber = computerNumber;
        this.clientName = clientName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getComputerNumber() { return computerNumber; }
    public String getClientName() { return clientName; }
    public String getDate() { return date; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public long getUsageDuration() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date start = format.parse(startTime);
        Date end = format.parse(endTime);
        return (end.getTime() - start.getTime()) / (60 * 1000);
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%s;%s;%s",
                computerNumber, clientName, date, startTime, endTime);
    }
}