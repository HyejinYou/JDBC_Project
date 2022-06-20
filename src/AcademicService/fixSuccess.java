package AcademicService;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class fixSuccess {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fixSuccess window = new fixSuccess();
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
	public fixSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("completed");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(59, 10, 95, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\uC218\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel.setBounds(29, 35, 255, 25);
		frame.getContentPane().add(lblNewLabel);

		JButton btnClose = new JButton("\uD655\uC778");
		btnClose.setBounds(337, 100, 95, 23);
		frame.getContentPane().add(btnClose);

		// 확인 버튼을 눌렀을 때
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.setVisible(true);

	}

}
