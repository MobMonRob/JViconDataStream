package de.dhbw.mobmonrob.vicon.datastreamapi.api;

import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetVersion;

/**
 * @author Oliver Rettig
 */
public class Version {
    
    private final Output_GetVersion version;
    
    public Version(Output_GetVersion version){
        this.version = version;
    }
    /**
     * The major version number. 
     * 
     * When this number increases we break backwards 
     * compatibility with previous major versions.<p>
     * 
     * @return The major version number.
     */
    public long getMajor(){
        return version.getMajor();
    }
    /**
     * The minor version number.
     * 
     * When this number increases we have probably added new functionality to 
     * the SDK without breaking backwards compatibility with previous versions.<p>
     * 
     * @return The minor version number.
     */
    public long getMinor(){
        return version.getMinor();
    }
    /**
     * The point version number.
     * 
     * When this number increases, we have introduced a bug fix or performance 
     * enhancement without breaking backwards compatibility.<p>
     * 
     * @return The point version number
     */
    public long getPoint(){
        return version.getPoint();
    }
}
