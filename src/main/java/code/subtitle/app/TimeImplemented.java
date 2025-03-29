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
    
    public void setTimeInMS(int totalMS){
    
        //in this we do some dividing and set all the time vars to their respective values in MS
        
        //so the way this works is that it sets everything to 0 again and then builds up from there rather than
        //catching if it's negative and then setting it backwards - here we just build it up.
        
        hour = 0;
        minute = 0;
        second = 0;
        millisecond = 0;
    
        //if the total is larger than one hour
        if (totalMS >= 3.6e+6) {
            
            //hour gets larger based on how many hours there are
            hour += totalMS / 3.6e+6;
            
            //then subtract hour-many-milliseconds from totalMS
            totalMS -= hour * 3.6e+6;
            
        }
        
        //if the total is larger than one minute
        if (totalMS >= 60000) {
            
            //minute gets larger based on how many hours there are
            minute += totalMS / 60000;
            
            //then subtract minute-many-milliseconds from totalMS
            totalMS -= minute * 60000;
            
        }
    
        //if the total is larger than one second
        if (totalMS >= 1000) {
            
            //second gets larger based on how many hours there are
            second += totalMS / 1000;
            
            //then subtract second-many-milliseconds from totalMS
            totalMS -= second * 1000;
            
        }
        
        //then we give the rese of totalMS to milliseconds
        millisecond += totalMS;
        
    }

}
