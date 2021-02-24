package frc.robot.trajectory_modes;

import edu.wpi.first.wpilibj.spline.Spline;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class TrajectoryUtils {
    //reads file & spits out trajectory
    public static Trajectory loadingTrajectory(String fileName, TrajectoryConfig trajectoryConfig) {
        TrajectoryGenerator.ControlVectorList list = new TrajectoryGenerator.ControlVectorList();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {

            // Read the CSV header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                double xPath = Double.parseDouble(tokenizer.nextToken());
                double yPath = Double.parseDouble(tokenizer.nextToken());
                double xTangent = Double.parseDouble(tokenizer.nextToken());
                double yTangent = Double.parseDouble(tokenizer.nextToken());
                list.add(new Spline.ControlVector(
                        new double[] {xPath, xTangent, 0},
                        new double[] {yPath, yTangent, 0}));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return TrajectoryGenerator.generateTrajectory(list, trajectoryConfig);
    }
}


