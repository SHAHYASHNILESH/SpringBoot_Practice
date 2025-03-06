package com.LMS.Library_Management_System.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String title;
	private boolean availabilityStatus;
	private LocalDate borrowDate;
	private LocalDate returnDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	
	public Book() {
		super();
	}

	public Book(Long bookId, String title, boolean availabilityStatus, LocalDate borrowDate, LocalDate returnDate,
			UserEntity user) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.availabilityStatus = availabilityStatus;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.user = user;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", availabilityStatus=" + availabilityStatus
				+ ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + ", user=" + user + "]";
	}

}
