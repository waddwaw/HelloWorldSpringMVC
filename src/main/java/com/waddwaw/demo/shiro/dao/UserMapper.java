package com.waddwaw.demo.shiro.dao;

import com.waddwaw.demo.shiro.model.User;
import com.waddwaw.demo.shiro.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.terracotta.offheapstore.paging.Page;

import java.util.List;


/**
 * 用户Dao接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:49:57
 **/
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录验证查询
     * 
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     * 
     * @param page
     * @param example
     * @return
     */
    List<User> selectByExampleAndPage(Page page, UserExample example);
}