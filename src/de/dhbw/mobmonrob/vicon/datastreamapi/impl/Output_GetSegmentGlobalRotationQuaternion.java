/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetSegmentGlobalRotationQuaternion {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetSegmentGlobalRotationQuaternion(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetSegmentGlobalRotationQuaternion obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetSegmentGlobalRotationQuaternion(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Result_get(swigCPtr, this));
  }

  public void setRotation(double[] value) {
    ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Rotation_set(swigCPtr, this, value);
  }

  public double[] getRotation() {
    return ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Rotation_get(swigCPtr, this);
  }

  public void setOccluded(boolean value) {
    ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Occluded_set(swigCPtr, this, value);
  }

  public boolean getOccluded() {
    return ViconDataStreamClientSDKJNI.Output_GetSegmentGlobalRotationQuaternion_Occluded_get(swigCPtr, this);
  }

  public Output_GetSegmentGlobalRotationQuaternion() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetSegmentGlobalRotationQuaternion(), true);
  }

}