/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

import static frc.robot.Constants.DriveConstants;

import java.util.function.DoubleSupplier;

public class Drive extends SubsystemBase implements Loggable {
  private final WPI_TalonFX m_LeftMotor = new WPI_TalonFX(DriveConstants.kLeftMotorFrontPort);
  private final WPI_TalonFX m_LeftFollowerMotor = new WPI_TalonFX(DriveConstants.kLeftMotorRearPort);
  private final WPI_TalonFX m_RightMotor = new WPI_TalonFX(DriveConstants.kRightMotorFrontPort);
  private final WPI_TalonFX m_RightFollowerMotor = new WPI_TalonFX(DriveConstants.kRightMotorRearPort);
  @Log.Gyro
  private final AHRS m_gyroscope = new AHRS(SPI.Port.kMXP);

  @Log.DifferentialDrive
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_LeftMotor, m_RightMotor);

 /**
   * Creates a new drive.
   */
  public Drive() {

    m_RightMotor.configFactoryDefault();
    m_RightFollowerMotor.configFactoryDefault();
    m_LeftMotor.configFactoryDefault();
    m_LeftFollowerMotor.configFactoryDefault();
    
    m_LeftFollowerMotor.follow(m_LeftMotor);
    m_RightFollowerMotor.follow(m_RightMotor);

    m_RightMotor.setInverted(TalonFXInvertType.CounterClockwise);
    m_LeftMotor.setInverted(TalonFXInvertType.Clockwise);

    m_RightFollowerMotor.setInverted(InvertType.FollowMaster);
    m_LeftFollowerMotor.setInverted(InvertType.FollowMaster);

    m_robotDrive.setRightSideInverted(false);
  
  }

  public void drive(double rightThrottle, double leftThrottle, double rotation) {
     m_robotDrive.arcadeDrive(this.deadband(rightThrottle - leftThrottle), this.deadband(-rotation));
    }
    public double deadband(double value){
      //Upper Deadband//
      if (value >= +0.2)
        return value; 

      //Lower Deadband//
      if (value <= -0.2)
        return value;

      //Outside Deadband//
      return 0;
    }

  public void driveTank(double d, double e){
    m_robotDrive.tankDrive(d, e);
  }

  public void vision() {

  }

  @Config
  public void tank(double left, double right){
    m_LeftMotor.set(left);
    m_RightMotor.set(right);
  }
  
  public void stopDrive(){
    this.tank(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
@Log(name = "Left Encoder")
  public Double getLeftEncoderPosition(){
    return m_LeftMotor.getSelectedSensorPosition();
  }

  @Log(name = "Right Encoder")
  public Double getRightEncoderPosition(){
    return m_RightMotor.getSelectedSensorPosition();
  }
}