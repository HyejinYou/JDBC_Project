package AcademicService;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import course.courseDAO;
import course.courseDTO;
import instructor.instructorDAO;
import student.studentDAO;
import student.studentDTO;

public class instructorMain {
	private static String id = GUI.getId();;
	private JFrame frame;
	private JTextField textField_1;
	private JTable table;
	private String colNames[] = { "교과목번호", "교과목명", "학점", "학과명" };
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private ArrayList<courseDTO> list = new ArrayList<courseDTO>();
	private JTable table2;
	private courseDAO cdao = new courseDAO();
	private String colNames2[] = { "학번", "이름", "학과명", "학년", "번호", "이메일" };
	private DefaultTableModel model2 = new DefaultTableModel(colNames2, 0);
	private ArrayList<studentDTO> slist = new ArrayList<studentDTO>();
	private Object c_id;
	private Object s_id;
	private static String cc_id;
	private static String ss_id;
	private studentDAO sdao = new studentDAO();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textPhone;
	private JTextField textMail;
	private instructorDAO idao = new instructorDAO();

	public static String getCc_id() {
		return cc_id;
	}

	public static String getSs_id() {
		return ss_id;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructorMain window = new instructorMain();
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
	public instructorMain() {
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

		JButton btndtU = new JButton("\uC815\uBCF4\uAD00\uB9AC");
		btndtU.setBounds(466, 44, 111, 33);
		frame.getContentPane().add(btndtU);

		JLabel lblNewLabel = new JLabel("\uB2D8 \uC548\uB155\uD558\uC138\uC694!");
		lblNewLabel.setBounds(578, 10, 96, 24);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 13));
		frame.getContentPane().add(lblNewLabel);

		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.setBounds(575, 44, 111, 33);
		frame.getContentPane().add(btnLogout);

		JButton btnGM = new JButton("\uC131\uC801\uAD00\uB9AC");
		btnGM.setBounds(357, 44, 111, 33);
		frame.getContentPane().add(btnGM);

		JPanel pandtU = new JPanel();
		pandtU.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(pandtU);
		pandtU.setLayout(null);

		JButton btnUPW = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btnUPW.setBounds(0, 0, 343, 23);
		pandtU.add(btnUPW);

		JButton btnUN = new JButton("\uC5F0\uB77D\uCC98 \uBCC0\uACBD");
		btnUN.setBounds(337, 0, 349, 23);
		pandtU.add(btnUN);

		JPanel panUN = new JPanel();
		panUN.setBounds(0, 23, 686, 344);
		pandtU.add(panUN);
		panUN.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("\uC5F0\uB77D\uCC98 \uBCC0\uACBD");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(253, 24, 181, 31);
		panUN.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1.setBounds(49, 65, 75, 31);
		panUN.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(203, 117, 65, 23);
		panUN.add(lblNewLabel_1_3);

