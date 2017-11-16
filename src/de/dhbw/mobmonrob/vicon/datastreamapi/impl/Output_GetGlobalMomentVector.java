/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetGlobalMomentVector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetGlobalMomentVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetGlobalMomentVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetGlobalMomentVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetGlobalMomentVector_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetGlobalMomentVector_Result_get(swigCPtr, this));
  }

  public void setMomentVector(double[] value) {
    ViconDataStreamClientSDKJNI.Output_GetGlobalMomentVector_MomentVector_set(swigCPtr, this, value);
  }

  public double[] getMomentVector() {
    return ViconDataStreamClientSDKJNI.Output_GetGlobalMomentVector_MomentVector_get(swigCPtr, this);
  }

  public Output_GetGlobalMomentVector() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetGlobalMomentVector(), true);
  }

}
