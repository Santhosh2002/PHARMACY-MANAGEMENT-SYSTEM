package Admin;

import java.util.Date;

public class PharmacistT {
	
         int Sno,M_num;
         Date DOB;
         String F_name,L_name,Email,QualificationP;
		public PharmacistT(int sno, int m_num, String f_name, String l_name, String email, String qualificationP) {
			super();
			Sno = sno;
			M_num = m_num;
			F_name = f_name;
			L_name = l_name;
			Email = email;
			QualificationP = qualificationP;
//			DOB = dOB;
		}
		public int getSno() {
			return Sno;
		}
		public void setSno(int sno) {
			Sno = sno;
		}
		public int getM_num() {
			return M_num;
		}
		public void setM_num(int m_num) {
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
		public Date getDOB() {
			return DOB;
		}
		public void setDOB(Date dOB) {
			DOB = dOB;
		}
		
}
