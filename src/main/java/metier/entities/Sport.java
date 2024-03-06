package metier.entities;

import java.io.Serializable;

public class Sport implements Serializable {
    private Long idSport;
    private String nomSport;
    private String description;
    private String dateFondation;

    public Sport() {
        super();
    }

    public Sport(String nomSport, String description, String dateFondation) {
        super();
        this.nomSport = nomSport;
        this.description = description;
        this.dateFondation = dateFondation;
    }

    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateFondation() {
        return dateFondation;
    }

    public void setDateFondation(String dateFondation) {
        this.dateFondation = dateFondation;
    }

    @Override
    public String toString() {
        return "Sport [idSport=" + idSport + ", nomSport=" + nomSport + ", description=" + description + ", dateFondation=" + dateFondation + "]";
    }
}
