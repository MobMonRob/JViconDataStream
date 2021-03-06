/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetAxisMapping {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetAxisMapping(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetAxisMapping obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetAxisMapping(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setXAxis(Direction_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetAxisMapping_XAxis_set(swigCPtr, this, value.swigValue());
  }

  public Direction_Enum getXAxis() {
    return Direction_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetAxisMapping_XAxis_get(swigCPtr, this));
  }

  public void setYAxis(Direction_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetAxisMapping_YAxis_set(swigCPtr, this, value.swigValue());
  }

  public Direction_Enum getYAxis() {
    return Direction_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetAxisMapping_YAxis_get(swigCPtr, this));
  }

  public void setZAxis(Direction_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetAxisMapping_ZAxis_set(swigCPtr, this, value.swigValue());
  }

  public Direction_Enum getZAxis() {
    return Direction_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetAxisMapping_ZAxis_get(swigCPtr, this));
  }

  public Output_GetAxisMapping() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetAxisMapping(), true);
  }

}
