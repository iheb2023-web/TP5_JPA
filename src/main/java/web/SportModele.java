package web;

import java.util.ArrayList;

import java.util.List;
import metier.entities.Sport;

public class SportModele {
	private String motCle;
	List<Sport> sp = new ArrayList<>();
	public String getMotCle() {
	return motCle;
	}
	public void setMotCle(String motCle) {
	this.motCle = motCle;
	}
	public List<Sport> getSport() {
	return sp;
	}
	public void setSport(List<Sport> sp) {
	this.sp = sp;
	}


}
