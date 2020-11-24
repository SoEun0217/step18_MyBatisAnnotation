package kosta.repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	private static SqlSessionFactory factory;
	
	static {//static블록이므로 제일먼저 실행된다.
		String resource = "config/SqlMapConfig.xml";//환경설정파일위치
		try {
		Reader reader = Resources.getResourceAsReader(resource);
		factory = new SqlSessionFactoryBuilder().build(reader);//factory를 반환
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MyBatis의 SqlSession객체를 리턴해주는 메소드 작성
	 *  : SqlSession는 CRUD작업에 관련된 메소드 제공
	 *    commit, rollback에 관련된 transaction메소드도 제공한다.
	 *    기본적으로 자동 commit이 아니기 때문에서
	 *    DML작업일 경우에 반드시 commit or rollback 처리 필수
	 *  : JDBC의 Connection과 유사하다
	 * */
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
	/**
	 * 닫기(select전용)
	 * */
	public static void sessionClose(SqlSession session) {
		if(session!=null) session.close();
	}
	
	/**
	 * 닫기(DML - insert,update,delete)
	 *  @param : boolean형은 true이면 commit, false이면 rollback한다.
	 * */
	public static void sessionClose(SqlSession session,boolean state) {
		if(session!=null) {
			if(state)session.commit();
			else session.rollback();
			
			session.close();
		}
	}
	
}
