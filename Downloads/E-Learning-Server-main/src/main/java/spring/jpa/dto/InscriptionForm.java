package spring.jpa.dto;

public class InscriptionForm {

    private String etudiantMatricule;
    private Long coursCode;

    public String getEtudiantMatricule() {
        return etudiantMatricule;
    }

    public void setEtudiantMatricule(String etudiantMatricule) {
        this.etudiantMatricule = etudiantMatricule;
    }

    public Long getCoursCode() {
        return coursCode;
    }

    public void setCoursCode(Long coursCode) {
        this.coursCode = coursCode;
    }
}
