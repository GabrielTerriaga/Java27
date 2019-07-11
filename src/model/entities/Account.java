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
	
	public void deposit(Double amount) {
		this.balance =+ amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		
		if (balance < amount) {
			
			throw new DomainException("Desculpe, conta com saldo insuficiente");
		}//FIM tratamento para caso saldo seja 0
	
		
		if (amount > withdrawLimit) {
			
			throw new DomainException("Desculpe, não é permitido realizar um saque superior ao limite disponivel da conta");
		}//FIM tratamento para caso seja maior que saldo e maior que limite de saque
		
		
		this.balance = balance - amount;
	}
	
}
