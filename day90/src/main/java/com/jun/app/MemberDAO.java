package com.jun.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; // 의존관계(멤버변수)
	
	// 응집도를 높여줌
	// 상수화 선언 시 대문자로 작성
	private final String SELECTALL = "SELECT * FROM MEMBER";
	
	private final String SELECTONE = "SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
	
	private final String SELECTONE_CHECK = "SELECT * FROM MEMBER WHERE MID = ?";
	
	private final String INSERT = "INSERT INTO MEMBER VALUES (?, ?)";
	
	private final String UPDATE = "UPDATE MEMBER SET MPW = ? WHERE MID = ?";
	
	private final String DELETE = "DELETE FROM MEMBER WHERE MID = ?";

	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	public MemberDTO selectOne(MemberDTO mDTO) {
		try {
			if (mDTO.getSearch() != null) {
				Object[] args = { mDTO.getMid() };
				return jdbcTemplate.queryForObject(SELECTONE_CHECK, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class), args);								
			}
			else {
				Object[] args = { mDTO.getMid(), mDTO.getMpw() };
				return jdbcTemplate.queryForObject(SELECTONE, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class), args);				
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	public boolean insert(MemberDTO mDTO) {
		Object[] args = { mDTO.getMid(), mDTO.getMpw() };
		int result = jdbcTemplate.update(INSERT, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean update(MemberDTO mDTO) {
		Object[] args = { mDTO.getMpw(), mDTO.getMid() };
		int result = jdbcTemplate.update(UPDATE, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean delete(MemberDTO mDTO) {
		Object[] args = { mDTO.getMid() };
		int result = jdbcTemplate.update(DELETE, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
}
