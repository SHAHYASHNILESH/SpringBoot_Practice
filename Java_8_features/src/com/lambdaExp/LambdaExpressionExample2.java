package com.lambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionExample2 {

	public static void main(String[] args) {

		List<Employee> lst = new ArrayList<Employee>();

		lst.addAll(Arrays.asList(new Employee(1, "A"), new Employee(2, "B"), new Employee(3, "C"), new Employee(4, "D"),
				new Employee(5, "E")));

		System.out.println(lst);

//		Collections.sort(lst, (Employee e1, Employee e2) -> e2.getEmpName().compareTo(e1.getEmpName()));
//		System.out.println(lst);

		// Class name:: method name
		Collections.sort(lst, Comparator.comparing(Employee::getEmpName));
		System.out.println(lst);
	}
}
