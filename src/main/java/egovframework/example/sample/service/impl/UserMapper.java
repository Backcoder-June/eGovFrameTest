package egovframework.example.sample.service.impl;

import egovframework.example.sample.service.entities.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {

    public UserVO getUserById(String userName);

}