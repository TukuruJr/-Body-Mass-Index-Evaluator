import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class BMI  implements ActionListener{

	private JFrame frmBmiCalculator;
	private JTextField Weight;
	private JTextField Height;
	private JButton btnCalculate,btnClear;
    private JComboBox comboFor,comboWeight,comboHeight;
    private JTextArea result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI window = new BMI();
					window.frmBmiCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBmiCalculator = new JFrame();
		frmBmiCalculator.getContentPane().setBackground(new Color(255, 69, 0));
		frmBmiCalculator.setTitle("BMI CALCULATOR");
		frmBmiCalculator.setBounds(100, 100, 661, 394);
		frmBmiCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmiCalculator.getContentPane().setLayout(null);
		
		JLabel lblKnowYourBody = new JLabel("KNOW YOUR BODY MASS INDEX");
		lblKnowYourBody.setForeground(Color.CYAN);
		lblKnowYourBody.setBounds(375, 12, 247, 15);
		frmBmiCalculator.getContentPane().add(lblKnowYourBody);
		
		comboFor = new JComboBox();
		comboFor.setModel(new DefaultComboBoxModel(new String[] {"CHILD AGE (2-19 YRS)", "ADULT AGE (20+ YRS)"}));
		comboFor.setBounds(391, 56, 231, 24);
		frmBmiCalculator.getContentPane().add(comboFor);
		
		JLabel lblCalculateBmiFor = new JLabel("BMI FOR: ");
		lblCalculateBmiFor.setForeground(new Color(0, 0, 0));
		lblCalculateBmiFor.setBounds(278, 61, 108, 15);
		frmBmiCalculator.getContentPane().add(lblCalculateBmiFor);
		
		JLabel lblWeight = new JLabel("weight:");
		lblWeight.setForeground(new Color(0, 0, 0));
		lblWeight.setBounds(285, 109, 70, 15);
		frmBmiCalculator.getContentPane().add(lblWeight);
		
	    comboWeight = new JComboBox();
		comboWeight.setModel(new DefaultComboBoxModel(new String[] {"Kgs", "Pounds"}));
		comboWeight.setBounds(474, 104, 148, 24);
		frmBmiCalculator.getContentPane().add(comboWeight);
		
		Weight = new JTextField();
		Weight.setBounds(363, 101, 83, 31);
		frmBmiCalculator.getContentPane().add(Weight);
		Weight.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(new Color(0, 0, 0));
		lblHeight.setBounds(285, 161, 70, 15);
		frmBmiCalculator.getContentPane().add(lblHeight);
		
		Height = new JTextField();
		Height.setColumns(10);
		Height.setBounds(363, 153, 83, 31);
		frmBmiCalculator.getContentPane().add(Height);
		
		comboHeight = new JComboBox();
		comboHeight.setForeground(Color.ORANGE);
		comboHeight.setBackground(Color.RED);
		comboHeight.setModel(new DefaultComboBoxModel(new String[] {"Meters", "Feet", "Inches(CHILDREN )"}));
		comboHeight.setBounds(474, 156, 148, 24);
		frmBmiCalculator.getContentPane().add(comboHeight);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(this);
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(0, 0, 255));
		btnClear.setBounds(375, 219, 117, 25);
		frmBmiCalculator.getContentPane().add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new TitledBorder(null, "RESULT", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(278, 256, 369, 95);
		frmBmiCalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		result = new JTextArea();
		result.setFont(new Font("Lato Black", Font.PLAIN, 12));
		result.setForeground(new Color(255, 255, 0));
		result.setBackground(new Color(105, 105, 105));
		result.setBounds(62, 22, 254, 61);
		panel.add(result);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(271, 0, 11, 356);
		frmBmiCalculator.getContentPane().add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 0, 139));
		panel_1.setBounds(14, 29, 246, 147);
		frmBmiCalculator.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBmi = new JLabel("BMI");
		lblBmi.setBounds(32, 12, 70, 15);
		panel_1.add(lblBmi);
		lblBmi.setForeground(Color.WHITE);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(139, 12, 70, 15);
		panel_1.add(lblStatus);
		lblStatus.setForeground(Color.WHITE);
		
		JLabel lblAdult_1 = new JLabel("<=18.4");
		lblAdult_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1.setBounds(42, 35, 70, 15);
		panel_1.add(lblAdult_1);
		lblAdult_1.setForeground(Color.CYAN);
		
		JLabel lblUnderweight = new JLabel("UNDERWEIGHT");
		lblUnderweight.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUnderweight.setBounds(122, 35, 112, 15);
		panel_1.add(lblUnderweight);
		lblUnderweight.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_1 = new JLabel("18.5 - 24.9");
		lblAdult_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1_1.setBounds(32, 62, 83, 15);
		panel_1.add(lblAdult_1_1);
		lblAdult_1_1.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_2 = new JLabel("NORMAL");
		lblAdult_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1_2.setBounds(120, 62, 70, 15);
		panel_1.add(lblAdult_1_2);
		lblAdult_1_2.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_3 = new JLabel("25.0 - 39.9");
		lblAdult_1_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1_3.setBounds(12, 89, 90, 15);
		panel_1.add(lblAdult_1_3);
		lblAdult_1_3.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_4 = new JLabel("OVERWEIGHT");
		lblAdult_1_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1_4.setBounds(110, 89, 99, 15);
		panel_1.add(lblAdult_1_4);
		lblAdult_1_4.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_5 = new JLabel(">=40");
		lblAdult_1_5.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAdult_1_5.setBounds(32, 116, 70, 15);
		panel_1.add(lblAdult_1_5);
		lblAdult_1_5.setForeground(Color.CYAN);
		
		JLabel lblAdult_1_6 = new JLabel("OBESE");
		lblAdult_1_6.setBounds(120, 116, 70, 15);
		panel_1.add(lblAdult_1_6);
		lblAdult_1_6.setForeground(Color.CYAN);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(110, 26, 11, 118);
		panel_1.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.RED);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(12, 26, 207, 15);
		panel_1.add(separator_2_1);
		separator_2_1.setForeground(Color.RED);
		
		btnCalculate = new JButton("CALCULATE");
		btnCalculate.setBounds(519, 219, 117, 25);
		frmBmiCalculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(this);
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(new Color(0, 0, 255));
		
		JLabel lblIndexer = new JLabel("INDEXER");
		lblIndexer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndexer.setForeground(Color.CYAN);
		lblIndexer.setBounds(21, 12, 247, 15);
		frmBmiCalculator.getContentPane().add(lblIndexer);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		Object btn = ev.getSource();
	
		
		if(btn.equals(btnCalculate)) 
		{
			if(comboFor.getSelectedIndex()==0)
			{
				//calculate for child
				JOptionPane.showMessageDialog(null, "This phase is Under Construction!!");
			}
			
			
			//calculate for Adult
			else if(comboFor.getSelectedIndex()==1)
			{
	
				if(comboHeight.getSelectedIndex()==0 && comboWeight.getSelectedIndex()==0)
				{
					//combination  meters and kilograms
					ShowAdult(CalculateBMI(Double.parseDouble(Weight.getText()),  Double.parseDouble(Height.getText())));
				}
				else if(comboHeight.getSelectedIndex()==0 && comboWeight.getSelectedIndex()==1)
				{
					//combination meters and pounds
					ShowAdult(CalculateBMI(poundsTokilos(Double.parseDouble(Weight.getText())), Double.parseDouble(Height.getText())));
					
				}
				
				else if(comboHeight.getSelectedIndex()==1 && comboWeight.getSelectedIndex()==1)
				{
					//combination feet and pounds
					
					ShowAdult(CalculateBMI(poundsTokilos(Double.parseDouble(Weight.getText())),feetTometers( Double.parseDouble(Height.getText()))));
				}
				
				else if(comboHeight.getSelectedIndex()==1 && comboWeight.getSelectedIndex()==0)
				{
					//combination feet and kilograms
					ShowAdult(CalculateBMI(Double.parseDouble(Weight.getText()), feetTometers(Double.parseDouble(Height.getText()))));
				}
				
			}
		}
		else if(btn.equals(btnClear))
		{
			Clear();
		}
	}

	private void Clear() 
	{
		// TODO clear all fields
		Height.setText("");
		Weight.setText("");
		comboHeight.setSelectedIndex(0);
		comboWeight.setSelectedIndex(0);
		comboFor.setSelectedIndex(0);
	}
	
	
	// a method to calculate BMI
	private double CalculateBMI(double weight, double height) 
	{
		return weight/(height * height);
	}
	
	
	//a method to convert feet to Meters
	private double feetTometers(double feet) {
		return (feet*0.305);
	}
	
	
	//convert pounds to kilos
	private double poundsTokilos(double pounds) 
	{
			return (pounds*0.454);
		}
	

	//convert inches to meters
	private double inchTometers(double inch) 
	{
			return (inch*0.0254);
		}
	
	
	//update Adult status
	private String Astatus(double value)
	{
		String mstatus = null;
		if( value<=18.4) {
			mstatus = "Underweight";
		}
		
		else if( value>18.4 && value<=24.9) {
			mstatus = "NormalWeight";
		}
		
		else if(value>24.9 && value<=39.0) {
			mstatus = "OverWeight";
		}
		
		else if( value>=40) {
			mstatus = "Obesed";
		}
		return mstatus;
	}
	//show result
	private void ShowAdult(Double mbmi)
	{
		DecimalFormat formatter = new DecimalFormat("#.##");
		result.setText("BMI Value: "+formatter.format(mbmi)+"\n"+"STATUS : "+Astatus(mbmi));
		
	}
}
