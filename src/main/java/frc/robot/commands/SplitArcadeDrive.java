/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import frc.robot.subsystems.Drive;

public class SplitArcadeDrive extends CommandBase {
  private final Drive m_drive;
  private final DoubleSupplier m_leftThrottle;
  private final DoubleSupplier m_rightThrottle;
  private  final DoubleSupplier m_rotation;
  /**
   * Creates a new ArcadeDrive.
   */
  public SplitArcadeDrive(DoubleSupplier leftThrottle, DoubleSupplier rightThrottle, DoubleSupplier rotation, Drive drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_rightThrottle = rightThrottle;
    m_leftThrottle = leftThrottle;
    m_rotation = rotation;
    addRequirements(m_drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drive(m_leftThrottle.getAsDouble(), m_rightThrottle.getAsDouble(), m_rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // runs untill interrupted
  }
}


