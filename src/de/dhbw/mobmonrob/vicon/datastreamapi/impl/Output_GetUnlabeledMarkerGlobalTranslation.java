/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetUnlabeledMarkerGlobalTranslation {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetUnlabeledMarkerGlobalTranslation(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetUnlabeledMarkerGlobalTranslation obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetUnlabeledMarkerGlobalTranslation(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetUnlabeledMarkerGlobalTranslation_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetUnlabeledMarkerGlobalTranslation_Result_get(swigCPtr, this));
  }

  public void setTranslation(double[] value) {
    ViconDataStreamClientSDKJNI.Output_GetUnlabeledMarkerGlobalTranslation_Translation_set(swigCPtr, this, value);
  }

  public double[] getTranslation() {
    return ViconDataStreamClientSDKJNI.Output_GetUnlabeledMarkerGlobalTranslation_Translation_get(swigCPtr, this);
  }

  public Output_GetUnlabeledMarkerGlobalTranslation() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetUnlabeledMarkerGlobalTranslation(), true);
  }

}
