package com.zxf.service;

import com.zxf.dao.DepartDAO;
import com.zxf.entity.Depart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class DepartServiceImpl implements DepartService {
    @Resource
    private DepartDAO departDAO;
    @Override
    public List<Depart> select() {
        return departDAO.selectAll();
    }

    @Override
    public void add(Depart depart) {
        departDAO.insert(depart);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update(Depart depart) {

    }
}
