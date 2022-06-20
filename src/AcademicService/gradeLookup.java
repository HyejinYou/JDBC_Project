package AcademicService;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import grade.gradeDAO;
import grade.gradeDTO;

public class gradeLookup {

	private JFrame frame;
	private String c_id = studentMain.getCc_id();
	private String s_id = GUI.getId();
	private gradeDTO gdto = new gradeDTO();
	private gradeDAO gdao = new gradeDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gradeLookup window = new gradeLookup();
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
	public gradeLookup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC131\uC801\uC870\uD68C");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1.setBounds(175, 10, 75, 31);
		frame.getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uC11D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(92, 51, 103, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uACFC\uC81C");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(92, 84, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uC911\uAC04");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(92, 116, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uAE30\uB9D0");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(92, 148, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("\uD559\uC810");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(92, 180, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		JButton btnClose = new JButton("\uB2EB\uAE30");
		btnClose.setBounds(358, 230, 66, 23);
		frame.getContentPane().add(btnClose);

		JLabel lbAttend = new JLabel("New label");
		lbAttend.setHorizontalAlignment(SwingConstants.CENTER);
		lbAttend.setBounds(175, 51, 150, 23);
		frame.getContentPane().add(lbAttend);

		JLabel lblworks = new JLabel("New label");
		lblworks.setHorizontalAlignment(SwingConstants.CENTER);
		lblworks.setBounds(175, 84, 150, 23);
		frame.getContentPane().add(lblworks);

		JLabel lblmid = new JLabel("New label");
		lblmid.setHorizontalAlignment(SwingConstants.CENTER);
		lblmid.setBounds(175, 116, 150, 23);
		frame.getContentPane().add(lblmid);

		JLabel lblfin = new JLabel("New label");
		lblfin.setHorizontalAlignment(SwingConstants.CENTER);
		lblfin.setBounds(175, 148, 150, 23);
		frame.getContentPane().add(lblfin);

		JLabel lbltot = new JLabel("New label");
		lbltot.setHorizontalAlignment(SwingConstants.CENTER);
		lbltot.setBounds(175, 180, 150, 23);
		frame.getContentPane().add(lbltot);

		gdto = gdao.gradeCheck(c_id, s_id);
		lbAttend.setText(gdto.getAttend());
		lblworks.setText(gdto.getWork());
		lblmid.setText(gdto.getMid());
		lblfin.setText(gdto.getFin());
		lbltot.setText(gdto.getGrade());

		// 닫기 버튼을 눌렀을 때
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
