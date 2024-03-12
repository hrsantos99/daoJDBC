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
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1999, Calendar.JANUARY, 11);
		Date birthDay = calendar.getTime();
		Seller newSeller = new Seller(null, "Vinícius", "vinimograph@gmail.com", birthDay, 5000.0, new Department(3, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}
}