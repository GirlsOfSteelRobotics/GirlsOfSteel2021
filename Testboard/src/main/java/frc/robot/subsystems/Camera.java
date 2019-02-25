package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.cameraserver.CameraServer;

public class Camera extends Subsystem {

	public CvSource processedStream;
	public UsbCamera visionCam;

	public Camera() {
		// Create a Camera Server video stream of the given name using the logical camera number
		visionCam = CameraServer.getInstance().startAutomaticCapture("Raw Camera", RobotMap.VISION_CAMERA);
		// Adjust the camera settings; most important is to reduce the exposure very low
		visionCam.setResolution(320, 240);
		visionCam.setFPS(10);
		visionCam.setExposureManual(16);
		// Create a second Camera Server stream that we'll fill with processed frames in GripPipelineListener
		processedStream = CameraServer.getInstance().putVideo("Processed", 320, 240);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}