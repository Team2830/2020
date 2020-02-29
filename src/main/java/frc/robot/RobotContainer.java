package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.ShooterDown;
import frc.robot.commands.MoveShooterUp;
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

/**
 * This tells what buttons are being used for which commands
 */
public void configureButtonBindings() {

  final JoystickButton operatorA = new JoystickButton(operatorContoller, XboxController.Button.kA.value);
  final JoystickButton operatorB = new JoystickButton(operatorContoller, XboxController.Button.kB.value);
  final JoystickButton operatorX = new JoystickButton(operatorContoller, XboxController.Button.kX.value);
  final JoystickButton operatorY = new JoystickButton(operatorContoller, XboxController.Button.kY.value);
  final JoystickButton operatorRightBumper = new JoystickButton(operatorContoller, XboxController.Button.kBumperRight.value);
  final JoystickButton oepratorLeftBumper = new JoystickButton(operatorContoller, XboxController.Button.kBumperLeft.value);


  operatorA.whenPressed(new IntakeIn(m_intake));
  operatorB.whenPressed(new IntakeOut(m_intake));
  operatorX.whenPressed(new IntakeDown(m_intake));
  operatorY.whenPressed(new IntakeUp(m_intake));
  operatorRightBumper.whenPressed(new MoveShooterUp(m_shooter));
  oepratorLeftBumper.whenPressed(new ShooterDown(m_shooter));
}

public void shuffleBoard(){

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