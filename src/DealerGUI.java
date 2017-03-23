import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.border.TitledBorder;

public class DealerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealerGUI window = new DealerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DealerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel displayScreen = new JPanel();
		displayScreen.setBounds(0, 0, 1200, 1);
		frame.getContentPane().add(displayScreen);
		displayScreen.setLayout(null);
		
		JLabel lblEclipseVehicleRentals = new JLabel("Eclipse Vehicle Rentals");
		lblEclipseVehicleRentals.setVerticalAlignment(SwingConstants.TOP);
		lblEclipseVehicleRentals.setHorizontalAlignment(SwingConstants.LEFT);
		lblEclipseVehicleRentals.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEclipseVehicleRentals.setBounds(4, 4, 240, 29);
		frame.getContentPane().add(lblEclipseVehicleRentals);
		
		JComboBox customerCategorySelector = new JComboBox();
		customerCategorySelector.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerCategorySelector.setBounds(0, 45, 240, 27);
		frame.getContentPane().add(customerCategorySelector);
		
		List customerList = new List();
		customerList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		customerList.setBounds(4, 78, 240, 388);
		frame.getContentPane().add(customerList);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDetails.setBounds(273, 13, 61, 16);
		frame.getContentPane().add(lblDetails);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblName.setBounds(273, 41, 61, 16);
		frame.getContentPane().add(lblName);
		
		JLabel customerName = new JLabel("NULL");
		customerName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerName.setBounds(346, 41, 80, 16);
		frame.getContentPane().add(customerName);
		
		JLabel lblDateOfBirth = new JLabel("DOB:");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(273, 69, 61, 16);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel customerDateOfBirth = new JLabel("NULL");
		customerDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerDateOfBirth.setBounds(346, 69, 80, 16);
		frame.getContentPane().add(customerDateOfBirth);
		
		JLabel lblSocialSecurityNumber = new JLabel("SSN:");
		lblSocialSecurityNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSocialSecurityNumber.setBounds(273, 99, 61, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel customerSocialSecurityNumber = new JLabel("NULL");
		customerSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerSocialSecurityNumber.setBounds(346, 98, 80, 16);
		frame.getContentPane().add(customerSocialSecurityNumber);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAge.setBounds(273, 127, 61, 16);
		frame.getContentPane().add(lblAge);
		
		JLabel lblCustomerAge = new JLabel("NULL");
		lblCustomerAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAge.setBounds(346, 126, 80, 16);
		frame.getContentPane().add(lblCustomerAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGender.setBounds(273, 155, 61, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblCustomerGender = new JLabel("NULL");
		lblCustomerGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerGender.setBounds(346, 154, 80, 16);
		frame.getContentPane().add(lblCustomerGender);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAddress.setBounds(273, 183, 61, 16);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCustomerAddress1 = new JLabel("NULL");
		lblCustomerAddress1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress1.setBounds(346, 182, 80, 17);
		frame.getContentPane().add(lblCustomerAddress1);
		
		JLabel lblCustomerAddress2 = new JLabel("NULL");
		lblCustomerAddress2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress2.setBounds(346, 200, 80, 16);
		frame.getContentPane().add(lblCustomerAddress2);
		
		JLabel lblCustomerAddress3 = new JLabel("NULL");
		lblCustomerAddress3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress3.setBounds(346, 218, 81, 16);
		frame.getContentPane().add(lblCustomerAddress3);
		
		JPanel VehicleMenu = new JPanel();
		VehicleMenu.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		VehicleMenu.setBounds(273, 266, 240, 200);
		frame.getContentPane().add(VehicleMenu);
		VehicleMenu.setLayout(null);
		
		JLabel lblErrorMessage = new JLabel("SOME ERROR MESSAGE");
		lblErrorMessage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrorMessage.setBounds(6, 18, 228, 16);
		VehicleMenu.add(lblErrorMessage);
	}
}
