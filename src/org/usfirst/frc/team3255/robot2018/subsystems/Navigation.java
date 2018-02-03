package org.usfirst.frc.team3255.robot2018.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Navigation extends Subsystem {
	
	public static AHRS ahrs = null;
	
	// Creates a new NetworkTable variable named data
	public static NetworkTable visionData = null;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Navigation() {
		// NavX
		try {
			ahrs = new AHRS(SerialPort.Port.kUSB);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
		}
		
		// Vision
		visionData = NetworkTableInstance.getDefault().getTable("NURDVision");
	}

	// NavX
	public double getYaw() {
		return ahrs.getYaw();
	}
	public double getPitch() {
		return ahrs.getRoll();
	}
	
	public void resetYaw() {
		// reset the yaw
		ahrs.reset();
		
		//wait for 1/4 seconds to allow the NavX to reset the yaw
		try { 
			Thread.sleep(250);
		}
		catch (InterruptedException e) {
			
		}
	
		//make the reset yaw position be the zero yaw position
		ahrs.zeroYaw();
	}
 
	public boolean isCalibrating() {
		return ahrs.isCalibrating();
	}
		
	public double getAccel() {
		return ahrs.getRawAccelX();
	}
	
	// Field Data
	private String getFieldData() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public char getAllianceSwitchPos() {
		String s = getFieldData();
		
		if((s != null) && (s.length() > 0)) {
			return s.charAt(0);
		}
		
		return 'X';
	}
	
	public char getScalePos() {
		String s = getFieldData();
		
		if((s != null) && (s.length() > 1)) {
			return s.charAt(1);
		}
		
		return 'X';
	}
	
	public char getOppenentSwitchPos() {
		String s = getFieldData();
		
		if((s != null) && (s.length() > 2)) {
			return s.charAt(2);
		}
		
		return 'X';
	}
	
	// Vision
	public double getTargetDistance() {
		return visionData.getEntry("Distance").getDouble(-99.9);
	}
	
	public double getTargetOffset() {
		return visionData.getEntry("Offset").getDouble(-99.9);
	}
	
	public double getTargetAngle() {
		 return visionData.getEntry("Angle").getDouble(-99.9);
	}
	
	public boolean isTargetFound() {
		return visionData.getEntry("TargetFound").getBoolean(false);
	}
	
	public void setHue(int hueLow, int hueHigh) {
		Number[] hue = {hueLow, hueHigh};
		visionData.getEntry("Hue").setNumberArray(hue);
	}
	
	public void setSaturation(int satLow, int satHigh) {
		Number[] sat = {satLow, satHigh};
		visionData.getEntry("Saturation").setNumberArray(sat);
	}
	
	public void setLuminance(int lumLow, int lumHigh) {
		Number[] lum = {lumLow, lumHigh};
		visionData.getEntry("Luminance").setNumberArray(lum);
	}
	
	public void setShowRaw(boolean showRaw) {
		visionData.getEntry("showRaw").setBoolean(showRaw);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

