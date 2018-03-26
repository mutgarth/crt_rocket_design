package crtRocketSimulator;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.concurrent.Callable;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;


public class ParametersInterface extends JPanel {

	private static final int FIN_PANEL_OFFSET = 25;
	private static final int SCALE_FACTOR = 3;

	Fin fin = new Fin();
	Rocket rocket = new Rocket();
	Propulsion propulsion = new Propulsion();

	private JTextField rocketRadiusField;
	private JTextField rocketCGField;
	private JTextField massField;
	private JTextField rocketTubeField;
	private JTextField rocketCDField;
	private JTextField finRootChordField;
	private JTextField finTipChordField;
	private JTextField finSweepLengthField;
	private JTextField finMeanACField;
	private JTextField finSemiSpanField;
	private JTextField numberFinField;
	private JTextField noseLengthField;
	private JTextField fuelMassField;
	private JTextField oxidizerMassField;
	private JTextField burnTimeField;
	private JTextField ispField;
	private JTextField exaustVelocityField;
	private JTextField finMassField;
		
	private final JPanel rocketDesignTab = new JPanel();
	private final JPanel nosePanel = new JPanel();

	private float dpi = Toolkit.getDefaultToolkit().getScreenResolution();
	private JTextField noseMassField;



	/**
	 * Create the panel.
	 */
	public ParametersInterface() {
		setLayout(null);
		
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBounds(0, 0, 1024, 768);
		add(tabbedPane2);
		tabbedPane2.addTab("Rocket Design", null, rocketDesignTab, null);
		rocketDesignTab.setBorder(new LineBorder(new Color(0, 0, 0)));
		rocketDesignTab.setLayout(null);
		
		// Rocket Parameters section

		
		JPanel rocketPanel = new JPanel();
		rocketPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		rocketPanel.setBounds(10, 24, 662, 179);
		rocketDesignTab.add(rocketPanel);
		rocketPanel.setLayout(null);
		
			JLabel massLabel = new JLabel("Total Mass");
			massLabel.setBounds(10, 50, 69, 14);
			rocketPanel.add(massLabel);
			
			JLabel rocketLabel = new JLabel("Rocket Parameters");
			rocketLabel.setBounds(285, 11, 164, 14);
			rocketPanel.add(rocketLabel);
			
			JLabel rocketTubeLabel = new JLabel("Tube Length");
			rocketTubeLabel.setBounds(10, 84, 146, 14);
			rocketPanel.add(rocketTubeLabel);
			
			JLabel rocketCDLabel = new JLabel("Drag coeficient");
			rocketCDLabel.setBounds(10, 120, 146, 14);
			rocketPanel.add(rocketCDLabel);
			
			massField = new JTextField();
			massField.setBounds(218, 50, 86, 20);
			rocketPanel.add(massField);
			massField.setColumns(10);
			
		
			rocketTubeField = new JTextField();
			rocketTubeField.setBounds(218, 87, 86, 20);
			rocketPanel.add(rocketTubeField);
			rocketTubeField.setColumns(10);
			
			rocketCDField = new JTextField();
			rocketCDField.setBounds(218, 120, 86, 20);
			rocketPanel.add(rocketCDField);
			rocketCDField.setColumns(10);
			
			JLabel rocketRadiLabel = new JLabel("Tube radius");
			rocketRadiLabel.setBounds(362, 50, 86, 14);
			rocketPanel.add(rocketRadiLabel);
			
			JLabel rocketCGLabel = new JLabel("Center of mass");
			rocketCGLabel.setBounds(362, 87, 105, 14);
			rocketPanel.add(rocketCGLabel);
		
			rocketRadiusField = new JTextField();
			rocketRadiusField.setBounds(503, 50, 86, 20);
			rocketPanel.add(rocketRadiusField);
			rocketRadiusField.setColumns(10);		

			rocketCGField = new JTextField();
			rocketCGField.setBounds(503, 87, 86, 20);
			rocketPanel.add(rocketCGField);
			rocketCGField.setColumns(10);
			nosePanel.setBounds(10, 533, 358, 159);
			rocketDesignTab.add(nosePanel);

		

		// ----------------------------------------------------------
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBounds(733, 176, 254, 152);
		rocketDesignTab.add(resultsPanel);
		resultsPanel.setLayout(null);
		
		JLabel machLabel = new JLabel("Mach Number:");
		machLabel.setBounds(10, 55, 82, 14);
		resultsPanel.add(machLabel);
		
		JLabel thrustLabel = new JLabel("Thrust: ");
		thrustLabel.setBounds(10, 22, 46, 14);
		resultsPanel.add(thrustLabel);
		
		JLabel maxVelocityLabel = new JLabel("Maximum velocity:");
		maxVelocityLabel.setBounds(10, 88, 114, 14);
		resultsPanel.add(maxVelocityLabel);
		
		JLabel staticMarginLabel = new JLabel("Static margin:");
		staticMarginLabel.setBounds(10, 121, 82, 14);
		resultsPanel.add(staticMarginLabel);
		
		
		JLabel machResult = new JLabel(String.valueOf(rocket.getMachNumber()));
		machResult.setBounds(138, 55, 98, 14);
		resultsPanel.add(machResult);
		
		JLabel thrustResult = new JLabel(String.valueOf(propulsion.getThrust()));
		thrustResult.setBounds(138, 22, 98, 14);
		resultsPanel.add(thrustResult);
		
		JLabel maxVelocityResult = new JLabel(String.valueOf(rocket.getRocketVelocity()));
		maxVelocityResult.setBounds(138, 88, 98, 14);
		resultsPanel.add(maxVelocityResult);

	
		// Propulsion section
		JPanel propulsionPanel = new JPanel();
		tabbedPane2.addTab("Propulsion", null, propulsionPanel, null);
		propulsionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		propulsionPanel.setLayout(null);
		
		JLabel lblPropulsion = new JLabel("Propulsion");
		lblPropulsion.setBounds(135, 11, 74, 14);
		propulsionPanel.add(lblPropulsion);
		
		JLabel fuelMassLabel = new JLabel("Fuel mass");
		fuelMassLabel.setBounds(23, 50, 63, 14);
		propulsionPanel.add(fuelMassLabel);
		
		JLabel lblOxidizerMass = new JLabel("Oxidizer mass");
		lblOxidizerMass.setBounds(23, 80, 86, 14);
		propulsionPanel.add(lblOxidizerMass);
		
		JLabel burnTimeLabel = new JLabel("Burn time");
		burnTimeLabel.setBounds(23, 110, 63, 14);
		propulsionPanel.add(burnTimeLabel);
		
		JLabel ispLabel = new JLabel("ISP");
		ispLabel.setBounds(23, 140, 46, 14);
		propulsionPanel.add(ispLabel);
		
		JLabel exaustVelocityLabel = new JLabel("Exaust velocity");
		exaustVelocityLabel.setBounds(23, 170, 86, 14);
		propulsionPanel.add(exaustVelocityLabel);
		
		fuelMassField = new JTextField();
		fuelMassField.setBounds(197, 47, 86, 20);
		propulsionPanel.add(fuelMassField);
		fuelMassField.setColumns(10);
		
		oxidizerMassField = new JTextField();
		oxidizerMassField.setBounds(197, 77, 86, 20);
		propulsionPanel.add(oxidizerMassField);
		oxidizerMassField.setColumns(10);
		
		burnTimeField = new JTextField();
		burnTimeField.setBounds(197, 107, 86, 20);
		propulsionPanel.add(burnTimeField);
		burnTimeField.setColumns(10);
		
		ispField = new JTextField();
		ispField.setBounds(197, 137, 86, 20);
		propulsionPanel.add(ispField);
		ispField.setColumns(10);
		
		exaustVelocityField = new JTextField();
		exaustVelocityField.setBounds(197, 167, 86, 20);
		propulsionPanel.add(exaustVelocityField);
		exaustVelocityField.setColumns(10);

		
		// Fin section
		
		JPanel finPanel = new JPanel();
		finPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		finPanel.setBounds(10, 214, 358, 308);
		rocketDesignTab.add(finPanel);
		finPanel.setLayout(null);
		
		JLabel finLabel = new JLabel("Fin Parameters");
		finLabel.setBounds(143, 8, 107, 20);
		finPanel.add(finLabel);
		
		JLabel finRootChordLabel = new JLabel("Fin root chord (mm)");
		finRootChordLabel.setBounds(10, 53, 118, 14);
		finPanel.add(finRootChordLabel);
		
		JLabel finTipChordLabel = new JLabel("Fin tip chord (mm)");
		finTipChordLabel.setBounds(10, 86, 118, 14);
		finPanel.add(finTipChordLabel);
		
		JLabel finSemiSpanLabel = new JLabel("Fin Semi Span (mm)");
		finSemiSpanLabel.setBounds(10, 119, 118, 14);
		finPanel.add(finSemiSpanLabel);
		
		finRootChordField = new JTextField();
		finRootChordField.setBounds(218, 50, 86, 20);
		finPanel.add(finRootChordField);
		finRootChordField.setColumns(10);
		
		finTipChordField = new JTextField();
		finTipChordField.setBounds(218, 83, 86, 20);
		finPanel.add(finTipChordField);
		finTipChordField.setColumns(10);
		
		// finMeanACField = new JTextField();
		// finMeanACField.setBounds(218, 152, 86, 20);
		// finPanel.add(finMeanACField);
		// finMeanACField.setColumns(10);
		
		finSemiSpanField = new JTextField();
		finSemiSpanField.setBounds(218, 116, 86, 20);
		finPanel.add(finSemiSpanField);
		finSemiSpanField.setColumns(10);
		
		JLabel sweepLengthLabel = new JLabel("Sweep Length (mm)");
		sweepLengthLabel.setBounds(10, 152, 118, 14);
		finPanel.add(sweepLengthLabel);
		
		JLabel numberFinLabel = new JLabel("Nunber of fins");
		numberFinLabel.setBounds(10, 185, 107, 14);
		finPanel.add(numberFinLabel);
		
		finSweepLengthField = new JTextField();
		finSweepLengthField.setBounds(218, 152, 86, 20);
		finPanel.add(finSweepLengthField);
		finSweepLengthField.setColumns(10);
		
		numberFinField = new JTextField();
		numberFinField.setBounds(218, 185, 86, 20);
		finPanel.add(numberFinField);
		numberFinField.setColumns(10);
		
		JLabel finMassLabel = new JLabel("Fin mass (g)");
		finMassLabel.setBounds(10, 218, 71, 14);
		finPanel.add(finMassLabel);
		
		finMassField = new JTextField();
		finMassField.setBounds(218, 218, 86, 20);
		finPanel.add(finMassField);
		finMassField.setColumns(10);

		JPanel drawFinPanel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g){

				int rootChordPoint = (mm2pixel(fin.getRootChord())*SCALE_FACTOR + FIN_PANEL_OFFSET);
				int semiSpamPoint = (mm2pixel(fin.getSemiSpan())*SCALE_FACTOR + FIN_PANEL_OFFSET);
				int sweepLengthPoint = (mm2pixel(fin.getSweepLength())*SCALE_FACTOR + FIN_PANEL_OFFSET);
				int tipChordPoint = (mm2pixel(fin.getTipChord())*SCALE_FACTOR + sweepLengthPoint);


				int xPoly[] = {FIN_PANEL_OFFSET, FIN_PANEL_OFFSET, semiSpamPoint, semiSpamPoint};
				int yPoly[] = {FIN_PANEL_OFFSET, rootChordPoint, tipChordPoint, sweepLengthPoint};
				Polygon finDesign = new Polygon(xPoly, yPoly, xPoly.length);
				
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.drawPolygon(finDesign);
				
			}
		};
		
		drawFinPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawFinPanel.setBounds(378, 214, 294, 308);
		rocketDesignTab.add(drawFinPanel);

		// text field listener
		finSemiSpanField.getDocument().addDocumentListener(new DocumentListener(){
		
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					fin.setSemiSpan(Double.parseDouble(finSemiSpanField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getSemiSpan());
				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSemiSpan(255);
				}
			}
		
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					fin.setSemiSpan(Double.parseDouble(finSemiSpanField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getSemiSpan());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSemiSpan(25);
				}
			}
		
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					fin.setSemiSpan(Double.parseDouble(finSemiSpanField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getSemiSpan());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSemiSpan(25);
				}
			}
		});


		finRootChordField.getDocument().addDocumentListener(new DocumentListener(){
		
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					fin.setRootChord(Double.parseDouble(finRootChordField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getRootChord());
				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setRootChord(70);
				}
			}
		
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					fin.setRootChord(Double.parseDouble(finRootChordField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getRootChord());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setRootChord(70);
				}
			}
		
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					fin.setRootChord(Double.parseDouble(finRootChordField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getRootChord());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setRootChord(70);
				}
			}
		});


		finSweepLengthField.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					fin.setSweepLength(Double.parseDouble(finSweepLengthField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getSweepLength());
				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSweepLength(70);
				}
			}
		
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					fin.setSweepLength(Double.parseDouble(finSweepLengthField.getText()));
					drawFinPanel.repaint();
					System.out.println(fin.getSweepLength());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSweepLength(70);
				}
			}
		
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					fin.setSweepLength(Double.parseDouble(finSweepLengthField.getText()) );
					drawFinPanel.repaint();
					System.out.println(fin.getSweepLength());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setSweepLength(70);
				}
			}
		});

		finTipChordField.getDocument().addDocumentListener(new DocumentListener(){
		
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					fin.setTipChord(Double.parseDouble(finTipChordField.getText()) );
					drawFinPanel.repaint();
					System.out.println(fin.getTipChord());
				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setTipChord(70);
				}
			}
		
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					fin.setTipChord(Double.parseDouble(finTipChordField.getText()) );
					drawFinPanel.repaint();
					System.out.println(fin.getTipChord());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setTipChord(70);
				}
			}
		
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					fin.setTipChord(Double.parseDouble(finTipChordField.getText()) );
					drawFinPanel.repaint();
					System.out.println(fin.getTipChord());

				} catch (NumberFormatException a) {
					//TODO: handle exception
					fin.setTipChord(70);
				}
			}
		});

		// Nose Section
		
		nosePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		nosePanel.setLayout(null);
		
		JLabel noseLabel = new JLabel("Nose");
		noseLabel.setBounds(147, 11, 161, 14);
		nosePanel.add(noseLabel);
		
		JLabel noseTypeLabel = new JLabel("Nose type");
		noseTypeLabel.setBounds(23, 50, 91, 14);
		nosePanel.add(noseTypeLabel);
		
		JLabel noseLengthLabel = new JLabel("Nose Length (mm)");
		noseLengthLabel.setBounds(23, 80, 108, 14);
		nosePanel.add(noseLengthLabel);
		
		noseLengthField = new JTextField();
		noseLengthField.setBounds(200, 80, 86, 20);
		nosePanel.add(noseLengthField);
		noseLengthField.setColumns(10);
		machResult.setVisible(true);
		

		String[] noseChoices = { "Conical","Ogive", "Parabolic","Von Karman"};
		DefaultComboBoxModel<String> comboModelNoseChoice = new DefaultComboBoxModel<String>(noseChoices);
		
	    final JComboBox<String> noseBox = new JComboBox<String>(comboModelNoseChoice);
	    noseBox.setBounds(200,47, 86, 20);
	    noseBox.setVisible(true);
	    nosePanel.add(noseBox);
	    
	    JLabel noseMassLabel = new JLabel("Nose mass (g)");
	    noseMassLabel.setBounds(23, 110, 91, 14);
	    nosePanel.add(noseMassLabel);
	    
	    noseMassField = new JTextField();
	    noseMassField.setBounds(200, 110, 86, 20);
	    nosePanel.add(noseMassField);
	    noseMassField.setColumns(10);

		// Start Simulation

		JButton startSimulationButton = new JButton("Lift Off");
		startSimulationButton.setBounds(733, 26, 254, 123);
		rocketDesignTab.add(startSimulationButton);
		
		
		startSimulationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					// rocket.setRocketMass(Double.parseDouble(massField.getText()));
					// rocket.setTubeLength(Double.parseDouble(rocketTubeField.getText()));
					// rocket.setTubeRadius(Double.parseDouble(rocketRadiusField.getText()));
					// rocket.setDragCoeficient(Double.parseDouble(rocketCDField.getText()));
					// rocket.setCenterMass(Double.parseDouble(rocketCGField.getText()));
					
					// propulsion.setFuelMass(Double.parseDouble(fuelMassField.getText()));
					// propulsion.setBurnTime(Double.parseDouble(burnTimeField.getText()));
					// propulsion.setOxidizerMass(Double.parseDouble(oxidizerMassField.getText()));
					// propulsion.setIsp(Double.parseDouble(ispField.getText()));

					// call methods
					propulsion.calculateThrust(rocket);
					rocket.calculateRocketVelocity(propulsion);
					
					System.out.println(noseBox.getSelectedItem());
					
					
					// print result
					
				}
				catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null,"Some fields has either wrong values or are missed.");
				}
							

			}
		});
				


	    
		
		
	}

	public int mm2pixel(double measure){
		int pixel;
		pixel = (int) (measure*dpi)/254;
		return pixel;
	}
}
