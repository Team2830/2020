/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;

/**
 * The main autonomous command to pickup and deliver the soda to the box.
 */
public class Autonomous extends SequentialCommandGroup {
    /**
     * Create a new autonomous command.
     */
    public Autonomous(Drive drive) {
    //addCommands(
        //new PrepareToPickup(claw, wrist, elevator),
        //new Pickup(claw, wrist, elevator),
        //new SetDistanceToBox(0.10, drive),
      //  new DriveStraight(4, drive).withTimeout(5),
       // new DriveStraight(-4, drive).withTimeout(5)
         // Use encoders if ultrasonic is broken
//        new Place(claw, wrist, elevator),
//        new SetDistanceToBox(0.60, drive),
        // new DriveStraight(-2), // Use Encoders if ultrasonic is broken
       // parallel(
         //   new SetWristSetpoint(-45, wrist),
          //  new CloseClaw(claw)
       // )
//);
  }
}
