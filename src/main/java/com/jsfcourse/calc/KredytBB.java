package com.jsfcourse.calc;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class KredytBB {

    private Double kwota;
    private Integer lata;
    private Double procent;
    private Double result;

    public Double getKwota() { return kwota; }
    public void setKwota(Double kwota) { this.kwota = kwota; }

    public Integer getLata() { return lata; }
    public void setLata(Integer lata) { this.lata = lata; }

    public Double getProcent() { return procent; }
    public void setProcent(Double procent) { this.procent = procent; }

    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }

    private boolean doTheMath() {
        try {
            double kwotaVal = kwota;
            double lataVal = lata;
            double procentVal = procent;

            double n = lataVal * 12;
            if (procentVal == 0) {
                result = kwotaVal / n;
            } else {
                double p = (procentVal / 100) / 12;
                result = kwotaVal * (p * Math.pow(1 + p, n)) / (Math.pow(1 + p, n) - 1);
            }
            result = Math.round(result * 100.0) / 100.0;
            return true;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd przetwarzania parametrów", null));
            return false;
        }
    }

    public String calc() {
        if (doTheMath()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
            return "showresult";
        }
        return null;
    }

    public String calc_AJAX() {
        if (doTheMath()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Wynik (rata): " + String.format("%.2f", result) + " zł", null));
        }
        return null;
    }
    public String info() {
        return "info";
    }
}
