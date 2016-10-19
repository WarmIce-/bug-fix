package com.springapp.mvc.DAO.serviceImp;

import com.springapp.mvc.DAO.service.UserService;
import com.springapp.mvc.models.UserBean;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserServiceImp extends JdbcTemplate implements UserService {


    private JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }


    @Override
    public boolean insert(UserBean userBean) {
        String sql = "INSERT INTO `userbean`(`userId`,`password`) VALUES(?,?)";
        String userId=userBean.getUserId();
        String password=userBean.getPassword();
        Object[]args={userId,password};
        int rowCount = getJdbcTemplate().update(sql, args);

//        if row insertion is success: rowCount = 1
        boolean isInsertionSuccess = rowCount > 0;

        return isInsertionSuccess;


        /*
        *
        * these three lines could be written as :
        *
        *
        * return getJdbcTemplate().update(sql, args)>0; // this returns boolean value.
        *
        * */

    }

    @Override
    public boolean user(UserBean userBean) {
        boolean userExist=false;
        String sql="SELECT count(*) FROM `userbean` WHERE `userId`=? And `password`=?";
        String userId=userBean.getUserId();
        String password=userBean.getPassword();
        Object[]args={userId,password};
       int rowCount= getJdbcTemplate().queryForObject(sql,args,Integer.class);
        if(rowCount == 1)
        {
            userExist=true;
        }
        return userExist;


        /*
        * No need to write this much code here. You can do as:
        *
        *
        * getJdbcTemplate().queryForObject(sql,args,Integer.class)>0;
        *
        * */
    }

}

