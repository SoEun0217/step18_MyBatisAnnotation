package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class EmpDAO {
	/**
	 * 전체검색 -- autoCloseable
	 * */
	public static void selectAll() {
		try(SqlSession session = DbUtil.getSession()) {//다 쓰면 session을 닫는다
			EmpMapper mapper = session.getMapper(EmpMapper.class);//session.getMapper메소드 사용
			List<EmpDTO>list = mapper.selectAll();
			for(EmpDTO dto:list) {
				System.out.println(dto);
			}
		}
	}
	
	public static void selectByEmpNo(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			System.out.println(mapper.selectByEmpNo(empno));
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.delete(empno)>0?true:false;
		} finally {
			DbUtil.sessionClose(session,state);
		}
	}
	
	public static void update(EmpDTO emp) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.update(emp)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	public static void insert(EmpDTO emp) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.insert(emp)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
			
		}
	}
	
	public static void ifTest(EmpDTO empDTO) {
		try(SqlSession session = DbUtil.getSession()) {
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO>list = mapper.ifTest(empDTO);
			for(EmpDTO dto:list) {
				System.out.println(dto);
			}
		}
	}
	
}
