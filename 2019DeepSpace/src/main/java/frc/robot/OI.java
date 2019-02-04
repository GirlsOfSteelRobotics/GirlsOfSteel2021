/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick drivingPad;
	public Joystick drivingPad1;

	private JoystickButton backUp;
	private JoystickButton backDown;

	private JoystickButton frontUp;
	private JoystickButton frontDown;

	private JoystickButton allUp;
	private JoystickButton allDown;

	private JoystickButton collect;
	private JoystickButton release;

	private JoystickButton hatchCollect;
	private JoystickButton hatchRelease;

	private JoystickButton babyDriveForward; 
	private JoystickButton babyDriveBackward;

	public OI() {
		drivingPad = new Joystick(0);
		drivingPad1 = new Joystick(1);

		// Piston climber buttons
		frontUp = new JoystickButton(drivingPad, 1);
		frontUp.whenPressed(new ScrewClimberFrontUp());
		
		frontDown = new JoystickButton(drivingPad, 2);
		frontDown.whenPressed(new ScrewClimberFrontDown());
		
		backUp = new JoystickButton(drivingPad, 3);
		backUp.whenPressed(new ScrewClimberBackUp());
		
		backDown = new JoystickButton(drivingPad, 4);
		backDown.whenPressed(new ScrewClimberBackDown());
		
		allUp = new JoystickButton(drivingPad, 5);
		allUp.whenPressed(new ScrewClimberAllUp());
		
		allDown = new JoystickButton(drivingPad, 6);
		allDown.whenPressed(new ScrewClimberAllDown());

		
		// Collector buttons
		collect = new JoystickButton(drivingPad, 9);
		collect.whileHeld(new Collect());

		release = new JoystickButton(drivingPad, 10);
		release.whileHeld(new Release());

		// Hatch buttons
		hatchCollect = new JoystickButton(drivingPad, 12);
		hatchCollect.whenPressed(new HatchCollect());

		hatchRelease = new JoystickButton(drivingPad, 11);
		hatchRelease.whenPressed(new HatchRelease());

		// BabyDrive buttons
		babyDriveForward = new JoystickButton(drivingPad, 7);
		babyDriveForward.whileHeld(new BabyDriveForward());

		babyDriveBackward = new JoystickButton(drivingPad, 8);
		babyDriveBackward.whileHeld(new BabyDriveBackwards());
	}


	public double getLeftUpAndDown() {
		return drivingPad.getY();
	}	

	public double getRightSideToSide() {
		return -drivingPad.getRawAxis(4);
	}
	
}




