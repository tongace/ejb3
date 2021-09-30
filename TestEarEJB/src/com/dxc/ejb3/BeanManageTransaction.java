package com.dxc.ejb3;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateful
@TransactionManagement(value=TransactionManagementType.BEAN)
public class BeanManageTransaction {
	int counter = 0;
	@Resource
	UserTransaction tx;
	public String hello() throws IllegalStateException, SecurityException, SystemException {
		try {
			tx.begin();
			String returnVal = "Bean Manage Transaction"+ (counter++);
			tx.commit();
			return returnVal;
		}catch(Exception ex) {
			tx.rollback();
			return "Error";
		}
	}
}
