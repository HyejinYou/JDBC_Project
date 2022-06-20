package AcademicService;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import grade.gradeDAO;
import grade.gradeDTO;

public class gradeInput {

	private JFrame frame;
	private JTextField attendField;
	private JTextField worksField;
	private JTextField midField;
	private JTextField finField;
	private JTextField gradeField;
	gradeDAO gdao = new gradeDAO();
	gradeDTO gdto = new gradeDTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gradeInput window = new gradeInput(null, null);
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
	public gradeInput(String cc_id, String ss_id) {
		initialize(cc_id, ss_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String cc_id, String ss_id) {
		frame = new JFrame();
		frame.setTitle("성적입력");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uC11D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(58, 51, 103, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uACFC\uC81C");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(58, 84, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uC911\uAC04");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(58, 116, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uAE30\uB9D0");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(58, 148, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("\uD559\uC810");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(58, 180, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC131\uC801\uC785\uB825");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1.setBounds(175, 10, 75, 31);
		frame.getContentPane().add(lblNewLabel_2_1_1);

		JButton btnClose = new JButton("\uCDE8\uC18C");
		btnClose.setBounds(358, 230, 66, 23);
		frame.getContentPane().add(btnClose);
		attendField = new JTextField();
		attendField.setText("0");
		attendField.setBounds(173, 52, 150, 21);
		frame.getContentPane().add(attendField);
		attendField.setColumns(10);

		worksField = new JTextField();
		worksField.setText("0");
		worksField.setColumns(10);
		worksField.setBounds(173, 85, 150, 21);
		frame.getContentPane().add(worksField);

		midField = new JTextField();
		midField.setText("0");
		midField.setColumns(10);
		midField.setBounds(173, 117, 150, 21);
		frame.getContentPane().add(midField);

		finField = new JTextField();
		finField.setText("0");
		finField.setColumns(10);
		finField.setBounds(173, 149, 150, 21);
		frame.getContentPane().add(finField);

		gradeField = new JTextField();
		gradeField.setText("-");
		gradeField.setColumns(10);
		gradeField.setBounds(173, 181, 150, 21);
		frame.getContentPane().add(gradeField);

		gdto = gdao.gradeCheck(cc_id, ss_id);

		if (gdto.getAttend() == null || gdto.getAttend().length() == 0) {
			attendField.setText("0");
		} else {
			attendField.setText(gdto.getAttend());
		}
		if (gdto.getWork() == null || gdto.getWork().length() == 0) {
			worksField.setText("0");
		} else {
			worksField.setText(gdto.getWork());
		}
		if (gdto.getMid() == null || gdto.getMid().length() == 0) {
			midField.setText("0");
		} else {
			midField.setText(gdto.getMid());
		}
		if (gdto.getFin() == null || gdto.getFin().length() == 0) {
			finField.setText("0");
		} else {
			finField.setText(gdto.getFin());
		}
		if (gdto.getGrade() == null || gdto.getGrade().length() == 0) {
			gradeField.setText("-");
		} else {
			gradeField.setText(gdto.getGrade());
		}

		JButton btnAdd = new JButton("\uC785\uB825");
		btnAdd.setBounds(280, 230, 66, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gdto.setC_id(cc_id);
				gdto.setS_id(ss_id);
				gdto.setAttend(attendField.getText());
				gdto.setWork(worksField.getText());
				gdto.setMid(midField.getText());
				gdto.setFin(finField.getText());
				gdto.setGrade(gradeField.getText());

				gdao.gradeUpdate(gdto);
			}
		});

		// 취소 버튼을 눌렀을 때
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
