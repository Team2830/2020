/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;

public class AdvanceStorageToShooter extends CommandBase {  
  private final Storage m_storage;
  /**
   * Creates a new AdvanceToShooter.
   */
  public AdvanceStorageToShooter(Storage storage) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_storage = storage;
    addRequirements(storage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_storage.isBallAtShooter()){
      m_storage.storageStop();
    }else{
      m_storage.turnIn();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_storage.storageStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
