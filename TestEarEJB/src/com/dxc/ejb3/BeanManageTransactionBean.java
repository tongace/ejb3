package com.dxc.ejb3;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

@Remote(value = BeanManageTransaction.class)
@Stateful
@TransactionManagement(value = TransactionManagementType.BEAN)
public class BeanManageTransactionBean implements BeanManageTransaction {
	int counter = 0;
	@Resource
	UserTransaction tx;

	@Override
	public String hello() {
		try {
			tx.begin();
			String returnVal = "Bean Manage Transaction" + (counter++);
			tx.commit();
			return returnVal;
		} catch (Exception ex) {
			try {
				tx.rollback();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			return "Error";
		}
	}
}
