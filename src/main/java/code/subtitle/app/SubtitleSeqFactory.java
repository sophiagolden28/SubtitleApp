/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

import com.sun.jdi.IntegerValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sound Room
 */
public class SubtitleSeqFactory {
    
    // Return an empty subtitles sequence 
    public static SubtitleSeq getSubtitleSeq() {

        return new SubSeqImplemented();

    }

    // Load a subtitle sequence from an SRT file. If the file does not exist or // is corrupted (incorrect format), null is returned. 
    public static SubtitleSeq loadSubtitleSeq(String fileName) {

        //ok for this one what happens is this: you create the supseqimp object, then go through the file,
        //and add each line to the object, then return the object
        //make the object:
        SubSeqImplemented subtitleSequence = new SubSeqImplemented();

        try {

            //make file object
            File file = new File(fileName);

            //make scanner object
            Scanner scanner = new Scanner(file);

            //while the scanner finds a new line, add it to the subseq object using split
            while (scanner.hasNext()) {

                //split the subtitle and assign vars to different parts of it
                //id
                String firstLine = scanner.nextLine();

                //skipping lines if they are not the id line (first line of the subtitle chunk of text) 
                //by checking to see if they match the format of the id number
                //this way we get to skip to the next time it's an id number so that we don't go to a different thing
                if (!firstLine.matches("-?(0|[1-9]\\d*)")) {
                    //keep going the loop if it's not the right format
                    continue;
                }

                //time
                String secondLine = scanner.nextLine();

                //text
                String subtitleText = scanner.nextLine();

                //blank line (not used) with a condition to check if it exists because technically the last subtitle 
                //doesn't have a blank line under it
                if (scanner.hasNext()) {
                    String blankLine = scanner.nextLine();

                    //if i messed up and it's NOT a blank line (like if the text is split up between 2 lines)
                    //we just add the text to subtitleText
                    if (!blankLine.equalsIgnoreCase("\n")) {

                        subtitleText = subtitleText + " " + blankLine;

                    }

                }

                //converting the time into a list of start time and end time (we split on the arrow)
                String[] startAndEndTime = secondLine.split(" --> ");

                //take the first part of the list we just made (which will be the start time) and turn it into a list
                String[] timeComponents = startAndEndTime[0].split(":");

                //making time vars
                int startHours = Integer.parseInt(timeComponents[0]);
                int startMinutes = Integer.parseInt(timeComponents[1]);

                //splitting the milliseconds from the seconds for ease of access
                String[] secsAndMilsList = timeComponents[2].split(",");

                //back to making time vars
                int startSeconds = Integer.parseInt(secsAndMilsList[0]);
                int startMilliseconds = Integer.parseInt(secsAndMilsList[1]);

                //take the second part of the list startAndEndTime (which will be the end time) and turn it into a list
                String[] timeComponents2 = startAndEndTime[1].split(":");

                //making time vars
                int endHours = Integer.parseInt(timeComponents2[0]);
                int endMinutes = Integer.parseInt(timeComponents2[1]);

                //splitting the milliseconds from the seconds for ease of access
                String[] secsAndMilsList2 = timeComponents2[2].split(",");

                //back to making time vars
                int endSeconds = Integer.parseInt(secsAndMilsList2[0]);
                int endMilliseconds = Integer.parseInt(secsAndMilsList2[1]);

                //building a start time var and and end time var and set the hours minutes etc. for both
                Time startTime = new TimeImplemented();
                startTime.setHH(startHours);
                startTime.setMM(startMinutes);
                startTime.setSS(startSeconds);
                startTime.setMS(startMilliseconds);

                Time endTime = new TimeImplemented();
                endTime.setHH(endHours);
                endTime.setMM(endMinutes);
                endTime.setSS(endSeconds);
                endTime.setMS(endMilliseconds);

                //build a subtitle using the time and text variables and use setter functions to add them
                SubtitleImplemented subtitle = new SubtitleImplemented();
                subtitle.setStartTime(startTime);
                subtitle.setEndTime(endTime);
                subtitle.setText(subtitleText);

                //add the built subtitle to the subtitle sequence
                subtitleSequence.addSubtitle(subtitle);

            }

            //return the subseq object
            return subtitleSequence;

        } catch (FileNotFoundException e) {

            //return null if no file is found 
            return null;
        }

    }

}
