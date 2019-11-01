package com.chenyx.ssm.dao;

import com.chenyx.ssm.domain.Orders;
import com.chenyx.ssm.domain.Product;
import com.chenyx.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.Member;
import java.util.List;

public interface IOrderDao {
    @Select("select * from orders")
    public List<Orders> findAll() throws Exception;
    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column ="orderNum"),
            @Result(property = "orderTimeStr", column = "orderTime"),
            @Result(property = "orderStatus" ,column ="orderStatus"),
            @Result(property = "peopleCount", column ="peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column ="orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select ="com.chenyx.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class, one = @One (select = "com.chenyx.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column ="id", javaType =java.util.List.class, many = @Many(select = "com.chenyx.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId) throws Exception;


    public void save(Role role);
}
