package crtRocketSimulator;

import java.lang.Math;

public class Rocket {
	
	private double rocketMass;
	private double tubeLength;
	private double tubeRadius;
	private double dragCoeficient;
	private double centerMass;
	private double rocketVelocity;
	private double machNumber;
	

	public double getRocketMass() {
		return this.rocketMass;
	}
	
	public double getTubleLength() {
		return this.tubeLength;
	}
	
	public double getTubeRadius() {
		return this.tubeRadius;
	}
	
	public double getDragCoeficient() {
		return this.dragCoeficient;
	}
	
	public double getCenterMass() {
		return this.centerMass;
	}
	
	public void setRocketMass(double rocketMass) {
		this.rocketMass = rocketMass;
	}
	
	public void setTubeLength(double tubeLength) {
		this.tubeLength = tubeLength;
	}
	
	public void setTubeRadius(double tubeRadius) {
		this.tubeRadius = tubeRadius;
	}
	
	public void setDragCoeficient(double dragCoeficient) {
		this.dragCoeficient = dragCoeficient;
	}
	
	public void setCenterMass(double centerMass) {
		this.centerMass = centerMass;
	}
	
	public double getRocketVelocity() {
		return rocketVelocity;
	}

	public double getMachNumber() {
		return machNumber;
	}
	
	
	public void calculateRocketVelocity(Propulsion propulsion) {
		
		double gravity = new PhysicalConstants().getGravity();
		double soundVelocity = new PhysicalConstants().getSoundVelocity();
		double finalMass = rocketMass - propulsion.getPropellantMass();
		double ve = propulsion.getExaustVelocity();
		double te = propulsion.getBurnTime();
		
		this.rocketVelocity = ve*Math.log(rocketMass/finalMass) - te*gravity;
		this.machNumber = rocketVelocity/soundVelocity;
		
	}
}
