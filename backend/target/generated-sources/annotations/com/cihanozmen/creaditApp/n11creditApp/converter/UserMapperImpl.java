package com.cihanozmen.creaditApp.n11creditApp.converter;

import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditResponseDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserSaveRequestDto;
import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-29T11:07:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(UserSaveRequestDto userSaveRequestDto) {
        if ( userSaveRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userSaveRequestDto.getName() );
        user.setIdentityNumber( userSaveRequestDto.getIdentityNumber() );
        user.setIncome( userSaveRequestDto.getIncome() );
        user.setPhone( userSaveRequestDto.getPhone() );
        user.setBirthDate( userSaveRequestDto.getBirthDate() );
        user.setGuarantee( userSaveRequestDto.getGuarantee() );

        return user;
    }

    @Override
    public UserDto convertToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setIdentityNumber( user.getIdentityNumber() );
        userDto.setIncome( user.getIncome() );
        userDto.setPhone( user.getPhone() );
        userDto.setBirthDate( user.getBirthDate() );
        userDto.setGuarantee( user.getGuarantee() );
        userDto.setCreditScore( user.getCreditScore() );

        return userDto;
    }

    @Override
    public List<UserDto> convertToUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( convertToUserDto( user ) );
        }

        return list;
    }

    @Override
    public UserCreditResponseDto convertToCreditResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserCreditResponseDto userCreditResponseDto = new UserCreditResponseDto();

        userCreditResponseDto.setCreditStatus( user.getCreditStatus() );
        userCreditResponseDto.setAmountCredit( user.getAmountCredit() );

        return userCreditResponseDto;
    }
}
