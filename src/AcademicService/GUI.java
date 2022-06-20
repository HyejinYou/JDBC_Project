package AcademicService;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frame;
	private JTextField idField;
	private JRadioButton rdbtn1;
	private int who;
	private JPasswordField pwField;
	private static String id;
	private static String pw;

	public static String getId() {
		return id;
	}

	public static String getPw() {
		return pw;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("학사행정서비스");
		frame.setBounds(100, 100, 700, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// new panel
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 443);
		// new JLabel
		JLabel lblNewLabel = new JLabel("\uD559\uC0AC\uD589\uC815\uC11C\uBE44\uC2A4 \uB85C\uADF8\uC778");
		lblNewLabel.setBounds(166, 80, 350, 30);
		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6A9\uC790 \uBC88\uD638:");
		lblNewLabel_1.setBounds(75, 179, 90, 27);
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_2.setBounds(75, 229, 90, 27);
		// new textField
		idField = new JTextField();
		idField.setBounds(177, 172, 277, 40);
		// new JButton
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(466, 172, 153, 90);
		// new pwField
		pwField = new JPasswordField();
		pwField.setBounds(177, 222, 276, 40);
		// new JRadioButton
		rdbtn1 = new JRadioButton("\uD559\uBD80\uC0DD");
		rdbtn1.setBounds(177, 295, 70, 23);
		JRadioButton rdbtn2 = new JRadioButton("\uAD50\uC218");
		rdbtn2.setBounds(256, 295, 70, 23);

		panel.setLayout(null);
		frame.getContentPane().add(panel);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		panel.add(lblNewLabel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel_1);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel_2);

		idField.setFont(new Font("굴림", Font.PLAIN, 15));
		idField.setColumns(10);
		panel.add(idField);

		btnLogin.setFont(new Font("굴림", Font.BOLD, 22));
		panel.add(btnLogin);

		panel.add(pwField);

		panel.add(rdbtn1);
		panel.add(rdbtn2);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnLogin) {
					int check;
					id = idField.getText().trim();
					pw = new String(pwField.getPassword()).trim();
					login lg = new login();
					check = lg.Login(id, pw, who);

					if (who == 1) {
						if (check == 1) {
							studentMain stm = new studentMain(); // sudentMain 불러옴.
							frame.dispose();
						} else {
							loginError logE = new loginError();
						}
					} else if (who == 2) {
						if (check == 1) {
							instructorMain inm = new instructorMain(); // instructorMain 불러옴.
							frame.dispose();
						} else {
							loginError logE = new loginError();
						}

					}
					// System.out.println('1');

				}
			}
		});

		rdbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtn1) {
					rdbtn2.setSelected(false);
					who = 1;
				}
			}
		});

		rdbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtn2) {
					rdbtn1.setSelected(false);
					who = 2;
				}
			}
		});

		// frame.setVisible(true);

	}
}