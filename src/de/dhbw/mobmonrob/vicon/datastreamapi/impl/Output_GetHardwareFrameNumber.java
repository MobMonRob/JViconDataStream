/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetHardwareFrameNumber {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetHardwareFrameNumber(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetHardwareFrameNumber obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetHardwareFrameNumber(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetHardwareFrameNumber_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetHardwareFrameNumber_Result_get(swigCPtr, this));
  }

  public void setHardwareFrameNumber(long value) {
    ViconDataStreamClientSDKJNI.Output_GetHardwareFrameNumber_HardwareFrameNumber_set(swigCPtr, this, value);
  }

  public long getHardwareFrameNumber() {
    return ViconDataStreamClientSDKJNI.Output_GetHardwareFrameNumber_HardwareFrameNumber_get(swigCPtr, this);
  }

  public Output_GetHardwareFrameNumber() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetHardwareFrameNumber(), true);
  }

}
