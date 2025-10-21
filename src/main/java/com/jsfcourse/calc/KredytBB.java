package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {


    private String kwota;
    private String lata;
    private String procent;
    private Double result;

    @Inject
    FacesContext ctx;

    public String getKwota() { return kwota; }
    public void setKwota(String kwota) { this.kwota = kwota; }

    public String getLata() { return lata; }
    public void setLata(String lata) { this.lata = lata; }

    public String getProcent() { return procent; }
    public void setProcent(String procent) { this.procent = procent; }

    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }


    private boolean doTheMath() {
        try {
            double kwotaVal = Double.parseDouble(this.kwota);
            double lataVal = Double.parseDouble(this.lata);
            double procentVal = Double.parseDouble(this.procent);

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
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Błąd podczas przetwarzania parametrów", null));
            return false;
        }
    }

    public String calc() {
        if (doTheMath()) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Operacja wykonana poprawnie", null));
            return "showresult";
        }
        return null;
    }
    public String calc_AJAX() {
        if (doTheMath()) {
            String formattedResult = String.format("%.2f", result);
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Wynik (rata): " + formattedResult + " zł", null));
        }
        return null;
    }

    public String info() {
        return "info";
    }
}
