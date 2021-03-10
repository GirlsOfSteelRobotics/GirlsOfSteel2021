package frc.robot.trajectory_modes;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Chassis;

public class TrajectoryBounce {
    public static Command bounce(Chassis chassis) {
        Command first = TrajectoryUtils.startTrajectory("pathweaver_athome/BouncePath/PathWeaver/Paths/Bounce1", TrajectoryModeFactory.getTrajectoryConfig(), chassis);
        Command second = TrajectoryUtils.createTrajectory("pathweaver_athome/BouncePath/PathWeaver/Paths/Bounce2", TrajectoryModeFactory.getTrajectoryConfig(), chassis);
        Command third = TrajectoryUtils.createTrajectory("pathweaver_athome/BouncePath/PathWeaver/Paths/Bounce3", TrajectoryModeFactory.getTrajectoryConfig(), chassis);
        Command fourth = TrajectoryUtils.createTrajectory("pathweaver_athome/BouncePath/PathWeaver/Paths/Bounce4", TrajectoryModeFactory.getTrajectoryConfig(), chassis);
        SequentialCommandGroup combinedPath = new SequentialCommandGroup();
        combinedPath.addCommands(first, second, third, fourth);
        return combinedPath;
    }
}
