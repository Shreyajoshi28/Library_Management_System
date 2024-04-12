package org_library_service;

import java.util.List;

import org_library_model.StudentModel;
import org_library_repository.StudentRepository;

public class StudentService {
	StudentRepository studRepo=new StudentRepository();
 public boolean isAddStudent(StudentModel studModel)
 {
	 return studRepo.isAddStudent(studModel);
 }
 public List<StudentModel> viewStudentInfo()
 {
	 return studRepo.viewStudentInfo();
 }
 public boolean isUpdateStudentInfo(StudentModel sModel)
 {
	 return studRepo.isUpdateStudentInfo(sModel);
 }
 public boolean isDeleteStudent(int sid)
 {
	 return studRepo.isDeleteStudent(sid);
 }
 public int isValidStudent(String user1,String pass1)
 {
	 return studRepo.isValidStudent(user1,pass1);
 }
 public List<StudentModel> showMyInfo(String user1,String pass1)
 {
	 return studRepo.showMyInfo(user1,pass1);
 }
 
}