/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetVersion {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetVersion(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetVersion obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetVersion(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMajor(long value) {
    ViconDataStreamClientSDKJNI.Output_GetVersion_Major_set(swigCPtr, this, value);
  }

  public long getMajor() {
    return ViconDataStreamClientSDKJNI.Output_GetVersion_Major_get(swigCPtr, this);
  }

  public void setMinor(long value) {
    ViconDataStreamClientSDKJNI.Output_GetVersion_Minor_set(swigCPtr, this, value);
  }

  public long getMinor() {
    return ViconDataStreamClientSDKJNI.Output_GetVersion_Minor_get(swigCPtr, this);
  }

  public void setPoint(long value) {
    ViconDataStreamClientSDKJNI.Output_GetVersion_Point_set(swigCPtr, this, value);
  }

  public long getPoint() {
    return ViconDataStreamClientSDKJNI.Output_GetVersion_Point_get(swigCPtr, this);
  }

  public Output_GetVersion() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetVersion(), true);
  }

}
