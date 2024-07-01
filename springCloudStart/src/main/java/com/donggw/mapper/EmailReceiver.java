package com.donggw.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmailReceiver {
	List<com.donggw.entity.EmailReceiver> findAll();

	List<com.donggw.entity.EmailReceiver> selectEmail(com.donggw.entity.EmailReceiver emailReceiver);

}
