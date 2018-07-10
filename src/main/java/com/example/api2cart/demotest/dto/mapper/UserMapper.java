package com.example.api2cart.demotest.dto.mapper;

import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
    List<User> toEntity(List<UserDTO> dtoList);
    List<UserDTO> toDto(List<User> entityList);
}
