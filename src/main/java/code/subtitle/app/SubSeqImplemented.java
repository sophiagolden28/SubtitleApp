/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.subtitle.app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sound Room
 */
public class SubSeqImplemented implements SubtitleSeq {

    //the very big list of subtitles
    ArrayList<Subtitle> subtitleList = new ArrayList<>();

    //so you have to add each subtitle manually
    @Override
    public void addSubtitle(Subtitle st) {
        subtitleList.add(st);
    }

    //returns the list of subtitles you just made
    @Override
    public List<Subtitle> getSubtitles() {
        return subtitleList;
    }

    //gets the subtitle object at the given time
    @Override
    public Subtitle getSubtitle(Time time) {

        //loops through the subtitle list and if the time matches up return it
        for (Subtitle subtitle : subtitleList) {

            if (((SubtitleImplemented) subtitle).getTimeInMilliseconds() == ((TimeImplemented) time).getTimeInMS()) {

                return subtitle;

            }

        }

        return null;
    }

    @Override
    public List<Subtitle> getSubtitles(Time startTime, Time endTime) {

        //returning all the subtitles between the certain time
        ArrayList<Subtitle> subtitlesWithinTime = new ArrayList<>();

        //loop through the subtitles in the big list then check the time then see if the subtitle is in the time 
        //then it them to the list if it is
        for (Subtitle subtitle : subtitleList) {
            if (((SubtitleImplemented) subtitle).getTimeInMilliseconds() >= ((TimeImplemented) startTime).getTimeInMS() && ((SubtitleImplemented) subtitle).getTimeInMilliseconds() <= ((TimeImplemented) endTime).getTimeInMS()) {
                subtitlesWithinTime.add(subtitle);
            }
        }

        return subtitlesWithinTime;
    }

    @Override
    public List<Subtitle> getSubtitles(String str) {

        //the list to return:
        ArrayList<Subtitle> subtList = new ArrayList<>();

        //if str is in the subtitle, add the subtitle to the list to return
        for (Subtitle subtitle : subtitleList) {

            if (subtitle.getText().contains(str)) {
                subtList.add(subtitle);
            }
        }

        return subtList;
    }

    //ok so this actually removes ALL the subtitles with the str in it for real so this is good
    @Override
    public void remove(String str) {

        //this is like getsubtitles - it searches through the subtitlelist and if the subtitle contains the 
        //string str we remove it from the big list
        //THIS IS TITLE CASE FOR NOW.
        //ACTUALLY INSTEAD OF REMOVING IT, IM GOING TO REBUILD SUBTITLES - TAKE ALL THE SUBTITLES 
        //NOT CONTAINING THE STRING AND THEN ADD THEM ONE BY ONE TO A COPYLIST, THEN SET SUBTITLELIST TO THE COPY
        ArrayList<Subtitle> copySubtitleList = new ArrayList<>();

        for (Subtitle subtitle : subtitleList) {

            if (!subtitle.getText().contains(str)) {

                copySubtitleList.add(subtitle);

            }

        }

        subtitleList = copySubtitleList;

    }

    @Override
    public void replace(String str1, String str2) {

        //loop through the the big subtitle list, if the text is str1, replace it with str2
        for (Subtitle subtitle : subtitleList) {

            if (subtitle.getText().contains(str1)) {

                //replace the text (str1 with str2) and set that as the new text
                String subtNewText = subtitle.getText().replace(str1, str2);
                subtitle.setText(subtNewText);

            }

        }

    }

    //shifts the time by the offset
    @Override
    public void shift(int offset) {

        //doing it in milliseconds: if the milliseconds would make the existing ms 1000 or more we add a minute and 
        //the leftovers are in ms.
        //if the offset is less than 0:
        if (offset < 0) {

            //ok again with this instead of looping over a list while modifying it (resulting in an error)
            //we have to create a new list with everything EXCEPT what we want to take out (basically inverting it)
            ArrayList<Subtitle> copySubtitleList = new ArrayList<>();

            for (Subtitle subtitle : subtitleList) {

                //shift
                ((TimeImplemented) subtitle.getStartTime()).setTimeInMS(((TimeImplemented) subtitle.getStartTime()).getTimeInMS() + offset);
                ((TimeImplemented) subtitle.getEndTime()).setTimeInMS(((TimeImplemented) subtitle.getEndTime()).getTimeInMS() + offset);

                //so if it's NOT less than 0 we add it back to a list
                if (!(((TimeImplemented) ((SubtitleImplemented) subtitle).getStartTime()).getTimeInMS() <= 0 || ((TimeImplemented) ((SubtitleImplemented) subtitle).getEndTime()).getTimeInMS() <= 0)) {

                    copySubtitleList.add(subtitle);

                }

            }

            //then set subtitle list to the new copy list without the 0-time subtitles
            subtitleList = copySubtitleList;

        } else {
            //if it's not, take all the subtitles in a loop and add the offset to the start and end times depending
            //on how big the offset is

            for (Subtitle subtitle : subtitleList) {

                //can we update the time in milliseconds all at once???????
                //yah instead do this: use a setMilliseconds function that sets the hour, minute, etc while dividing it etc. and
                //set the total milliseconds to the existing total milliseconds + the offset
                ((TimeImplemented) subtitle.getStartTime()).setTimeInMS(((TimeImplemented) subtitle.getStartTime()).getTimeInMS() + offset);
                ((TimeImplemented) subtitle.getEndTime()).setTimeInMS(((TimeImplemented) subtitle.getEndTime()).getTimeInMS() + offset);

//                this only works if offset is under 1000, add if-elses to catch
//                subtitle.getStartTime().setMS(subtitle.getStartTime().getMS() + offset);
//                subtitle.getEndTime().setMS(subtitle.getEndTime().getMS() + offset);
            }

        }

    }

    //cuts all the subtitles between a specific time - this is like getsubtitle(time) but reversed
    @Override
    public void cut(Time startTime, Time endTime) {

        //doing this like for remove - building up a new list instead of removing stuff from an 
        //old list at the same time as iterating over it
        ArrayList<Subtitle> copySubtitleList = new ArrayList<>();

        for (Subtitle subtitle : subtitleList) {

            if (!(((SubtitleImplemented) subtitle).getTimeInMilliseconds() >= ((TimeImplemented) startTime).getTimeInMS() && ((SubtitleImplemented) subtitle).getTimeInMilliseconds() <= ((TimeImplemented) endTime).getTimeInMS())) {

                copySubtitleList.add(subtitle);

            }

        }

        subtitleList = copySubtitleList;

    }

}
