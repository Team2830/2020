/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;

import static frc.robot.Constants.ClimberConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;

public class Climber extends SubsystemBase implements Loggable {
  /**
   * Creates a new Climber.
   */
  static Spark climberLeft = new Spark(ClimberConstants.kClimberMotorLeft);
  static Spark climberRight = new Spark(ClimberConstants.kClimberMotorRight);
  private final DoubleSolenoid climberSolenoid = new DoubleSolenoid(ClimberConstants.kClimberSolenoid1, ClimberConstants.kClimberSolenoid2);

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
