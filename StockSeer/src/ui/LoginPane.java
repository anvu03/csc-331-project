package ui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import controller.LoginController;
import javax.swing.JButton;

public class LoginPane extends JPanel {
	public static final String LOGIN_BTN = "Login";
	public static final String SIGNUP_BTN = "Sign Up";

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel panel;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnResetPassword;

	/**
	 * Create the panel.
	 */
	public LoginPane() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 17, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 0;
		add(lblUsername, gbc_lblUsername);

		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 0;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 1;
		add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 1;
		add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);

		btnLogin = new JButton(LOGIN_BTN);
		panel.add(btnLogin);

		btnSignUp = new JButton(SIGNUP_BTN);
		panel.add(btnSignUp);

		btnResetPassword = new JButton("Reset Password");
		panel.add(btnResetPassword);

	}

	/**
	 * assign listeners to specific buttons
	 * 
	 * @param loginController
	 */
	public void registerListeners(LoginController loginController) {
		btnLogin.addActionListener(loginController);
		btnSignUp.addActionListener(loginController);
		btnResetPassword.addActionListener(loginController);
		txtPassword.addKeyListener(loginController);
		txtUsername.addKeyListener(loginController);
	}

	public String getUsername() {
		return txtUsername.getText().trim();
	}

	public String getPassword() {
		return String.valueOf(txtPassword.getPassword()).trim();
	}

	/**
	 * clear all text fields
	 */
	public void setTextFieldsEmpty() {
		txtUsername.setText("");
		txtPassword.setText("");
	}

}
