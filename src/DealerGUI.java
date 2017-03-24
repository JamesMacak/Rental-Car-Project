import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DealerGUI {

	private Customer activeCustomer;
	private Privileged activePrivilegedCutomer;
	private Basic activeBasicCustomer;
	private Rental activeContract;

	private JFrame frame;
	private JPanel returnPanel, displayScreen, basePanel, newCustomerPanel;

	private List customerList, contractList;
	private Choice customerCategorySelector;

	private JLabel customerName, customerDateOfBirth, customerSocialSecurityNumber, lblCustomerAge, lblCustomerGender,
			lblCustomerAddress1, lblCustomerAddress2, lblCustomerAddress3, lblCustomerAttributePrivilege,
			lblCustomerAttributeWaiting, lblCustomerAttributeBasic, lblActiceContractName, lblRentalVehicle,
			lblRentalStartDate, lblRentalEndDate, lblRentalPricePerDay, lblRentalSale;

	private JTextField txtSearch, txtRentalDate, txtRentalAmount, txtGasLevel, txtMiles, txtNewCustomerLastName,
			txtNewCustomerDOB, txtNewCustomerSSN, txtNewCustomerGender, txtNewCustomerAddress1, txtNewCustomerAddress2,
			txtNewCustomerAddress3;

	/**
	 * Launch the application.
	 */
	public void run() {
		DealerGUI window = new DealerGUI();
		window.frame.setVisible(true);
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

		displayScreen = new JPanel();
		displayScreen.setBounds(0, 0, 1200, 1);
		frame.getContentPane().add(displayScreen);
		displayScreen.setLayout(null);

		basePanel = new JPanel();
		basePanel.setBounds(587, 252, 365, 416);
		frame.getContentPane().add(basePanel);
		basePanel.setLayout(null);

		List privilegeWaitList = new List();
		privilegeWaitList.setBounds(6, 68, 174, 195);
		basePanel.add(privilegeWaitList);

		JLabel lblWaitList = new JLabel("Wait List");
		lblWaitList.setBounds(6, 6, 105, 33);
		basePanel.add(lblWaitList);
		lblWaitList.setFont(new Font("Times New Roman", Font.PLAIN, 28));

		JLabel lblSales = new JLabel("Sales           $");
		lblSales.setBounds(6, 269, 137, 29);
		basePanel.add(lblSales);
		lblSales.setFont(new Font("Times New Roman", Font.PLAIN, 24));

		List slaesList = new List();
		slaesList.setBounds(6, 304, 359, 102);
		basePanel.add(slaesList);

		List basicWaitList = new List();
		basicWaitList.setBounds(191, 68, 174, 195);
		basePanel.add(basicWaitList);

		Label label_8 = new Label("Privileged");
		label_8.setBounds(6, 46, 105, 16);
		basePanel.add(label_8);

		Label label_9 = new Label("Basic");
		label_9.setBounds(191, 46, 105, 16);
		basePanel.add(label_9);

		JLabel lblTotalSales = new JLabel("0000.00");
		lblTotalSales.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTotalSales.setBounds(155, 269, 210, 29);
		basePanel.add(lblTotalSales);

		JLabel lblEclipseVehicleRentals = new JLabel("Eclipse Vehicle Rentals");
		lblEclipseVehicleRentals.setVerticalAlignment(SwingConstants.TOP);
		lblEclipseVehicleRentals.setHorizontalAlignment(SwingConstants.LEFT);
		lblEclipseVehicleRentals.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEclipseVehicleRentals.setBounds(4, 4, 240, 29);
		frame.getContentPane().add(lblEclipseVehicleRentals);

		customerCategorySelector = new Choice();
		customerCategorySelector.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerCategorySelector.setBounds(0, 45, 240, 27);
		frame.getContentPane().add(customerCategorySelector);
		customerCategorySelector.add("All Customers");
		customerCategorySelector.add("Privileged Customers");
		customerCategorySelector.add("Basic Customers");
		customerCategorySelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customerList.removeAll();
				fillCustomerList(customerCategorySelector.getSelectedItem());
			}
		});

		customerList = new List();
		customerList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		customerList.setBounds(4, 78, 240, 346);
		frame.getContentPane().add(customerList);
		customerList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					activeCustomer = Dealer.getCustomer(customerList.getSelectedItem().substring(0, 7));
					if (activeCustomer.isPrivileged()) {
						activePrivilegedCutomer = Dealer.getPrivilegedCustomer(activeCustomer);
						activeBasicCustomer = null;
					} else {
						activePrivilegedCutomer = null;
						activeBasicCustomer = Dealer.getBasicCustomer(activeCustomer);
					}
					activeContract = activeCustomer.getActiveRentalContract();

					fillCustomerData();
					if (activeContract != null) {
						lblActiceContractName.setText(activeContract.getContractNumber());
					} else {
						lblActiceContractName.setText("NO CONTRACT");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

				
				System.out.println(activeContract);
			}
		});

		for (Customer customer : Dealer.getCustomers()) {
			customerList.add(customer.toString());
		}

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDetails.setBounds(273, 13, 61, 16);
		frame.getContentPane().add(lblDetails);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblName.setBounds(246, 41, 61, 16);
		frame.getContentPane().add(lblName);

		customerName = new JLabel("NULL");
		customerName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerName.setBounds(319, 41, 95, 16);
		frame.getContentPane().add(customerName);

		JLabel lblDateOfBirth = new JLabel("DOB:");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(246, 69, 61, 16);
		frame.getContentPane().add(lblDateOfBirth);

		customerDateOfBirth = new JLabel("NULL");
		customerDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerDateOfBirth.setBounds(319, 69, 95, 16);
		frame.getContentPane().add(customerDateOfBirth);

		JLabel lblSocialSecurityNumber = new JLabel("SSN:");
		lblSocialSecurityNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSocialSecurityNumber.setBounds(250, 97, 61, 16);
		frame.getContentPane().add(lblSocialSecurityNumber);

		customerSocialSecurityNumber = new JLabel("NULL");
		customerSocialSecurityNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		customerSocialSecurityNumber.setBounds(319, 97, 95, 16);
		frame.getContentPane().add(customerSocialSecurityNumber);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAge.setBounds(250, 126, 61, 16);
		frame.getContentPane().add(lblAge);

		lblCustomerAge = new JLabel("NULL");
		lblCustomerAge.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAge.setBounds(319, 125, 95, 16);
		frame.getContentPane().add(lblCustomerAge);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGender.setBounds(250, 154, 61, 16);
		frame.getContentPane().add(lblGender);

		lblCustomerGender = new JLabel("NULL");
		lblCustomerGender.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerGender.setBounds(319, 154, 95, 16);
		frame.getContentPane().add(lblCustomerGender);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAddress.setBounds(246, 182, 61, 16);
		frame.getContentPane().add(lblAddress);

		lblCustomerAddress1 = new JLabel("NULL");
		lblCustomerAddress1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress1.setBounds(319, 182, 121, 17);
		frame.getContentPane().add(lblCustomerAddress1);

		lblCustomerAddress2 = new JLabel("NULL");
		lblCustomerAddress2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress2.setBounds(319, 200, 95, 16);
		frame.getContentPane().add(lblCustomerAddress2);

		lblCustomerAddress3 = new JLabel("NULL");
		lblCustomerAddress3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerAddress3.setBounds(319, 219, 95, 16);
		frame.getContentPane().add(lblCustomerAddress3);

		JPanel VehicleMenu = new JPanel();
		VehicleMenu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rent A Vehicle",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		VehicleMenu.setBounds(273, 266, 299, 203);
		frame.getContentPane().add(VehicleMenu);
		VehicleMenu.setLayout(null);

		JLabel lblErrorMessage = new JLabel("SOME ERROR MESSAGE");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrorMessage.setBounds(6, 18, 287, 16);
		VehicleMenu.add(lblErrorMessage);

		JButton btnCar = new JButton("Car");
		btnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCar.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnCar.setBounds(6, 46, 90, 90);
		VehicleMenu.add(btnCar);

		JButton btnVan = new JButton("Van");
		btnVan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVan.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnVan.setBounds(104, 46, 90, 90);
		VehicleMenu.add(btnVan);

		JButton btnTruck = new JButton("Truck");
		btnTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTruck.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnTruck.setBounds(203, 46, 90, 90);
		VehicleMenu.add(btnTruck);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		avaliableVehicles.setBounds(273, 513, 299, 155);
		frame.getContentPane().add(avaliableVehicles);

		JLabel lblAvailableVehicles = new JLabel("Available Vehicles");
		lblAvailableVehicles.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableVehicles.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblAvailableVehicles.setBounds(273, 481, 299, 29);
		frame.getContentPane().add(lblAvailableVehicles);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			}
		});

		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtSearch.setText("Search");
		txtSearch.setBounds(4, 430, 240, 39);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblNewRentalContract = new JLabel("New Rental Contract");
		lblNewRentalContract.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRentalContract.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewRentalContract.setBounds(8, 481, 263, 29);
		frame.getContentPane().add(lblNewRentalContract);

		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustomer.setBounds(6, 512, 66, 16);
		frame.getContentPane().add(lblCustomer);

		JLabel lblVehicle = new JLabel("Vehicle:");
		lblVehicle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVehicle.setBounds(-2, 539, 74, 16);
		frame.getContentPane().add(lblVehicle);

		JLabel lblRentalDate = new JLabel("Date:");
		lblRentalDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRentalDate.setBounds(-14, 567, 86, 16);
		frame.getContentPane().add(lblRentalDate);

		JLabel lblCustomerRental = new JLabel("NULL");
		lblCustomerRental.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerRental.setBounds(84, 512, 176, 16);
		frame.getContentPane().add(lblCustomerRental);

		JLabel lblVehicleRental = new JLabel("NULL");
		lblVehicleRental.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblVehicleRental.setBounds(84, 540, 176, 16);
		frame.getContentPane().add(lblVehicleRental);

		JButton btnCreateNewContract = new JButton("Create Contract");
		btnCreateNewContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateNewContract.setBounds(0, 643, 244, 29);
		frame.getContentPane().add(btnCreateNewContract);

		txtRentalDate = new JTextField();
		txtRentalDate.setText("DATE");
		txtRentalDate.setBounds(78, 562, 130, 26);
		frame.getContentPane().add(txtRentalDate);
		txtRentalDate.setColumns(10);

		JLabel lblPricePerDay = new JLabel("Price/Day");
		lblPricePerDay.setBounds(4, 595, 61, 16);
		frame.getContentPane().add(lblPricePerDay);

		Checkbox checkboxDefualtPrice = new Checkbox("Default Price");
		checkboxDefualtPrice.setFont(new Font("Dialog", Font.PLAIN, 10));
		checkboxDefualtPrice.setBounds(14, 618, 95, 23);
		frame.getContentPane().add(checkboxDefualtPrice);

		JLabel lblCustomAmount = new JLabel("Custom: $");
		lblCustomAmount.setBounds(111, 622, 66, 16);
		frame.getContentPane().add(lblCustomAmount);

		txtRentalAmount = new JTextField();
		txtRentalAmount.setBounds(175, 617, 55, 26);
		frame.getContentPane().add(txtRentalAmount);
		txtRentalAmount.setColumns(10);

		JLabel lblActiveContract = new JLabel("Active Contract");
		lblActiveContract.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblActiveContract.setBounds(440, 13, 100, 16);
		frame.getContentPane().add(lblActiveContract);

		lblActiceContractName = new JLabel("NULL");
		lblActiceContractName.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiceContractName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblActiceContractName.setBounds(440, 40, 149, 16);
		frame.getContentPane().add(lblActiceContractName);

		JButton btnNewButton_3 = new JButton("Return");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnPanel.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		btnNewButton_3.setBounds(543, 7, 46, 29);
		frame.getContentPane().add(btnNewButton_3);

		returnPanel = new JPanel();
		returnPanel.setBounds(440, 62, 149, 106);
		frame.getContentPane().add(returnPanel);
		returnPanel.setLayout(null);

		JLabel lblGasLevel = new JLabel("Gas Level:");
		lblGasLevel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGasLevel.setBounds(6, 6, 63, 16);
		returnPanel.add(lblGasLevel);

		JLabel lblMiles = new JLabel("Miles:");
		lblMiles.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMiles.setBounds(6, 26, 63, 16);
		returnPanel.add(lblMiles);

		JCheckBox chckboxIsDamaged = new JCheckBox("Damaged");
		chckboxIsDamaged.setHorizontalAlignment(SwingConstants.CENTER);
		chckboxIsDamaged.setBounds(6, 46, 137, 23);
		returnPanel.add(chckboxIsDamaged);

		txtGasLevel = new JTextField();
		txtGasLevel.setBounds(73, 1, 70, 26);
		returnPanel.add(txtGasLevel);
		txtGasLevel.setColumns(10);

		txtMiles = new JTextField();
		txtMiles.setColumns(10);
		txtMiles.setBounds(73, 21, 70, 26);
		returnPanel.add(txtMiles);

		JButton btnConfirmRetrun = new JButton("Confirm");
		btnConfirmRetrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnPanel.setVisible(false);
			}
		});
		btnConfirmRetrun.setBounds(16, 71, 117, 29);
		returnPanel.add(btnConfirmRetrun);

		lblCustomerAttributePrivilege = new JLabel("Priviliged");
		lblCustomerAttributePrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerAttributePrivilege.setBounds(440, 181, 149, 16);
		frame.getContentPane().add(lblCustomerAttributePrivilege);

		lblCustomerAttributeWaiting = new JLabel("On Wait List");
		lblCustomerAttributeWaiting.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerAttributeWaiting.setBounds(440, 218, 149, 16);
		frame.getContentPane().add(lblCustomerAttributeWaiting);

		lblCustomerAttributeBasic = new JLabel("Basic");
		lblCustomerAttributeBasic.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerAttributeBasic.setBounds(440, 200, 149, 16);
		frame.getContentPane().add(lblCustomerAttributeBasic);

		JLabel lblAllContracts = new JLabel("All Contracts");
		lblAllContracts.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAllContracts.setBounds(601, 13, 100, 16);
		frame.getContentPane().add(lblAllContracts);

		contractList = new List();
		contractList.setBounds(601, 35, 138, 115);
		frame.getContentPane().add(contractList);
		contractList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(contractList.getSelectedItem());
				fillRentalData();
			}
		});

		JLabel label = new JLabel("Details");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setBounds(763, 13, 61, 16);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Vehicle:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(763, 35, 66, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblDateStart = new JLabel("Start Date:");
		lblDateStart.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateStart.setBounds(763, 56, 66, 16);
		frame.getContentPane().add(lblDateStart);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndDate.setBounds(763, 78, 66, 16);
		frame.getContentPane().add(lblEndDate);

		JLabel lblPrice = new JLabel("Price/Day:");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(763, 106, 66, 16);
		frame.getContentPane().add(lblPrice);

		JLabel lblSale = new JLabel("Sale:");
		lblSale.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSale.setBounds(763, 134, 66, 16);
		frame.getContentPane().add(lblSale);

		JLabel label_1 = new JLabel("$");
		label_1.setBounds(833, 107, 8, 16);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("$");
		label_2.setBounds(833, 135, 8, 16);
		frame.getContentPane().add(label_2);

		lblRentalVehicle = new JLabel("NULL");
		lblRentalVehicle.setBounds(838, 56, 111, 16);
		frame.getContentPane().add(lblRentalVehicle);

		lblRentalStartDate = new JLabel("NULL");
		lblRentalStartDate.setBounds(838, 78, 111, 16);
		frame.getContentPane().add(lblRentalStartDate);

		lblRentalEndDate = new JLabel("NULL");
		lblRentalEndDate.setBounds(848, 106, 104, 16);
		frame.getContentPane().add(lblRentalEndDate);

		lblRentalPricePerDay = new JLabel("NULL");
		lblRentalPricePerDay.setBounds(838, 35, 111, 16);
		frame.getContentPane().add(lblRentalPricePerDay);

		lblRentalSale = new JLabel("NULL");
		lblRentalSale.setBounds(849, 134, 104, 16);
		frame.getContentPane().add(lblRentalSale);
		newCustomerPanel = new JPanel();
		newCustomerPanel.setForeground(SystemColor.window);
		newCustomerPanel.setBackground(SystemColor.window);
		newCustomerPanel.setBounds(587, 252, 362, 416);
		frame.getContentPane().add(newCustomerPanel);
		newCustomerPanel.setLayout(null);
		newCustomerPanel.setVisible(false);

		JLabel lblCreateNewCustomer = new JLabel("Create New Customer");
		lblCreateNewCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblCreateNewCustomer.setBounds(6, 6, 299, 29);
		newCustomerPanel.add(lblCreateNewCustomer);

		JLabel lblName_1 = new JLabel("First Name:");
		lblName_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName_1.setBounds(6, 47, 77, 16);
		newCustomerPanel.add(lblName_1);

		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastname.setBounds(6, 75, 77, 16);
		newCustomerPanel.add(lblLastname);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDob.setBounds(6, 103, 77, 16);
		newCustomerPanel.add(lblDob);

		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSsn.setBounds(6, 159, 77, 16);
		newCustomerPanel.add(lblSsn);

		JLabel lblGender_1 = new JLabel("Gender");
		lblGender_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender_1.setBounds(6, 187, 77, 16);
		newCustomerPanel.add(lblGender_1);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress_1.setBounds(6, 215, 77, 16);
		newCustomerPanel.add(lblAddress_1);

		JLabel lblAge_1 = new JLabel("Age:");
		lblAge_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAge_1.setBounds(6, 131, 77, 16);
		newCustomerPanel.add(lblAge_1);

		JTextField txtNewCustomerFirstName = new JTextField();
		txtNewCustomerFirstName.setBounds(95, 42, 261, 26);
		newCustomerPanel.add(txtNewCustomerFirstName);
		txtNewCustomerFirstName.setColumns(10);

		txtNewCustomerLastName = new JTextField();
		txtNewCustomerLastName.setColumns(10);
		txtNewCustomerLastName.setBounds(95, 70, 261, 26);
		newCustomerPanel.add(txtNewCustomerLastName);

		txtNewCustomerDOB = new JTextField();
		txtNewCustomerDOB.setColumns(10);
		txtNewCustomerDOB.setBounds(95, 98, 261, 26);
		newCustomerPanel.add(txtNewCustomerDOB);

		txtNewCustomerSSN = new JTextField();
		txtNewCustomerSSN.setColumns(10);
		txtNewCustomerSSN.setBounds(95, 154, 261, 26);
		newCustomerPanel.add(txtNewCustomerSSN);

		txtNewCustomerGender = new JTextField();
		txtNewCustomerGender.setColumns(10);
		txtNewCustomerGender.setBounds(95, 182, 261, 26);
		newCustomerPanel.add(txtNewCustomerGender);

		txtNewCustomerAddress1 = new JTextField();
		txtNewCustomerAddress1.setColumns(10);
		txtNewCustomerAddress1.setBounds(95, 210, 261, 26);
		newCustomerPanel.add(txtNewCustomerAddress1);

		txtNewCustomerAddress2 = new JTextField();
		txtNewCustomerAddress2.setColumns(10);
		txtNewCustomerAddress2.setBounds(95, 238, 261, 26);
		newCustomerPanel.add(txtNewCustomerAddress2);

		txtNewCustomerAddress3 = new JTextField();
		txtNewCustomerAddress3.setColumns(10);
		txtNewCustomerAddress3.setBounds(95, 266, 261, 26);
		newCustomerPanel.add(txtNewCustomerAddress3);

		JButton btnNewCustomerCreate = new JButton("Create New Customer");
		btnNewCustomerCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewCustomerCreate.setBounds(6, 304, 350, 36);
		newCustomerPanel.add(btnNewCustomerCreate);

		JLabel lblNewCustomerID = new JLabel("XXXXXXX");
		lblNewCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCustomerID.setBounds(95, 381, 184, 29);
		newCustomerPanel.add(lblNewCustomerID);

		JLabel lblAccount = new JLabel("Customer ID Number");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setBounds(6, 346, 350, 29);
		newCustomerPanel.add(lblAccount);

		JButton btnNewCustomerClose = new JButton("Close");
		btnNewCustomerClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCustomerPanel.setVisible(false);
				basePanel.setVisible(true);
			}
		});
		btnNewCustomerClose.setBounds(6, 387, 88, 29);
		newCustomerPanel.add(btnNewCustomerClose);

		JLabel lblNewCustomerAge = new JLabel("AGE");
		lblNewCustomerAge.setBounds(99, 131, 251, 16);
		newCustomerPanel.add(lblNewCustomerAge);

		JButton btnMainCreateNewCustomer = new JButton("Create New Customer");
		btnMainCreateNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basePanel.setVisible(false);
				newCustomerPanel.setVisible(true);
			}
		});
		btnMainCreateNewCustomer.setBounds(587, 182, 362, 60);
		frame.getContentPane().add(btnMainCreateNewCustomer);

		JTextArea noContractToReturn = new JTextArea();
		noContractToReturn.setBackground(SystemColor.window);
		noContractToReturn.setEditable(false);
		noContractToReturn.setRows(2);
		noContractToReturn.setText("\n\n       NO CONTRACT \n          TO RETURN");
		noContractToReturn.setBounds(440, 63, 149, 106);
		frame.getContentPane().add(noContractToReturn);
		noContractToReturn.setLineWrap(true);

		txtRentalAmount = new JTextField();
		txtRentalAmount.setBounds(181, 618, 51, 26);
		frame.getContentPane().add(txtRentalAmount);
		txtRentalAmount.setColumns(10);

		returnPanel.setVisible(false);

	}

	private void fillCustomerData() {

		customerName.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
		customerDateOfBirth.setText(activeCustomer.getDateOfBirth());
		customerSocialSecurityNumber.setText(activeCustomer.getSocialSecurityNumber());
		lblCustomerAge.setText(activeCustomer.getAge());
		lblCustomerGender.setText(activeCustomer.getGender());
		lblCustomerAddress1.setText(activeCustomer.getAddressSub1());
		lblCustomerAddress2.setText(activeCustomer.getAddressSub2());
		lblCustomerAddress3.setText(activeCustomer.getAddressSub3());

		if (activeCustomer.isPrivileged()) {
			lblCustomerAttributePrivilege.setVisible(true);
			lblCustomerAttributeBasic.setVisible(false);
		} else {
			lblCustomerAttributePrivilege.setVisible(false);
			lblCustomerAttributeBasic.setVisible(true);
		}

		if (activeCustomer.isWaiting()) {
			lblCustomerAttributeWaiting.setVisible(true);
		} else {
			lblCustomerAttributeWaiting.setVisible(false);
		}

		contractList.removeAll();
		for (Rental rental : activeCustomer.getRentalContracts()) {
			contractList.add(rental.getContractNumber());
		}
	}

	private void fillRentalData() {
		Rental r = null;
		for (Rental rental : activeCustomer.getRentalContracts()) {
			if (contractList.getSelectedItem().equals(rental.toString())) {
				r = rental;
			}
		}
		System.out.println(r);
//		lblRentalVehicle.setText(r.getVehicle().getCompanyID());
//		lblRentalStartDate.setText(r.getStartDate());
//		lblRentalEndDate.setText(r.getEndDate());
//		lblRentalPricePerDay.setText(Double.toString(r.getDailyPrice()));
//		lblRentalSale.setText(Dealer.calculateSale(r));
	}

	private void fillCustomerList(String choice) {

		switch (choice) {
		case "All Customers":
			for (Customer customer : Dealer.getCustomers()) {
				customerList.add(customer.toString());
			}
			break;

		case "Privileged Customers":
			for (Privileged customer : Dealer.getPrivilegedCustomers()) {
				customerList.add(customer.toString());
			}
			break;

		case "Basic Customers":
			for (Basic customer : Dealer.getBasicCustomers()) {
				customerList.add(customer.toString());
			}
			break;
		}
	}
}
