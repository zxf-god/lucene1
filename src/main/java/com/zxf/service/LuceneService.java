package com.zxf.service;

import com.zxf.entity.Depart;

import java.util.List;

public interface LuceneService {
    public List<Depart> select(String name);
    public void add(Depart depart);
    public void delete();
    public void update(Depart depart);
}
