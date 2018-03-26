package crtRocketSimulator;


public class MainGui {
	
	public static Application menuFrame = new Application();
		
	public MainGui() {

		menuFrame.add(new ParametersInterface());
		menuFrame.setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MainGui();

	}
}
