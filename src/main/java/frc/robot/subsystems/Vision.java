/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;

public class Vision extends SubsystemBase implements Loggable {
  /**
   * Creates a new Vision.
   */
  public Vision() {

  }

  public double getDistance(){
    return 1.0;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
