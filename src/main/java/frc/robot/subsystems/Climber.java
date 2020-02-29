/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  static Spark climberLeft = new Spark(3);
  static Spark climberRight = new Spark(4);
  static Spark climberSmall = new Spark(5);
  private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(6, 7);

  public Climber() {

}
/**
 * This elongates the elevator to hook onto the bar
 */
public void extend() {
  climberSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  
  /**
   * This shrinks the elevator to lift the robot
   */
  public void unextend() {
    climberSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
