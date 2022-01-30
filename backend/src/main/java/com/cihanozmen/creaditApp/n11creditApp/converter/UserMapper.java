package com.cihanozmen.creaditApp.n11creditApp.converter;

import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditResponseDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserSaveRequestDto;
import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);

    UserDto convertToUserDto(User user);

    List<UserDto> convertToUserDtoList(List<User> userList);

    UserCreditResponseDto convertToCreditResponseDto(User user);
}
