/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class StartUpShooter extends CommandBase {
  private final Shooter m_Shooter;
  private final Double m_frontSpeed;
  private final Double m_backSpeed;

  /**
   * Creates a new Shoot.
   */
  public StartUpShooter(double front, double back, Shooter shooter) {
    m_Shooter = shooter;
    m_frontSpeed = front;
    m_backSpeed = back;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     m_Shooter.runShooter();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_Shooter.runShooter(SmartDashboard.getNumber("Shooter Front", 0), SmartDashboard.getNumber("Shooter Back", 0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
