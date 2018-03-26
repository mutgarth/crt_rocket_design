package crtRocketSimulator;


public class Propulsion {
	
	private double fuelMass;
	private double oxidizerMass;
	private double burnTime;
	private double isp;
	private double exaustVelocity;
	private double propellantMass;
	private double thrust;
	
	public double getFuelMass() {
		return fuelMass;
	}
	public void setFuelMass(double fuelMass) {
		this.fuelMass = fuelMass;
	}
	public double getOxidizerMass() {
		return oxidizerMass;
	}
	public void setOxidizerMass(double oxidizerMass) {
		this.oxidizerMass = oxidizerMass;
	}
	public double getBurnTime() {
		return burnTime;
	}
	public void setBurnTime(double burnTime) {
		this.burnTime = burnTime;
	}
	public double getIsp() {
		return isp;
	}
	public void setIsp(double isp) {
		this.isp = isp;
	}
	public double getExaustVelocity() {
		return exaustVelocity;
	}
	public void setExaustVelocity(double exaustVelocity) {
		this.exaustVelocity = exaustVelocity;
	}
	
	public double getPropellantMass() {
		return propellantMass;
	}
	
	public void setPropellantMass(double propellantMass) {
		this.propellantMass = propellantMass;
	}
	
	public double getThrust() {
		return this.thrust;
	}

	public void calculateThrust(Rocket rocket) {
		double mdot;
		double finalMass;
		
		this.propellantMass = this.fuelMass + this.oxidizerMass;
		finalMass = rocket.getRocketMass() - propellantMass;
		mdot = (rocket.getRocketMass()/this.burnTime)*(1 - (finalMass/rocket.getRocketMass()));
		
		thrust = this.exaustVelocity*mdot;

		//Esse comentário vai ser pushado pro repositório na branch teste
				
	}
	
}
