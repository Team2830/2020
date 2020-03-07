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
import static frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private final Spark intake = new Spark(IntakeConstants.kIntakeMotor);
  private final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(IntakeConstants.kIntakeSolenoid1, IntakeConstants.kIntakeSolenooid2);

   public Intake() {
     intake.setInverted(true);
  }

  /**
   * This moves the intake mechanism up, towards the robot
   */
  public void moveUp () {
    intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    //moveUp = true;
  }
  
  /**
   * This moves the intake mechanism down, towards the floor
   */
  public void moveDown () {
    intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    //moveUp = false;
  }

  /**
   * This moves the motors so the ball goes into the robot at full speed
   */
  public void rotateIn() {
    intake.set(-1);
  }

  /**
   * This moves the motors so the ball goes out of the robot at full speed
   */
  public void rotateOut() {
    intake.set(1);
  }

  /**
   * This stops the motors from moving
   */
  public void rotateStop () {
    intake.stopMotor();
  }

  /**
   * This moves the motors so the ball goes into the robot at a specific speed
   * @param speed
   */
  public void rotateIn(Double speed){
    intake.set(speed);
  }

  /**
   * This moves the motors so the ball goes out of the robot at a specific speed
   * @param speed
   */
  public void rotateOut(Double speed){
    intake.set(speed);
  }
}
