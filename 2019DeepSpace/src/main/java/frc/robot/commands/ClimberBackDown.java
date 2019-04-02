/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Climber.ClimberType;

public class ClimberBackDown extends Command {
  public ClimberBackDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("init Back Down");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climber.decrementBackClimber();
    Robot.climber.holdClimberPosition(ClimberType.All);
    //System.out.println(" Back Position: " + Robot.climber.getBackPosition() + "Goal Back Position: " + Robot.climber.goalBackPosition);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
    }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climber.climberStop();
    System.out.println("end Back Down");

  }
}
