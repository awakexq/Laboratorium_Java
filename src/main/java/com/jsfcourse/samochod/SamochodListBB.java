package com.jsfcourse.samochod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.Flash;

import com.jsfcourse.dao.SamochodDAO;
import com.jsfcourse.entities.Samochod;

@Named
@RequestScoped
public class SamochodListBB {
    private static final String PAGE_SAMOCHOD_EDIT = "samochodEdit?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private String marka;

    @Inject
    ExternalContext extcontext;

    @Inject
    Flash flash;

    @EJB
    SamochodDAO samochodDAO;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public List<Samochod> getFullList(){
        return samochodDAO.getFullList();
    }

    public List<Samochod> getList(){
        List<Samochod> list = null;

        Map<String,Object> searchParams = new HashMap<>();
        if (marka != null && !marka.isEmpty()) {
            searchParams.put("marka", marka);
        }

        list = samochodDAO.getList(searchParams);
        return list;
    }

    public String newSamochod(){
        Samochod samochod = new Samochod();
        flash.put("samochod", samochod);
        return PAGE_SAMOCHOD_EDIT;
    }

    public String editSamochod(Samochod samochod){
        flash.put("samochod", samochod);
        return PAGE_SAMOCHOD_EDIT;
    }

    public String deleteSamochod(Samochod samochod){
        samochodDAO.remove(samochod);
        return PAGE_STAY_AT_THE_SAME;
    }
}
