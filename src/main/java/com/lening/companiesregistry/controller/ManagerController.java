package com.lening.companiesregistry.controller;

import com.github.pagehelper.PageInfo;
import com.lening.companiesregistry.entity.CompanyBean;
import com.lening.companiesregistry.service.CompanyService;
import com.lening.companiesregistry.utile.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/man")
public class ManagerController {
    @Resource
    private CompanyService companyService;


    @RequestMapping("/getLogin")
    public ResultInfo getLogin(){
        return new ResultInfo(true, "ok");
    }

    @RequestMapping("/findAll")
    public List<CompanyBean> findAll(){
        return companyService.findAll();
    }

    @RequestMapping("/findAllConnAndPage")
    public PageInfo<CompanyBean> findAllConnAndPage(
                                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "1") Integer pageSize) {
        return companyService.findAllConnAndPage(pageNum, pageSize);
    }

    /**
     * 批量删除
     */
    @RequestMapping("/deleteBatch")
    public ResultInfo deleteBatch(@RequestBody Integer[] id) {
        try {
            companyService.deleteBatch(id);
            return new ResultInfo(true, "删除成功");
        } catch (Exception e) {
            return new ResultInfo(false, "删除失败");
        }
    }

    //新增
    @RequestMapping("/saveOrUpdate")
    public ResultInfo saveOrUpdateGoods(@RequestBody CompanyBean CompanyBean) {
        try {
            companyService.saveOrUpdate(CompanyBean);
            return new ResultInfo(true, "编辑成功");
        } catch (Exception e) {
            return new ResultInfo(false, "编辑失败");
        }
    }

}
