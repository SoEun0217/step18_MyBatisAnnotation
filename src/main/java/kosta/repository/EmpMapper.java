package kosta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.dto.EmpDTO;

/**
 * SQL문장 interface 기반
 * */
public interface EmpMapper {
	/**
	 * 전체검색
	 * @Results를 사용해 column명과 property가 다를 때 맞추어 줄 수있다.
	 * */
	@Select("select empno,ename,job,sal,hiredate from emp")
	@Results(value = {
			@Result(column = "empno",property = "empno"),
			@Result(column = "ename", property = "ename")
	})
	List<EmpDTO> selectAll();	
	
	/**
	 * 사원번호에 해당하는 정보 검색
	 * */
	@Select("select empno,ename,job,sal,hiredate from emp where empno=#{_parameter}")
	EmpDTO selectByEmpNo(int empno);
	
	/**
	 * 사원번호에 해당하는 정보 삭제
	 * */
	@Delete("delete from emp where empno = #{_parameter}")
	int delete(int empno);
	
	/**
	 * 사원번호에 해당하는 정보 수정
	 * */
	@Update("update emp set ename=#{ename} ,job=#{job} ,sal=#{sal} where empno = #{empno}")
	int update(EmpDTO emp);
	
	/**
	 * 사원등록하기
	 * */
	@Insert("insert into emp(empno,ename,job,sal,hiredate) values(#{empno},#{ename},#{job},#{sal},sysdate)")
	int insert(EmpDTO emp);
	
	/**
	 * 동적쿼리
	 * */
	@Select("<script>select empno,ename,job,sal,hiredate from emp\r\n" + 
			"		<trim prefix=\"where\" prefixOverrides=\"and\">\r\n" + 
			"			<if test=\"ename!=null\">\r\n" + 
			"				ename=#{ename}\r\n" + 
			"			</if>\r\n" + 
			"			<if test=\"job!=null\">\r\n" + 
			"				and job=#{job}\r\n" + 
			"			</if>\r\n" + 
			"		</trim></script>")
	List<EmpDTO> ifTest(EmpDTO empDTO);
}
