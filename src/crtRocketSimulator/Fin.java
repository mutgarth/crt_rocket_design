package crtRocketSimulator;

public class Fin {

    private double rootChord = 200;
    private double sweepLength = 62.5;
    private double tipChord = 75;
    private double semiSpan = 125;
    private double meanAerodynamicChord;
    private int numberOfFins;


    public int getNumberOfFins(){
        return numberOfFins;
    }

    public void setNumberOfFins(int numberOfFins){
        this.numberOfFins = numberOfFins;
    }
    public double getRootChord() {
		return rootChord;
	}
	public void setRootChord(double rootChord) {
		this.rootChord = rootChord;
	}
	public double getTipChord() {
		return tipChord;
	}
	public void setTipChord(double tipChord) {
		this.tipChord = tipChord;
	}
	public double getSweepLength() {
		return sweepLength;
	}
	public void setSweepLength(double sweepLength) {
		this.sweepLength = sweepLength;
	}
	public double getSemiSpan() {
		return semiSpan;
	}
	public void setSemiSpan(double semiSpan) {
		this.semiSpan = semiSpan;
	}
	public double getMeanAerodynamicChord() {
		return meanAerodynamicChord;
	}
	public void setMeanAerodynamicChord(double meanAerodynamicChord) {
		this.meanAerodynamicChord = meanAerodynamicChord;
    }

    public double calculateMeanAerodynamicChord(){
        double x1 = 0;
        double y1 = rootChord/2;
        double x2 = semiSpan;
        double y2 = sweepLength + tipChord/2;
        meanAerodynamicChord = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return meanAerodynamicChord;
    }
    
}