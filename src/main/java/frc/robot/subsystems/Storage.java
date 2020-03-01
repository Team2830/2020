/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.StorageConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

public class Storage extends SubsystemBase {
  /**
   * Creates a new Storage.
   */
  private final Spark storageLeft = new Spark(StorageConstants.kStorageLeft);
  private final Spark storageRight = new Spark(StorageConstants.kStorageRight);
  private final DigitalInput intakeInput = new DigitalInput(StorageConstants.kPhotoEye1);
  private final DigitalInput shooterInput = new DigitalInput(StorageConstants.kPhotoEye2);

   public Storage() {
    
  }

  /**
   * This moves the ball further into the storage system
   */
  public void turnIn(){
    storageRight.set(-1);
    storageLeft.set(-1);
  }

  /**
   * This moves the ball out of the storage system
   */
  public void turnOut(){
    storageRight.set(1);
    storageLeft.set(1);
  }

  /**
   * This is for PhotoEyes to know where the ball is to make sure that we can shoot the ball
   */
  public void ballAtShooter(){
    shooterInput.get();
  }

  /**
   * This is for PhotoEyes to know where the ball is so we can continue moving the ball into the storage system
   */
  public void ballAtIntake(){
    intakeInput.get();
  }

  public void storageStop(){
    storageRight.stopMotor();
    storageLeft.stopMotor();
  }

}
