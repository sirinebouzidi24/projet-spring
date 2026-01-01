package spring.jpa.dto;

import java.util.List;

public class CoursForm {

    private Long code;
    private String titre;
    private String description;

    private List<Long> formateurIds;
    private List<Long> etudiantIds;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getFormateurIds() {
        return formateurIds;
    }

    public void setFormateurIds(List<Long> formateurIds) {
        this.formateurIds = formateurIds;
    }

    public List<Long> getEtudiantIds() {
        return etudiantIds;
    }

    public void setEtudiantIds(List<Long> etudiantIds) {
        this.etudiantIds = etudiantIds;
    }
}
