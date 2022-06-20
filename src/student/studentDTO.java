package student;

public class studentDTO {
	private String id;
	private String name;
	private String dept_name;
	private String c_year;
	private String p_num;
	private String mail;

	public studentDTO(String id, String name, String dept_name, String c_year, String p_num, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.dept_name = dept_name;
		this.c_year = c_year;
		this.p_num = p_num;
		this.mail = mail;
	}

	public studentDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getC_year() {
		return c_year;
	}

	public void setC_year(String c_year) {
		this.c_year = c_year;
	}

	public String getP_num() {
		return p_num;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
