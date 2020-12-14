package com.elsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.elsys.common.utils.StaticVO;


public class DBConn extends Exception {


      private static final long serialVersionUID = 1L;
      private Connection con;

      static StaticVO staticVO = new StaticVO();

      public DBConn()   {}

      public Connection getConnection(StaticVO stVO){

            staticVO = stVO;

            if(staticVO.getDbId() == null){
                  return null;
            }

            try{
                  Class.forName(staticVO.getDriverClassName());
                  con = DriverManager.getConnection(staticVO.getDbUrl(), staticVO.getDbId(), staticVO.getDbPwd());
                  con.setAutoCommit(true);
                  if ( con == null){
                        return null;
                  }
            }     catch(Exception e){     System.out.println(e);        }

            return con;
      }


      public void close(ResultSet rs, PreparedStatement pstmt, Connection con){
            try{
                  if(rs != null) {
                        rs.close();
                        rs = null;
                  }
                  if(pstmt != null) {
                        pstmt.close();
                        pstmt = null;
                  }
                  if(con      != null) {
                        con.close();
                        con = null;
                  }
            }catch(Exception e){}
      }


}