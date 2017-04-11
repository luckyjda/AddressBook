package service;

import java.util.List;

import domain.Student;

interface StudentService {
	
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> queryAllStudent();
	
	/**
	 * ��ѯѧ��
	 * @param id  ѧ��id
	 * @return
	 */
	public Student query(String id);
	
	/**
	 * ͨ�����ֲ�ѯѧ��
	 * @return
	 */
	public Student queryByName();
	
}
