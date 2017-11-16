package de.dhbw.mobmonrob.vicon.datastreamapi.api;

import de.dhbw.mobmonrob.vicon.datastreamapi.impl.CString;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Client;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_Connect;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_Disconnect;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_EnableMarkerData;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_EnableSegmentData;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_EnableUnlabeledMarkerData;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetFrameNumber;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetMarkerCount;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetMarkerGlobalTranslation;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetMarkerName;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetSegmentCount;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetSegmentLocalRotationMatrix;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetSegmentName;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetSubjectCount;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetSubjectName;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetUnlabeledMarkerCount;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Output_GetUnlabeledMarkerGlobalTranslation;
import de.dhbw.mobmonrob.vicon.datastreamapi.impl.Result_Enum;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Oliver Rettig
 */
public class ViconDataStreamSDKClient{
    
    private final Client client;
    static {
        try {
            // Adding a directory to java.library.path here will not change anything.
            // System.loadLibrary will still look in the directories listed in java.library.path
            // as it existed at the very start of the program.
            // The extra directory path added to java.library.path will not
            // be searched by loadLibrary.
            //String libpath = System.getProperty("java.library.path");
            //libpath = libpath + ";V:\\Hardware\\Platformen\\Mir\\PROJECTS\\ViconDataStream\\libs";
            //System.setProperty("java.library.path",libpath);
        
            System.out.println(System.getProperty("java.library.path"));
            System.loadLibrary("ViconDataStreamSDK_JAVA");
        } catch (UnsatisfiedLinkError e) {
          System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
          System.exit(1);
        }
    }
     
    /**
     * You can create many instances of the Vicon DataStream Client which can 
     * connect to multiple Vicon DataStream Servers.
     */
    public ViconDataStreamSDKClient(){
        client = new Client();
    }
    
