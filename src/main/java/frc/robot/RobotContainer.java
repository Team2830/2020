package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class RobotContainer {
  private final Drive m_drive = new Drive();
  private final Intake m_intake = new Intake();
  private final Storage m_storage = new Storage();
  private final Shooter m_shooter = new Shooter();
  private final Climber m_climber = new Climber();

  private final PowerDistributionPanel pdp = new PowerDistributionPanel();
  private final XboxController driverController = new XboxController(0);
  private final XboxController operatorContoller = new XboxController(1);
  private final CommandBase m_autonomousCommand = new Autonomous(m_drive).withTimeout(5);

public RobotContainer() {
    configureButtonBindings();
    m_drive.setDefaultCommand(new ArcadeDrive(() -> driverController.getTriggerAxis(GenericHID.Hand.kLeft),
      () -> driverController.getTriggerAxis(GenericHID.Hand.kRight), m_drive));
}

public <Button> void configureButtonBindings() {
  final JoystickButton a = new JoystickButton(operatorContoller, XboxController.Button.kA.value);
  final JoystickButton b = new JoystickButton(operatorContoller, XboxController.Button.kB.value);
  final JoystickButton x = new JoystickButton(operatorContoller, XboxController.Button.kX.value);
  final JoystickButton y = new JoystickButton(operatorContoller, XboxController.Button.kY.value);

  a.whenPressed(new Autonomous(m_drive).withTimeout(5));
  b.whenPressed(new Autonomous(m_drive).withTimeout(5));
  x.whenPressed(new Autonomous(m_drive).withTimeout(5));
  y.whenPressed(new Autonomous(m_drive).withTimeout(5));
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommand;
  }

}