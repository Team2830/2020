/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class ShooterShoot extends CommandBase {
  private final Shooter m_Shooter;
  private final Storage m_storage;
  /**
   * Creates a new ShooterShoot.
   */
  public ShooterShoot(Shooter shooter, Storage storage) {
    m_Shooter = shooter;
    m_storage = storage;
 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Shooter);
    addRequirements(m_storage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Shooter.runShooter();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_storage.turnIn();
    m_Shooter.runShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
