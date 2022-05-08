import javax.swing.*;
import java.awt.*;
import java.lang.String;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Carculator extends JFrame implements ActionListener {

    private JFrame frame;
    private JMenuBar jmenuBar;
    private JMenuItem M_bz, M_rq, M_jz;

    private JTextField input_text = new JTextField();

    private String backText1;//储存删除后的值
    private String backText2;//储存删除后的值
    private String backText3;//储存删除后的值
    private String backText4;//储存删除后的值

    private Color color7 = new Color(0x646363);
    private Color color1 = new Color(181, 181, 181);
    Color color2 = new Color(126, 192, 238);  //等于号专属颜色
    Color color3 = new Color(232, 232, 232);  //背景颜色//功能键和运算符颜色
    Color color4 = new Color(132, 132, 232);//紫色
    Color color5 = new Color(0xF3000001, true);
    Color color6 = new Color(0xCFFFFFFF, true);
    private double c, q, k, jia, jian, cheng, chu, yu = 0;

    //进制计算器——定义
    private JPanel n_panel;
    private JPanel c_panel;

    private String[] buttons = {"A", "B", "7", "8", "9", "+",
            "C", "D", "4", "5", "6", "-",
            "E", "F", "1", "2", "3", "=",
            "(", ")", "c", "0", "<-", "."};
    private JButton jz_button[] = new JButton[buttons.length];
    private JButton HEX, DEC, OCT, BIN;

    private JPanel buttonPanel = new JPanel(); //按钮面板

    private JTextField H_result;   //文本框
    private JTextField D_result;
    private JTextField O_result;
    private JTextField B_result;

    private JTextField n_result;
    private JTextField n_process;//储存运算过程


    public Carculator() throws HeadlessException {

        init();

    }

    public void init() {
        frame = new JFrame();
        frame.setTitle("计算器");
        frame.setSize(500, 700);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        jmenuBar = new JMenuBar();

        //设置主面板
        n_panel = new JPanel();
        n_panel.setPreferredSize(new Dimension(400, 150));
        n_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        c_panel = new JPanel();
        c_panel.setPreferredSize(new Dimension(400, 550));
        c_panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.add(n_panel , BorderLayout.NORTH);
        frame.add(c_panel , BorderLayout.CENTER);

        menu();
        home();
        frame.setJMenuBar(jmenuBar);
        frame.setVisible(true);

    }

    public void menu() {
        //菜单
        JMenu M = new JMenu("菜单");

        //菜单项
        JMenuItem M_j = new JMenuItem("计算器：");
        M_j.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        M_bz = new JMenuItem(" 标准");
        M_bz.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 20));

        JMenuItem M_zh = new JMenuItem("转换器：");
        M_zh.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        M_jz = new JMenuItem(" 进制转换");
        M_jz.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 20));



        //设立监听对象
        M_bz.addActionListener(this);
        M_jz.addActionListener(this);


        //将菜单项加入菜单中
        M.add(M_j);
        M.add(M_bz);
        M.add(M_zh);
        M.add(M_jz);


        jmenuBar.add(M);
    }



    public void home() {
        addNorthComponent();
        addCenterButton();

    }

    //标准——北部控件
    public void addNorthComponent() {

        n_process = new JTextField();
        input_text = new JTextField();

        n_process.setPreferredSize(new Dimension(500, 70));
        n_process.setFont(new Font("黑体", Font.TRUETYPE_FONT, 37));
        n_process.setHorizontalAlignment(JTextField.RIGHT);
        n_process.setBorder(null);//去边框
        n_process.setBackground(null);//去颜色

        input_text.setPreferredSize(new Dimension(500, 70));
        input_text.setFont(new Font("黑体", Font.TRUETYPE_FONT, 37));
        input_text.setHorizontalAlignment(JTextField.RIGHT);
        input_text.setBorder(null);
        input_text.setBackground(null);
        n_panel.add(input_text);//添加文本框
        n_panel.add(n_process);//添加文本框
    }

    //标准——中部控件
    public void addCenterButton() {
        JPanel in_c = new JPanel();
        in_c.setPreferredSize(new Dimension(500 , 485));
        in_c.setBackground(null);
        String btn_text = "C×÷←789+456-123◐%0.=";
        in_c.setLayout(new GridLayout(5, 4));
        for (int i = 1; i <= 20; i++) {
            String temp = btn_text.substring(i - 1, i);
            JButton btn = new JButton();
            btn.setText(temp);
            btn.setFont(new Font("粗体", Font.BOLD, 30));//设置键盘文字大小
            btn.addActionListener(this); //监听器
            in_c.add(btn);
            btn.setContentAreaFilled(false);
        }
        c_panel.add(in_c);
    }

    //进制——面板空件
    public void jz() {

        //声明相关组件

        //北面

        n_process = new JTextField();
        n_result = new JTextField();

        n_process.setPreferredSize(new Dimension(400, 30));
        n_process.setFont(new Font("楷体", Font.TRUETYPE_FONT, 25));
        n_process.setHorizontalAlignment(JTextField.RIGHT);
        //n_process.setBorder(null);
        //n_process.setBackground(null);

        n_result.setPreferredSize(new Dimension(400, 60));
        n_result.setFont(new Font("黑体", Font.BOLD, 40));
        n_result.setHorizontalAlignment(JTextField.RIGHT);
        //n_result.setBorder(null);
        // n_result.setBackground(null);

        n_panel.add(n_process);
        n_panel.add(n_result);

        //中部文本域
        JPanel in_c = new JPanel();
        in_c.setPreferredSize(new Dimension(500, 180));
        in_c.setLayout(new FlowLayout(FlowLayout.LEFT));

        //文本域控件定义

        D_result = new JTextField();
        O_result = new JTextField();
        B_result = new JTextField();
        H_result = new JTextField();

        DEC = new JButton("DEC");
        OCT = new JButton("OCT");
        BIN = new JButton("BIN");
        HEX = new JButton("HEX");
        D_result.setPreferredSize(new Dimension(320, 30));
        H_result.setPreferredSize(new Dimension(320, 30));
        O_result.setPreferredSize(new Dimension(320, 30));
        B_result.setPreferredSize(new Dimension(320, 30));
        //文本域样式定义
        DEC.setFont(new Font("黑体", Font.BOLD, 15));
        OCT.setFont(new Font("黑体", Font.BOLD, 15));
        BIN.setFont(new Font("黑体", Font.BOLD, 15));
        HEX.setFont(new Font("黑体", Font.BOLD, 15));

        DEC.setPreferredSize(new Dimension(100, 30));
        HEX.setPreferredSize(new Dimension(100, 30));
        OCT.setPreferredSize(new Dimension(100, 30));
        BIN.setPreferredSize(new Dimension(100, 30));

        DEC.setHorizontalAlignment(JButton.LEFT);
        HEX.setHorizontalAlignment(JButton.LEFT);
        OCT.setHorizontalAlignment(JButton.LEFT);
        BIN.setHorizontalAlignment(JButton.LEFT);

        DEC.setContentAreaFilled(false);
        HEX.setContentAreaFilled(false);
        OCT.setContentAreaFilled(false);
        BIN.setContentAreaFilled(false);

        D_result.setFont(new Font("黑体", Font.BOLD, 15));
        H_result.setFont(new Font("黑体", Font.BOLD, 15));
        O_result.setFont(new Font("黑体", Font.BOLD, 15));
        B_result.setFont(new Font("黑体", Font.BOLD, 15));

        //中部按钮面板
        JPanel in_s = new JPanel();

        in_s.setLayout(new GridLayout(4, 5));
        in_s.setPreferredSize(new Dimension(500, 300));
        in_s.setBackground(color1);
        for (int i = 0; i < 24; i++) {
            jz_button[i] = new JButton(buttons[i]);
            jz_button[i].setFont(new Font("黑体" , Font.TRUETYPE_FONT , 15));
            in_s.add(jz_button[i]);
        }

        //中部按钮及文本
        in_c.add(HEX);
        in_c.add(H_result);
        in_c.add(DEC);
        in_c.add(D_result);
        in_c.add(OCT);
        in_c.add(O_result);
        in_c.add(BIN);
        in_c.add(B_result);

        c_panel.add(in_c, BorderLayout.NORTH);
        c_panel.add(in_s , BorderLayout.CENTER);

        //添加监听器
        HEX.addActionListener(new HEXHandler());
        DEC.addActionListener(new DECHandler());
        BIN.addActionListener(new BINHandler());
        OCT.addActionListener(new OCTHandler());

        for (int i = 0; i < 24; i++) { //对按钮监听
            jz_button[i].addActionListener(this);
        }
    }

    private int midOf = 2;  //进制

    public class HEXHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 24; i++) {
                jz_button[i].setForeground(color5);
            }
            HEX.setForeground(color1);
            DEC.setForeground(color5);
            OCT.setForeground(color5);
            BIN.setForeground(color5);

            n_result.setText(H_result.getText());

            pd = 16;
            midOf = 1;

        }
    }

    private class DECHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 24; i++) {
                jz_button[i].setForeground(color5);
            }

            for (int i = 0; i < 24; i += 6) {
                jz_button[i].setForeground(color1);
                jz_button[i + 1].setForeground(color1);
            }

            DEC.setForeground(color1);
            OCT.setForeground(color5);
            HEX.setForeground(color5);
            BIN.setForeground(color5);

            n_result.setText(D_result.getText());

            midOf = 2;
            pd = 10;

        }
    }

    private class OCTHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 24; i++) {
                jz_button[i].setForeground(color5);
            }
            for (int i = 0; i < 24; i += 6) {
                jz_button[i].setForeground(color1);
                jz_button[i + 1].setForeground(color1);
            }
            jz_button[3].setForeground(color1);
            jz_button[4].setForeground(color1);


            DEC.setForeground(color5);
            OCT.setForeground(color1);
            HEX.setForeground(color5);
            BIN.setForeground(color5);

            n_result.setText(O_result.getText());
            midOf = 3;
            pd = 8;

        }
    }

    private class BINHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 24; i++) {
                jz_button[i].setForeground(color1);
            }
            for (int i = 5; i < 24; i += 6) {
                jz_button[i].setForeground(color5);
            }
            jz_button[21].setForeground(color5);
            jz_button[14].setForeground(color5);


            DEC.setForeground(color5);
            OCT.setForeground(color5);
            HEX.setForeground(color5);
            BIN.setForeground(color1);

            n_result.setText(B_result.getText());
            midOf = 4;
            pd = 2;
        }
    }

    private String backText;//储存删除后的值


    public void doBackSpace() {

        backText = n_result.getText();
        int i = backText.length();

        if (i > 0) {
            backText = backText.substring(0, i - 1);
            if (backText.length() == 0) {
                n_result.setText("0");
                backText = "0";

            } else {

                n_result.setText(backText);//显示新值
            }
        }

        midStr1 = n_result.getText();
        midStr2 = midStr1;

        H_result.setText(doTransform(midStr1, pd, 16));
        D_result.setText(doTransform(midStr1, pd, 10));
        O_result.setText(doTransform(midStr1, pd, 8));
        B_result.setText(doTransform(midStr1, pd, 2));


    }

    private String midStr1, midStr2;

    public void doGetNumbers(String key) {

        if(cl){
            n_result.setText(null);
            cl = false;
        }

        n_result.setText(n_result.getText() + key);
        switch (midOf) {
            case 2:
                if ("ABCDEF".indexOf(key) >= 0) {//使点击无效
                    System.out.println("1");
                    n_result.setText(n_result.getText().substring(0, n_result.getText().length() - 1));
                }
                break;
            case 3:
                if ("ABCDEF89".indexOf(key) >= 0) {
                    n_result.setText(n_result.getText().substring(0, n_result.getText().length() - 1));
                    System.out.println("1");
                }
                break;
            case 4:
                if ("ABCDEF23456789".indexOf(key) >= 0) {
                    n_result.setText(n_result.getText().substring(0, n_result.getText().length() - 1));
                    System.out.println("1");
                }
                break;

        }

        midStr2 = doTransform(n_result.getText(), pd, 10);

        System.out.println("1:" + midStr1);
        System.out.println("2:" + midStr2);


        //北部文本显示：

        H_result.setText(doTransform(midStr2, 10, 16));
        D_result.setText(doTransform(midStr2, 10, 10));
        O_result.setText(doTransform(midStr2, 10, 8));
        B_result.setText(doTransform(midStr2, 10, 2));

    }

    public static String jiaa(String midStr1, String midStr2) {
        Integer a = Integer.valueOf(midStr1);
        Integer b = Integer.valueOf(midStr2);

        a = a + b;
        String str = a.toString();

        return str;
    }

    public static String jiana(String midStr1, String midStr2) {
        Integer a = Integer.valueOf(midStr1);
        Integer b = Integer.valueOf(midStr2);

        a = a - b;
        String str = a.toString();

        return str;
    }

    private boolean cl = false;
    public void doClear() {
        //初始化计算器各值
        cl = true;
        n_result.setText("0");
        H_result.setText("0");
        D_result.setText("0");
        O_result.setText("0");
        B_result.setText("0");

        midStr2 = "0";
        midStr1 = "0";
    }

    private int kk = 0;

    public void doOperator1(String keys) {
        switch (kk) {
            case 1:
                midStr2 = jiaa(midStr1, midStr2);
                System.out.println("k:" + midStr2);
                kk = 0;
                break;
            case 2:
                midStr2 = jiana(midStr1, midStr2);
                System.out.println("k:" + midStr2);
                kk = 0;
                break;
        }
        midStr1 = midStr2;
        //get n_process
        if (keys == "+" || keys == "-") {
            if (keys == "+") {
                kk = 1;
            } else
                kk = 2;
            n_process.setText(n_process.getText() + n_result.getText() + keys);
            n_result.setText(null);

        } else {
            H_result.setText(doTransform(midStr1, 10, 16));
            D_result.setText(doTransform(midStr1, 10, 10));
            O_result.setText(doTransform(midStr1, 10, 8));
            B_result.setText(doTransform(midStr1, 10, 2));
            System.out.println("out1:" + midStr1);

            midStr1 = doTransform(midStr1, 10, pd);
            n_result.setText(midStr1);

            System.out.println(midStr1);
            n_process.setText(null);

            kk = 0;
        }

    }

    private int ms = 1;

    private int pd = 10;
    private String mid = new String();

    public String doTransform(String vul, int in, int out) {//传输值和现在的进制和输出的进制

        BigInteger num = new BigInteger(vul, in);
        String outPut = new String();
        outPut = num.toString(out);
        return outPut;

    }

    private String firstInput = null;
    private String operator = null;

    public static void main(String[] args) {
        new Carculator();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent ev) {


        String command = ev.getActionCommand();//获取事件源

        if (command.equals(buttons[22]) && ms ==2) {
            doBackSpace(); //执行清除上一输入

        } else if (command.equals(buttons[20])&& ms ==2) {//清除事件
            doClear();

        } else if ((command.equals(buttons[5]) || command.equals(buttons[11]) || command.equals(buttons[17]) || command.equals(buttons[18]) || command.equals(buttons[19]))&& ms ==2) {
            doOperator1(command);//计算事件

        } else if ("1234567890ABCDEF".contains(command) && ms == 2) {
            doGetNumbers(command);
        }
        else if (ev.getSource() == M_bz) {

            ms = 1;
            buttonPanel.removeAll();
            n_panel.removeAll();
            c_panel.removeAll();

            addNorthComponent();
            addCenterButton();

            n_panel.validate();
            c_panel.validate();
            n_panel.repaint();
            c_panel.repaint();

        }
        else if (ev.getSource() == M_jz) {

            ms = 2;
            buttonPanel.removeAll();

            n_panel.removeAll();
            c_panel.removeAll();
            jz();
            n_panel.repaint();
            c_panel.repaint();

            n_panel.revalidate();
            c_panel.revalidate();

        }


        else if (".0123456789".indexOf(command)!=-1 &&  ms == 1) {  //运算符不显示
            this.input_text.setText(input_text.getText() + command);//显示值
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);//从右显示
            this.n_process.setText(n_process.getText() + command);//显示值
            this.n_process.setHorizontalAlignment(JTextField.RIGHT);//从右显示
            backText3 = input_text.getText();
            backText4 = n_process.getText();
            if (backText3.length()>10){
                input_text.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 32));
            }else {
                input_text.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 42));
            }
            if (backText4.length()>10){
                n_process.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 32));
            }else {
                n_process.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 42));
            }
        }
        else if (command.matches("[\\+\\-×÷C%◐]{1}") && ms == 1) {
            operator = command;//记录点击的运算符
            firstInput = this.n_process.getText();//第一次值
            this.input_text.setText(input_text.getText() + command);//显示值
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);//从右显示
            switch (operator) {
                case "◐":
                    if (q==0){
                        n_panel.setBackground(color1);
                        c_panel.setBackground(color1);
                        q++;
                    }else if (q==1){
                        n_panel.setBackground(null);
                        c_panel.setBackground(null);
                        q=0;
                    }
                case "C":
                    this.input_text.setText("");
                    this.n_process.setText("");
                    k = 0;
                    c = 0;
                    jia = 0;
                    jian = 0;
                    cheng = 0;
                    chu = 0;
                    yu =0;
                    break;
                case "+":
                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0&& yu==0) {
                        c = Double.valueOf(firstInput);
                        jia++;
                        break;
                    } else if (jia!=0&&cheng!=0){
                        c = c+k*Double.valueOf(firstInput);
                        jia=0;
                        cheng=0;
                        jia++;
                        break;
                    } else if (jian!=0&&cheng!=0){
                        c = c-k*Double.valueOf(firstInput);
                        jian=0;
                        cheng=0;
                        jia++;
                        break;
                    } else if (jia!=0&&chu!=0){
                        c = c+k/Double.valueOf(firstInput);
                        jia=0;
                        chu=0;
                        jia++;
                        break;
                    } else if (jian!=0&&chu!=0){
                        c = c-k/Double.valueOf(firstInput);
                        jian=0;
                        chu=0;
                        jia++;
                        break;
                    } else if (jia!=0&&yu!=0){
                        c = c+k%Double.valueOf(firstInput);
                        jia=0;
                        yu=0;
                        jia++;
                        break;
                    } else if (jian!=0&&yu!=0){
                        c = c-k%Double.valueOf(firstInput);
                        jian=0;
                        yu=0;
                        jia++;
                        break;
                    } else if (jia != 0) {
                        c += Double.valueOf(firstInput);
                        jia = 0;
                        jia++;
                        break;
                    } else if (jian != 0) {
                        c -= Double.valueOf(firstInput);
                        jian = 0;
                        jia++;
                        break;
                    } else if (cheng != 0) {
                        c *= Double.valueOf(firstInput);
                        cheng = 0;
                        jia++;
                        break;
                    } else if (chu != 0) {
                        c /= Double.valueOf(firstInput);
                        chu = 0;
                        jia++;
                        break;
                    } else if (yu!=0){
                        c %= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        yu=0;
                        jia++;
                        break;
                    }
                case "-":
                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0&& yu==0) {
                        c = Double.valueOf(firstInput);
                        jian++;
                        break;
                    } else if (jia!=0&&cheng!=0){
                        c = c+k*Double.valueOf(firstInput);
                        jia=0;
                        cheng=0;
                        jian++;
                        break;
                    } else if (jian!=0&&cheng!=0){
                        c = c-k*Double.valueOf(firstInput);
                        jian=0;
                        cheng=0;
                        jian++;
                        break;
                    }else if (jia!=0&&chu!=0){
                        c = c+k/Double.valueOf(firstInput);
                        jia=0;
                        chu=0;
                        jia++;
                        break;
                    } else if (jian!=0&&chu!=0){
                        c = c-k/Double.valueOf(firstInput);
                        jian=0;
                        chu=0;
                        jia++;
                        break;
                    } else if (jia!=0&&yu!=0){
                        c = c+k%Double.valueOf(firstInput);
                        jia=0;
                        yu=0;
                        jian++;
                        break;
                    } else if (jian!=0&&yu!=0){
                        c = c-k%Double.valueOf(firstInput);
                        jian=0;
                        yu=0;
                        jian++;
                        break;
                    } else if (jia != 0) {
                        c += Double.valueOf(firstInput);
                        jia = 0;
                        jian++;
                        break;
                    } else if (jian != 0) {
                        c -= Double.valueOf(firstInput);
                        jian = 0;
                        jian++;
                        break;
                    } else if (cheng != 0) {
                        c *= Double.valueOf(firstInput);
                        cheng = 0;
                        jian++;
                        break;
                    } else if (chu != 0) {
                        c /= Double.valueOf(firstInput);
                        chu = 0;
                        jian++;
                        break;
                    }
                case "×":
                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0&& yu==0) {
                        c = Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        cheng++;
                        break;
                    } else if (cheng+1==2&&(jian==1||jia==1)){
                        k *= Double.valueOf(firstInput);
                        cheng=1;
                        break;
                    } else if (jia != 0) {
                        k = Double.valueOf(firstInput);
                        cheng++;
                        break;
                    } else if (jian != 0) {
                        k = Double.valueOf(firstInput);
                        cheng++;
                        break;
                    } else if (cheng != 0) {
                        c *= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        cheng = 0;
                        cheng++;
                        break;
                    } else if (chu != 0) {
                        c /= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        chu = 0;
                        cheng++;
                        break;
                    }
                case "÷":
                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0&& yu==0) {
                        c = Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        chu++;
                        break;
                    } else if (chu+1==2&&(jian==1||jia==1)){
                        k /= Double.valueOf(firstInput);
                        chu=1;
                        break;
                    }else if (jia != 0) {
                        k = Double.valueOf(firstInput);
                        chu++;
                        break;
                    } else if (jian != 0) {
                        k = Double.valueOf(firstInput);
                        chu++;
                        break;
                    } else if (cheng != 0) {
                        c *= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        cheng = 0;
                        chu++;
                        break;
                    } else if (chu != 0) {
                        c /= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        chu = 0;
                        chu++;
                        break;
                    }
                case "%":
                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0&& yu ==0) {
                        c = Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        yu++;
                        break;
                    } else if (yu+1==2&&(jian==1||jia==1)){
                        k %= Double.valueOf(firstInput);
                        yu=1;
                        break;
                    } else if (jia != 0) {
                        k = Double.valueOf(firstInput);
                        yu++;
                        break;
                    } else if (jian != 0) {
                        k = Double.valueOf(firstInput);
                        yu++;
                        break;
                    } else if (cheng != 0) {
                        c *= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        cheng = 0;
                        yu++;
                        break;
                    } else if (chu != 0) {
                        c /= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        chu = 0;
                        yu++;
                        break;
                    } else if (yu!=0){
                        c %= Double.valueOf(firstInput);
                        k = Double.valueOf(firstInput);
                        yu++;
                        break;
                    }
            }
            this.n_process.setText("");//清空
        } else if (command.equals("←")&& ms ==1) {

            backText1 = input_text.getText();
            backText2 = n_process.getText();
            int i = backText1.length();
            int m = backText2.length();
            if (i>1){
                backText1 = backText1.substring(0,i-1);
                input_text.setText(backText1);
            }else {
                input_text.setText("");
            }
            if (m>1){
                backText2 = backText2.substring(0,m-1);
                n_process.setText(backText2);
            }else {
                n_process.setText("");
            }

        } else if (command.equals("=")&& ms ==1){
            this.input_text.setText(input_text.getText() + command);//显示值
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);//从右显示
            Double a = c;
            Double b = Double.valueOf(this.n_process.getText());//第二次抓取的值
            Double result = null;
            if (jia!=0&&cheng!=0){
                result = c+k*b;
                jia=0;
                cheng=0;
            } else if (jia!=0&&chu!=0){
                result = c+k/b;
                jia=0;
                chu=0;
            } else if (jian!=0&&cheng!=0){
                result = c-k*b;
                jian=0;
                cheng=0;
            } else if (jian!=0&&chu!=0){
                result = c-k/b;
                jian=0;
                chu=0;
            } else if (jia!=0&&yu!=0){
                c = c+k%Double.valueOf(firstInput);
                jia=0;
                yu=0;
                jian++;
            } else if (jian!=0&&yu!=0){
                c = c-k%Double.valueOf(firstInput);
                jian=0;
                yu=0;
                jian++;
            } else if (jia!=0){
                result = c+b;
            } else if (jian!=0){
                result = c-b;
            } else if (cheng!=0){
                result = c*b;
            } else if (chu!=0){
                result = c/b;
            } else if (yu!=0){
                result = c%b;
            }
            this.n_process.setText(result.toString());
        }
    }

}


