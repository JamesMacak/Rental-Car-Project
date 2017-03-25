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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DealerGUI {

	// Its working

	private Customer activeCustomer;
	private Rental activeContract;
	private Vehicle activeVehicle;

	private JFrame frame;
	private JPanel returnPanel, displayScreen, basePanel, newCustomerPanel;

	private List customerList, contractList, avaliableVehicles, privilegeWaitList, basicWaitList, salesList;;
	private Choice customerCategorySelector;

	private JButton btnNewCustomerCreate, btnConfirmRetrun, btnReturn, btnWait, btnCreateNewContract;
	private JCheckBox chckboxIsDamaged, checkboxDefualtPrice;

	private JLabel customerName, customerDateOfBirth, customerSocialSecurityNumber, lblCustomerAge, lblCustomerGender,
			lblCustomerAddress1, lblCustomerAddress2, lblCustomerAddress3, lblCustomerAttributePrivilege,
			lblCustomerAttributeWaiting, lblCustomerAttributeBasic, lblActiceContractName, lblStartDateRentalDetail,
			lblEndDateRentalDetail, lblPricePerDayRentalDetail, lblVehicleRentalDetail, lblRentalSale, lblNewCustomerID,
			lblNewCustomerAge, lblTotalSales, lblErrorMessage, lblCustomerRental, lblVehicleRental;

	private JTextField txtSearch, txtRentalDate, txtRentalAmount, txtGasLevel, txtMiles, txtNewCustomerFirstName,
			txtNewCustomerLastName, txtNewCustomerDOB, txtNewCustomerSSN, txtNewCustomerGender, txtNewCustomerAddress1,
			txtNewCustomerAddress2, txtNewCustomerAddress3;

	JTextArea noContractToReturn;

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

		privilegeWaitList = new List();
		privilegeWaitList.setBounds(6, 68, 174, 195);
		basePanel.add(privilegeWaitList);
		privilegeWaitList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				basicWaitList.deselect(basicWaitList.getSelectedIndex());
				salesList.deselect(salesList.getSelectedIndex());
				customerCategorySelector.select("Privileged Customers");
				customerList.removeAll();
				fillCustomerList(customerCategorySelector.getSelectedItem());

				getSelectedFromList(privilegeWaitList.getSelectedItem());
			}
		});

		JLabel lblWaitList = new JLabel("Wait List");
		lblWaitList.setBounds(6, 6, 105, 33);
		basePanel.add(lblWaitList);
		lblWaitList.setFont(new Font("Times New Roman", Font.PLAIN, 28));

		JLabel lblSales = new JLabel("Sales           $");
		lblSales.setBounds(6, 269, 137, 29);
		basePanel.add(lblSales);
		lblSales.setFont(new Font("Times New Roman", Font.PLAIN, 24));

		salesList = new List();
		salesList.setBounds(6, 304, 359, 102);
		basePanel.add(salesList);
		salesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				privilegeWaitList.deselect(privilegeWaitList.getSelectedIndex());
				basicWaitList.deselect(basicWaitList.getSelectedIndex());
				customerCategorySelector.select("All Customers");
				customerList.removeAll();
				fillCustomerList(customerCategorySelector.getSelectedItem());

				getSelectedFromList(salesList.getSelectedItem());
			}
		});

		basicWaitList = new List();
		basicWaitList.setBounds(191, 68, 174, 195);
		basePanel.add(basicWaitList);
		basicWaitList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				privilegeWaitList.deselect(privilegeWaitList.getSelectedIndex());
				salesList.deselect(salesList.getSelectedIndex());
				customerCategorySelector.select("Basic Customers");
				customerList.removeAll();
				fillCustomerList(customerCategorySelector.getSelectedItem());

				getSelectedFromList(basicWaitList.getSelectedItem());
			}
		});

		Label label_8 = new Label("Privileged");
		label_8.setBounds(6, 46, 105, 16);
		basePanel.add(label_8);

		Label label_9 = new Label("Basic");
		label_9.setBounds(191, 46, 105, 16);
		basePanel.add(label_9);

		lblTotalSales = new JLabel("0000.00");
		lblTotalSales.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTotalSales.setBounds(155, 269, 210, 29);
		basePanel.add(lblTotalSales);
		lblTotalSales.setText(Dealer.getSales());

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
		customerCategorySelector.add("Active Customers");
		customerCategorySelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customerList.removeAll();
				fillCustomerList(customerCategorySelector.getSelectedItem());
			}
		});

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		customerList = new List();
		customerList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		customerList.setBounds(4, 78, 240, 346);
		frame.getContentPane().add(customerList);
		customerList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				privilegeWaitList.deselect(privilegeWaitList.getSelectedIndex());
				basicWaitList.deselect(basicWaitList.getSelectedIndex());
				salesList.deselect(salesList.getSelectedIndex());
				cutomerListSelect();
			}
		});

		customerList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cutomerListSelect();
			}
		});

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrorMessage.setBounds(6, 18, 287, 16);
		VehicleMenu.add(lblErrorMessage);

		//////////////////////////////////////////////////////////
		JButton btnCar = new JButton("Car");
		btnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("CAR");
				avaliableVehicles.setEnabled(true);
				lblErrorMessage.setText("");
				fillAvaliableVehicleList("car");
			}
		});
		btnCar.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnCar.setBounds(6, 46, 90, 90);
		VehicleMenu.add(btnCar);

		JButton btnVan = new JButton("Van");
		btnVan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("VAN");
				avaliableVehicles.setEnabled(true);
				lblErrorMessage.setText("");
				fillAvaliableVehicleList("van");
			}
		});
		btnVan.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnVan.setBounds(104, 46, 90, 90);
		VehicleMenu.add(btnVan);

		JButton btnTruck = new JButton("Truck");
		btnTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Truck");
				avaliableVehicles.setEnabled(true);
				lblErrorMessage.setText("");
				fillAvaliableVehicleList("truck");
			}
		});
		////////////////////////////////////////////////////////

		btnTruck.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnTruck.setBounds(203, 46, 90, 90);
		VehicleMenu.add(btnTruck);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("This button has no use as of yet.");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(26, 148, 117, 38);
		VehicleMenu.add(btnNewButton);

		btnWait = new JButton("Wait");
		btnWait.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnWait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (activeContract == null && !activeCustomer.isWaiting()) {
					activeCustomer.setWaiting(true);
				} else if (activeContract != null) {
					lblErrorMessage.setText("ALREADY RENTING A VEHICLE");
				} else if (activeCustomer.isWaiting()) {
					lblErrorMessage.setText("ALREADY ON WAITING LIST");
				}
				privilegeWaitList.removeAll();
				basicWaitList.removeAll();
				fillWaitLists();

				cutomerListSelect();
			}
		});

		btnWait.setBounds(155, 148, 117, 38);
		VehicleMenu.add(btnWait);
		fillWaitLists();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		avaliableVehicles = new List();
		avaliableVehicles.setBounds(273, 513, 299, 155);
		frame.getContentPane().add(avaliableVehicles);
		avaliableVehicles.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				vehicleListSelect();
				// System.out.println(activeVehicle);
			}
		});

		avaliableVehicles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				vehicleListSelect();
			}
		});

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		lblCustomerRental = new JLabel("NULL");
		lblCustomerRental.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerRental.setBounds(84, 512, 176, 16);
		frame.getContentPane().add(lblCustomerRental);

		lblVehicleRental = new JLabel("NULL");
		lblVehicleRental.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblVehicleRental.setBounds(84, 540, 176, 16);
		frame.getContentPane().add(lblVehicleRental);

		checkboxDefualtPrice = new JCheckBox("Default Price");
		checkboxDefualtPrice.setFont(new Font("Dialog", Font.PLAIN, 10));
		checkboxDefualtPrice.setBounds(14, 618, 95, 23);
		frame.getContentPane().add(checkboxDefualtPrice);

		JLabel lblCustomAmount = new JLabel("Custom: $");
		lblCustomAmount.setBounds(111, 622, 66, 16);
		frame.getContentPane().add(lblCustomAmount);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		btnCreateNewContract = new JButton("Create Contract");
		btnCreateNewContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double rentalPrice = 0.00;
				if (checkboxDefualtPrice.isSelected()) {
					if (activeVehicle.getCompanyID().charAt(6) == '1') {
						rentalPrice = Dealer.CAR_DAILY_RENTAL_PRICE;
						System.out.println(rentalPrice);
					}
					if (activeVehicle.getCompanyID().charAt(6) == '2') {
						rentalPrice = Dealer.VAN_DAILY_RENTAL_PRICE;
						System.out.println(rentalPrice);
					}
					if (activeVehicle.getCompanyID().charAt(6) == '3') {
						rentalPrice = Dealer.TRUCK_DAILY_RENTAL_PRICE;
						System.out.println(rentalPrice);
					}
					setNewRentalContractFieldsEditable(false);
				} else if (!checkboxDefualtPrice.isSelected()) {
					rentalPrice = Double.parseDouble(txtRentalAmount.getText());
					setNewRentalContractFieldsEditable(false);
				}
				Rental r = new Rental(activeVehicle, activeCustomer, txtRentalDate.getText(),
						Rental.getRentalContractNumber(), rentalPrice, activeVehicle.getCurrentMiles(),
						activeVehicle.getGasCapacity());
				Dealer.addRentalContracts(r);
				System.out.println(r.toString());

				cutomerListSelect();
			}
		});
		btnCreateNewContract.setBounds(0, 643, 244, 29);
		frame.getContentPane().add(btnCreateNewContract);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		txtRentalDate = new JTextField();
		txtRentalDate.setText("DATE");
		txtRentalDate.setBounds(78, 562, 130, 26);
		frame.getContentPane().add(txtRentalDate);
		txtRentalDate.setColumns(10);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblPricePerDay = new JLabel("Price/Day");
		lblPricePerDay.setBounds(4, 595, 61, 16);
		frame.getContentPane().add(lblPricePerDay);

		txtRentalAmount = new JTextField();
		txtRentalAmount.setBounds(175, 617, 55, 26);
		frame.getContentPane().add(txtRentalAmount);
		txtRentalAmount.setColumns(10);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblActiveContract = new JLabel("Active Contract");
		lblActiveContract.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblActiveContract.setBounds(440, 13, 100, 16);
		frame.getContentPane().add(lblActiveContract);

		lblActiceContractName = new JLabel("NULL");
		lblActiceContractName.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiceContractName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblActiceContractName.setBounds(440, 40, 149, 16);
		frame.getContentPane().add(lblActiceContractName);

		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnPanel.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		btnReturn.setBounds(543, 7, 46, 29);
		frame.getContentPane().add(btnReturn);

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

		chckboxIsDamaged = new JCheckBox("Damaged");
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

		btnConfirmRetrun = new JButton("Confirm");
		btnConfirmRetrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnPanel.setVisible(false);
				returnVehicle();
				fillSalesList();
			}
		});
		btnConfirmRetrun.setBounds(16, 71, 117, 29);
		returnPanel.add(btnConfirmRetrun);
		fillSalesList();

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

		contractList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
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

		lblStartDateRentalDetail = new JLabel("NULL");
		lblStartDateRentalDetail.setBounds(838, 56, 111, 16);
		frame.getContentPane().add(lblStartDateRentalDetail);

		lblEndDateRentalDetail = new JLabel("NULL");
		lblEndDateRentalDetail.setBounds(838, 78, 111, 16);
		frame.getContentPane().add(lblEndDateRentalDetail);

		lblPricePerDayRentalDetail = new JLabel("NULL");
		lblPricePerDayRentalDetail.setBounds(848, 106, 104, 16);
		frame.getContentPane().add(lblPricePerDayRentalDetail);

		lblVehicleRentalDetail = new JLabel("NULL");
		lblVehicleRentalDetail.setBounds(838, 35, 111, 16);
		frame.getContentPane().add(lblVehicleRentalDetail);

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

		txtNewCustomerFirstName = new JTextField();
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
		txtNewCustomerDOB.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (txtNewCustomerDOB.getText().length() == 10) {
					lblNewCustomerAge.setText("");
					lblNewCustomerAge.setText(Dealer.calculateAge(txtNewCustomerDOB.getText()));
				} else {
					lblNewCustomerAge.setText("TYPE DOB : MM/dd/yy");
				}
			}
		});

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

		btnNewCustomerCreate = new JButton("Create New Customer");
		btnNewCustomerCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewCustomer();
				setNewCustomerFieldsEditable(false);
			}
		});
		btnNewCustomerCreate.setBounds(6, 304, 350, 36);
		newCustomerPanel.add(btnNewCustomerCreate);

		lblNewCustomerID = new JLabel("XXXXXXX");
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
				setNewCustomerFieldsEditable(true);
				clearNewCustomerScreen();
			}
		});
		btnNewCustomerClose.setBounds(6, 387, 88, 29);
		newCustomerPanel.add(btnNewCustomerClose);

		lblNewCustomerAge = new JLabel("AGE");
		lblNewCustomerAge.setBounds(99, 131, 251, 16);
		newCustomerPanel.add(lblNewCustomerAge);

		JButton btnMainCreateNewCustomer = new JButton("Create New Customer");
		btnMainCreateNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basePanel.setVisible(false);
				newCustomerPanel.setVisible(true);
				setNewCustomerFieldsEditable(true);
			}
		});
		btnMainCreateNewCustomer.setBounds(587, 182, 362, 60);
		frame.getContentPane().add(btnMainCreateNewCustomer);

		noContractToReturn = new JTextArea();
		noContractToReturn.setBackground(SystemColor.window);
		noContractToReturn.setEditable(false);
		noContractToReturn.setRows(2);
		noContractToReturn.setText("\n\n       NO CONTRACT \n          TO RETURN");
		noContractToReturn.setBounds(440, 63, 149, 106);
		frame.getContentPane().add(noContractToReturn);
		noContractToReturn.setLineWrap(true);

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

		if (activeContract != null) {
			lblActiceContractName.setText(activeContract.getContractNumber());
			btnReturn.setEnabled(true);
		} else {
			lblActiceContractName.setText("NO CONTRACT");
			btnReturn.setEnabled(false);
		}

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

		if (activeContract != null) {
			noContractToReturn.setText("\n\n        PRESS RETURN \n          TO RETURN");
		} else {
			noContractToReturn.setText("\n\n       NO CONTRACT \n          TO RETURN");
		}

		contractList.removeAll();
		for (Rental rental : activeCustomer.getRentalContracts()) {
			String toList = (rental.isContractExpired()) ? rental.getContractNumber()
					: "*" + rental.getContractNumber();
			contractList.add(toList);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void fillRentalContractData() {
		lblCustomerRental.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
		lblVehicleRental.setText(activeVehicle.getCompanyID());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void fillRentalData() {
		Rental r = null;
		if (contractList.getSelectedItem().charAt(0) != '*') {
			for (Rental rental : activeCustomer.getRentalContracts()) {
				if (contractList.getSelectedItem().equals(rental.getContractNumber())) {
					r = rental;
				}
			}
		} else {
			for (Rental rental : activeCustomer.getRentalContracts()) {
				if (contractList.getSelectedItem().substring(1).equals(rental.getContractNumber())) {
					r = rental;
				}
			}

		}
		// System.out.println(r);
		if (r != null) {
			lblVehicleRentalDetail.setText(r.getVehicle().getCompanyID());
			lblStartDateRentalDetail.setText(r.getStartDate());
			lblPricePerDayRentalDetail.setText(Double.toString(r.getDailyPrice()));

			if (r.isContractExpired()) {
				lblEndDateRentalDetail.setText(r.getEndDate());
				lblRentalSale.setText(Dealer.calculateSale(r)[0]);
			} else {
				lblEndDateRentalDetail.setText("STILL ACTIVE");
				lblRentalSale.setText("STILL ACTIVE");
			}
		}
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
		case "Active Customers":
			for (Customer customer : Dealer.getCustomers()) {
				if (customer.getActiveRentalContract() != null) {
					customerList.add(customer.toString());
				}
			}
			break;
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void cutomerListSelect() {
		lblErrorMessage.setText("");
		try {
			setNewRentalContractFieldsEditable(true);
			activeCustomer = Dealer.getCustomer(customerList.getSelectedItem().substring(0, 7));
			activeContract = activeCustomer.getActiveRentalContract();

			fillCustomerData();

			fillRentalContractData();
			if (activeContract != null) {
				lblActiceContractName.setText(activeContract.getContractNumber());
			} else {
				lblActiceContractName.setText("NO CONTRACT");
			}

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		// System.out.println(activeContract);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void createNewCustomer() {
		Customer c = Dealer.createBasicCustomer(txtNewCustomerFirstName.getText(), txtNewCustomerLastName.getText(),
				txtNewCustomerDOB.getText(), txtNewCustomerSSN.getText(), txtNewCustomerGender.getText(),
				txtNewCustomerAddress1.getText() + ";" + txtNewCustomerAddress2.getText() + ";"
						+ txtNewCustomerAddress3.getText());

		lblNewCustomerAge.setText(c.getAge());
		lblNewCustomerID.setText(c.getCustomerID());

		setNewCustomerFieldsEditable(false);
		sortCustomerLists();
		fillCustomerList(customerCategorySelector.getSelectedItem());
	}

	private void sortCustomerLists() {
		Dealer.getCustomers().sort(null);
		Dealer.getBasicCustomers().sort(null);
		Dealer.getPrivilegedCustomers().sort(null);
	}

	public void setNewCustomerFieldsEditable(boolean b) {
		txtNewCustomerFirstName.setEditable(b);
		txtNewCustomerLastName.setEditable(b);
		txtNewCustomerDOB.setEditable(b);
		txtNewCustomerSSN.setEditable(b);
		txtNewCustomerGender.setEditable(b);
		txtNewCustomerAddress1.setEditable(b);
		txtNewCustomerAddress2.setEditable(b);
		txtNewCustomerAddress3.setEditable(b);

		btnNewCustomerCreate.setEnabled(b);
	}

	public void clearNewCustomerScreen() {
		txtNewCustomerFirstName.setText("");
		txtNewCustomerLastName.setText("");
		txtNewCustomerDOB.setText("");
		txtNewCustomerSSN.setText("");
		txtNewCustomerGender.setText("");
		txtNewCustomerAddress1.setText("");
		txtNewCustomerAddress2.setText("");
		txtNewCustomerAddress3.setText("");

		lblCustomerAge.setText("");
		lblNewCustomerID.setText("XXXXXXX");
	}

	public void setNewRentalContractFieldsEditable(boolean b) {
		txtRentalDate.setEditable(b);
		txtRentalAmount.setEditable(b);

		btnCreateNewContract.setEnabled(b);
	}

	public void fillAvaliableVehicleList(String choice) {
		avaliableVehicles.removeAll();
		switch (choice) {
		case "car":
			for (Vehicle vehicle : Dealer.getVehicles()) {
				if (vehicle.getCompanyID().charAt(vehicle.getCompanyID().length() - 1) == '1') {
					if (vehicle.isAvailable()) {
						avaliableVehicles.add(vehicle.toString());
					}
				}
			}
			break;
		case "van":
			for (Vehicle vehicle : Dealer.getVehicles()) {
				if (vehicle.getCompanyID().charAt(vehicle.getCompanyID().length() - 1) == '2') {
					if (vehicle.isAvailable()) {
						avaliableVehicles.add(vehicle.toString());
					}
				}
			}
			break;
		case "truck":
			for (Vehicle vehicle : Dealer.getVehicles()) {
				if (vehicle.getCompanyID().charAt(vehicle.getCompanyID().length() - 1) == '3') {
					if (vehicle.isAvailable()) {
						avaliableVehicles.add(vehicle.toString());
					}
				}
			}

			break;
		default:
			System.out.println("ERROR");
			break;
		}

		if (avaliableVehicles.getItemCount() == 0) {
			avaliableVehicles.add("NO VEHICLES AVAILABLE");
			lblErrorMessage.setText("NO VEHICLES AVAILABLE");

			avaliableVehicles.setEnabled(false);
		}
	}

	private void returnVehicle() {
		String[] sale = null;
		Rental c = null;
		try {
			c = activeCustomer.returnContract(chckboxIsDamaged.isSelected(), Double.parseDouble(txtMiles.getText()),
					Double.parseDouble(txtGasLevel.getText()));
			// System.out.println(c);
			sale = Dealer.calculateSale(c);
			Dealer.addSale(Double.parseDouble(sale[0]));
			// System.out.println(Dealer.calculateSale(c));
		} catch (Exception e) {
			e.printStackTrace();
		}

		cutomerListSelect();
		lblTotalSales.setText(Dealer.getSales());

		String damage = (c.isDamageDone()) ? "\nDamage Charge: $ " + sale[3] : "";
		String miles = (c.isMilesUpCharge()) ? "\nMiles Charge: $ " + sale[4] : "";
		String gas = (c.isGasUpCharge()) ? "\nGas Charge: $ " + sale[5] : "";

		String prompt = "Days Owned: " + sale[2] + "\nDaily Total: $" + sale[1] + damage + miles + gas;

		JOptionPane.showConfirmDialog(frame, prompt, "TOTAL SALE: $ " + sale[0], JOptionPane.NO_OPTION);

	}

	private void fillWaitLists() {
		for (Privileged c : Dealer.getPrivilegedCustomers()) {
			if (c.isWaiting()) {
				privilegeWaitList
						.add(c.getCustomerID() + " : " + c.getLastName() + ", " + c.getFirstName().charAt(0) + ".");
			}
		}

		for (Basic c : Dealer.getBasicCustomers()) {
			if (c.isWaiting()) {
				basicWaitList
						.add(c.getCustomerID() + " : " + c.getLastName() + ", " + c.getFirstName().charAt(0) + ".");
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void vehicleListSelect() {
		try {
			activeVehicle = Dealer.getVehicle(avaliableVehicles.getSelectedItem().substring(0, 7));
			fillRentalContractData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void fillSalesList() {
		salesList.removeAll();
		for (Rental rental : Dealer.getAllSales()) {
			salesList.add(rental.getCustomer().toString() + " : $ " + Dealer.calculateSale(rental)[0]);
		}
	}

	public void getSelectedFromList(String info) {
		String c = info.substring(0, 6);

		for (int i = 0; i < customerList.getItemCount(); i++) {
			if (c.equals(customerList.getItem(i).substring(0, 6))) {
				customerList.select(i);
			}
		}

		cutomerListSelect();
	}
}
