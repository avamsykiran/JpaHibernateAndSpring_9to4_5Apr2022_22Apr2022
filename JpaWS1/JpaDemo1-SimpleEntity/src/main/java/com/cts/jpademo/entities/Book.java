package com.cts.jpademo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bcode")
	private Long bcode;
	@Column(name = "btitle", nullable = false)
	private String title;
	@Column(name = "pubDt", nullable = false)
	private LocalDate publishedDate;
	private Double price;
	@Enumerated(EnumType.STRING)
	private Zonar zonar;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long bcode, String title, LocalDate publishedDate, Double price, Zonar zonar) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.publishedDate = publishedDate;
		this.price = price;
		this.zonar = zonar;
	}

	public Long getBcode() {
		return bcode;
	}

	public void setBcode(Long bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Zonar getZonar() {
		return zonar;
	}

	public void setZonar(Zonar zonar) {
		this.zonar = zonar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcode == null) ? 0 : bcode.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((zonar == null) ? 0 : zonar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bcode == null) {
			if (other.bcode != null)
				return false;
		} else if (!bcode.equals(other.bcode))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (zonar != other.zonar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", title=" + title + ", publishedDate=" + publishedDate + ", price=" + price
				+ ", zonar=" + zonar + "]";
	}
	
}
