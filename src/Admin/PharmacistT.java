package Admin;

public class PharmacistT {
	
         int Sno;
         String F_name,L_name,Email,QualificationP,DOB,M_num;
		public PharmacistT(int sno, String m_num, String f_name, String l_name, String email, String qualificationP,String dOB) {
			super();
			Sno = sno;
			M_num = m_num;
			F_name = f_name;
			L_name = l_name;
			Email = email;
			QualificationP = qualificationP;
			DOB = dOB;
		}
		public int getSno() {
			return Sno;
		}
		public void setSno(int sno) {
			Sno = sno;
		}
		public String getM_num() {
			return M_num;
		}
		public void setM_num(String m_num) {
			M_num = m_num;
		}
		public String getF_name() {
			return F_name;
		}
		public void setF_name(String f_name) {
			F_name = f_name;
		}
		public String getL_name() {
			return L_name;
		}
		public void setL_name(String l_name) {
			L_name = l_name;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getQualificationP() {
			return QualificationP;
		}
		public void setQualificationP(String qualificationP) {
			QualificationP = qualificationP;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		
}
