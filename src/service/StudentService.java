package service;

import java.util.List;

import domain.Student;

interface StudentService {
	
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> queryAllStudent();
	
	/**
	 * 查询学生
	 * @param id  学生id
	 * @return
	 */
	public Student query(String id);
	
	/**
	 * 通过名字查询学生
	 * @return
	 */
	public Student queryByName();
	
}
