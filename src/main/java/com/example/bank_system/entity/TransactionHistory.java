package com.example.bank_system.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "transaction_history")
	public class TransactionHistory {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   
	    @Column(name = "number")
	    private String number;
	    
	    

	    @Column(name = "transaction_date")
	    private LocalDateTime transactionDate;

	    @Column(name = "transaction_type")
	    private String transactionType;

	    @Column(name = "transaction_amount")
	    private Integer transactionAmount;

	    @Column(name = "transaction_who")
	    private String transactionWho;

	    @Column(name = "transaction_deposit")
	    private Double transactionDeposit;
	 
    

	public TransactionHistory() {
		super();
	}


	public TransactionHistory(Long id, String number, LocalDateTime transactionDate, String transactionType,
			Integer transactionAmount, String transactionWho, Double transactionDeposit) {
		super();
		this.id = id;
		this.number = number;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionWho = transactionWho;
		this.transactionDeposit = transactionDeposit;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getTransactionWho() {
		return transactionWho;
	}


	public void setTransactionWho(String transactionWho) {
		this.transactionWho = transactionWho;
	}


	public Double getTransactionDeposit() {
		return transactionDeposit;
	}


	public void setTransactionDeposit(Double transactionDeposit) {
		this.transactionDeposit = transactionDeposit;
	}
  
}
