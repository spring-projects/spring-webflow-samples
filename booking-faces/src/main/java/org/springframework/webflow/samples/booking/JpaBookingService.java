package org.springframework.webflow.samples.booking;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * A JPA-based implementation of the Booking Service. Delegates to a JPA entity manager to issue data access calls
 * against the backing repository. The EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Service("bookingService")
@Repository
public class JpaBookingService implements BookingService, Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
	this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Booking> findBookings(String username) {
	if (username != null) {
	    return em.createQuery("select b from Booking b where b.user.username = :username order by b.checkinDate")
		    .setParameter("username", username).getResultList();
	} else {
	    return null;
	}
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Hotel> findHotels(SearchCriteria criteria, int firstResult, String orderBy, boolean ascending) {
	String pattern = getSearchPattern(criteria);
	orderBy = (orderBy != null) ? orderBy : "name";
	String orderDirection = (ascending) ? " ASC" : " DESC";
	return em
		.createQuery(
			"select h from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
				+ "or lower(h.zip) like :pattern or lower(h.address) like :pattern order by h."
				+ orderBy + orderDirection).setParameter("pattern", pattern)
		.setMaxResults(criteria.getPageSize()).setFirstResult(firstResult).getResultList();
    }

    @Transactional(readOnly = true)
    public int getNumberOfHotels(SearchCriteria criteria) {
	String pattern = getSearchPattern(criteria);
	Long count = (Long) em
		.createQuery(
			"select count(h.id) from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
				+ "or lower(h.zip) like :pattern or lower(h.address) like :pattern")
		.setParameter("pattern", pattern).getSingleResult();
	return count.intValue();
    }

    @Transactional(readOnly = true)
    public Hotel findHotelById(Long id) {
	return em.find(Hotel.class, id);
    }

    @Transactional(readOnly = true)
    public Booking createBooking(Long hotelId, String username) {
	Hotel hotel = em.find(Hotel.class, hotelId);
	User user = findUser(username);
	Booking booking = new Booking(hotel, user);
	return booking;
    }

    @Transactional
    public void persistBooking(Booking booking) {
	em.persist(booking);
    }

    @Transactional
    public void cancelBooking(Booking booking) {
	booking = em.find(Booking.class, booking.getId());
	if (booking != null) {
	    em.remove(booking);
	}
    }

    // helpers

    private String getSearchPattern(SearchCriteria criteria) {
	if (StringUtils.hasText(criteria.getSearchString())) {
	    return "%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
	} else {
	    return "%";
	}
    }

    private User findUser(String username) {
	return (User) em.createQuery("select u from User u where u.username = :username")
		.setParameter("username", username).getSingleResult();
    }

}