		JButton btnPhoneUpdate = new JButton("\uC218\uC815");
		btnPhoneUpdate.setBounds(239, 150, 95, 23);
		panUN.add(btnPhoneUpdate);
		btnPhoneUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPhoneUpdate) {
					idao.instructorPhoneUpdate(id, textPhone.getText());
				}
			}
		});
		JButton btnPhoneCancel = new JButton("\uC9C0\uC6B0\uAE30");
		btnPhoneCancel.setBounds(355, 150, 95, 23);
		panUN.add(btnPhoneCancel);

		btnPhoneCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPhoneCancel) {
					textPhone.setText("");
				}
			}
		});
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1_1.setBounds(49, 199, 75, 31);
		panUN.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("\uC774\uBA54\uC77C:");
		lblNewLabel_1_3_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(214, 261, 54, 23);
		panUN.add(lblNewLabel_1_3_1);

		JButton btnEmailUpdate = new JButton("\uC218\uC815");
		btnEmailUpdate.setBounds(239, 294, 95, 23);
		panUN.add(btnEmailUpdate);
		btnPhoneUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPhoneUpdate) {
					idao.instructorMailUpdate(id, textMail.getText());
				}
			}
		});

		JButton btnEmailCancel = new JButton("\uC9C0\uC6B0\uAE30");
		btnEmailCancel.setBounds(355, 294, 95, 23);
		panUN.add(btnEmailCancel);

		btnEmailCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEmailCancel) {
					textMail.setText("");
				}
			}
		});

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(280, 118, 170, 21);
		panUN.add(textPhone);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(280, 261, 170, 21);
		panUN.add(textMail);

		JPanel panUPW = new JPanel();
		panUPW.setBounds(0, 23, 686, 344);
		pandtU.add(panUPW);
		panUPW.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(188, 109, 103, 23);
		panUPW.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(303, 110, 150, 21);
		panUPW.add(passwordField);

		JLabel lblNewLabel_1_1 = new JLabel(
				"* \uC554\uD638\uB294 1~10\uC790\uB9AC \uC774\uB0B4\uC5D0\uC11C \uBCC0\uACBD \uAC00\uB2A5\uD569\uB2C8\uB2E4.");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(303, 163, 251, 23);
		panUPW.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uC2E0\uADDC \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(188, 142, 103, 23);
		panUPW.add(lblNewLabel_1_2);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(303, 143, 150, 21);
		panUPW.add(passwordField_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778:");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(188, 196, 103, 23);
		panUPW.add(lblNewLabel_1_2_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(303, 197, 150, 21);
		panUPW.add(passwordField_2);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638(\uC554\uD638) \uBCC0\uACBD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(252, 37, 181, 31);
		panUPW.add(lblNewLabel_2);

		JButton btnPwUpdate = new JButton("\uC218\uC815");
		btnPwUpdate.setBounds(239, 282, 95, 23);
		panUPW.add(btnPwUpdate);

		JButton btnPwUpdateCencel = new JButton("\uCDE8\uC18C");
		btnPwUpdateCencel.setBounds(355, 282, 95, 23);
		panUPW.add(btnPwUpdateCencel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 46, 604, 253);
		panel.add(scrollPane_1);

		table2 = new JTable(model2);
		scrollPane_1.setViewportView(table2);

		JLabel lblNewLabel_2_2_2 = new JLabel("\uC131\uC801\uAD00\uB9AC");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_2.setBounds(278, 10, 140, 31);
		panel.add(lblNewLabel_2_2_2);

		JButton btnSI = new JButton("\uC131\uC801\uC785\uB825");
		btnSI.setBounds(579, 334, 95, 23);
		panel.add(btnSI);
		btnSI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gradeInput input = new gradeInput(cc_id, ss_id);
			}
		});

		JPanel panGM = new JPanel();
		panGM.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(panGM);
		panGM.setLayout(null);

		JLabel lblNewLabel_2_2 = new JLabel("\uC131\uC801\uAD00\uB9AC");
		lblNewLabel_2_2.setBounds(278, 10, 140, 31);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		panGM.add(lblNewLabel_2_2);

		panGM.setVisible(false);
		JPanel panAM = new JPanel();
		panAM.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(panAM);
		panAM.setLayout(null);

		JLabel lblNewLabel_2_2_1 = new JLabel("\uCD9C\uC11D\uBD80");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1.setBounds(278, 10, 140, 31);
		panAM.add(lblNewLabel_2_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(231, 52, 230, 21);
		panAM.add(textField_1);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("\uAD50\uACFC\uBAA9 \uBA85:");
		lblNewLabel_1_3_1_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1_1_1.setBounds(155, 51, 76, 23);
		panAM.add(lblNewLabel_1_3_1_1_1);

		JButton btnNewButton_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_1.setBounds(469, 51, 70, 23);
		panAM.add(btnNewButton_1);

		JLabel lblNewLabel_1_1_1 = new JLabel(
				"* \uACFC\uBAA9\uBCC4 \uC218\uAC15 \uD559\uC0DD \uC870\uD68C \uBC0F \uCD9C\uC11D\uAD00\uB9AC");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(231, 72, 251, 23);
		panAM.add(lblNewLabel_1_1_1);

		JButton btnNewButton_2_2_1_1_1_1 = new JButton("\uCD9C\uC11D\uC785\uB825");
		btnNewButton_2_2_1_1_1_1.setBounds(579, 334, 95, 23);
		panAM.add(btnNewButton_2_2_1_1_1_1);
		panAM.setVisible(false); // 출석부 panel
		panel.setVisible(false);
		panGM.setVisible(false);

		pandtU.setVisible(false);
		panUPW.setVisible(false);
		panUN.setVisible(false);

		// 성적관리 버튼을 눌렀을 때
		btnGM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panGM.setVisible(true);
				panAM.setVisible(false);
				panel.setVisible(false);
				pandtU.setVisible(false);
				panUPW.setVisible(false);
				panUN.setVisible(false);
				model.setRowCount(0); // 테이블 새로고침
				list = cdao.instructorCourseList(id);
				for (courseDTO dto : list) {
					model.addRow(new Object[] { dto.getId(), dto.getName(), dto.getCredit(), dto.getDept_name() });
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 46, 604, 253);
		panGM.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);

		JLabel lbId = new JLabel((String) null);
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbId.setFont(new Font("굴림", Font.ITALIC, 13));
		lbId.setBounds(466, 10, 111, 24);
		frame.getContentPane().add(lbId);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = table.getSelectedRow();
					System.out.println(row);
					c_id = table.getValueAt(row, 0);
					// System.out.println(row + " " + c_id.toString());
					cc_id = c_id.toString();
					panel.setVisible(true);
					panAM.setVisible(false);
					panGM.setVisible(false);
					pandtU.setVisible(false);
					panUPW.setVisible(false);
					panUN.setVisible(false);

					model2.setRowCount(0); // 테이블 새로고침

					slist = sdao.studentList(cc_id);
					System.out.println(cc_id);
					for (studentDTO dto : slist) {
						model2.addRow(new Object[] { dto.getId(), dto.getName(), dto.getDept_name(), dto.getC_year(),
								dto.getP_num(), dto.getMail() });
						System.out.println(dto.getId());
						System.out.println(dto.getName());
					}
				}
			}
		});
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = table2.getSelectedRow();
					System.out.println(row);
					s_id = table2.getValueAt(row, 0);
					// System.out.println(row + " " + c_id.toString());
					ss_id = s_id.toString();
				}
			}
		});

		// 정보관리 버튼을 눌렀을 때
		btndtU.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pandtU.setVisible(true);
				panUPW.setVisible(false);
				panUN.setVisible(false);
			}

		});

		// 정보관리/비밀번호 변경 버튼을 눌렀을 때
		btnUPW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panUPW.setVisible(true);
				panUN.setVisible(false);
			}

		});

		// 정보관리/연락처 변경 버튼을 눌렀을 때
		btnUN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panUN.setVisible(true);
				panUPW.setVisible(false);
			}

		});

		// 로그아웃 버튼을 눌렀을 때
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// GUI gui = new GUI();
				frame.dispose();
			}
		});

		frame.setVisible(true);
	}
}
