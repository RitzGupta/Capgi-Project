package com.capgemini.onlineWallet.serviceImpl;

import java.util.List;

import com.capgemini.onlineWallet.daoImpl.WalletTransactionDaoImpl;
import com.capgemini.onlineWallet.daos.WalletTransactionDao;
import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.model.WalletTransactions;
import com.capgemini.onlineWallet.services.WalletTransactionService;

public class WalletTransactionServiceImpl implements WalletTransactionService {

	WalletTransactionDao dao = new WalletTransactionDaoImpl();
	
	@Override
	public void amountTransaction(int senderAccId, int receiverAccId, double balance) throws InsufficientAmount, IncorrectArgumentException {
		// TODO Auto-generated method stub
		List<WalletAccount> list = dao.retriveAllAccount();
		int count = 0;
		if(balance>0) {
			for (WalletAccount w : list) {
				if (w.getAccountId() == receiverAccId)

				{
					count++;
					dao.amountTransaction(senderAccId, receiverAccId, balance);
				}
			}
		}else {
			throw new InsufficientAmount("Amount can not be in negative");
		}
		
		if (count == 0) {

			throw new IncorrectArgumentException("AccountId is not valid");

		}
		
		
	}
	
	
	@Override
	public List<WalletTransactions> allTransactions(int senderid) {
		// TODO Auto-generated method stub
		return dao.allTransactions(senderid);
	}
}
