package crtRocketSimulator;

public class PhysicalConstants {
	
	private static final double GRAVITY = 9.80665;
	private static final double SOUND_VELOCITY = 343;
	private static final double PI = 3.14159;
	private static final double GAS_CONSTANT = 287.05;
	private double airDensity;

	
	public double getGravity() {
		return GRAVITY;
	}
	
	public double getSoundVelocity() {
		return SOUND_VELOCITY;
	}

	
	public double getPi(){
		return PI;
	}

	public double getAirDensity(){
		return this.airDensity;
	}
	public double calculateAirDensity(double temperature, double pressure){
		return this.airDensity = pressure/(GAS_CONSTANT*temperature);
	}
}
