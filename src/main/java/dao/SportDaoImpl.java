package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.SingletonConnection;
import metier.entities.Sport;


public class SportDaoImpl implements ISportDao{
	@Override
	public Sport save(Sport p) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("INSERT INTO sport(NOM_sport,description,date_fondation) VALUES(?,?,?)");
	ps.setString(1, p.getNomSport());
	ps.setString(2, p.getDescription());
	ps.setString(3, p.getDateFondation());
	ps.executeUpdate();
	PreparedStatement ps2= conn.prepareStatement("SELECT MAX(ID_SPORT) as MAX_ID FROM sport");
	ResultSet rs =ps2.executeQuery();
	if (rs.next()) {
	p.setIdSport(rs.getLong("MAX_ID"));
	}
	ps.close();
	ps2.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	}
	
	@Override
	public List<Sport> sportParMC(String mc) {
	 List<Sport> prods= new ArrayList<Sport>();
	 Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from sport where NOM_sport LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Sport p = new Sport();
	p.setIdSport(rs.getLong("ID_SPORT"));
	p.setNomSport(rs.getString("NOM_SPORT"));
	p.setDescription(rs.getString("DESCRIPTION"));
	p.setDateFondation(rs.getString("DATE_FONDATION"));
	prods.add(p);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return prods;
	}
	
	@Override
	public Sport getSport(Long id) {
		Connection conn=SingletonConnection.getConnection();
		 Sport p = new Sport();
		 try {
		PreparedStatement ps= conn.prepareStatement("select * from sport where ID_sport = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			 p.setIdSport(rs.getLong("ID_SPORT"));
			    p.setNomSport(rs.getString("NOM_SPORT"));
			    p.setDescription(rs.getString("DESCRIPTION"));
			    p.setDateFondation(rs.getString("DATE_FONDATION"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return p;
	
	
	}
	@Override
	public Sport updateSport(Sport p) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("UPDATE sport SET NOM_sport=?, description=?, date_fondation=? WHERE ID_SPORT=?");
	        ps.setString(1, p.getNomSport());
	        ps.setString(2, p.getDescription());
	        ps.setString(3, p.getDateFondation());
	        ps.setLong(4, p.getIdSport()); 
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return p;
	}

	@Override
	public void deleteSport(Long id) {
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM sport WHERE ID_sport = ?");
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}

}
