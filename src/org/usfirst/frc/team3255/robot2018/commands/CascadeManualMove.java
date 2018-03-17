package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeManualMove extends Command {

	double speed = 0;
	
    public CascadeManualMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cascadeLift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	speed = 0;
    	Robot.cascadeLift.shiftToCascade();
    	Robot.cascadeLift.unlockLift();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.collector.isBackArmSwitch() && Robot.cascadeLift.isBottomSwitchClosed()) {
    		speed = 0;
    	}
    	else {
    		speed = -Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_MOVE_AXIS);
    	}
    	Robot.cascadeLift.setLiftSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.collector.isBackArmSwitch() && Robot.cascadeLift.isBottomSwitchClosed());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	Robot.cascadeLift.lockLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
