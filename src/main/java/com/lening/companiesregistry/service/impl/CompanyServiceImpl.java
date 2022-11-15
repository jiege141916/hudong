package com.lening.companiesregistry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.companiesregistry.entity.CompanyBean;
import com.lening.companiesregistry.mapper.CompanyMapper;
import com.lening.companiesregistry.service.CompanyService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
   @Resource
   private CompanyMapper companyMapper;


    @Override
    public List<CompanyBean> findAll() {
        return companyMapper.selectAll();
    }

    @Override
    public void deleteBatch(Integer[] id) {
        if (id != null && id.length >= 1) {
            for (Integer gid : id) {
                companyMapper.deleteByPrimaryKey(gid);
            }
        }
    }

    @Override
    public void saveOrUpdate(CompanyBean companyBean) {
        if (companyBean!=null){
            if (companyBean.getId() == null){
                companyMapper.updateByPrimaryKeySelective(companyBean);
            }else {
                companyMapper.insertSelective(companyBean);
            }
        }
    }

    @Override
    public PageInfo<CompanyBean> findAllConnAndPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(CompanyBean.class);
        Example.Criteria criteria = example.createCriteria();
        List<CompanyBean> list = companyMapper.selectByExample(example);
        PageInfo<CompanyBean> pageInfo = new PageInfo<CompanyBean>(list);
        return pageInfo;
    }
}
