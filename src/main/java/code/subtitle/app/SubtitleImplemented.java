/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author Sound Room
 */
public class SubtitleImplemented implements Subtitle {

    Time startTime = new TimeImplemented();
    Time endTime = new TimeImplemented();
    String text;

    @Override
    public Time getStartTime() {
        return startTime;
    }

    @Override
    public Time getEndTime() {
        return endTime;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public int getTimeInMilliseconds() {
        int time = ((TimeImplemented) startTime).getTimeInMS();
        return time;

    }

}
