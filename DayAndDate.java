package salonsystem;

public class DayAndDate {
    private String date;
    private String day;

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return date + " " + day;
    }

}
