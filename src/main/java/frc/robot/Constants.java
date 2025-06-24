// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final double JOYSTICK_DEADBAND = .075;
  }

  // Motor controller IDs
  public static final int LEFT_LEAD_MOTOR_ID = 1;
  public static final int LEFT_FOLLOW_MOTOR_ID = 2;
  public static final int RIGHT_LEAD_MOTOR_ID = 3;
  public static final int RIGHT_FOLLOW_MOTOR_ID = 4;

  // Drivetrain constants
  public static final double LEFT_DRIVE_VELOCITY = 1.0;
  public static final double RIGHT_DRIVE_VELOCITY = 1.0;
  public static final double LEFT_SLOW_VELOCITY = .6;
  public static final double RIGHT_SLOW_VELOCITY = .6;

  public static final InvertedValue LEFT_DRIVE_INVERT_DIRECTION = InvertedValue.Clockwise_Positive;
  public static final InvertedValue RIGHT_DRIVE_INVERT_DIRECTION = InvertedValue.CounterClockwise_Positive;
}
