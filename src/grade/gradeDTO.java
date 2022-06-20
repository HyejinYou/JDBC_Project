package grade;

public class gradeDTO {
	private String c_id;
	private String s_id;
	private String attend;
	private String work;
	private String mid;
	private String fin;
	private String grade;

	public gradeDTO(String c_id, String s_id, String attend, String work, String mid, String fin, String grade) {
		super();
		this.c_id = c_id;
		this.s_id = s_id;
		this.attend = attend;
		this.work = work;
		this.mid = mid;
		this.fin = fin;
		this.grade = grade;
	}

	public gradeDTO() {
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getAttend() {
		return attend;
	}

	public void setAttend(String attend) {
		this.attend = attend;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
