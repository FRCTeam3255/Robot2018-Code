package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	double maxPitch = 0;
	
	public Telemetry(){
		SmartDashboard.putData("Reset Drive Encoder", new DrivetrainResetEncoder());
		SmartDashboard.putData("Reset Collector Encoder", new CollectorResetEncoder());
		
		SmartDashboard.putData("Retract Collector", new CollectorRetractIntake());
		SmartDashboard.putData("Deploy Collector", new CollectorDeployIntake());
		
		SmartDashboard.putData("Move to High Scale", new CollectorMoveToHighScale());
		SmartDashboard.putData("Move to Low Scale", new CollectorMoveToLowScale());
		SmartDashboard.putData("Move to Switch", new CollectorMoveToSwitch());
		SmartDashboard.putData("Move to Bottom", new CollectorMoveToBottom());
		
		SmartDashboard.putData("Collector Dogtooth Unlock", new CollectorLiftUnlock());
		SmartDashboard.putData("Collector Dogtooth Lock", new CollectorLiftLock());
		
		SmartDashboard.putData("Reset Yaw", new NavResetYaw());
		SmartDashboard.putData("Reset Max Pitch", new NavResetMaxPitch());
		SmartDashboard.putData("Reset Pitch", new NavResetPitch());
		
		SmartDashboard.putString("Autonomous Status", "No Auto Running");

		SmartDashboard.putData("Drive 5 Feet", new DriveDistance("Drive 5 Feet", 60.0));
		SmartDashboard.putData("Drive To Target", new DriveToTarget("Drive To Target", 15.0));
		SmartDashboard.putData("Rotate 90", new DriveRotate("Rotate 90", 90.0));
		SmartDashboard.putData("Drive to Cube", new VisionMoveToCube("Drive To Cube", 40.0));
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Encoder Distance, Inches", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Encoder Count", Robot.drivetrain.getEncoderCount());
		SmartDashboard.putNumber("Get Drivetrain Speed", Robot.drivetrain.getSpeed());
//		SmartDashboard.putNumber("Drivetrain Current", Robot.drivetrain.getTalonCurrent());
		
		SmartDashboard.putNumber("Collector Encoder Count", Robot.cascadeLift.getEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Distance", Robot.cascadeLift.getEncoderDistance());
		SmartDashboard.putBoolean("Collector Is Top", Robot.cascadeLift.isTopSwitchClosed());
		SmartDashboard.putBoolean("Collector Is Bottom", Robot.cascadeLift.isBottomSwitchClosed());
		SmartDashboard.putNumber("Lifter Current", Robot.cascadeLift.getTalonCurrent());
		
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
		SmartDashboard.putNumber("Collector Current", Robot.collector.getTalonCurrent());
		
		SmartDashboard.putBoolean("Red Alliance", Robot.navigation.isRedAlliance());
		
		SmartDashboard.putString("Alliance Switch Pos", String.valueOf(Robot.navigation.getAllianceSwitchPos()));
		SmartDashboard.putString("Alliance Scale Pos", String.valueOf(Robot.navigation.getScalePos()));
		SmartDashboard.putString("Opponent Switch Pos", String.valueOf(Robot.navigation.getOppenentSwitchPos()));
		
		SmartDashboard.putNumber("Vision Distance", Robot.navigation.getTargetDistance());
		SmartDashboard.putNumber("Vision Offset", Robot.navigation.getTargetOffset());
		SmartDashboard.putNumber("Vision Angle", Robot.navigation.getTargetAngle());
		SmartDashboard.putBoolean("Vision Target Found", Robot.navigation.isTargetFound());
		
		SmartDashboard.putNumber("Nav Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Nav Roll", Robot.navigation.getRoll());
		
		double pitch = Robot.navigation.getPitch();
		SmartDashboard.putNumber("Nav Pitch", pitch);
		
		if(pitch > maxPitch) {
			maxPitch = pitch;
		}
		SmartDashboard.putNumber("Max Pitch", maxPitch);
		
		SmartDashboard.putBoolean("Do Switch", AutoPreferences.doSwitch());
		SmartDashboard.putBoolean("Is Debug", AutoPreferences.isDebug());
		
	}
	
	public void resetMaxPitch() {
		maxPitch = 0;
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

