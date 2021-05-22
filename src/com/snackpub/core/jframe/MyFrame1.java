package com.snackpub.core.jframe;


import com.snackpub.core.moduel.User;
import com.snackpub.core.util.Func;
import com.snackpub.core.util.JDBCUtil;

import javax.swing.*;
import java.awt.*;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author lyn
 * @date 2021/5/3
 */
public class MyFrame1 extends JFrame {

    static final ThreadLocal<User> localVar = new ThreadLocal<>();


    private static final class RandomNumberGeneratorHolder {
        static final Random randomNumberGenerator = new Random();
    }

    public static int random(int bound) {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(bound);
    }

    private static final String[] OPERATORS = {"+", "-", "*", "/"};
    private static final List<String> OPS = new ArrayList<>(Arrays.asList(OPERATORS));
    private static final DecimalFormat DF = new DecimalFormat("0.00");

    public static void main(String[] args) {
        MyFrame1 myFrame = new MyFrame1();
        myFrame.showTime();
    }


    private void showTime() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.showLoginFrame();
    }


    private void showFrame() {
        //创建并设置JFrame容器窗口
        this.setTitle("小学数学<<<一起学吧！");

        this.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        this.add(panel, BorderLayout.NORTH);

        JLabel topicNumLabel = new JLabel("题目数：", JLabel.CENTER);
        panel.add(topicNumLabel);
        JComboBox<String> topicNumbers = new JComboBox<>();//创建一个下拉列表框c1
        topicNumbers.addItem("10");
        topicNumbers.addItem("20");
        topicNumbers.addItem("30");
        panel.add(topicNumbers);
        panel.add(new Label());

        JLabel levelLabel = new JLabel("难度：", JLabel.CENTER);
        panel.add(levelLabel);
        JComboBox<String> levels = new JComboBox<>();//创建一个下拉列表框c1
        levels.addItem("初级");
        levels.addItem("中级");
        levels.addItem("高级");
        panel.add(levels);
        panel.add(new Label());

        JButton generateBtn = new JButton("生成题目");
        panel.add(generateBtn);
        panel.add(new Label());

        JButton percentageCompleteBtn = new JButton("查看题目完成率");
        panel.add(percentageCompleteBtn);

        // 生成题目
        generateBtn.addActionListener(e -> {

            // 获取题目生成数量
            int count = Func.toInteger(topicNumbers.getSelectedItem());
            String level = (String) levels.getSelectedItem();
            LinkedList<String> topics = new LinkedList<>();
            assert level != null;
            switch (level) {
                default:
                case "初级":
                    // 生成题目，将题目保存到题目库
                    IntStream.rangeClosed(1, count).forEach(index -> {
                        int i1 = (int) (Math.random() * 6);
                        int i2 = (int) (Math.random() * 6);
                        if (i1 < i2) {
                            int temp;
                            temp = i1;
                            i1 = i2;
                            i2 = temp;
                        }
                        /*Collections.shuffle(OPS); // 每次生成都重新洗牌*/
                        String op = OPS.get(RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(3));
                        op = recursionOpt(op, OPERATORS[0], OPERATORS[1]);
                        int value;
                        String value2;
                        switch (op) {
                            default:// none
                            case "+":
                                value = Math.addExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "-":
                                value = Math.subtractExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                        }
                        topics.add(value2);
                    });
                    break;
                case "中级":
                    // 生成题目，将题目保存到题目库
                    IntStream.rangeClosed(1, count).forEach(index -> {
                        int i1 = (int) (Math.random() * 31);
                        int i2 = (int) (Math.random() * 31);
//                        Collections.shuffle(OPS); // 每次生成都重新洗牌
                        String op = OPS.get(RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(3));
                        op = recursionOpt2(op, OPERATORS[3]);
                        int value;
                        String value2;
                        switch (op) {
                            default: // none
                            case "+":
                                value = Math.addExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "-":
                                value = Math.subtractExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "*"://30以内的乘法
                                int random = random(10) + 1;
                                int random2 = random(10) + 1;
                                value = Math.multiplyExact(random, random2);
                                value2 = topicStr(random, random2, op, value);
                                break;
                        }
                        topics.add(value2);
                    });
                    break;
                case "高级":
                    // 生成题目，将题目保存到题目库
                    IntStream.rangeClosed(1, count).forEach(index -> {
                        int i1 = (int) (Math.random() * 101) + 1;
                        int i2 = (int) (Math.random() * 101) + 1;
                        Collections.shuffle(OPS); // 每次生成都重新洗牌
                        String op = OPS.get(RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(3));
                        int value;
                        String value2;
                        switch (op) {
                            default: // none
                            case "+":
                                value = Math.addExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "-":
                                value = Math.subtractExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "*":
                                value = Math.multiplyExact(i1, i2);
                                value2 = topicStr(i1, i2, op, value);
                                break;
                            case "/":
                                String v = dfpointTwo((double) i1 / i2);
                                value2 = topicStr(i1, i2, op, v);
                                break;
                        }
                        topics.add(value2);
                    });
                    break;
            }

            System.out.println(topics);
            AnswerFrame myFrame2 = new AnswerFrame();
            myFrame2.showFrame(topics, level, count);
        });


        //设置窗口尺寸
        this.setSize(700, 150);
        // 设置窗口显示的位置
        this.setLocation(300, 200);
        // 设置此窗口是否始终高于其他窗口。
        this.setAlwaysOnTop(false);
        //设置窗体可见
        this.setVisible(true);
        //使用 System exit 方法退出应用程序。
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //使窗口居中对齐
        this.setLocationRelativeTo(null);
        // //禁止窗口最大化
        this.setResizable(false);
    }

    // 登录窗口
    class LoginFrame extends JFrame {
        public void showLoginFrame() {
            JFrame jFrame = new JFrame();
            jFrame.setTitle("李雨凝");
            JLabel userNameLabel = new JLabel("用户名：", JLabel.LEFT);
            userNameLabel.setFont(new Font("粗体", Font.BOLD, 15));
            JTextField userNameText = new JTextField(15);
            userNameText.setPreferredSize(new Dimension(15, 30));

            JLabel pwdLabel = new JLabel("密码:", JLabel.LEFT);
            pwdLabel.setFont(new Font("粗体", Font.BOLD, 15));
            JTextField pwd = new JTextField(15);
            pwd.setPreferredSize(new Dimension(15, 30));

            JButton register = new JButton("登录");
            JButton close = new JButton("清空");


            // 网格布局
            GridLayout gridLayout = new GridLayout(3, 4, 0, 10);
            jFrame.setLayout(gridLayout);

            jFrame.add(new Label());
            jFrame.add(userNameLabel);
            jFrame.add(userNameText);
            jFrame.add(new Label());

            jFrame.add(new Label());
            jFrame.add(pwdLabel);
            jFrame.add(pwd);
            jFrame.add(new Label());

            jFrame.add(new Label());
            jFrame.add(register);
            jFrame.add(close);
            jFrame.add(new Label());

            // 设置窗口显示的位置
            //设置窗口尺寸
            jFrame.setLocation(300, 200);
            jFrame.setBounds(300, 200, 400, 150);
            jFrame.setVisible(true);
            jFrame.setAlwaysOnTop(false);
            //使窗口居中对齐
            jFrame.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            // 初始化init
            userNameText.setText("");
            pwd.setText("");

            register.addActionListener(args -> {
                boolean mark = false;
                String userName = userNameText.getText();
                String password = pwd.getText();
                // 统一转换字母为小写
                String lowerCasePwd = password.toLowerCase();
                Connection conn = JDBCUtil.getConn();
                PreparedStatement ps = null;
                ResultSet rs = null;
                String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
                try {
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, userName);
                    ps.setString(2, password);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        mark = true;
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String password2 = rs.getString("password");
                        String lsh = rs.getString("lsh");
                        User user = new User(id, name, password2, lsh);
                        localVar.set(user);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    JDBCUtil.closeConn(conn, ps, rs);
                }
                if (mark) {
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    showFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误！", "提示", JOptionPane.WARNING_MESSAGE);
                }

            });

            close.addActionListener(args -> {
                userNameText.setText("");
                pwd.setText("");
            });
        }
    }

    /**
     * 判断当前操作符是否是符合当前级别，否则重新生成
     *
     * @param opt     生成的操作符
     * @param curOpt1 当前级别操作符1
     * @param curOpt2 当前级别操作符2
     * @return opt
     */
    public String recursionOpt(String opt, String curOpt1, String curOpt2) {
        if (!Objects.equals(opt, curOpt1) && !Objects.equals(opt, curOpt2)) {
            String newOpt = OPS.get(RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(3));
            opt = recursionOpt(newOpt, curOpt1, curOpt2);
        }
        return opt;
    }

    public String recursionOpt2(String opt, String curOpt1) {
        if (Objects.equals(opt, curOpt1)) {
            String newOpt = OPS.get(RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(3));
            opt = recursionOpt2(newOpt, curOpt1);
        }
        return opt;
    }


    /**
     * 拼接计算题目
     *
     * @param ojb1 运算数1
     * @param ojb2 运算数2
     * @param op   运算符
     * @param val  运算值
     * @return {string}
     */
    public static String topicStr(Object ojb1, Object ojb2, String op, Object val) {
        return ojb1 + "," + op + "," + ojb2 + "," + val;
    }

    /**
     * 该方法不四舍五入
     */
    public DecimalFormat df() {
        DF.setMaximumFractionDigits(2);
        DF.setGroupingSize(0);
        DF.setRoundingMode(RoundingMode.FLOOR);
        return DF;
    }

    //保持2位小数
    private String dfpointTwo(double value) {
        return DF.format(value);
    }


    /**
     * 获取用户信息
     */
    public static User getUser() {
        return localVar.get();
    }
}
