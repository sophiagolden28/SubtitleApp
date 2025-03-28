/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author Sound Room
 */
public class TimeImplemented implements Time {

    int hour, minute, second, millisecond;

    @Override
    public int getHH() {
        return hour;
    }

    @Override
    public int getMM() {
        return minute;
    }

    @Override
    public int getSS() {
        return second;
    }

    @Override
    public int getMS() {
        return millisecond;
    }

    @Override
    public void setHH(int hh) {
        this.hour = hh;
    }

    @Override
    public void setMM(int mm) {
        this.minute = mm;
    }

    @Override
    public void setSS(int ss) {
        this.second = ss;
    }

    @Override
    public void setMS(int ms) {
        this.millisecond = ms;
    }

    public void setTime(int hour, int minute, int second, int millisecond) {

        setHH(hour);
        setMM(minute);
        setSS(second);
        setMS(millisecond);

    }

    public int getTimeInMS() {

        //convert all these to MS
        int hoursMS = (int) (hour * 3.6e+6);
        int minutesMS = minute * 60000;
        int secondsMS = second * 1000;
        int milliseconds = millisecond;

        int totalMS = hoursMS + minutesMS + secondsMS + milliseconds;

        return totalMS;

    }

}
