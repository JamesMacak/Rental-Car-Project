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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class DealerGUI {

	private JFrame frame;
	private JTextField txtSearch;

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
		frame.setBounds(100, 100, 958, 700);
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
		customerName.setBounds(346, 41, 226, 16);
		frame.getContentPane().add(customerName);
		
		JLabel lblDateOfBirth = new JLabel("DOB:");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(273, 69, 61, 16);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel customerDateOfBirth = new JLabel("NULL");
		customerDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerDateOfBirth.setBounds(346, 69, 226, 16);
		frame.getContentPane().add(customerDateOfBirth);
		
		JLabel lblSocialSecurityNumber = new JLabel("SSN:");
		lblSocialSecurityNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSocialSecurityNumber.setBounds(273, 99, 61, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel customerSocialSecurityNumber = new JLabel("NULL");
		customerSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerSocialSecurityNumber.setBounds(346, 98, 226, 16);
		frame.getContentPane().add(customerSocialSecurityNumber);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAge.setBounds(273, 127, 61, 16);
		frame.getContentPane().add(lblAge);
		
		JLabel lblCustomerAge = new JLabel("NULL");
		lblCustomerAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAge.setBounds(346, 126, 226, 16);
		frame.getContentPane().add(lblCustomerAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGender.setBounds(273, 155, 61, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblCustomerGender = new JLabel("NULL");
		lblCustomerGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerGender.setBounds(346, 154, 226, 16);
		frame.getContentPane().add(lblCustomerGender);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAddress.setBounds(273, 183, 61, 16);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCustomerAddress1 = new JLabel("NULL");
		lblCustomerAddress1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress1.setBounds(346, 182, 226, 17);
		frame.getContentPane().add(lblCustomerAddress1);
		
		JLabel lblCustomerAddress2 = new JLabel("NULL");
		lblCustomerAddress2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress2.setBounds(346, 200, 226, 16);
		frame.getContentPane().add(lblCustomerAddress2);
		
		JLabel lblCustomerAddress3 = new JLabel("NULL");
		lblCustomerAddress3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress3.setBounds(346, 218, 226, 16);
		frame.getContentPane().add(lblCustomerAddress3);
		
		JPanel VehicleMenu = new JPanel();
		VehicleMenu.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		VehicleMenu.setBounds(273, 266, 299, 203);
		frame.getContentPane().add(VehicleMenu);
		VehicleMenu.setLayout(null);
		
		JLabel lblErrorMessage = new JLabel("SOME ERROR MESSAGE");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrorMessage.setBounds(6, 18, 287, 16);
		VehicleMenu.add(lblErrorMessage);
		
		JButton btnCar = new JButton("Car");
		btnCar.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnCar.setBounds(6, 46, 90, 90);
		VehicleMenu.add(btnCar);
		
		JButton btnVan = new JButton("Van");
		btnVan.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnVan.setBounds(104, 46, 90, 90);
		VehicleMenu.add(btnVan);
		
		JButton btnTruck = new JButton("Truck");
		btnTruck.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnTruck.setBounds(203, 46, 90, 90);
		VehicleMenu.add(btnTruck);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(26, 148, 117, 38);
		VehicleMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wait");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(155, 148, 117, 38);
		VehicleMenu.add(btnNewButton_1);
		
		List avaliableVehicles = new List();
		avaliableVehicles.setBounds(601, 45, 348, 291);
		frame.getContentPane().add(avaliableVehicles);
		
		List waitList = new List();
		waitList.setBounds(601, 377, 348, 291);
		frame.getContentPane().add(waitList);
		
		JLabel lblAvailableVehicles = new JLabel("Available Vehicles");
		lblAvailableVehicles.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblAvailableVehicles.setBounds(601, 13, 348, 29);
		frame.getContentPane().add(lblAvailableVehicles);
		
		JLabel lblWaitList = new JLabel("Wait List");
		lblWaitList.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblWaitList.setBounds(601, 342, 348, 29);
		frame.getContentPane().add(lblWaitList);
		
		txtSearch = new JTextField();
		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtSearch.setText("Search");
		txtSearch.setBounds(4, 516, 240, 39);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSales.setBounds(273, 481, 299, 29);
		frame.getContentPane().add(lblSales);
		
		List list = new List();
		list.setBounds(273, 522, 299, 146);
		frame.getContentPane().add(list);
	}
}
