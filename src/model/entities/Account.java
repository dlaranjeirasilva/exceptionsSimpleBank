package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		
		//Although the deposit method wasn't used, as a good practice,
		//I implemented a simple exception to it, in case of future need
		if(amount<0) {
			throw new DomainException("Deposit error: Can't deposit a negative amount");
		}
		
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		
		if(amount>withdrawLimit) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
		}
		
		if(amount>balance) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
		
		//Same exception used within deposit method, but with a different message,
		//to be clear that happened in the withdraw method this time
		if(amount<0) {
			throw new DomainException("Withdraw error: Can't withdraw a negative amount");
		}
		
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return	"New balance: " + String.format("%.2f", balance);
	}
}
