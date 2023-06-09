package com.example.bank_system.service.ifs;

import java.util.List;

import com.example.bank_system.entity.Bank;
import com.example.bank_system.entity.TransactionHistory;
import com.example.bank_system.vo.request.BankRequest;
import com.example.bank_system.vo.response.BankResponse;

public interface BankService {
	
	// 查詢用戶資料
	public List<Bank> findByCard(String card);

	// 修改用戶資料
	public BankResponse updateClient(BankRequest bankRequest);

	// 存款
	public BankResponse deposit(String card, String account, String password, Integer amount);

	// 查詢存款利息
	public BankResponse getDepositRate(String card, String account, String password);
	
	BankResponse login(BankRequest request);
	
	BankResponse login2(BankRequest request);

	BankResponse withdrawByCardAndPassword(BankRequest request);

	BankResponse transferMoney(BankRequest request);

	BankResponse getDepositByAccountAndPassword(BankRequest request);

	public BankResponse findTransactionHistory(BankRequest request);

	

}
