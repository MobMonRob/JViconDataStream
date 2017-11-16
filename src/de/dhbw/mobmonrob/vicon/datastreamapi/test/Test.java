package de.dhbw.mobmonrob.vicon.datastreamapi.test;

import de.dhbw.mobmonrob.vicon.datastreamapi.api.Version;
import de.dhbw.mobmonrob.vicon.datastreamapi.api.ViconDataStreamSDKClient;

/**
 *
 * @author Oliver Rettig
 */
public class Test {

    public static void main(String argv[]) throws InterruptedException {
    
        ViconDataStreamSDKClient client = new ViconDataStreamSDKClient();
        
        String hostname = "127.0.0.2:801";
        hostname = "localhost";
        
        Version version = client.getVersion();
        System.out.println("Version: "+version.getMajor()+"."+version.getMinor()+"."+version.getPoint());
        
        System.out.println("Try to connect to: "+hostname);
        
        client.connect(hostname);
        
        client.enableMarkerData();
        //client.enableSegmentData();
        //client.enableUnlabeledMarkerData();
        
        client.getFrame(true);
        long frameNumber = client.getFrameNumber();
        System.out.println("frame "+frameNumber);
        
        //printSubjectHierarchie(client);
        
        /*for (int markerIndex = 0; markerIndex < client.getUnlabeledMarkerCount(); markerIndex++){
            double[] translation = client.getUnlabeledMarkerGlobalTranslation(markerIndex);
            //TODO
        }*/
        
        String subjectName = "50621_HAT";//54562";
        String markerName = "HATX";
        
        while(true){
            client.getFrame(true);
            
            
            // framenumber bestimmen
            frameNumber = client.getFrameNumber();
            
            try {
                double[] m = client.getMarkerGlobalTranslation(subjectName, markerName);
                if (m== null){
                    System.out.println("m==null");
                } else {
                    System.out.println("frame "+frameNumber+": x="+m[0]+" y="+m[1]+" z="+m[2]);
                }
            } catch (RuntimeException e){
                System.out.println(e);
            }
            // Count the number of markers
            //long markerCount = client.getMarkerCount(subjectName);
        
        }
        // Note: this invokes the virtual destructor
        // You could leave this to the garbage collector
        //client.delete();

        //System.out.println( "Goodbye" );
    }
    
    private static void printSubjectHierarchie(ViconDataStreamSDKClient client){
        long subjects = client.getSubjectCount();
        System.out.println("subjects "+subjects);
        for (long subjectIndex=0;subjectIndex<subjects;subjectIndex++){
            String SubjectName = client.getSubjectName(subjectIndex);
            System.out.println("Found subject: "+SubjectName);
            long segments = client.getSegmentCount(SubjectName);
            for (int segmentIndex=0;segmentIndex < segments;segmentIndex++){
                String SegmentName = client.getSegmentName(SubjectName, segmentIndex);
                System.out.println("   Found segment: "+SegmentName);
            }
            for (int markerIndex=0;markerIndex < client.getMarkerCount(SubjectName);markerIndex++){
                    String markerName = client.getMarkerName(SubjectName, markerIndex);
                    System.out.println("      Found marker: "+markerName);
            }
        }
    }
}