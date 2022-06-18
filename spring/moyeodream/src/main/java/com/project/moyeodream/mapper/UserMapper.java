package com.project.moyeodream.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface UserMapper {
//    SQL이 복잡하거나 길어지는 경우에는 어노테이션보다 XML방식을 더 선호하게 된다.
//    @Select("SELECT SYSDATE FROM DUAL")
    public String getTime();
}
