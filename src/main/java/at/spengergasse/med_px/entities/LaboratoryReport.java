package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "l_laborbefunde")
public class LaboratoryReport extends Report {

    @OneToMany
    @JoinColumn(name = "report_id")
    private List<MeasuredValue> values;   // the measured values of the report
    private long svnr;
    private String vorname;
    private String nachname;
    private LocalDate geburtstag;
    private int leukozyten;
    private int thrombozyten;
    private float erythrozyten;
    private float hamoeglobin;
    private float haemokrit;

    @Override
    public String toString() {
        return "LaboratoryReport{" +
                "values=" + values +
                ", svnr=" + svnr +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtstag=" + geburtstag +
                ", leukozyten=" + leukozyten +
                ", thrombozyten=" + thrombozyten +
                ", erythrozyten=" + erythrozyten +
                ", hamoeglobin=" + hamoeglobin +
                ", haemokrit=" + haemokrit +
                ", mch=" + mch +
                ", mcv=" + mcv +
                ", mchc=" + mchc +
                '}';
    }

    public LaboratoryReport(){

    }

    public LaboratoryReport(List<MeasuredValue> values, long svnr, String vorname, String nachname, LocalDate geburtstag, int leukozyten, int thrombozyten, float erythrozyten, float hamoeglobin, float haemokrit, float mch, float mcv, float mchc) {
        this.values = values;
        this.svnr = svnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.leukozyten = leukozyten;
        this.thrombozyten = thrombozyten;
        this.erythrozyten = erythrozyten;
        this.hamoeglobin = hamoeglobin;
        this.haemokrit = haemokrit;
        this.mch = mch;
        this.mcv = mcv;
        this.mchc = mchc;
    }

    public List<MeasuredValue> getValues() {
        return values;
    }

    public long getSvnr() {
        return svnr;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public int getLeukozyten() {
        return leukozyten;
    }

    public int getThrombozyten() {
        return thrombozyten;
    }

    public float getErythrozyten() {
        return erythrozyten;
    }

    public float getHamoeglobin() {
        return hamoeglobin;
    }

    public float getHaemokrit() {
        return haemokrit;
    }

    public float getMch() {
        return mch;
    }

    public float getMcv() {
        return mcv;
    }

    public float getMchc() {
        return mchc;
    }

    public void setValues(List<MeasuredValue> values) {
        this.values = values;
    }

    public void setSvnr(long svnr) {
        this.svnr = svnr;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }

    public void setLeukozyten(int leukozyten) {
        this.leukozyten = leukozyten;
    }

    public void setThrombozyten(int thrombozyten) {
        this.thrombozyten = thrombozyten;
    }

    public void setErythrozyten(float erythrozyten) {
        this.erythrozyten = erythrozyten;
    }

    public void setHamoeglobin(float hamoeglobin) {
        this.hamoeglobin = hamoeglobin;
    }

    public void setHaemokrit(float haemokrit) {
        this.haemokrit = haemokrit;
    }

    public void setMch(float mch) {
        this.mch = mch;
    }

    public void setMcv(float mcv) {
        this.mcv = mcv;
    }

    public void setMchc(float mchc) {
        this.mchc = mchc;
    }

    private float mch;
    private float mcv;
    private float mchc;



}
