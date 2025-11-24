package com.jsfcourse.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsfcourse.entities.Samochod;
// DAO - Data Access Object for Samochod entity
// Provides CRUD operations and search functionality
@Stateless
public class SamochodDAO {

    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Samochod samochod) {
        em.persist(samochod);
    }

    public Samochod merge(Samochod samochod) {
        return em.merge(samochod);
    }

    public void remove(Samochod samochod) {
        em.remove(em.merge(samochod));
    }

    public Samochod find(Object id) {
        return em.find(Samochod.class, id);
    }

    public List<Samochod> getFullList() {
        List<Samochod> list = null;
        Query query = em.createQuery("select s from Samochod s");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Samochod> getList(Map<String, Object> searchParams) {
        List<Samochod> list = null;

        // 1. Build query string
        String select = "select s ";
        String from = "from Samochod s ";
        String where = "";
        String orderby = "order by s.marka asc, s.model";

        // search by marka
        String marka = (String) searchParams.get("marka");
        if (marka != null && !marka.isEmpty()) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "s.marka like :marka ";
        }

        // search by model
        String model = (String) searchParams.get("model");
        if (model != null && !model.isEmpty()) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "s.model like :model ";
        }

        // 2. Create query object
        Query query = em.createQuery(select + from + where + orderby);

        // 3. Set parameters
        if (marka != null && !marka.isEmpty()) {
            query.setParameter("marka", marka + "%");
        }
        if (model != null && !model.isEmpty()) {
            query.setParameter("model", model + "%");
        }

        // 4. Execute query
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
