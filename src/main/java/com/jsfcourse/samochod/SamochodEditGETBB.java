package com.jsfcourse.samochod;

import java.io.IOException;
import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.jsfcourse.dao.SamochodDAO;
import com.jsfcourse.entities.Samochod;

@Named
@ViewScoped
public class SamochodEditGETBB implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String PAGE_SAMOCHOD_LIST = "samochodList?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private Samochod samochod = new Samochod();
    private Samochod loaded = null;

    @Inject
    FacesContext context;

    @EJB
    SamochodDAO samochodDAO;

    public Samochod getSamochod() {
        return samochod;
    }

    public void onLoad() throws IOException {
        if (!context.isPostback()) {
            if (!context.isValidationFailed() && samochod.getIdSamochodu() != null) {
                loaded = samochodDAO.find(samochod.getIdSamochodu());
            }
            if (loaded != null) {
                samochod = loaded;
            } else {
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
            }
        }
    }

    public String saveData() {
        if (loaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
            if (samochod.getIdSamochodu() == null) {
                samochodDAO.create(samochod);
            } else {
                samochodDAO.merge(samochod);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_SAMOCHOD_LIST;
    }
}
