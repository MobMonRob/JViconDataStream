package de.dhbw.mobmonrob.vicon.datastreamapi.api;

import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetTimecode;

/**
 * Return the timecode information for the last frame retrieved from the DataStream. 
 * 
 * If the stream is valid but timecode is not available the Output will be 
 * Result.Success and the Standard will be None.<p>
 * 
 * See Also : GetFrame, GetFrameNumber<p>
 * 
 * @author Oliver Rettig
 */
public class TimeCode {
    private final Output_GetTimecode timeCode;
    public TimeCode(Output_GetTimecode timeCode){
        this.timeCode = timeCode;
    }
    
    public long getSubFrame(){
        return timeCode.getSubFrame();
    }
    public long getFrames(){
        return timeCode.getFrames();
    }
    
    //TODO
    // weitere Methoden wrappen
}
