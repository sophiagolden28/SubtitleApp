/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author babafemisorinolu
 */
public class Utils {

    public static String convertTime(Time time) {
        return time.getHH() + ":" + time.getMM() + ":" + time.getSS() + "," + time.getMS();
    }

    public static Time convertTime(String startTime) {

        //take the first part of the list we just made (which will be the start time) and turn it into a list
        String[] timeComponents = startTime.split(":");

        //making time vars
        int startHours = Integer.parseInt(timeComponents[0]);
        int startMinutes = Integer.parseInt(timeComponents[1]);

        //splitting the milliseconds from the seconds for ease of access
        String[] secsAndMilsList = timeComponents[2].split(",");

        //back to making time vars
        int startSeconds = Integer.parseInt(secsAndMilsList[0]);
        int startMilliseconds = Integer.parseInt(secsAndMilsList[1]);

        //replace with your Implemented Class (Time)
        Time time = new TimeImplemented();
        time.setHH(startHours);
        time.setMM(startMinutes);
        time.setSS(startSeconds);
        time.setMS(startMilliseconds);
        System.out.println("" + ((TimeImplemented) time).getTimeInMS());
        return time;
    }

    public static Subtitle getSubtitle(Time startTime, Time endTime, String text) {
        //replace with your Implemented Class (Subtitle)
        Subtitle subtitle = new SubtitleImplemented();
        subtitle.setStartTime(startTime);
        subtitle.setEndTime(endTime);
        subtitle.setText(text);

        return subtitle;
    }
}
