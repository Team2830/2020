/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import io.github.oblarg.oblog.Logger;

/**
 * The VM is configured to automatically run this class, and to call thefunctions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package aftercreating this project, you must also update the build.gradnle 
 * file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  
  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  m_robotContainer = new RobotContainer();
  Logger.configureLoggingAndConfig(m_robotContainer, false);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    Logger.updateEntries();

    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousInit(){
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
   
  // schedule the autonomous command (example)
   if (m_autonomousCommand != null) {
     m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void autonomousPeriodic() {
  }
 
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void teleopInit() {
  if (m_autonomousCommand !=null){
    m_autonomousCommand.cancel();
  }
}
  
  @Override
  public void teleopPeriodic() {
    m_robotContainer.shuffleBoard();
}

  @Override
  public void testInit() {
  CommandScheduler.getInstance().cancelAll();
}

  @Override
  public void testPeriodic() {
}

}