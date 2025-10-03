package com.cg.hib.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyDTO {
	
	//oi.orderItemId,p.name,p.unitcost,oi.unitPrice
	
	private int orderItemId;
	private String name;
	private int unitCostInternal;
	private int actualSellingPrice;

}
