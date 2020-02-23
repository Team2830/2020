/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase {
  final WPI_TalonFX m_frontLeftMotor = new WPI_TalonFX(DriveConstants.kLeftMotorFrontPort);
  final WPI_TalonFX m_rearLeftMotor = new WPI_TalonFX(DriveConstants.kLeftMotorRearPort);
  final WPI_TalonFX m_frontRightMotor = new WPI_TalonFX(DriveConstants.kRightMotorFrontPort);
  final WPI_TalonFX m_rearRightMotor = new WPI_TalonFX(DriveConstants.kRightMotorRearPort);
  // final AHRS m_gyroscope = new AHRS(SPI.Port.kMXP);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);

  // driverController = new XboxController(0);

  public void teleopInit() {

    m_rearLeftMotor.follow(m_frontLeftMotor);
    m_rearRightMotor.follow(m_frontRightMotor);
  }


 /**
   * Creates a new drive.
   */
  public Drive() {
  
  }

  public void drive(double throttle, double speed) {
    m_robotDrive.arcadeDrive(throttle, speed);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}