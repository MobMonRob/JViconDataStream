/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_EnabledFlag {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_EnabledFlag(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_EnabledFlag obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_EnabledFlag(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEnabled(boolean value) {
    ViconDataStreamClientSDKJNI.Output_EnabledFlag_Enabled_set(swigCPtr, this, value);
  }

  public boolean getEnabled() {
    return ViconDataStreamClientSDKJNI.Output_EnabledFlag_Enabled_get(swigCPtr, this);
  }

  public Output_EnabledFlag() {
    this(ViconDataStreamClientSDKJNI.new_Output_EnabledFlag(), true);
  }

}
