package kosta.main;

import kosta.dto.EmpDTO;
import kosta.repository.EmpDAO;


public class MainApp {

	public static void main(String[] args) {
		System.out.println("전체 검색");
		EmpDAO.selectAll();
		
		System.out.println("사원 번호 검색");
		//EmpDAO.selectByEmpNo(131);
		
		System.out.println("사원 update");
		//EmpDAO.update(new EmpDTO(131, "1124", "개발자", 2500, null));
		
		System.out.println("사원 입력하기");
		//EmpDAO.insert(new EmpDTO(525, "태민", "singer", 5000, "2008.05.25"));
		
		System.out.println("사원 삭제하기");
		//EmpDAO.delete(130);
		
		System.out.println("동적 쿼리 테스트");//동적쿼리는 앞뒤에<script></script>붙여서 써준다 @Select("요안에").
		EmpDAO.ifTest(new EmpDTO(0, "태민", "singer", 0, null));
		EmpDAO.ifTest(new EmpDTO(0, "소은", null, 0, null));
		EmpDAO.ifTest(new EmpDTO(0,null, "냐냐", 0, null));
		EmpDAO.ifTest(new EmpDTO(0,null, null, 0, null));//전체검색
	}

}
