package com.export.service;

import com.export.dao.CompanyDao;
import com.export.domain.Company;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    // PageInfo等同于我们自定义的pageBean 并且比pageBean更完善
    public PageInfo<Company> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);  //使用分页插件 一定要紧跟一个查询方法
        List<Company> list = companyDao.findAll(); //表面上是查询所有，但是执行时已经分页了
        return new PageInfo<Company>(list,5);
    }

    public void save(Company company) {
        companyDao.save(company);
    }

    public Company getById(String id) {
        return companyDao.getById(id);
    }

    public void update(Company company) {
        companyDao.update(company);
    }

    public void delete(String[] id) {
        companyDao.delete(id);
    }
}
