// RobotBuilder Version: 3.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.DrivePastAutoLine;
import frc.robot.subsystems.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    private final Shooter m_shooter = new Shooter();
    private final Collector m_collector = new Collector();
    private final Chassis m_chassis = new Chassis();
    private final LimelightSubsystem m_limelight = new LimelightSubsystem();
    private final LEDSubsystem m_led = new LEDSubsystem(m_limelight);

    // Joysticks
    private final XboxController m_operatorJoystick = new XboxController(1);
    private final XboxController m_driverJoystick = new XboxController(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Smartdashboard Subsystems


        // SmartDashboard Buttons
        SmartDashboard.putData("DrivePastAutoLine", new DrivePastAutoLine(m_chassis));
        SmartDashboard.putData("ExtendCollector", new ExtendCollector(m_collector));
        SmartDashboard.putData("RetractCollector", new RetractCollector(m_collector));
        SmartDashboard.putData("IntakeBall", new IntakeBall(m_collector));
        SmartDashboard.putData("ReverseBall", new ReverseBall(m_collector));
        SmartDashboard.putData("AngleUp", new AngleUp(m_shooter));
        SmartDashboard.putData("AngleDown", new AngleDown(m_shooter));
        SmartDashboard.putData("RunShooter", new RunShooter(3500, m_shooter));
        SmartDashboard.putData("StopShooter", new StopShooter(m_shooter));
        SmartDashboard.putData("FeedIn", new FeedIn(m_shooter));
        SmartDashboard.putData("FeedOut", new FeedOut(m_shooter));
        SmartDashboard.putData("AutoShoot", new AutoShoot(m_shooter));
        SmartDashboard.putData("LimelightPID", new AimWithLimelightCommand(m_chassis, m_limelight));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
        m_chassis.setDefaultCommand(new DriveByJoystick(m_chassis, m_driverJoystick));


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

        // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        m_chooser.addOption("DrivePastAutoLine", new DrivePastAutoLine(m_chassis));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto Mode", m_chooser);

        m_led.rainbow();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
        // Create some buttons
        final JoystickButton autoLine = new JoystickButton(m_driverJoystick, 1);
        autoLine.whenPressed(new DrivePastAutoLine(m_chassis), true);
        SmartDashboard.putData("AutoLine", new DrivePastAutoLine(m_chassis));

        final JoystickButton extendCollector = new JoystickButton(m_driverJoystick, 1);
        extendCollector.whileHeld(new ExtendCollector(m_collector), true);
        SmartDashboard.putData("Extend Collector", new ExtendCollector(m_collector));

        final JoystickButton retractCollector = new JoystickButton(m_driverJoystick, 1);
        retractCollector.whileHeld(new RetractCollector(m_collector), true);
        SmartDashboard.putData("Retract Collector", new RetractCollector(m_collector));

        final JoystickButton angleUp = new JoystickButton(m_operatorJoystick, 1);
        angleUp.whileHeld(new AngleUp(m_shooter), true);
        SmartDashboard.putData("Angle Up", new AngleUp(m_shooter));

        final JoystickButton angleDown = new JoystickButton(m_operatorJoystick, 2);
        angleDown.whileHeld(new AngleDown(m_shooter), true);
        SmartDashboard.putData("Angle Down", new AngleDown(m_shooter));

        final JoystickButton intakeBall = new JoystickButton(m_operatorJoystick, 3);
        intakeBall.whileHeld(new IntakeBall(m_collector), true);
        SmartDashboard.putData("Intake Ball", new IntakeBall(m_collector));

        final JoystickButton reverseBall = new JoystickButton(m_operatorJoystick, 4);
        reverseBall.whileHeld(new ReverseBall(m_collector), true);
        SmartDashboard.putData("Reverse Ball", new ReverseBall(m_collector));

        final JoystickButton feedIn = new JoystickButton(m_operatorJoystick, 5);
        feedIn.whileHeld(new FeedIn(m_shooter), true);
        SmartDashboard.putData("Feed In", new FeedIn(m_shooter));

        final JoystickButton feedOut = new JoystickButton(m_operatorJoystick, 6);
        feedOut.whileHeld(new FeedOut(m_shooter), true);
        SmartDashboard.putData("Feed Out", new FeedOut(m_shooter));

        final JoystickButton runShooter = new JoystickButton(m_operatorJoystick, 7);
        runShooter.whenPressed(new RunShooter(3500, m_shooter), true);
        SmartDashboard.putData("Run Shooter", new RunShooter(3500, m_shooter));

        final JoystickButton stopShooter = new JoystickButton(m_operatorJoystick, 8);
        stopShooter.whenPressed(new StopShooter(m_shooter), true);
        SmartDashboard.putData("Stop Shooter", new StopShooter(m_shooter));

        final JoystickButton autoShoot = new JoystickButton(m_operatorJoystick, 9);
        autoShoot.whenPressed(new AutoShoot(m_shooter), true);
        SmartDashboard.putData("Auto Shoot", new AutoShoot(m_shooter));


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public XboxController getDriverJoystick() {
        return m_driverJoystick;
    }

    public XboxController getOperatorJoystick() {
        return m_operatorJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }


}

