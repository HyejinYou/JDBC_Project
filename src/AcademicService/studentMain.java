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
import grade.gradeDAO;
import student.studentDAO;

public class studentMain {

	private JFrame frame;
	private JPasswordField curPw;
	private JPasswordField newPw;
	private JPasswordField newPwCheck;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField searchText;
	private JTable table1;
	private String colNames1[] = { "교과목번호", "교과목명", "학점", "학과명", "담당교수" };
	private DefaultTableModel model1 = new DefaultTableModel(colNames1, 0) {
		public boolean isCellEdittable(int i, int c) {
			return false;
		}
	};
	private ArrayList<courseDTO> list = new ArrayList<courseDTO>();
	private courseDAO cdao = new courseDAO();
	private Object c_id;
	private static String cc_id;

	public static String getCc_id() {
		return cc_id;
	}

	private static String id = GUI.getId();
	private static String pw = GUI.getPw();
	private JTable table2;
	private String colNames2[] = { "교과목번호", "교과목명", "학점", "학과명", "담당교수" };
	private Object data[][] = new Object[0][5];
	private DefaultTableModel model2 = new DefaultTableModel(data, colNames2) {
		public boolean isCellEdittable(int i, int c) {
			return false;
		}
	};
	studentDAO sdao = new studentDAO();
	gradeDAO gdao = new gradeDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentMain window = new studentMain();
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
	public studentMain() {
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

		// new
		JLabel lblNewLabel = new JLabel("\uB2D8 \uC548\uB155\uD558\uC138\uC694!");
		lblNewLabel.setBounds(563, 10, 111, 24);
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.setBounds(575, 44, 111, 33);
		JButton btndtU = new JButton("\uC815\uBCF4\uAD00\uB9AC");
		btndtU.setBounds(466, 44, 111, 33);
		JButton btnGI = new JButton("\uC131\uC801\uC870\uD68C");
		btnGI.setBounds(357, 44, 111, 33);
		JButton btnRC = new JButton("\uC218\uAC15\uC2E0\uCCAD");
		btnRC.setBounds(248, 44, 111, 33);
		frame.getContentPane().setLayout(null);

		lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnLogout);
		frame.getContentPane().add(btndtU);
		frame.getContentPane().add(btnGI);
		frame.getContentPane().add(btnRC);

		JPanel panGI = new JPanel();
		panGI.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(panGI);
		panGI.setLayout(null);

