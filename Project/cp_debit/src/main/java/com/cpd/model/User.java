package com.cpd.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "DTDC_USER")
public class User {

	@Id
	@SequenceGenerator(name = "SEQ_GEN_U_C", sequenceName = "SEQ_N_T_DTDC_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_U_C")
	@Column(name = "USER_ID")
	private int userId;
	private String name;
	private String phone;
	private String email;
	private Date dob;

	@OneToMany(mappedBy = "user")
	private Set<Address> addresses;

	@OneToOne(mappedBy = "user")
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Login login;

	@OneToMany(mappedBy = "user")
	private Set<ShipmentBooking> shipmentBookings;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Set<ShipmentBooking> getShipmentBookings() {
		return shipmentBookings;
	}

	public void setShipmentBookings(Set<ShipmentBooking> shipmentBookings) {
		this.shipmentBookings = shipmentBookings;
	}

	
}