package util;

public class TimeRepresentation {

    private int currentMinutes, currentHours = 0;
    final int TICK_TIME = 10;

    public void increase() {

        if (currentMinutes < 50) {
            currentMinutes += TICK_TIME;
        } else {
            currentMinutes = 0;
            if (currentHours < 23) {
                currentHours++;
            } else {
                currentHours = 0;
            }
        }
    }

    public void setTime(String time) {
        this.currentHours = Integer.parseInt(time.split(":")[0]);
        this.currentMinutes = Integer.parseInt(time.split(":")[1]);
    }

    public String getCurrentTime() {

        String time = "Time: ";

        if (currentHours < 10)  {
            time += "0" + currentHours;
        } else {
            time += currentHours;
        }

        if (currentMinutes == 0) return time + ":00";
        return time + ":" + currentMinutes;
    }

    public int hoursForSimulation(int hours) {
        return hours * 6;
    }
}
