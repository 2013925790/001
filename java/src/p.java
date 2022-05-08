//package cn.lidan.start;
//
//
//import com.sun.deploy.security.SelectableSecurityManager;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//
////创建界面
//public class Carculator extends JFrame implements ActionListener {
//    private double   c,k,jia,jian,cheng,chu=0;
//
//    /***************北面控件定义************/
//    private JPanel jp_north = new JPanel();
//    private JTextField input_text = new JTextField();
//    //private JButton c_Btn = new JButton("C");//建立一个有文字的按钮
//
//    /***************中间控件定义***********/
//    private JPanel jp_center = new JPanel();
//
//
//
//    public Carculator() throws HeadlessException{
//        this.init();
//        this.addNorthComponent();
//        this.addCenterButton();
//
//    }
//    public void init(){//初始化界面
//        this.setTitle("计算器");
//        this.setSize(500 , 700);
//        this.setLayout(new BorderLayout());//设置界面边距
//        this.setResizable(false);//防止界面拉伸
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//窗口退出程序
//
//
//    }
//
//    public void addNorthComponent(){
////添加北面控件
//        this.input_text.setPreferredSize(new Dimension(400,100));//设置文本框长度大小
////this.input_text.setPreferredSize(new Dimension(230 , 10));
//        jp_north.add(input_text);//添加文本框
//       // jp_north.add(c_Btn);//添加按钮
//       // this.c_Btn.setForeground(Color.RED);
//        //c_Btn.setContentAreaFilled(false);//按钮透明
////c_Btn.setBorderPainted(false);
//
//
//        this.add(jp_north , BorderLayout.NORTH);
//
//    }
//    public void addCenterButton(){         //添加中间控件
//
//        String btn_text = "C×÷←789+456-123=%0.=";
//        jp_center.setLayout(new FlowLayout(FlowLayout.LEFT));
//        jp_center.setLayout(new FlowLayout(FlowLayout.CENTER));
//        this.jp_center.setLayout(new GridLayout(5,4));
//        for (int i = 1; i<=20; i++) {
//            String temp =btn_text.substring(i-1,i);
//            JButton btn = new JButton();
//            btn.setText(temp);
//            btn.setFont(new Font("粗体",Font.BOLD,24));//设置键盘文字大小
//            btn.addActionListener(this); //监听器
//            jp_center.add(btn);
//            btn.setContentAreaFilled(false);
//            btn.setPreferredSize(new Dimension(118,110));
//        }
//        this.add(jp_center , BorderLayout.CENTER);
//    }
//
//    public static void main(String[] args) {
//        Carculator carculator = new Carculator();
//        carculator.setVisible(true);//运行程序
//    }
//
//    private String firstInput = null;
//    private String operator = null;
//    @Override//监听
//    public void actionPerformed(ActionEvent e) {
//
//        String clickStr = e.getActionCommand();//获取值
//        if (".0123456789".indexOf(clickStr)!=-1) {  //运算符不显示
//            this.input_text.setText(input_text.getText() + clickStr);//显示值
//            this.input_text.setHorizontalAlignment(JTextField.RIGHT);//从右显示
//        }else if (clickStr.matches("[\\+\\-×÷C]{1}")) {
//            operator = clickStr;//记录点击的运算符
//            firstInput = this.input_text.getText();//第一次值
//            switch (operator) {
//                case "C":
//                    this.input_text.setText("");
//                    k = 0;
//                    c = 0;
//                    jia = 0;
//                    jian = 0;
//                    cheng = 0;
//                    chu = 0;
//                    break;
//                case "+":
//                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0) {
//                        c = Double.valueOf(firstInput);//第二次抓取的值
//                        jia++;
//                        break;
//                    } else if (jia!=0&&cheng!=0){
//                        c = c+k*Double.valueOf(firstInput);
//                        jia=0;
//                        cheng=0;
//                        jia++;
//                        break;
//                    } else if (jian!=0&&cheng!=0){
//                        c = c-k*Double.valueOf(firstInput);
//                        jian=0;
//                        cheng=0;
//                        jia++;
//                        break;
//                    }else if (jia!=0&&chu!=0){
//                        c = c+k/Double.valueOf(firstInput);
//                        jia=0;
//                        chu=0;
//                        jia++;
//                        break;
//                    } else if (jian!=0&&chu!=0){
//                        c = c-k/Double.valueOf(firstInput);
//                        jian=0;
//                        chu=0;
//                        jia++;
//                        break;
//                    }else if (jia != 0) {
//                        c += Double.valueOf(firstInput);
//                        jia = 0;
//                        jia++;
//                        break;
//                    } else if (jian != 0) {
//                        c -= Double.valueOf(firstInput);
//                        jian = 0;
//                        jia++;
//                        break;
//                    } else if (cheng != 0) {
//                        c *= Double.valueOf(firstInput);
//                        cheng = 0;
//                        jia++;
//                        break;
//                    } else if (chu != 0) {
//                        c /= Double.valueOf(firstInput);
//                        chu = 0;
//                        jia++;
//                        break;
//                    }
//                case "-":
//                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0) {
//                        c = Double.valueOf(firstInput);
//                        jian++;
//                        break;
//                    } else if (jia!=0&&cheng!=0){
//                        c = c+k*Double.valueOf(firstInput);
//                        jia=0;
//                        cheng=0;
//                        jian++;
//                        break;
//                    } else if (jian!=0&&cheng!=0){
//                        c = c-k*Double.valueOf(firstInput);
//                        jian=0;
//                        cheng=0;
//                        jian++;
//                        break;
//                    }else if (jia!=0&&chu!=0){
//                        c = c+k/Double.valueOf(firstInput);
//                        jia=0;
//                        chu=0;
//                        jia++;
//                        break;
//                    } else if (jian!=0&&chu!=0){
//                        c = c-k/Double.valueOf(firstInput);
//                        jian=0;
//                        chu=0;
//                        jia++;
//                        break;
//                    } else if (jia != 0) {
//                        c += Double.valueOf(firstInput);
//                        jia = 0;
//                        jian++;
//                        break;
//                    } else if (jian != 0) {
//                        c -= Double.valueOf(firstInput);
//                        jian = 0;
//                        jian++;
//                        break;
//                    } else if (cheng != 0) {
//                        c *= Double.valueOf(firstInput);
//                        cheng = 0;
//                        jian++;
//                        break;
//                    } else if (chu != 0) {
//                        c /= Double.valueOf(firstInput);
//                        chu = 0;
//                        jian++;
//                        break;
//                    }
//                case "×":
//                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0) {
//                        c = Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        cheng++;
//                        break;
//                    } else if (jia != 0) {
//                        k = Double.valueOf(firstInput);
//                        cheng++;
//                        break;
//                    } else if (jian != 0) {
//                        k = Double.valueOf(firstInput);
//                        cheng++;
//                        break;
//                    } else if (cheng != 0) {
//                        c *= Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        cheng = 0;
//                        cheng++;
//                        break;
//                    } else if (chu != 0) {
//                        c /= Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        chu = 0;
//                        cheng++;
//                        break;
//                    }
//                case "÷":
//                    if (jia == 0 && jian == 0 && cheng == 0 && chu == 0) {
//                        c = Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        chu++;
//                        break;
//                    } else if (jia != 0) {
//                        k = Double.valueOf(firstInput);
//                        chu++;
//                        break;
//                    } else if (jian != 0) {
//                        k = Double.valueOf(firstInput);
//                        chu++;
//                        break;
//                    } else if (cheng != 0) {
//                        c *= Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        cheng = 0;
//                        chu++;
//                        break;
//                    } else if (chu != 0) {
//                        c /= Double.valueOf(firstInput);
//                        k = Double.valueOf(firstInput);
//                        chu = 0;
//                        chu++;
//                        break;
//                    }
//            }
//            this.input_text.setText("");//清空
//        }else if (clickStr.equals("=")){
//            Double a = c;
//            Double b = Double.valueOf(this.input_text.getText());//第二次抓取的值
//            Double result = null;
//            if (jia!=0&&cheng!=0){
//                result = c+k*b;
//                jia=0;
//                cheng=0;
//            } else if (jia!=0&&chu!=0){
//                result = c+k/b;
//                jia=0;
//                chu=0;
//            } else if (jian!=0&&cheng!=0){
//                result = c-k*b;
//                jian=0;
//                cheng=0;
//            } else if (jian!=0&&chu!=0){
//                result = c-k/b;
//                jian=0;
//                chu=0;
//            } else if (jia!=0){
//                result = c+b;
//            } else if (jian!=0){
//                result = c-b;
//            } else if (cheng!=0){
//                result = c*b;
//            } else if (chu!=0){
//                result = c/b;
//            }
//            this.input_text.setText(result.toString());
//        }
//    }
//}