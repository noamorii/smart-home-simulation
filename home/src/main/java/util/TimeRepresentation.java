package util;

/**
 * Class representing time.
 */
public class TimeRepresentation {

    private int currentMinutes, currentHours = 0;
    private int currentDay = 1;
    private static final int TICK_TIME = 10;

    /**
     * Simulates the passage of time
     */
    public void increase() {

        if (currentMinutes < 50) {
            currentMinutes += TICK_TIME;
        } else {
            currentMinutes = 0;
            if (currentHours < 23) {
                currentHours++;
            } else {
                currentHours = 0;
                currentDay++;
            }
        }
    }

    /**
     * Setting simulation start time and division into hours and minutes
     *
     * @param time simulation start time
     */
    public void setTime(String time) {
        this.currentHours = Integer.parseInt(time.split(":")[0]);
        this.currentMinutes = Integer.parseInt(time.split(":")[1]);
    }

    /**
     * Getting the current simulation time
     *
     * @return time
     */
    public String getCurrentTime() {

        String time = "Day:" + currentDay + " ";

        if (currentHours < 10) {
            time += "0" + currentHours;
        } else {
            time += currentHours;
        }

        if (currentMinutes == 0) return time + ":00";
        return time + ":" + currentMinutes;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public boolean isMidNight() {
        return (currentHours == 0 && currentMinutes == 0);
    }

    public boolean isNight() {
        return currentHours > 2 && currentHours <= 6;
    }
}