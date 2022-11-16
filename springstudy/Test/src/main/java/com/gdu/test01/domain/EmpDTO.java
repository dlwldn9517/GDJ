package com.gdu.test01.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {
	private int empNo;
	private String empName, deptName, salary;
}
