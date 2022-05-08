package cn.lidan.start;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


    //创建界面
public class Carculator1 extends JFrame implements ActionListener {
    private String backText1;//储存删除后的值
    private String backText2;//储存删除后的值
    private String backText3;//储存删除后的值
    private String backText4;//储存删除后的值
    private JFrame frame;
    private Color color1 = new Color(0x646363);
    private double   c,k,q,jia,jian,cheng,chu,yu=0;


    /***************北面控件定义************/
    private JPanel n_panel = new JPanel();
    private JTextField input_text = new JTextField();
    private JTextField n_process = new JTextField();//结果


    /***************中间控件定义***********/
    private JPanel c_panel = new JPanel();


    public Carculator1() throws HeadlessException{
        /*this.init();
        this.addNorthComponent();
        this.addCenterButton();
*/
        init();
    }
    //初始化界面
    public void init(){

        frame = new JFrame();
        frame.setTitle("计算器");
        frame.setSize(500 , 700);

        addNorthComponent();
        addCenterButton();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        Image frame_icon=Toolkit.getDefaultToolkit().createImage(Carculator1.class.getResource("03男性角色.png"));
        frame.setIconImage(frame_icon);

    }
    //添加北面控件
    public void addNorthComponent(){
        n_panel = new JPanel();
        n_panel.setPreferredSize(new Dimension(400 , 150));
        n_panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        n_process.setPreferredSize(new Dimension(500 , 70));
        n_process.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 42));
        n_process.setHorizontalAlignment(JTextField.RIGHT);
        n_process.setBorder(null);//去边框
        n_process.setBackground(null);//去颜色


        input_text.setPreferredSize(new Dimension(500 , 70));
        input_text.setFont(new Font("黑体" , Font.TRUETYPE_FONT , 42));
        input_text.setHorizontalAlignment(JTextField.RIGHT);
        input_text.setBorder(null);
        input_text.setBackground(null);
        //this.input_text.setPreferredSize(new Dimension(400,100));//设置文本框长度大小

        n_panel.add(input_text);//添加文本框
        n_panel.add(n_process);//添加文本框
       // this.add(n_panel , BorderLayout.NORTH);
        frame.add(n_panel , BorderLayout.NORTH);
    }
    //添加中间控件
    public void addCenterButton(){
        c_panel = new JPanel();
        c_panel.setPreferredSize(new Dimension(400 , 550));
        c_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        String btn_text = "C×÷←789+456-123◐%0.=";
        c_panel.setLayout(new GridLayout(5,4));
        for (int i = 1; i<=20; i++) {
            String temp =btn_text.substring(i-1,i);
            JButton btn = new JButton();
            btn.setText(temp);
            btn.setFont(new Font("粗体",Font.BOLD,30));//设置键盘文字大小
            btn.addActionListener(this); //监听器
            c_panel.add(btn);
            btn.setContentAreaFilled(false);
        }
        frame.add(c_panel , BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Carculator1 carculator = new Carculator1();
    }

    private String firstInput = null;
    private String operator = null;
    
    @Override//监听
    public void actionPerformed(ActionEvent e) {
        String clickStr = e.getActionCommand();//获取值
        if (".0123456789".indexOf(clickStr)!=-1) {  //运算符不显示
            this.input_text.setText(input_text.getText() + clickStr);//显示值
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);//从右显示
            this.n_process.setText(n_process.getText() + clickStr);//显示值
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
        }  else if (clickStr.matches("[\\+\\-×÷C%◐]{1}")) {
            operator = clickStr;//记录点击的运算符
            firstInput = this.n_process.getText();//第一次值
            this.input_text.setText(input_text.getText() + clickStr);//显示值
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
        } else if (clickStr.equals("←")) {
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

        } else if (clickStr.equals("=")){
            this.input_text.setText(input_text.getText() + clickStr);//显示值
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
