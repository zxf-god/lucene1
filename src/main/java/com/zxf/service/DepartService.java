package com.zxf.service;

import com.zxf.entity.Depart;

import java.util.List;

public interface DepartService {
    public List<Depart> select();
    public void add(Depart depart);
    public void delete();
    public void update(Depart depart);
}
