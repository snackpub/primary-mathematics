package com.snackpub.core.mapper;

import com.snackpub.core.constant.SystemConstant;
import com.snackpub.core.exception.ServiceException;
import com.snackpub.core.jframe.MyFrame;
import com.snackpub.core.jframe.MyFrame1;
import com.snackpub.core.moduel.User;
import com.snackpub.core.util.JDBCUtil;
import com.snackpub.core.util.Pager;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Objects;
import java.util.Vector;

/**
 * @author snackpub
 * @date 2021/5/4
 */
public class MathMapper {

    public Vector currentGetAll() {
        Vector list = new Vector();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            User user = MyFrame1.getUser();
            conn = JDBCUtil.getConn();
            String sql2 = "SELECT id,operand1,operand2,system_value,user_value,op,pra_log_lsh,create_time,cur_flag,level FROM math_problems where cur_flag=? and create_user = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, SystemConstant.CURRENT_FLAG);
            ps.setString(2, user.getLsh());
            rs = ps.executeQuery();
            Vector rowData;
            while (rs.next()) {
                rowData = new Vector();
                int id = rs.getInt("id");
                String operand1 = rs.getString("operand1");
                String operand2 = rs.getString("operand2");
                float sysValue = rs.getFloat("system_value");
                float userValue = rs.getFloat("user_value");
                String op = rs.getString("op");
                String praLogLsh = rs.getString("pra_log_lsh");
                Timestamp createTime = rs.getTimestamp("create_time");
                String curFlag = rs.getString("cur_flag");
                String level = rs.getString("level");
                rowData.add(operand1);
                rowData.add(op);
                rowData.add(operand2);
                rowData.add(userValue);
                rowData.add(sysValue);
                rowData.add(sysValue == userValue ? "正确" : "错误");
                rowData.add(Objects.equals(curFlag, SystemConstant.CURRENT_FLAG) ? "是" : "否");
                rowData.add(level);
                list.add(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "查询失败！", "提示", JOptionPane.ERROR_MESSAGE);
            throw new ServiceException("查询失败", e);
        } finally {
            JDBCUtil.closeConn(conn, ps, rs);
        }
        return list;
    }

    public Vector getAll() {
        Vector list = new Vector();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            User user = MyFrame1.getUser();
            conn = JDBCUtil.getConn();
            String sql2 = "SELECT id,operand1,operand2,system_value,user_value,op,pra_log_lsh,create_time,cur_flag,level FROM math_problems where cur_flag=? and create_user = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, SystemConstant.CURRENT_FLAG);
            ps.setString(2, user.getLsh());
            rs = ps.executeQuery();
            Vector rowData;
            while (rs.next()) {
                rowData = new Vector();
                int id = rs.getInt("id");
                String operand1 = rs.getString("operand1");
                String operand2 = rs.getString("operand2");
                float sysValue = rs.getFloat("system_value");
                float userValue = rs.getFloat("user_value");
                String op = rs.getString("op");
                String praLogLsh = rs.getString("pra_log_lsh");
                Timestamp createTime = rs.getTimestamp("create_time");
                String curFlag = rs.getString("cur_flag");
                String level = rs.getString("level");
                rowData.add(operand1);
                rowData.add(op);
                rowData.add(operand2);
                rowData.add(userValue);
                rowData.add(sysValue);
                rowData.add(sysValue == userValue ? "正确" : "错误");
                rowData.add(Objects.equals(curFlag, SystemConstant.CURRENT_FLAG) ? "是" : "否");
                rowData.add(level);
                list.add(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "查询失败！", "提示", JOptionPane.ERROR_MESSAGE);
            throw new ServiceException("查询失败", e);
        } finally {
            JDBCUtil.closeConn(conn, ps, rs);
        }
        return list;
    }

    public Vector getPage(Pager pager) {
        Vector list = new Vector();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            String sql2 = "SELECT id,operand1,operand2,system_value,user_value,op,pra_log_lsh,create_time FROM math_problems limit ?,?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(pager.getCurrentPageIndex(), 1);
            ps.setInt(pager.getCountPerpage(), 2);
            rs = ps.executeQuery();
            Vector rowData;
            while (rs.next()) {
                rowData = new Vector();
                int id = rs.getInt("id");
                String operand1 = rs.getString("operand1");
                String operand2 = rs.getString("operand2");
                float sysValue = rs.getFloat("system_value");
                float userValue = rs.getFloat("user_value");
                String op = rs.getString("op");
                String praLogLsh = rs.getString("pra_log_lsh");
                Timestamp createTime = rs.getTimestamp("create_time");
                rowData.add(operand1);
                rowData.add(op);
                rowData.add(operand2);
                rowData.add(userValue);
                rowData.add(sysValue);
                list.add(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "查询失败！", "提示", JOptionPane.ERROR_MESSAGE);
            throw new ServiceException("查询失败", e);
        } finally {
            JDBCUtil.closeConn(conn, ps, rs);
        }
        return list;
    }
}
