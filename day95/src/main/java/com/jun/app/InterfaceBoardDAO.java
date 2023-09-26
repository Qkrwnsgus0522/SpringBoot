package com.jun.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterfaceBoardDAO {
	public List<BoardDTO> selectAll(BoardDTO bDTO);
	public BoardDTO selectOne(int bid); // #{param1}
	public boolean insert(Map<String, Object> map);
	public boolean update(Map<String, Object> map);
	public boolean delete(@Param("BID")int bid); // #{BID}
}
