package com.kmust.social.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * SocialFunService
 *
 * @author Cai Wei
 * @date 2017/1/10
 */

public interface SocialFunService {

    /** 在线商品评价*/
    public Boolean onlineProductsEvaluation(List<List<Object>> excelLists);

    public String onlineProductsEvaluation(File dataFile,String newFileNameLength);

}
