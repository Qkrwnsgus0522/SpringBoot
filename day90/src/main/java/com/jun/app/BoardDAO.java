package com.jun.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate; // 의존관계(멤버변수)
	
	// 응집도를 높여줌
	// 상수화 선언 시 대문자로 작성
	private final String SELECTALL = "SELECT * FROM BOARD";
	
	private final String SELECTONE = "SELECT * FROM BOARD WHERE BID = ?";

	private final String INSERT = "INSERT INTO BOARD (MID, CONTENT) VALUES (?, ?)";
	
	private final String UPDATE = "UPDATE BOARD SET CONTENT = ? WHERE BID = ?";
	
	private final String DELETE = "DELETE FROM BOARD WHERE BID = ?";

	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	public BoardDTO selectOne(BoardDTO bDTO) {
		try {
			Object[] args = { bDTO.getBid() };
			return jdbcTemplate.queryForObject(SELECTONE, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class), args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	public boolean insert(BoardDTO bDTO) {
		Object[] args = { bDTO.getMid(), bDTO.getContent() };
		int result = jdbcTemplate.update(INSERT, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean update(BoardDTO bDTO) {
		Object[] args = { bDTO.getContent(), bDTO.getBid() };
		int result = jdbcTemplate.update(UPDATE, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean delete(BoardDTO bDTO) {
		Object[] args = { bDTO.getBid() };
		int result = jdbcTemplate.update(DELETE, args);

		if(result <= 0) {
			return false;
		}
		return true;
	}
	
}
