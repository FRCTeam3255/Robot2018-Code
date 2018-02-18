/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Talons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 1;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 4;	
	
	public static final int COLLECTOR_INTAKE_LEFT_TALON = 5;
	public static final int COLLECTOR_INTAKE_RIGHT_TALON = 6;
	public static final int COLLECTOR_TOP_LIFT_TALON = 7;
	public static final int COLLECTOR_BOTTOM_LIFT_TALON = 8;
	public static final int COLLECTOR_CLIMB_TALON = 9;

	
	//Lighting
	public static final int LIGHTING_STATUSLIGHTING = 0;
	
	//Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	public static final int JOYSTICK_PREFERENCES = 2;
	
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 2;
	
	public static final int COLLECTOR_MOVE_AXIS = 1;
	public static final int COLLECTOR_ROTATE_AXIS = 0;
	
	//Switches
	public static final int COLLECTOR_TOP_SWITCH = 4;
	public static final int COLLECTOR_BOTTOM_SWITCH = 3;
	public static final int COLLECTOR_INTAKE_SWITCH = 2;
	
	
	//Encoder
	public static final int DRIVETRAIN_ENCODER_A = 7;
	public static final int DRIVETRAIN_ENCODER_B = 8;
	
	public static final int COLLECTOR_ENCODER_A = 0;
	public static final int COLLECTOR_ENCODER_B = 1;
	
	//Solenoid
	public static final int COLLECTOR_CLAMP_SOLENOID_CLAMP = 0;
	public static final int COLLECTOR_CLAMP_SOLENOID_RELEASE = 1;
	public static final int COLLECTOR_DEPLOY_SOLENOID_DEPLOY = 2;
	public static final int COLLECTOR_DEPLOY_SOLENOID_RETRACT = 3;
	public static final int COLLECTOR_LIFT_SOLENOID_A = 4;
	public static final int COLLECTOR_LIFT_SOLENOID_B = 5;
}
