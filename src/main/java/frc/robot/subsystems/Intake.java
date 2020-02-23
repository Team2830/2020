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

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private final Spark intake = new Spark(0);
  private final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(0, 1);
   public Intake() {

  }
  public void moveUp () {
  }
  
  public void moveDown () {
  }

  public void rotateIn () {
  }

  public void rotateOut () {
  }

  public void rotateStop () {
  }
}
