/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public class Output_GetGreyscaleBlob {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Output_GetGreyscaleBlob(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Output_GetGreyscaleBlob obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ViconDataStreamClientSDKJNI.delete_Output_GetGreyscaleBlob(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setResult(Result_Enum value) {
    ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_Result_set(swigCPtr, this, value.swigValue());
  }

  public Result_Enum getResult() {
    return Result_Enum.swigToEnum(ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_Result_get(swigCPtr, this));
  }

  public void setBlobLinePositionsX(SWIGTYPE_p_std__vectorT_unsigned_int_t value) {
    ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePositionsX_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_unsigned_int_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_unsigned_int_t getBlobLinePositionsX() {
    return new SWIGTYPE_p_std__vectorT_unsigned_int_t(ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePositionsX_get(swigCPtr, this), true);
  }

  public void setBlobLinePositionsY(SWIGTYPE_p_std__vectorT_unsigned_int_t value) {
    ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePositionsY_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_unsigned_int_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_unsigned_int_t getBlobLinePositionsY() {
    return new SWIGTYPE_p_std__vectorT_unsigned_int_t(ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePositionsY_get(swigCPtr, this), true);
  }

  public void setBlobLinePixelValues(SWIGTYPE_p_std__vectorT_std__vectorT_unsigned_char_t_t value) {
    ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePixelValues_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_std__vectorT_unsigned_char_t_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_std__vectorT_unsigned_char_t_t getBlobLinePixelValues() {
    return new SWIGTYPE_p_std__vectorT_std__vectorT_unsigned_char_t_t(ViconDataStreamClientSDKJNI.Output_GetGreyscaleBlob_BlobLinePixelValues_get(swigCPtr, this), true);
  }

  public Output_GetGreyscaleBlob() {
    this(ViconDataStreamClientSDKJNI.new_Output_GetGreyscaleBlob(), true);
  }

}
