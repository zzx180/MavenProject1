package com.zzx.dao;

import com.zzx.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zzx
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
