package Doctor;

public class DoctorT {
	int Sno;
    String Name,Email,M_num,Gender,DOA,TimeOA;
	public DoctorT(int sno, String name, String email, String m_num, String gender, String dOA, String timeOA) {
		super();
		Sno = sno;
		Name = name;
		Email = email;
		M_num = m_num;
		Gender = gender;
		DOA = dOA;
		//DOB = dOB;
		TimeOA = timeOA;
	}

	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getM_num() {
		return M_num;
	}
	public void setM_num(String m_num) {
		M_num = m_num;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDOA() {
		return DOA;
	}
	public void setDOA(String dOA) {
		DOA = dOA;
	}
//	public String getDOB() {
//		return DOB;
//	}
//	public void setDOB(String dOB) {
//		DOB = dOB;
//	}
	public String getTimeOA() {
		return TimeOA;
	}
	public void setTimeOA(String timeOA) {
		TimeOA = timeOA;
	}

}
