/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_EnableUnlabeledMarkerData extends Output_SimpleResult {
  private transient long swigCPtr;

  protected Output_EnableUnlabeledMarkerData(long cPtr, boolean cMemoryOwn) {
    super(ViconDataStreamClientSDKJNI.Output_EnableUnlabeledMarkerData_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_EnableUnlabeledMarkerData obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_EnableUnlabeledMarkerData(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public Output_EnableUnlabeledMarkerData() {
    this(ViconDataStreamClientSDKJNI.new_Output_EnableUnlabeledMarkerData(), true);
  }

}
