package dao;

import java.util.List;

import metier.entities.Sport;

public class TestDao {
	public static void main(String[] args) {
		SportDaoImpl pdao= new SportDaoImpl();
		Sport prod= pdao.save(new Sport("Hoonde","Sport collectif où deux équipes","2000-02-02"));
		System.out.println(prod);
		List<Sport> prods =pdao.sportParMC("n");
		for (Sport p : prods)
		System.out.println(p);
		}

}
