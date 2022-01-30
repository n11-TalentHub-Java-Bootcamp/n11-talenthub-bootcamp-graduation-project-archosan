package com.cihanozmen.creaditApp.n11creditApp.service;

import com.cihanozmen.creaditApp.n11creditApp.converter.UserMapper;
import com.cihanozmen.creaditApp.n11creditApp.dao.UserDao;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditResponseDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserSaveRequestDto;
import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final CreditService creditService;


    public UserCreditResponseDto save(UserSaveRequestDto userSaveRequestDto) {

        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user = creditService.setUserCreditScore(user);
        creditService.loanAmountCalculate(user);
        User save = userDao.save(user);



        UserCreditResponseDto userCreditResponseDto = UserMapper.INSTANCE.convertToCreditResponseDto(save);

        return userCreditResponseDto;
    }

    public List<UserDto> findAll() {

        List<User> all = userDao.findAll();
        List<UserDto> userDtos = UserMapper.INSTANCE.convertToUserDtoList(all);
        return userDtos;

    }

    public UserDto update(Long id, UserSaveRequestDto userSaveRequestDto) {
        User userById = findUserById(id);
        userById.setName(userSaveRequestDto.getName());
        userById.setIdentityNumber(userSaveRequestDto.getIdentityNumber());
        userById.setIncome(userSaveRequestDto.getIncome());
        userById.setPhone(userSaveRequestDto.getPhone());
        userById.setBirthDate(userSaveRequestDto.getBirthDate());
        userById.setGuarantee(userSaveRequestDto.getGuarantee());
        userById = creditService.setUserCreditScore(userById);
        creditService.loanAmountCalculate(userById);
        User save = userDao.save(userById);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(save);
        return userDto;
    }

    private User findUserById(Long id) {
        Optional<User> optionalUser = userDao.findById(id);
        User user;
        if(optionalUser.isPresent()){
             user = optionalUser.get();
             return user;
        }else {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
    }

    public User getCreditInfo(Long identifyNumber, LocalDate birtdate) {
        User creditInfo = userDao.getCreditInfo(identifyNumber, birtdate);
        return creditInfo;
    }
}
