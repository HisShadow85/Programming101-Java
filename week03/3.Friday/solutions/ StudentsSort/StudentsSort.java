package Friday;

import java.util.LinkedList;
import java.util.List;

class Student {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getGrade() {
		return grade;
	}

	public void setGrade(byte grade) {
		this.grade = grade;
	}

	private byte grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = (byte) grade;
	}

	public String toString() {
		return "Name: " + this.name + "\r\nGrade: " + grade;
	}
}

public class StudentsSort {

	public static void main(String[] args) {
		List<Student> list = new LinkedList<Student>();
		list.add(new Student("Gosho", 3));
		list.add(new Student("Ivan", 2));
		list.add(new Student("Dimitrichka", 4));
		list.add(new Student("Petko", 2));
		list.add(new Student("Sashko", 5));
		list.add(new Student("Dragan", 3));		
		list.add(new Student("Penka", 4));
		list.add(new Student("Vladko", 5));	
		sort(list);
		for (Student student : list) {
			System.out.println(student);
		}

	}

	static void sort(List<Student> list) {
		list.sort((a, b) -> {
			return a.getGrade() - b.getGrade() == 0 ? a.getName().compareTo(b.getName()) : a.getGrade() - b.getGrade();
		});
	}
}
