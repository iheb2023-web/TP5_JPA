package dao;

import java.util.List;
import metier.entities.Sport;

public interface ISportDao {
	public Sport save(Sport p);
	public List<Sport> sportParMC(String mc);
	public Sport getSport(Long id);
	public Sport updateSport(Sport p);
	public void deleteSport(Long id);

}
