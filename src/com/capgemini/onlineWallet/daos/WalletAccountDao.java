package com.capgemini.onlineWallet.daos;

import java.util.List;

import com.capgemini.onlineWallet.model.WalletAccount;

public interface WalletAccountDao {
	void createWalletAccount(WalletAccount w);

	void addAmountToAccountByAccountId(int accountId, double balance);

	
	double showBalanceByAccountid(int accountId);
	int accountIdOfCurrentUser(int userId);
	List<WalletAccount> allAccount();
	
	public List<WalletAccount> retriveAllAccount();

}
