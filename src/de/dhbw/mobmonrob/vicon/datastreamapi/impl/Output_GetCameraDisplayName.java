/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetCameraDisplayName {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetCameraDisplayName(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetCameraDisplayName obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetCameraDisplayName(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetCameraDisplayName_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetCameraDisplayName_Result_get(swigCPtr, this));
  }

  public void setCameraDisplayName(CString value) {
    ViconDataStreamClientSDKJNI.Output_GetCameraDisplayName_CameraDisplayName_set(swigCPtr, this, CString.getCPtr(value), value);
  }

  public CString getCameraDisplayName() {
    long cPtr = ViconDataStreamClientSDKJNI.Output_GetCameraDisplayName_CameraDisplayName_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CString(cPtr, false);
  }

  public Output_GetCameraDisplayName() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetCameraDisplayName(), true);
  }

}
