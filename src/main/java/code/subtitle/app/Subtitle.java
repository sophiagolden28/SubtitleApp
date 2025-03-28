/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package code.subtitle.app;

/**
 *
 * @author babafemisorinolu
 */
public interface Subtitle {
    
    // Return the start time of the Subtitle. 
    Time getStartTime();

    // Return the end time of the Subtitle.  
    Time getEndTime();

    // Return the subtitle text.  
    String getText();

    // Set the start time of the Subtitle.  
    void setStartTime(Time startTime);

    // Set the end time of the Subtitle. 
    void setEndTime(Time endTime);

    // Set the subtitle text.  
    void setText(String text);

}
