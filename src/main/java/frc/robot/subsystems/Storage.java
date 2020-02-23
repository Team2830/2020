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

public class Storage extends SubsystemBase {
  /**
   * Creates a new Storage.
   */
  private final Spark storageLeft = new Spark(1);
  private final Spark storageRight = new Spark(2);
  private final DoubleSolenoid flapperSolenoid = new DoubleSolenoid(2, 3);
   public Storage() {

  }

  @Override
  public void() {
  
}
