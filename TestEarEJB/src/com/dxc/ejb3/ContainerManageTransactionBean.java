package com.dxc.ejb3;

import javax.ejb.Remote;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
@Remote(value = ContainerManageTransaction.class)
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class ContainerManageTransactionBean implements ContainerManageTransaction{
	int counter = 0;
	@Override
	public String hello() {
		return "Container Manage Transaction"+ (counter++);
	}
}
