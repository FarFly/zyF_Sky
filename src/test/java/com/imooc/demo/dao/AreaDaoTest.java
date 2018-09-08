package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    AreaDao dao;
    @Test
    public void queryArea() throws Exception {
        List<Area> areaList = dao.queryArea();
        for(Area area : areaList){
            System.out.println(area.getAreaName());
        }
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = dao.queryAreaById(1);
        System.out.println(area.getAreaName());
    }

    @Test
    public void insertArea() throws Exception {
        dao.insertArea(new Area("楠苑", 3, new Date(), new Date()));
        List<Area> areaList = dao.queryArea();
        for(Area area : areaList){
            System.out.println(area.getAreaName());
        }
        assertEquals(3, areaList.size());
    }

    @Test
    public void updateArea() throws Exception {
        Area a = new Area("南苑", 5, new Date(), new Date());
        a.setAreaId(3);
        dao.updateArea(a);
        List<Area> areaList = dao.queryArea();
        for(Area area : areaList){
            System.out.println(area.getAreaName());
        }
        assertEquals(3, areaList.size());
    }

    @Test
    public void deleteArea() throws Exception {
        dao.deleteArea(3);
    }

}