package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Place;

@ApplicationScoped
public class PlaceService {

    @Inject
    private EntityManager entityManager;

    
    public List<Place> getPlaces() {
        var qry = entityManager.createQuery("FROM Place", Place.class);
        return qry.getResultList();
    }

    @Transactional
    public Place updatPlace(Place place, Long id) {
        return entityManager.merge(place);
    }


}
