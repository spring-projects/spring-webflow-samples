package org.springframework.webflow.samples.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * A Hotel Booking made by a User.
 */
@Entity
@BookingDateRange
public class Booking implements Serializable {
    private Long id;

    private User user;

    private Hotel hotel;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date checkinDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date checkoutDate;

    private String creditCard;

    private String creditCardName;

    private int creditCardExpiryMonth;

    private int creditCardExpiryYear;

    private boolean smoking;

    private int beds;

    public Booking() {
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, 1);
	setCheckinDate(calendar.getTime());
	calendar.add(Calendar.DAY_OF_MONTH, 1);
	setCheckoutDate(calendar.getTime());
    }

    public Booking(Hotel hotel, User user) {
	this();
	this.hotel = hotel;
	this.user = user;
    }

    @Transient
    public BigDecimal getTotal() {
	return hotel.getPrice().multiply(new BigDecimal(getNights()));
    }

    @Transient
    public int getNights() {
	return (int) (checkoutDate.getTime() - checkinDate.getTime()) / 1000 / 60 / 60 / 24;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @NotNull
    @Future
    public Date getCheckinDate() {
	return checkinDate;
    }

    public void setCheckinDate(Date datetime) {
	this.checkinDate = datetime;
    }

    @ManyToOne
    public Hotel getHotel() {
	return hotel;
    }

    public void setHotel(Hotel hotel) {
	this.hotel = hotel;
    }

    @ManyToOne
    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @NotNull
    @Future
    public Date getCheckoutDate() {
	return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
	this.checkoutDate = checkoutDate;
    }

    @NotEmpty
    public String getCreditCard() {
	return creditCard;
    }

    public void setCreditCard(String creditCard) {
	this.creditCard = creditCard;
    }

    @Transient
    public String getDescription() {
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	return hotel == null ? null : hotel.getName() + ", " + df.format(getCheckinDate()) + " to "
		+ df.format(getCheckoutDate());
    }

    public boolean isSmoking() {
	return smoking;
    }

    public void setSmoking(boolean smoking) {
	this.smoking = smoking;
    }

    public int getBeds() {
	return beds;
    }

    public void setBeds(int beds) {
	this.beds = beds;
    }

    @NotEmpty
    public String getCreditCardName() {
	return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
	this.creditCardName = creditCardName;
    }

    public int getCreditCardExpiryMonth() {
	return creditCardExpiryMonth;
    }

    public void setCreditCardExpiryMonth(int creditCardExpiryMonth) {
	this.creditCardExpiryMonth = creditCardExpiryMonth;
    }

    public int getCreditCardExpiryYear() {
	return creditCardExpiryYear;
    }

    public void setCreditCardExpiryYear(int creditCardExpiryYear) {
	this.creditCardExpiryYear = creditCardExpiryYear;
    }

    @Override
    public String toString() {
	return "Booking(" + user + "," + hotel + ")";
    }

}
