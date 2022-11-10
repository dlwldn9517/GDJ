package com.gdu.app12.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {
	
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;

}
