package com.lening.companiesregistry.service;

import com.github.pagehelper.PageInfo;
import com.lening.companiesregistry.entity.CompanyBean;

import java.util.List;

public interface CompanyService {
    List<CompanyBean> findAll();



    PageInfo<CompanyBean> findAllConnAndPage(Integer pageNum, Integer pageSize);

    void deleteBatch(Integer[] id);

    void saveOrUpdate(CompanyBean companyBean);
}
