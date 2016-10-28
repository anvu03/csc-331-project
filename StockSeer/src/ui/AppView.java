package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistence.DBConnection;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppView extends JFrame {

	private JPanel contentPane; // main panel

	private LoginPane loginPane;
	private HomePane homePane;
	private LeagueCreationPane createLeaguePane;
	private ChooseStockPane chooseStockPane;
	private CardLayout cardLayout;
	private RegistrationPane signUpPane;

	// Components constraints
	private final String LOGIN_PANE = "LOGIN_PANE";
	private final String HOME_PANE = "HOME_PANE";
	private final String CREATE_LEAGUE_PANE = "CREATE_LEAGUE_PANE";
	private final String CHOOSE_STOCK_PANE = "CHOOSE_STOCK_PANE";
	private final String SIGN_UP_PANE = "SIGN_UP_PANE";

	/**
	 * Create the frame.
	 */
	public AppView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DBConnection.closeConnection();
			}
		});
		setTitle("Stock Seer");
		setMinimumSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		initPanes();
	}

	public void initPanes() {
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		loginPane = new LoginPane();
		contentPane.add(loginPane, LOGIN_PANE);

		signUpPane = new RegistrationPane();
		contentPane.add(signUpPane, SIGN_UP_PANE);

		homePane = new HomePane();
		contentPane.add(homePane, HOME_PANE);

		createLeaguePane = new LeagueCreationPane();
		contentPane.add(createLeaguePane, CREATE_LEAGUE_PANE);

		chooseStockPane = new ChooseStockPane();
		contentPane.add(chooseStockPane, CHOOSE_STOCK_PANE);
	}

	public void viewLogin() {
		cardLayout.show(contentPane, LOGIN_PANE);
	}

	public void viewHome() {
		cardLayout.show(contentPane, HOME_PANE);
		System.out.println("Switched to home pane");
	}

	public void viewCreateLeaguePane() {
		cardLayout.show(contentPane, CREATE_LEAGUE_PANE);
	}

	public void viewChooseStockPane() {
		cardLayout.show(contentPane, CHOOSE_STOCK_PANE);
	}

	public void viewSignUp() {
		cardLayout.show(contentPane, SIGN_UP_PANE);
	}

	public LoginPane getLoginPane() {
		return loginPane;
	}

	public HomePane getHomePane() {
		return homePane;
	}

	public ChooseStockPane getChooseStockPane() {
		return chooseStockPane;
	}

	public LeagueCreationPane getCreateLeaguePane() {
		return createLeaguePane;
	}

	public RegistrationPane getSignUpPane() {
		return signUpPane;
	}

}
