package kosta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmpDTO {
	private int empno;
	private String ename;//db에는 ename으로 되어있다.
	private String job;
	private int sal;
	private String hiredate;
}
