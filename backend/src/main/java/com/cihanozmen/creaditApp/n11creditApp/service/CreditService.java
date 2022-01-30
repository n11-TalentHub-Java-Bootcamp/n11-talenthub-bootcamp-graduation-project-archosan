package com.cihanozmen.creaditApp.n11creditApp.service;

import com.cihanozmen.creaditApp.n11creditApp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    public User setUserCreditScore(User user) {
        int lastNumber =(int) (user.getIdentityNumber() % 10);
        user.setCreditScore(findCreditScore(lastNumber));

        return user;

    }

    public void loanAmountCalculate(User user){
        if(user.getCreditScore() <= 500){
            user.setCreditStatus(false);
        }else if((user.getCreditScore() >= 500 && user.getCreditScore() <= 1000) && user.getIncome() <= 5000 ){
            user.setCreditStatus(true);
            user.setAmountCredit(10000);
            if(user.getGuarantee() != null){
                int number = 10000;
                number += (user.getGuarantee()*10)/100;
                user.setAmountCredit(number);
            }
        }else if((user.getCreditScore() >= 500 && user.getCreditScore() <= 1000) && user.getIncome() >= 5000 && user.getIncome() <= 10000 ){
            user.setCreditStatus(true);
            user.setAmountCredit(20000);
            if(user.getGuarantee() !=null){
                int number = 20000;
                number += (user.getGuarantee()*20)/100;
                user.setAmountCredit(number);
            }
        }else if((user.getCreditScore() >= 500 && user.getCreditScore() <=1000) && user.getIncome() >= 10000){
            user.setCreditStatus(true);
            user.setAmountCredit((int)(user.getIncome() * (4 / 2)));
            if(user.getGuarantee() != null){
                int number = (int)(user.getIncome() * (4 / 2));
                number += (user.getGuarantee() * 25)/100;
                user.setAmountCredit(number);
            }
        }else if(user.getCreditScore() >= 1000){
            user.setCreditStatus(true);
            user.setAmountCredit((int)( user.getIncome() * 4));
            if(user.getGuarantee() != null){
                int number = (int)(user.getIncome() * 4);
                number += (user.getGuarantee() * 50)/100;
                user.setAmountCredit(number);
            }
        }
    }

    public int findCreditScore(int lastNumber){
        switch (lastNumber){
            case 0:
                return 1200;
            case 1:
                return 800;
            case 2:
                return 600;
            case 3:
                return 300;
            case 4:
                return 400;
            case 5:
                return 500;
            case 6:
                return 100;
            case 7:
                return 700;
            case 8:
                return 1500;
            case 9:
                return 900;
        }
        return 100;
    }
}
