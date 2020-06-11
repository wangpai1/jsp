package Service;

import DAL.SqlHelper;
import Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSerivce {
    public boolean VerifyLogin(User user){
        String sql="select * from Tlogin where UName='"+user.getUName()+"' and UPwd='"+user.getUPwd()+"'";
        ResultSet rs= SqlHelper.executeQuery(sql);
        try {
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
