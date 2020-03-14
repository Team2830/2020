/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

import static frc.robot.Constants.StorageConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Storage extends SubsystemBase implements Loggable {
  /**
   * Creates a new Storage.
   */
  @Log.SpeedController
  private final Spark storageLeft = new Spark(StorageConstants.kStorageLeft);
  @Log.SpeedController
  private final Spark storageRight = new Spark(StorageConstants.kStorageRight);
  private final AnalogInput intakeInput = new AnalogInput(StorageConstants.kPhotoEye1);
  private final AnalogInput shooterInput = new AnalogInput(StorageConstants.kPhotoEye2);
  private  double m_outputCount = 0;

   public Storage() {
    storageLeft.setInverted(true);
    storageRight.setInverted(true);
    AnalogInput.setGlobalSampleRate(50);
  }

  /**
   * This moves the ball further into the storage system
   */
  @Config
  public void turnIn(){
    storageRight.set(-1);
    storageLeft.set(-1);
  }

  /**
   * This moves the ball out of the storage system
   */
  @Config
  public void turnOut(){
    storageRight.set(1);
    storageLeft.set(1);
  }

  /**
   * This is for PhotoEyes to know where the ball is to make sure that we can shoot the ball
   */
  public boolean isBallAtShooter(){
    return shooterInput.getVoltage()<.55;
  }
@Config
  public void storageStop(){
    storageRight.stopMotor();
    storageLeft.stopMotor();
  }

  public boolean isBallAtIntake(){
    return intakeInput.getVoltage()<.55;
  }

  public void periodic(){
    SmartDashboard.putData(intakeInput);
    SmartDashboard.putNumber("intakeInputValue", intakeInput.getValue());
    SmartDashboard.putNumber("intakeInputVoltage", intakeInput.getVoltage());
    SmartDashboard.putBoolean("isBallAtIntake", isBallAtIntake());
    SmartDashboard.putNumber("CurrentCount", m_outputCount++ );
  }
}
