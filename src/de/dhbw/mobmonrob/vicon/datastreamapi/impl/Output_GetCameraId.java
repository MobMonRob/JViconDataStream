/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetCameraId {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetCameraId(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetCameraId obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetCameraId(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetCameraId_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetCameraId_Result_get(swigCPtr, this));
  }

  public void setCameraId(long value) {
    ViconDataStreamClientSDKJNI.Output_GetCameraId_CameraId_set(swigCPtr, this, value);
  }

  public long getCameraId() {
    return ViconDataStreamClientSDKJNI.Output_GetCameraId_CameraId_get(swigCPtr, this);
  }

  public Output_GetCameraId() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetCameraId(), true);
  }

}