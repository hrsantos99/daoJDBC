package application;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		seller = sellerDao.findById(9);
		seller.setName("Stephany");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1999, Calendar.SEPTEMBER, 03);
		Date birthDay = calendar.getTime();
		seller.setBirthDate(birthDay);
		seller.setEmail("stephanycassiano@gmail.com");
		seller.setDepartment(new Department(2, null));
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}
}