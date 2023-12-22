package containers;

import java.util.Objects;
/// <summary>
/// It provides simple implementation of time
/// that is used as a field in Lesson class
/// </summary>
public class Time implements Comparable<Time>{
    private int hour;
    private int minute;

    public Time() {}

    public Time(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    public String toString() {
        return hour + ":" + minute;
    }
    public void setHour(int hour) {
        if (hour < 0) {
            throw new IllegalArgumentException("Hour must be a non-negative value.");
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be a non-negative value and less than 60.");
        }
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public int compareTo(Time o) {
        if(hour > o.hour) return 1;
        if(hour < o.hour) return -1;
        if(minute > o.minute) return 1;
        if(minute < o.minute) return -1;
        return 0;
    }
}
