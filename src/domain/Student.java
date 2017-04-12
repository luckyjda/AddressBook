package domain;

public class Student {
	//学号
	private Integer id;
	//姓名
	private String name;
	//性别
	private String sex; 
	//电话号码
	private String phone;
	//职务
	private String position;
	//班级
	private String classNo;
	
	public Student() {
		super();
	}

	public Student(Integer id, String name, String sex, String phone,
			String position, String classNo) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.position = position;
		this.classNo = classNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String toString() {
		return "Student [classNo=" + classNo + ", id=" + id + ", name=" + name
				+ ", phone=" + phone + ", position=" + position + ", sex="
				+ sex + "]";
	}
}
