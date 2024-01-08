package at.spengergasse.med_px.Anamnese;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "a_anamnese")
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int svnr;
    private String name;
    private LocalDate birth;
    private String Medikamente;
    private String Familienanamnese;
    private boolean InBehandlung;

    public Anamnese() {

    }

    public int getSvnr() {
        return svnr;
    }

    public void setSvnr(int svnr) {
        this.svnr = svnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getMedikamente() {
        return Medikamente;
    }

    public void setMedikamente(String medikamente) {
        Medikamente = medikamente;
    }

    public String getFamilienanamnese() {
        return Familienanamnese;
    }

    public void setFamilienanamnese(String familienanamnese) {
        Familienanamnese = familienanamnese;
    }

    public boolean isInBehandlung() {
        return InBehandlung;
    }

    public void setInBehandlung(boolean inBehandlung) {
        InBehandlung = inBehandlung;
    }

    public Anamnese(int svnr, String name, LocalDate birth, String medikamente, String familienanamnese, boolean inBehandlung) {
        this.svnr = svnr;
        this.name = name;
        this.birth = birth;
        Medikamente = medikamente;
        Familienanamnese = familienanamnese;
        InBehandlung = inBehandlung;
    }
}
