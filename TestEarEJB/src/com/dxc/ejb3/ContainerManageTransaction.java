package com.dxc.ejb3;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class ContainerManageTransaction {
	int counter = 0;
	public String hello() {
		return "Container Manage Transaction"+ (counter++);
	}
}
