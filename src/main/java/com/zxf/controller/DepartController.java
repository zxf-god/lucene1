package com.zxf.controller;

import com.zxf.dao.DepartDAO;
import com.zxf.entity.Depart;
import com.zxf.service.DepartService;
import com.zxf.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("depart")
public class DepartController {
    @Resource
    private DepartService departService;
    @Resource
    private LuceneService luceneService;
    @RequestMapping("select")
    public String select(){
        List<Depart> departs = departService.select();
        for (Depart dep:departs) {
            System.out.println(dep);
        }
        return "index";
    }
    @RequestMapping("add")
    public String add(Depart depart){
        departService.add(depart);
        luceneService.add(depart);
           return "index";
    }
    @RequestMapping("seacher")
    @ResponseBody
    public List<Depart> seacher(String name){
        List<Depart> departs = luceneService.select(name);
        return departs;
    }
}
