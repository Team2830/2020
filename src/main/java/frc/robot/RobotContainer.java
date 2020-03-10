package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.MoveShooterDown;
import frc.robot.commands.MoveShooterUp;
import frc.robot.commands.MoveUpStorage;
import frc.robot.commands.SplitArcadeDrive;
import frc.robot.commands.StartUpShooter;
import frc.robot.commands.StopShooter;
import frc.robot.commands.StopStorage;
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

 // private final PowerDistributionPanel pdp = new PowerDistributionPanel();
  private final XboxController driverController = new XboxController(0);
  private final XboxController operatorController = new XboxController(1);
  private final CommandBase m_autonomousCommand = new Autonomous(m_drive).withTimeout(5);

public RobotContainer() {
  SmartDashboard.putNumber("Shooter Front", 0);
  SmartDashboard.putNumber("Shooter Back", 0);
  SmartDashboard.putData("intake In", new InstantCommand(m_intake::rotateIn, m_intake));
  SmartDashboard.putData("intake Out", new InstantCommand(m_intake::rotateOut, m_intake));
  SmartDashboard.putData("intake Up", new InstantCommand(m_intake::moveUp, m_intake));
  SmartDashboard.putData("intake Down", new InstantCommand(m_intake::moveDown, m_intake));
  SmartDashboard.putData("intake Stop", new InstantCommand(m_intake::rotateStop, m_intake));
  SmartDashboard.putData("Move Shooter Up", new MoveShooterUp(m_shooter));
  SmartDashboard.putData("Move Shooter Down", new MoveShooterDown(m_shooter)); 
  //SmartDashboard.putData("Start Shooter", new InstantCommand(m_shooter::runShooter, m_shooter));
  SmartDashboard.putData("Start Shooter", new StartUpShooter(SmartDashboard.getNumber("Shooter Front", 0), SmartDashboard.getNumber("Shooter Back", 0), m_shooter));
  SmartDashboard.putData("Stop Shooter", new InstantCommand(m_shooter::stopShooter,m_shooter));
  SmartDashboard.putData("Turn In Storage", new InstantCommand(m_storage::turnIn, m_storage));
  SmartDashboard.putData("Stop Storage", new InstantCommand(m_storage::storageStop, m_storage));
  SmartDashboard.putData("intake Stop", new IntakeStop(m_intake));
  
  
  
  configureButtonBindings();
    m_drive.setDefaultCommand(new SplitArcadeDrive(() -> driverController.getTriggerAxis(GenericHID.Hand.kLeft),
         () -> driverController.getTriggerAxis(GenericHID.Hand.kRight), () -> driverController.getX(GenericHID.Hand.kLeft), m_drive));
    //m_drive.setDefaultCommand(new TankDrive(() -> driverController.getY(GenericHID.Hand.kLeft), () -> driverController.getY(GenericHID.Hand.kRight), m_drive));
    
}

/**
 * This tells what buttons are being used for which commands
 */
public void configureButtonBindings() {

  final JoystickButton operatorA = new JoystickButton(operatorController, XboxController.Button.kA.value);
  final JoystickButton operatorB = new JoystickButton(operatorController, XboxController.Button.kB.value);
  final JoystickButton operatorX = new JoystickButton(operatorController, XboxController.Button.kX.value);
  final JoystickButton operatorY = new JoystickButton(operatorController, XboxController.Button.kY.value);
  final JoystickButton operatorRightBumper = new JoystickButton(operatorController, XboxController.Button.kBumperRight.value);
  final JoystickButton oepratorLeftBumper = new JoystickButton(operatorController, XboxController.Button.kBumperLeft.value);
  final JoystickButton operatorStarButton = new JoystickButton(operatorController, XboxController.Button.kStart.value);
  final JoystickButton operatorBaButton = new JoystickButton(operatorController, XboxController.Button.kBack.value);
  final JoystickButton operatorLeftStick = new JoystickButton(operatorController, XboxController.Button.kStickLeft.value);
  final JoystickButton operatorRightStick = new JoystickButton(operatorController, XboxController.Button.kStickRight.value);

  operatorA.whenPressed(new IntakeIn(m_intake));
  operatorB.whenPressed(new IntakeOut(m_intake));
  operatorX.whenPressed(new IntakeDown(m_intake));
  operatorY.whenPressed(new IntakeUp(m_intake));

  operatorRightBumper.whenPressed(new MoveShooterUp(m_shooter));
  oepratorLeftBumper.whenPressed(new MoveShooterDown(m_shooter));

  operatorStarButton.whenPressed(new MoveUpStorage(m_storage));
  operatorBaButton.whenPressed(new StopStorage(m_storage));

  operatorLeftStick.whenPressed(new StopShooter(m_shooter));
 //operatorRightStick.whenPressed(new StartUpShooter(m_shooter));

}

public void shuffleBoard(){
  SmartDashboard.putBoolean("intakeInput", m_storage.isBallAtIntake());


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