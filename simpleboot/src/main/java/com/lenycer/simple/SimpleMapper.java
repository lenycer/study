package com.lenycer.simple;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SimpleMapper {

	@Select("SELECT id, name FROM simple WHERE id = #{id}")
	public Simple selectSimple(@Param("id") int id);
	
	@Insert("insert into simple (id, name) values (#{id}, #{name})")
	public int insertSimple(Simple simple);
}
