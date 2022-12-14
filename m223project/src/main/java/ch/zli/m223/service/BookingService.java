package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;



@ApplicationScoped
public class BookingService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Booking getBookingById(Long id) {
        return  entityManager.find(Booking.class, id);
    }

    public List<Booking> getBookings() {
        var qry = entityManager.createQuery("FROM Booking", Booking.class);
        return qry.getResultList();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.merge(booking);
        return booking;
    }

    @Transactional
    public void deleteBooking(Long id) {
        var qry = entityManager.find(Booking.class, id);
        entityManager.remove(qry);
    }

    @Transactional
    public Booking updateBooking(Booking booking, Long id) {
        return entityManager.merge(booking);
    }


}


