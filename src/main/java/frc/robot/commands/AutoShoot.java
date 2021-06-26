// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class AutoShoot extends CommandBase {
  private final Shooter m_Shooter;
  private final Storage m_storage;
  
  /** Creates a new AutoShoot. */
  public AutoShoot(Shooter shooter, Storage storage) {
    m_Shooter = shooter;
    m_storage = storage;
 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Shooter);
    addRequirements(m_storage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Shooter.runShooter(.45,.75);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooter.runShooter(.45,.75);
    m_storage.turnIn();
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