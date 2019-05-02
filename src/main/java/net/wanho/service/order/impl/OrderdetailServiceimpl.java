package net.wanho.service.order.impl;

import net.wanho.mapper.OrderdetailMapper;
import net.wanho.pojo.Orderdetail;
import net.wanho.service.order.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderdetailServiceimpl implements OrderdetailService {


    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public int deleteByPrimaryKey(Long tid) {
        return orderdetailMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Orderdetail record) {
        return orderdetailMapper.insert(record);
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return orderdetailMapper.insertSelective(record);
    }

    @Override
    public Orderdetail selectByPrimaryKey(Long tid) {
        return orderdetailMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetail record) {
        return orderdetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderdetail record) {
        return orderdetailMapper.updateByPrimaryKey(record);
    }
}
