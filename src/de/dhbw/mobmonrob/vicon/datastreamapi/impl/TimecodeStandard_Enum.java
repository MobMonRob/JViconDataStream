/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package de.dhbw.mobmonrob.vicon.datastreamapi.impl;

public final class TimecodeStandard_Enum {
  public final static TimecodeStandard_Enum None = new TimecodeStandard_Enum("None");
  public final static TimecodeStandard_Enum PAL = new TimecodeStandard_Enum("PAL");
  public final static TimecodeStandard_Enum NTSC = new TimecodeStandard_Enum("NTSC");
  public final static TimecodeStandard_Enum NTSCDrop = new TimecodeStandard_Enum("NTSCDrop");
  public final static TimecodeStandard_Enum Film = new TimecodeStandard_Enum("Film");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static TimecodeStandard_Enum swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + TimecodeStandard_Enum.class + " with value " + swigValue);
  }

  private TimecodeStandard_Enum(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private TimecodeStandard_Enum(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private TimecodeStandard_Enum(String swigName, TimecodeStandard_Enum swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static TimecodeStandard_Enum[] swigValues = { None, PAL, NTSC, NTSCDrop, Film };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

