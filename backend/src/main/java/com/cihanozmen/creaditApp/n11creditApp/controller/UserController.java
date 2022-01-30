package com.cihanozmen.creaditApp.n11creditApp.controller;

import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditRequestDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserCreditResponseDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserDto;
import com.cihanozmen.creaditApp.n11creditApp.dto.UserSaveRequestDto;
import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import com.cihanozmen.creaditApp.n11creditApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping
   public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto){

        UserCreditResponseDto save = userService.save(userSaveRequestDto);
        return ResponseEntity.ok(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<UserDto> userDtoList = userService.findAll();

        return ResponseEntity.ok(userDtoList);
    }
    @GetMapping("/getCreditInfo")
    public ResponseEntity getCreditInfo(@RequestParam Long identifyNumber, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birtdate){
        User creditInfo = userService.getCreditInfo(identifyNumber, birtdate);
        return ResponseEntity.ok(creditInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserSaveRequestDto userSaveRequestDto){
        UserDto update = userService.update(id, userSaveRequestDto);

        return ResponseEntity.ok(update);
    }


}