    /**
     * Establish a dedicated connection to a Vicon DataStream Server.
     * 
     * See Also : ConnectToMulticast, Disconnect, IsConnected<p>
     * 
     * @param hostname The DNS identifiable name, or IP address of the PC hosting 
     * the DataStream server. The function defaults to connecting on port 801. 
     * You can specify an alternate port number after a colon. E.g.: "localhost"
     * "MyViconPC:804", "10.0.0.2"
     */
    public void connect(String hostname){
         while (!isConnected()){
            
            Output_Connect result = client.Connect(new CString(hostname));
            //Output_ConnectToMulticast result = client.ConnectToMulticast(new CString(hostname), new CString(hostname));
            
            if (result.getResult() == Result_Enum.InvalidHostName) 
                throw new RuntimeException("connect() but invalid hostname \""+hostname+"\"!");
      
            // Result.Success --> beendet die while schleife
            // Result.ClientAlreadyConnected --> kann innerhalb der while schleife nicht auftreten
            // Result.ClientConnectionFailed --> dafür ist die while schleife da
            
            //System.out.println("connect result = \""+result.getResult().toString()+"\"!");
        
            try {
                 Thread.sleep(1000l);
            } catch (InterruptedException ex) {
                 Logger.getLogger(ViconDataStreamSDKClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Discover whether client is connected to the Vicon DataStream Server.
     * 
     * See Also : Connect, Disconnect<p>
     * 
     * @return true, if you are connected to the stream, otherwise false.
     */
    public boolean isConnected(){
        return client.IsConnected().getConnected();
    }
    /**
     * Disconnect from the Vicon DataStream Server.
     * 
     * See Also : Connect, IsConnected<p>
     * 
     * @return success status
     */
    public boolean disconnect(){
        Output_Disconnect result = client.Disconnect();
        if (result.getResult().equals(Result_Enum.Success)) {
            return true;
        } else if (result.getResult().equals(Result_Enum.NotConnected)) {
            System.out.println("disconnect: but client was not connected!");
        }
        return false;
    }
    
    /**
     * Get the version of the Vicon DataStream SDK.
     * 
     * @return version
     */
    public Version getVersion(){
        return new Version(client.GetVersion());
    }
    
    /**
     * Enable labeled reconstructed marker data in the Vicon DataStream. 
     * 
     * Call this function on startup, after connecting to the server, and before 
     * trying to read labeled marker data.<p>
     * 
     * See Also : IsMarkerDataEnabled, DisableMarkerData, EnableSegmentData, 
     * EnableUnlabelledMarkerData, EnableDeviceData, GetMarkerCount, GetMarkerName, 
     * GetMarkerGlobalTranslation
     */
    public void enableMarkerData(){
        Output_EnableMarkerData result = client.EnableMarkerData();
        //System.out.println("Enable marker data: "+result.getResult().toString());
        if (result.getResult().equals(Result_Enum.NotConnected)) {
           throw new RuntimeException("enableMarkerData() but client was not connected!");
        }
    }
    
    /**
     * Enable kinematic segment data in the Vicon DataStream. 
     * 
     * You should call 
     * this function on startup, after connecting to the server, and before trying 
     * to read local or global segment data.<p>
     * 
     * See Also : IsSegmetnDataEnabled, DisableSegmentData, EnableMarkerData, 
     * EnableUnlabelledMarkerData, EnableDeviceData, GetSegmentCount, GetSegmentName, 
     * GetSegmentGlobalTranslation, GetSegmentGlobalRotationXXX, 
     * GetSegmentLocalTranslation, GetSegmentLocalRotationXXX
     */
    public void enableSegmentData(){
        Output_EnableSegmentData result = client.EnableSegmentData();
        System.out.println("Enable segment data: "+result.getResult().toString());
        if (result.getResult().equals(Result_Enum.NotConnected)) {
            throw new RuntimeException("enableSegmentData() but client was not connected!");
        }
    }
    /**
     * Enable unlabeled reconstructed marker data in the Vicon DataStream. 
     * 
     * You should call this function on startup, after connecting to the server, 
     * and before trying to read global unlabeled marker data.<p>
     * 
     * See Also : IsUnlabeledMarkerDataEnabled, DisableUnlabeledMarkerData, 
     * EnableSegmentData, EnableMarkerData, EnableDeviceData, GetUnlabeledMarkerCount, 
     * GetUnlabeledMarkerGlobalTranslation
     * 
     * @throws RuntimeException, if client not connected.
     */
    public void enableUnlabeledMarkerData(){
        Output_EnableUnlabeledMarkerData result = client.EnableUnlabeledMarkerData();
        //System.out.println("Enable unlabeled marker data: "+result.getResult().toString());
        if (result.getResult().equals(Result_Enum.NotConnected)) {
           throw new RuntimeException("enableUnlabeledMarkerData() but client was not connected!");
        }
    }    
    
    /**
     * Return the number of unlabeled markers in the data stream. 
     * 
     * This information can be used in conjunction with GetGlobalUnlabeledMarkerTranslation.<p>
     * 
     * @return  The number of unlabeled markers.
     */
    public long getUnlabeledMarkerCount(){
        Output_GetUnlabeledMarkerCount result = client.GetUnlabeledMarkerCount();
        System.out.println("Get unlabeled marker count: "+result.getResult().toString());
        if (result.getResult() == Result_Enum.NoFrame) throw new RuntimeException("getUnlabeledMarkerCount() invoked but no frame available!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getUnlabeledMarkerCount() but client is not connected!!");
        return result.getMarkerCount();
    }
    
    public double[] getUnlabeledMarkerGlobalTranslation(long markerIndex){
        Output_GetUnlabeledMarkerGlobalTranslation result =
                    client.GetUnlabeledMarkerGlobalTranslation(markerIndex);
        System.out.println("Get unlabeled marker global translation: "+result.getResult().toString());
        return result.getTranslation();
    }
    
    /**
     * Return the number of subjects in the DataStream. 
     * 
     * This information can be used in conjunction with GetSubjectName.<p>
     * 
     * See Also : GetSubjectName<p>
     * 
     * @return subject count >=0
     * @throws RuntimeException if no frame available.
     * 
     */
    public long getSubjectCount(){
        Output_GetSubjectCount result = client.GetSubjectCount();
        //System.out.println("Get subject count: "+result.getResult().toString());
        if (result.getResult() == Result_Enum.NoFrame) throw new RuntimeException("getSubjectCount() invoked but no frame available!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getSubjectCount() but client is not connected!!");
        return result.getSubjectCount();
    }
    
    /**
     * Return the name of a subject. 
     * 
     * This can be passed into segment and marker functions.<p>
     * 
     * See Also : GetSubjectCount<p>
     * 
     * @param subjectIndex between 0 and getSubjectCount()-1
     * @return The name of the subject.
     * @throw new RuntimeException if subject index is invalid.
     * @throw IllegalArgumentException, if subjectIndex <0
     */
    public String getSubjectName(long subjectIndex){
        if (subjectIndex <0) throw new IllegalArgumentException("getSubjectName() subjectIndex >=0 is needed!");
        System.out.println("test1");
        Output_GetSubjectName result = client.GetSubjectName(subjectIndex);
        System.out.println("test2");
        if (result.getResult() == Result_Enum.InvalidIndex) throw new RuntimeException("getSubjectName() but subjectIndex is invalid!");
        if (result.getResult() == Result_Enum.NoFrame) 
             throw new RuntimeException("getSubjectName() but no frame available!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getSubjectName() but client is not connected!!");
        String SubjectName = result.getSubjectName().toString();
        //System.out.println("Get subject name: "+result.getResult().toString());
        return SubjectName;
    }
    
    /**
     * Return the number of segments for a specified subject in the DataStream. 
     * 
     * This information can be used in conjunction with GetSegmentName<p>
     * 
     * See Also : GetSubjectName, GetSegmentName<p>
     * 
     * @param subjectName
     * @return segment count
     * @throws RuntimeException if subjectName is invalid, client is not connected or no frame available.
     */
    public long getSegmentCount(String subjectName){
        Output_GetSegmentCount result = client.GetSegmentCount(new CString(subjectName));
        if (result.getResult() == Result_Enum.InvalidSubjectName) 
             throw new RuntimeException("getSegmentCount() but subjectName \""+subjectName+"\" is invalid!");
        if (result.getResult() == Result_Enum.NoFrame) 
             throw new RuntimeException("getSegmentCount() but no frame available!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getSegmentCount() but client is not connected!!");
        System.out.println("Get segment count: "+result.getResult().toString());
        return result.getSegmentCount();
    }
    
    /**
     * Return the name of a subject segment specified by index.
     * 
     * See Also : GetSegmentCount, GetSegmentChildCount, GetSegmentChildName, 
     * GetSubjectRootSegmentName<p>
     * 
     * @param subjectName The name of the subject.
     * @param segmentIndex The index of the segment.
     * @return The name of the parent segment of an empty string if it is the root segment.
     * @throws RuntimeException if the client is not connected, the subjectName is not valid,
     * the segment index is invalid or if no frame available
     */
    public String getSegmentName(String subjectName, long segmentIndex){    
        Output_GetSegmentName result = client.GetSegmentName(new CString(subjectName), segmentIndex);
        if (result.getResult() == Result_Enum.InvalidSubjectName) 
             throw new RuntimeException("getSegmentName() but subjectName \""+subjectName+"\" is invalid!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getSegmentName() but client is not connected!!");
        if (result.getResult() == Result_Enum.NoFrame) 
             throw new RuntimeException("getSegmentName() but no frame available!");
        if (result.getResult() == Result_Enum.InvalidIndex) 
             throw new RuntimeException("getSegmentName() but segmentIndex \""+segmentIndex+"\" is invalid!");
        String SegmentName = result.getSegmentName().toString();
        //System.out.println("Get segment name: "+SegmentName);
        return SegmentName;
    }
       
    /**
     * Return the number of markers for a specified subject in the DataStream. 
     * 
     * This information can be used in conjunction with GetMarkerName<p>
     * 
     * See Also : GetSubjectName, GetMarkerName<p>
     * 
     * @param subjectName The name of the subject
     * @return The number of markers
     */
    public long getMarkerCount(String subjectName){
        Output_GetMarkerCount result = client.GetMarkerCount(new CString(subjectName));
        if (result.getResult() == Result_Enum.InvalidSubjectName) 
             throw new RuntimeException("getMarkerCount() but segmentName \""+subjectName+"\" is invalid!");
        if (result.getResult() == Result_Enum.NotConnected) 
             throw new RuntimeException("getMarkerCount() but client is not connected!!");
        if (result.getResult() == Result_Enum.NoFrame) 
             throw new RuntimeException("getMarkerCount() but no frame available!");
        //System.out.println("Get marker count: "+result.getResult().toString());
        return result.getMarkerCount();
    }
    /**
     * Return the name of a marker for a specified subject. 
     * 
     * This can be passed into GetMarkerGlobalTranslation.<p>
     * 
     * See Also : GetMarkerCount, GetMarkerGlobalTranslation<p>
     * 
     * @param subjectName the name of the subject.
     * @param markerIndex The index of the marker.
     * @return The name of the marker.
     */
    public String getMarkerName(String subjectName, long markerIndex){
        Output_GetMarkerName result = client.GetMarkerName(new CString(subjectName), markerIndex);
        //System.out.println("Get marker name: "+result.getResult().toString());
        if (result.getResult() == Result_Enum.NotConnected) throw new RuntimeException("getMarkerName() but client not connected!");
        if (result.getResult() == Result_Enum.NoFrame) throw new RuntimeException("getMarkerName() but no frame available!");
        if (result.getResult() == Result_Enum.InvalidSubjectName) throw new RuntimeException("getMarkerName() but invalid subject name \""+subjectName+"\"!");
        if (result.getResult() == Result_Enum.InvalidIndex) throw new RuntimeException("getMarkerName() but invalid marker index \""+markerIndex+"\"!");
        return result.getMarkerName().toString();
    }
    
    /**
     * Return the number of the last frame retrieved from the DataStream.
     * 
     * See Also : GetFrame, GetTimecode<p>
     * 
     * @return number of the last frame.
     * @throws RuntimeException if client not connected or no frame available.
     */
    public long getFrameNumber(){
        Output_GetFrameNumber frameNumber = client.GetFrameNumber();
        //System.out.println("Get frame number: "+frameNumber.getResult().toString());
        if (frameNumber.getResult() == Result_Enum.NotConnected) throw new RuntimeException("get frame number but client not connected!");
        if (frameNumber.getResult() == Result_Enum.NoFrame) throw new RuntimeException("get frame number but no frame available!");
        return frameNumber.getFrameNumber();
    }
        
    public TimeCode getTimeCode(){
        return new TimeCode(client.GetTimecode());
    }
    /**
     * Request a new frame to be fetched from the Vicon DataStream Server.
     * 
     * TODO eventuell timeout als argument mitübergeben?<p>
     * 
     * @param waiting
     * @return false if client is not connected.
     * 
     * See Also : SetStreamMode
     */
    public boolean getFrame(boolean waiting){
        Result_Enum result = client.GetFrame().getResult();
        if (waiting){
            while(result != Result_Enum.Success){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViconDataStreamSDKClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                result = client.GetFrame().getResult();
            }
            return true;
        } else {
            if (result == Result_Enum.Success){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get segment local rotation matrix.
     * 
     * @param subjectName The name of the subject
     * @param segmentName The name of the segment.
     * @return The translation of a subject segment in local co-ordinates relative 
     * to its parent segment.<p>
     * 
     * See Also : GetSegmentLocalRotationHelical, GetSegmentLocalRotationMatrix, 
     * GetSegmentLocalRotationQuaternion, GetSegmentLocalRotationEulerXYZ, 
     * GetSegmentGlobalTranslation,GetSegmentGlobalRotationHelical, 
     * GetSegmentGlobalRotationMatrix, GetSegmentGlobalRotationQuaternion, 
     * GetSegmentGlobalRotationEulerXYZ
     */
    public double[] getSegmentLocalRotationMatrix(String subjectName, String segmentName){
        Output_GetSegmentLocalRotationMatrix result = 
            client.GetSegmentLocalRotationMatrix(new CString(subjectName), new CString(segmentName));
        System.out.println("Get segment local rotation matrix: "+result.getResult().toString());
        if (result.getResult() == Result_Enum.NotConnected) throw new RuntimeException("getSegmentLocalRotationMatrix() but client not connected!");
        if (result.getResult() == Result_Enum.NoFrame) throw new RuntimeException("getSegmentLocalRotationMatrix() but no frame available!");
        if (result.getResult() == Result_Enum.InvalidSubjectName) throw new RuntimeException("getSegmentLocalRotationMatrix() but invalid subject name \""+subjectName+"\"!");
        if (result.getResult() == Result_Enum.InvalidSegmentName) throw new RuntimeException("getSegmentLocalRotationMatrix() but invalid segment name \""+segmentName+"\"!");
       
        if (result.getOccluded()) {
            return new double[]{Double.NaN, Double.NaN, Double.NaN};
        }   
        return result.getRotation();
    }
    
    /**
     * Return the translation of a subject marker in global co-ordinates.
     * 
     * The Translation is of the form ( x, y, z ) where x, y & z are in Millimeters 
     * with respect to the global origin.<p>
     * 
     * See Also : GetMarkerName<p>
     * 
     * @param subjectName
     * @param markerName
     * @return The translation of the marker as a 3d vector, [NaN, NaN, NaN] if the marker is occluded.
     * @throws RuntimeException if client not connected, no frame available, invalid subject name
     * or invalid marker name.
     */
    public double[] getMarkerGlobalTranslation(String subjectName, String markerName){
        Output_GetMarkerGlobalTranslation result = client.GetMarkerGlobalTranslation(new CString(subjectName), new CString(markerName));
        if (result.getResult() == Result_Enum.NotConnected) throw new RuntimeException("getMarkerGlobalTranslation() but client not connected!");
        if (result.getResult() == Result_Enum.NoFrame) throw new RuntimeException("getMarkerGlobalTranslation() but no frame available!");
        if (result.getResult() == Result_Enum.InvalidSubjectName) throw new RuntimeException("getMarkerGlobalTranslation() but invalid subject name \""+subjectName+"\"!");
        if (result.getResult() == Result_Enum.InvalidMarkerName) throw new RuntimeException("getMarkerGlobalTranslation() but invalid marker name \""+markerName+"\"!");
        if (result.getOccluded()){
            return new double[]{Double.NaN, Double.NaN, Double.NaN};
        }
        return result.getTranslation();
    }
}
