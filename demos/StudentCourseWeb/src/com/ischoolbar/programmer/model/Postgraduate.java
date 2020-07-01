package com.ischoolbar.programmer.model;
/**
 * @author future
 *
 */

public class Postgraduate extends Student {
		private String tutor;//导师
		private String researchDir;//研究方向
		
		
//		public Postgraduate(int studentNum, String studentName, String studentSex, Date studentBirthday, String studentGrade,
//				String studentMajor,String tutor, String researchDir) {
//			super(studentNum, researchDir, researchDir, studentBirthday, researchDir, researchDir);
//			this.tutor = tutor;
//			this.researchDir = researchDir;
//		}

		/**
		 * @return the tutor
		 */
		
		public String getTutor() {
			return tutor;
		}
		
		/**
		 * @param tutor the tutor to set
		 */
		
		public void setTutor(String tutor) {
			this.tutor = tutor;
		}
		
		/**
		 * @return the researchDir
		 */
		
		public String getResearchDir() {
			return researchDir;
		}
		
		/**
		 * @param researchDir the researchDir to set
		 */
		
		public void setResearchDir(String researchDir) {
			this.researchDir = researchDir;
		}
		
	}


