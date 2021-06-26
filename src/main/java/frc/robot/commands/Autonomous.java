/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;

/**
 * The main autonomous command to pickup and deliver the soda to the box.
 */
public class Autonomous extends CommandBase {
  private final Drive m_drive;
  private double m_angle = 0;
  private double m_timer = 0;
    /**
     * Create a new autonomous command.
     */
  public Autonomous(Drive drive) {

      addRequirements(drive);
      m_drive = drive;
      

  }
   // Called when the command is initially scheduled.
   @Override
   public void initialize() {
     m_timer = Timer.getFPGATimestamp();
     m_angle = m_drive.getAngle();

   }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.driveTank(.4, .4);
   // m_drive.driveCorrection(m_angle,.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if ((Timer.getFPGATimestamp() - m_timer) < 4) {
      return false;
    } else {
      return true;
    }
  }
 
}
