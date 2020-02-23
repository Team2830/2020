/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */ 
static TalonSRX shooterOutsideLeft = new TalonSRX(0);
static TalonSRX shooterInsideLeft = new TalonSRX(1);
static TalonSRX shooterOutsideRight = new TalonSRX(2);
static TalonSRX shooterInsideRight = new TalonSRX(3);
private final DoubleSolenoid shooterSolenoid = new DoubleSolenoid(4, 5);
   public Shooter() {

  }

  public void start() {
  }

  public void stop(){
  }

  public void up() {
  }

  public void down() {
  }
}
