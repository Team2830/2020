/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */ 
static VictorSPX shooterOutsideLeft = new VictorSPX(0);
static TalonSRX shooterInsideLeft = new TalonSRX(1);
static VictorSPX shooterOutsideRight = new VictorSPX(2);
static TalonSRX shooterInsideRight = new TalonSRX(3);
private final DoubleSolenoid shooterSolenoid = new DoubleSolenoid(4, 5);

public Shooter (){
  shooterOutsideLeft.follow(shooterInsideLeft);
  shooterOutsideRight.follow(shooterInsideRight);
  //This has the Victors follow the Talons
}
  /**
   * This raises the shooter
   */
  public void up() {
    shooterSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  /**
   * This lowers the shooter
   */
  public void down() {
    shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /**
   * This will have the motors run full speed
   **/
  public void runShooter() {
    shooterInsideLeft.set(ControlMode.PercentOutput, 1);
    shooterInsideRight.set(ControlMode.PercentOutput,1);
  }

  /**
   * This will have the motors run at a specific speed
   * @param speed
   */
  public void runShooter(Double speed){
    shooterInsideLeft.set(ControlMode.PercentOutput, speed);
    shooterInsideRight.set(ControlMode.PercentOutput, speed);
  }

  public void stopShooter(){
    shooterInsideLeft.set(ControlMode.PercentOutput, 0);
    shooterInsideRight.set(ControlMode.PercentOutput, 0);
  }
}
