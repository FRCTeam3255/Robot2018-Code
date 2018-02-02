package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotate extends Command {
	String commandName;
	double angle;

    public DriveRotate(String name, double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.navigation);
    	requires(Robot.navYawPID);
    	
    	commandName = name;
    	angle = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + angle);
    	Robot.navigation.resetYaw();
    	
    	Robot.navYawPID.setSetpoint(angle);
    	Robot.navYawPID.setAbsoluteTolerance(RobotPreferences.yawTolerance());
    	Robot.navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName + ": " + angle);
    	Robot.drivetrain.arcadeDrive(0.0, Robot.navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.navYawPID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finishing " + commandName + ": " + angle);
    	Robot.navYawPID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}