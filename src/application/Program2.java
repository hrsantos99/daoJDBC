package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\nCommand Insert Department");
		System.out.println("\nInsert the department data:");
		System.out.println("\nName: ");
		String name = sc.nextLine();

		Department newDep = new Department(null, name);
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());

		
		System.out.println("\nCommand Department Update");
		System.out.println("\nInsert id for update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department department = departmentDao.findById(id);
		System.out.println("\nDefine new name: ");
		String newName = sc.nextLine();
		department.setName(newName);
		departmentDao.update(department);
		System.out.println("Update completed");

		
		System.out.println("\nCommand Delete Department");
		System.out.println("\nDefine id for delete department: ");
		int id1 = sc.nextInt();
		sc.nextLine();
		departmentDao.deleteById(id1);
		System.out.println("Delete completed!");

		
		System.out.println("Command Find By Id");
		System.out.println("\nInsert the id: ");
		int id2 = sc.nextInt();
		sc.nextLine();
		department = departmentDao.findById(id2);
		System.out.println(department);

		
		System.out.println("\nCommand Find All");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

}
