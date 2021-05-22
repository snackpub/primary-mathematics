package com.snackpub.core.jframe;

import com.snackpub.core.constant.SystemConstant;
import com.snackpub.core.mapper.MathMapper;
import com.snackpub.core.moduel.User;
import com.snackpub.core.util.*;
import com.sun.xml.internal.ws.spi.db.FieldSetter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * 答题窗口
 *
 * @author snackpub
 * @date 2021/5/3
 */
public class AnswerFrame extends JFrame {

    private static long count = 0;

    void showFrame(LinkedList<String> topics, String level, int size) {
        this.setTitle("计算");
        JPanel jPanelCenter = new JPanel();
        this.add(jPanelCenter, BorderLayout.CENTER);
        // 运算数1
        JTextField jTextField = new JTextField();
        jTextField.setColumns(5);
        jTextField.setPreferredSize(new Dimension(15, 30));
        jTextField.setEditable(false);
        jPanelCenter.add(jTextField);
        // 操作符
        JButton oper = new JButton();
        oper.setEnabled(false);
        jPanelCenter.add(oper);
        // 运算数2
        JTextField jTextField2 = new JTextField(StringPool.EMPTY);
        jTextField2.setPreferredSize(new Dimension(15, 30));
        jTextField2.setColumns(5);
        jTextField2.setEditable(false);
        jPanelCenter.add(jTextField2);
        // equals
        JButton equalsBut = new JButton(StringPool.EQ);
        equalsBut.setEnabled(false);
        jPanelCenter.add(equalsBut);
        // 值
        JTextField textValue = new JTextField();
        textValue.setPreferredSize(new Dimension(15, 30));
        textValue.setColumns(5);
        jPanelCenter.add(textValue);


        // bottom
        JPanel bottomJPanel = new JPanel();
        this.add(bottomJPanel, BorderLayout.SOUTH);
        JButton previousButton = new JButton("上一题");
        JButton nextButton = new JButton("下一题");
        bottomJPanel.add(previousButton);
        bottomJPanel.add(nextButton);


        //设置窗口尺寸
        this.setSize(600, 150);
        // 设置窗口显示的位置
        this.setLocation(300, 200);
        // 设置此窗口是否始终高于其他窗口。
        this.setAlwaysOnTop(false);
        //设置窗体可见
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //使窗口居中对齐
        this.setLocationRelativeTo(null);
        // //禁止窗口最大化
        this.setResizable(false);


        ListIterator<String> iterator = topics.listIterator();
        // 初始化第一题
        // pollFirst 检索并移除首个，item为null时返回null
        // peekFirst 检索但不移除，item为null时返回null
        // String first = topics.peekFirst();
        String firstItem = "";
        if (iterator.hasNext()) {
            firstItem = iterator.next();
            String[] str = firstItem.split(StringPool.COMMA);
            jTextField.setText(str[0]);
            oper.setText(str[1]);
            jTextField2.setText(str[2]);
        }
        String tempvar = firstItem;
        nextButton.addActionListener(e -> {
            // 获取用户输入的值
            String inputV = textValue.getText();
            if (!Func.isNotBlank(inputV)) {
                JOptionPane.showMessageDialog(null, "请输入运算值！", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String replaceItem;
            String[] ops = new String[0];
            if (count == 0) { // the first time
                replaceItem = tempvar + StringPool.COMMA + inputV;
                topics.set((int) count, replaceItem); // replace
                ops = topics.get((int) ++count).split(StringPool.COMMA);
            }
            if (count > 0 && count < topics.size() && ops.length == 0) {
                // 将上一题的数据进行替换
                String preItem = topics.get((int) count);
                replaceItem = preItem + StringPool.COMMA + inputV;
                topics.set((int) count, replaceItem);
                // current item
                if (++count >= topics.size()) {
                    // 将用户完成的题目进行保存
                    Connection conn = JDBCUtil.getConn();
                    JDBCUtil.beginTransaction(conn);
                    PreparedStatement ps = null;
                    User user = MyFrame1.getUser();
                    String sql = "insert into practice_log(level,count,user_id,create_time,lsh) values(?,?,?,?,?)";
                    String uuid = UUIDUtil.getUUID();
                    try {
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, level);
                        ps.setInt(2, size);
                        ps.setInt(3, user.getId());
                        ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                        ps.setString(5, uuid);
                        int i = ps.executeUpdate();
                        if (i == 0) throw new RuntimeException();
                    } catch (SQLException ex) {
                        JDBCUtil.rollBackTransaction(conn);
                        ex.printStackTrace();
                    }
                    try {
                        String updateSql = "update math_problems t  SET t.cur_flag = ? where  t.create_user = ? ";
                        ps = conn.prepareStatement(updateSql);
                        ps.setString(1, SystemConstant.OLD_FLAG);
                        ps.setString(2, user.getLsh());
                        int i1 = ps.executeUpdate();
                        for (String item : topics) {
                            String[] s = item.split(StringPool.COMMA);
                            String sql2 = "insert into math_problems(operand1,operand2,system_value,user_value,op,pra_log_lsh,create_time,create_user,cur_flag,level) values(?,?,?,?,?,?,?,?,?,?)";
                            ps = conn.prepareStatement(sql2);
                            ps.setInt(1, Integer.parseInt(s[0]));
                            ps.setInt(2, Integer.parseInt(s[2]));
                            ps.setFloat(3, Float.parseFloat(s[3]));
                            ps.setFloat(4, Float.parseFloat(s[4]));
                            ps.setString(5, s[1]);
                            ps.setString(6, uuid);
                            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                            ps.setString(8, user.getLsh());
                            ps.setString(9, SystemConstant.CURRENT_FLAG);
                            ps.setString(10, level);
                            int i = ps.executeUpdate();
                            if (i == 0) throw new RuntimeException("保存练习题失败！");
                        }
                        JDBCUtil.commitTransaction(conn);
                        Printll.prlnMsg("题目保存成功！");

                        MathMapper mapper = new MathMapper();
                        Vector allT = mapper.currentGetAll();
                        int count = 0;

                        pager.setCurentPageIndex(1);
                        pager.setCountPerpage(10);
                        pager.setBigList(allT);
                        pager.getRecordCount();//得到总条数
                        pager.getSmallList();//得到小的集合(分页的当前页的记录)

                        QueryFrame queryFrame = new QueryFrame();
                        queryFrame.showQueryFrame(pager.getSmallList());


                    } catch (SQLException ex) {
                        JDBCUtil.rollBackTransaction(conn);
                        ex.printStackTrace();
                        Printll.prlnMsg("题目保存失败！");
                    } finally {
                        JDBCUtil.closeConn(conn, ps, null);
                    }
                    return;
                }
                ops = topics.get((int) count).split(StringPool.COMMA);
            }
            if (ops.length > 0) {
                textValue.setText(StringPool.EMPTY);
                jTextField.setText(ops[0]);
                oper.setText(ops[1]);
                jTextField2.setText(ops[2]);
            }
        });
        previousButton.addActionListener(e -> {
            if (count > 0) {
                count--;
                String[] preArr = topics.get((int) count).split(StringPool.COMMA);
                if (preArr.length == 5)
                    textValue.setText(preArr[4]); // This value of the input
                jTextField.setText(preArr[0]);
                oper.setText(preArr[1]);
                jTextField2.setText(preArr[2]);
            } else
                System.out.println("none item...");
        });
    }

    private static final Pager<Object> pager = new Pager<>();

    class QueryFrame extends JFrame {
        void showQueryFrame(Vector data) {
            this.setTitle("成绩展示");
            this.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            JButton first = new JButton("首页");
            JButton pre = new JButton("上一页");
            JButton next = new JButton("下一页");
            JButton last = new JButton("末页");
            JLabel label = new JLabel();
            panel.add(first);
            panel.add(pre);
            panel.add(next);
            panel.add(last);
            panel.add(new JLabel());
            panel.add(new JLabel());
            panel.add(label);
            this.add(panel, BorderLayout.NORTH);
            // 表头（列名）
            Vector<String> columnNames = new Vector<>();
            columnNames.add("运算数1");
            columnNames.add("运算符");
            columnNames.add("运算数2");
            columnNames.add("用户值");
            columnNames.add("正确值");
            columnNames.add("是否正确");
            columnNames.add("当前练习");

            DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);


            JPanel panelBody = new JPanel();
            panelBody.setLayout(new BorderLayout());
            // 创建一个表格，指定 所有行数据 和 表头
            JTable table = new JTable(defaultTableModel);
            JTableHeader tableHeader = table.getTableHeader();
            // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
            panelBody.add(table.getTableHeader(), BorderLayout.NORTH);
            panelBody.add(table, BorderLayout.CENTER);
            this.add(panelBody, BorderLayout.CENTER);
           /* this.add(table.getTableHeader(), BorderLayout.CENTER);
            // 把 表格内容 添加到容器中心
            this.add(table, BorderLayout.SOUTH);*/

            // 设置窗口显示的位置
            this.setLocation(300, 200);
            this.setBounds(300, 200, 800, 600);
            this.setVisible(true);
            this.setAlwaysOnTop(false);
            //使窗口居中对齐
            this.setLocationRelativeTo(null);
            // The hide-window default window close operation
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

//            QueryFrame queryFrame = new QueryFrame();
            first.addActionListener(e -> {
                MathMapper mapper = new MathMapper();
                Vector allT = mapper.getAll();
                pager.setCurentPageIndex(1);
                pager.setCountPerpage(10);
                pager.setBigList(allT);
                pager.getRecordCount();//得到总条数
                pager.getSmallList();//得到小的集合(分页的当前页的记录)
                defaultTableModel.setRowCount(0);// 清除原有行
                defaultTableModel.setDataVector(pager.getSmallList(), columnNames);
            });
            pre.addActionListener(e -> {
                MathMapper mapper = new MathMapper();
                Vector allT = mapper.getAll();
                pager.setCurentPageIndex(pager.getPrePageIndex());
                pager.setBigList(allT);
                defaultTableModel.setRowCount(0);// 清除原有行
                defaultTableModel.setDataVector(pager.getSmallList(), columnNames);
            });
            next.addActionListener(e -> {
                MathMapper mapper = new MathMapper();
                Vector allT = mapper.getAll();
                pager.setCurentPageIndex(pager.getCurrentPageIndex() + 1);
                pager.setBigList(allT);
                defaultTableModel.setRowCount(0);// 清除原有行
                defaultTableModel.setDataVector(pager.getSmallList(), columnNames);
            });
            last.addActionListener(e -> {
                MathMapper mapper = new MathMapper();
                Vector allT = mapper.getAll();
                pager.setCurentPageIndex(pager.getNextPageIndex());
                pager.setBigList(allT);
                defaultTableModel.setRowCount(0);// 清除原有行
                defaultTableModel.setDataVector(pager.getSmallList(), columnNames);
            });

        }
    }

}
