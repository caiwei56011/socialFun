package com.kmust.social.service.impl;

import com.kmust.social.function.Application;
import com.kmust.social.service.SocialFunService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * SocialFunServiceImpl
 *
 * @author Cai Wei
 * @date 2017/1/10
 */
@Service
public class SocialFunServiceImpl implements SocialFunService,Serializable {

    @Override
    public Boolean onlineProductsEvaluation(List<List<Object>> excelLists) {

        return false;
    }

    @Override
    public String onlineProductsEvaluation(File dataFile,String newFileNameLength) {

        Application app = new Application();
        String isSuccess = app.doSchulze(dataFile,newFileNameLength);

        return isSuccess;
    }

}
