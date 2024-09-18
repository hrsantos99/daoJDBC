package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Command Find By Id");
		System.out.println("\nInsert the id: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(id);
		System.out.println(seller);
		
		System.out.println("\nCommand Find By Department");
		System.out.println("\nInsert the department: ");
		int dep = sc.nextInt();
		sc.nextLine();
		Department department = new Department(dep, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nCommand Find All");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nCommand Insert Seller");
		System.out.println("\nInsert the seller data:");
		System.out.println("\nName: ");
		String name = sc.nextLine();
		System.out.println("\nEmail: ");
		String email = sc.nextLine();
		System.out.println();
		System.out.println("\nBirthday (dd/MM/yyyy): ");
		LocalDate bd = null;
		String birthday = sc.nextLine();
		try {
            bd = LocalDate.parse(birthday, fmt);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido! Por favor, insira no formato dd/MM/yyyy.");
        }
		System.out.println();
		System.out.println("\nSalary: ");
		Double salary = sc.nextDouble();
		sc.nextLine();
		System.out.println("\nDepartment: ");
		int dep1 = sc.nextInt();
		sc.nextLine();
		Department department1 = new Department(dep1, null);
		Seller newSeller = new Seller(null, name, email, bd, salary, department1);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\nCommand Seller Update");
		System.out.println("\nInsert id for update: ");
		int id1 = sc.nextInt();
		sc.nextLine();
		seller = sellerDao.findById(id1);
		System.out.println("\nDefine new name: ");
		String newName = sc.nextLine();
		seller.setName(newName);
		System.out.println("\nDefine new email: ");
		String newEmail = sc.nextLine();
		seller.setEmail(newEmail);
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\nCommand Delete Seller");
		System.out.println("\nDefine id for delete seller: ");
		int id3 = sc.nextInt();
		sc.nextLine();
		sellerDao.deleteById(id3);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}