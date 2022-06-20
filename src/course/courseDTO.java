package course;

public class courseDTO {
	private String id;
	private String name;
	private String credit;
	private String dept_name;
	private String i_id;

	// 강의 list 생성자
	public courseDTO(String id, String name, String credit, String dept_name, String i_id) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.dept_name = dept_name;
		this.i_id = i_id; // 교수 이름 들어감
	}

	// 교수 강의 list 생성자
	public courseDTO(String id, String name, String credit, String dept_name) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.dept_name = dept_name;
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

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

}