		JLabel lblNewLabel_2_2_1 = new JLabel("\uC131\uC801\uC870\uD68C");
		lblNewLabel_2_2_1.setBounds(278, 10, 140, 31);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		panGI.add(lblNewLabel_2_2_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 63, 620, 280);
		panGI.add(scrollPane_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("* \uC0AC\uC6A9\uC790(\uD559\uC0DD) \uC218\uAC15\uACFC\uBAA9");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(278, 37, 140, 23);
		panGI.add(lblNewLabel_1_1_1);

		JPanel panRC = new JPanel();
		panRC.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(panRC);
		panRC.setLayout(null);

		JLabel lblNewLabel_2_2 = new JLabel("\uC218\uAC15\uC2E0\uCCAD");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2.setBounds(278, 10, 140, 31);
		panRC.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("\uAD50\uACFC\uBAA9 \uBA85:");
		lblNewLabel_1_3_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(155, 51, 76, 23);
		panRC.add(lblNewLabel_1_3_1_1);

		searchText = new JTextField();
		searchText.setColumns(10);
		searchText.setBounds(231, 52, 230, 21);
		panRC.add(searchText);

		JButton btnSearchButton = new JButton("\uAC80\uC0C9");
		btnSearchButton.setBounds(469, 51, 70, 23);
		panRC.add(btnSearchButton);
		btnSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSearchButton) {
					model1.setRowCount(0); // 테이블 새로고침
					list = cdao.list(searchText.getText().trim());
					for (courseDTO dto : list) {
						model1.addRow(new Object[] { dto.getId(), dto.getName(), dto.getCredit(), dto.getDept_name(),
								dto.getI_id() });
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 84, 575, 240);
		panRC.add(scrollPane);

		table1 = new JTable(model1);
		scrollPane.setViewportView(table1);

		// course 테이블의 강의를 누를때마다 저장되는 값이 달라짐
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = table1.getSelectedRow();
					c_id = table1.getValueAt(row, 0);
					// System.out.println(row + " " + c_id.toString());
					cc_id = c_id.toString();
				}
			}
		});

		JButton btnOrd = new JButton("\uC2E0\uCCAD");
		btnOrd.setBounds(579, 334, 95, 23);
		panRC.add(btnOrd);

		// 신청 버튼을 누르면 수강 신청 완료 -> advisor 테이블에 insert

		btnOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOrd) {
					cdao.Enrolment(cc_id, id);

					CourseCompleted couE = new CourseCompleted();
				}
			}
		});

		JPanel pandtU = new JPanel();
		pandtU.setBounds(0, 76, 686, 367);
		frame.getContentPane().add(pandtU);

		JButton btnUPW = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btnUPW.setBounds(0, 0, 343, 23);
		btnUPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pandtU.setLayout(null);
		pandtU.add(btnUPW);

		JButton btnUN = new JButton("\uC5F0\uB77D\uCC98 \uBCC0\uACBD");
		btnUN.setBounds(337, 0, 349, 23);
		pandtU.add(btnUN);

		JPanel panUPW = new JPanel();
		panUPW.setBounds(0, 22, 686, 345);
		pandtU.add(panUPW);
		panUPW.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_1.setBounds(186, 101, 103, 23);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		panUPW.add(lblNewLabel_1);

		curPw = new JPasswordField();
		curPw.setBounds(301, 102, 150, 21);
		panUPW.add(curPw);

		JLabel lblNewLabel_1_1 = new JLabel(
				"* \uC554\uD638\uB294 1~10\uC790\uB9AC \uC774\uB0B4\uC5D0\uC11C \uBCC0\uACBD \uAC00\uB2A5\uD569\uB2C8\uB2E4.");
		lblNewLabel_1_1.setBounds(301, 155, 251, 23);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		panUPW.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uC2E0\uADDC \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_1_2.setBounds(186, 134, 103, 23);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 14));
		panUPW.add(lblNewLabel_1_2);

		newPw = new JPasswordField();
		newPw.setBounds(301, 135, 150, 21);
		panUPW.add(newPw);

		JLabel lblNewLabel_1_2_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778:");
		lblNewLabel_1_2_1.setBounds(186, 188, 103, 23);
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		panUPW.add(lblNewLabel_1_2_1);

		newPwCheck = new JPasswordField();
		newPwCheck.setBounds(301, 189, 150, 21);
		panUPW.add(newPwCheck);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638(\uC554\uD638) \uBCC0\uACBD");
		lblNewLabel_2.setBounds(250, 29, 181, 31);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		panUPW.add(lblNewLabel_2);

		JButton btnPwUpdate = new JButton("\uC218\uC815");
		btnPwUpdate.setBounds(237, 274, 95, 23);
		panUPW.add(btnPwUpdate);

		btnPwUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPwUpdate) {
					if (new String(curPw.getPassword()).equals(pw)) { // 현재비밀번호 확인(참)
						if (new String(newPw.getPassword()).equals(new String(newPwCheck.getPassword()))) { // 새로운 비밀번호,
																											// 확인비밀번호
																											// 확인(참)
							fixSuccess fixS = new fixSuccess();

							sdao.studentUpdate(id, new String(newPw.getPassword())); // 비밀번호 수정
						} else {
							PwmatchproblemError pwmE = new PwmatchproblemError();
						}
					} else {
						CurrentpasswordError curpwE = new CurrentpasswordError();
					}
				}
			}
		});
		JButton btnPwUpdateCencel = new JButton("\uCDE8\uC18C");
		btnPwUpdateCencel.setBounds(353, 274, 95, 23);
		panUPW.add(btnPwUpdateCencel);
		panUPW.setVisible(false); // 비밀번호 변경 panel

		// 취소 버튼 누르면 텍스트필드 내용 null
		/*
		 * btnPwUpdateCencel.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * } });
		 */

		JPanel panUN = new JPanel();
		panUN.setBounds(0, 22, 686, 345);
		pandtU.add(panUN);
		panUN.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("\uC5F0\uB77D\uCC98 \uBCC0\uACBD");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(255, 10, 181, 31);
		panUN.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1.setBounds(51, 51, 75, 31);
		panUN.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(205, 103, 65, 23);
		panUN.add(lblNewLabel_1_3);

		JButton btnPhoneUpdate = new JButton("\uC218\uC815");
		btnPhoneUpdate.setBounds(241, 136, 95, 23);
		panUN.add(btnPhoneUpdate);
		btnPhoneUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPhoneUpdate) {
					sdao.studentPhoneUpdate(id, phoneField.getText()); // 수정
					fixSuccess fixS = new fixSuccess();
				}
			}
		});

		JButton btnPhoneCancel = new JButton("\uCDE8\uC18C");
		btnPhoneCancel.setBounds(357, 136, 95, 23);
		panUN.add(btnPhoneCancel);
		btnPhoneCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPhoneCancel) {
					phoneField.setText("");
				}
			}
		});

		JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1_1_1.setBounds(51, 185, 75, 31);
		panUN.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("\uC774\uBA54\uC77C:");
		lblNewLabel_1_3_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(216, 247, 54, 23);
		panUN.add(lblNewLabel_1_3_1);

		JButton btnEmailUpdate = new JButton("\uC218\uC815");
		btnEmailUpdate.setBounds(241, 280, 95, 23);
		panUN.add(btnEmailUpdate);

		btnEmailUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEmailUpdate) {
					sdao.studentEmailUpdate(id, emailField.getText()); // 수정
					fixSuccess fixS = new fixSuccess();
				}
			}
		});
		JButton btnEmailCancel = new JButton("\uCDE8\uC18C");
		btnEmailCancel.setBounds(357, 280, 95, 23);
		panUN.add(btnEmailCancel);
		btnEmailCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEmailCancel) {
					emailField.setText("");
				}
			}
		});

		phoneField = new JTextField();
		phoneField.setBounds(282, 104, 170, 21);
		panUN.add(phoneField);
		phoneField.setColumns(10);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(282, 247, 170, 21);
		panUN.add(emailField);
		panUN.setVisible(false); // 연락처 변경 panel

		JLabel lbId = new JLabel("New label");
		lbId.setFont(new Font("굴림", Font.ITALIC, 13));
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbId.setBounds(466, 10, 111, 24);
		frame.getContentPane().add(lbId);
		lbId.setText(id);

		pandtU.setVisible(false); // 비밀번호, 연락처 변경 panel
		panUN.setVisible(false); // 연락처 변경 panel
		panRC.setVisible(false); // 수강신청 panel
		panGI.setVisible(false); // 성적조회 panel

		// 수강신청 버튼을 눌렀을 때
		btnRC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panGI.setVisible(false);
				pandtU.setVisible(false);
				panRC.setVisible(true);
				panUPW.setVisible(false);
				panUN.setVisible(false);
				model1.setRowCount(0); // 테이블 새로고침
				list = cdao.list("");
				for (courseDTO dto : list) {
					model1.addRow(new Object[] { dto.getId(), dto.getName(), dto.getCredit(), dto.getDept_name(),
							dto.getI_id() });
				}
			}

		});

		// 성적 조회 버튼을 눌렀을 때
		btnGI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panGI.setVisible(true);
				pandtU.setVisible(false);
				panRC.setVisible(false);
				panUPW.setVisible(false);
				panUN.setVisible(false);
				model2.setRowCount(0); // 테이블 새로고침
				list = cdao.studentCourseList(id);
				for (courseDTO dto : list) {
					model2.addRow(new Object[] { dto.getId(), dto.getName(), dto.getCredit(), dto.getDept_name(),
							dto.getI_id() });
				}
			}

		});
		table2 = new JTable(model2);

		scrollPane_1.setViewportView(table2);

		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = table2.getSelectedRow();
					System.out.println(row);
					c_id = table2.getValueAt(row, 0);
					// System.out.println(row + " " + c_id.toString());
					cc_id = c_id.toString();
					System.out.println(cc_id);
					gradeLookup sl = new gradeLookup();
				}
			}
		});
		// 정보관리 버튼을 눌렀을 때
		btndtU.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pandtU.setVisible(true);
				panRC.setVisible(false);
				panGI.setVisible(false);
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
				panRC.setVisible(false);
				panGI.setVisible(false);
			}

		});

		// 정보관리/연락처 변경 버튼을 눌렀을 때
		btnUN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panUN.setVisible(true);
				panUPW.setVisible(false);
				panRC.setVisible(false);
				panGI.setVisible(false);
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

	class NonEditableTableModel extends DefaultTableModel {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}
}
