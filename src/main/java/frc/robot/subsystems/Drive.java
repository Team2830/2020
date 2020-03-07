/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants;

import java.util.function.DoubleSupplier;

public class Drive extends SubsystemBase {
  final WPI_TalonFX m_frontLeftMotor = new WPI_TalonFX(DriveConstants.kLeftMotorFrontPort);
  final WPI_TalonFX m_rearLeftMotor = new WPI_TalonFX(DriveConstants.kLeftMotorRearPort);
  final WPI_TalonFX m_frontRightMotor = new WPI_TalonFX(DriveConstants.kRightMotorFrontPort);
  final WPI_TalonFX m_rearRightMotor = new WPI_TalonFX(DriveConstants.kRightMotorRearPort);
  // final AHRS m_gyroscope = new AHRS(SPI.Port.kMXP);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);

  public void teleopInit() {

 
  }


 /**
   * Creates a new drive.
   */
  public Drive() {
    m_rearLeftMotor.follow(m_frontLeftMotor);
    m_rearRightMotor.follow(m_frontRightMotor);
    m_robotDrive.setRightSideInverted(true);
  
  }

  public void drive(double rightThrottle, double leftThrottle, double rotation) {
    m_robotDrive.arcadeDrive(rightThrottle-leftThrottle, rotation);
    }

  public void driveTank(double d, double e){
    m_robotDrive.tankDrive(d, e);
  }

  public void vision() {

  }

  public void tank(double left, double right){
    m_frontLeftMotor.set(left);
    m_frontRightMotor.set(right);
  }
  
  public void stopDrive(){
    this.tank(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}