import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorAPP extends JFrame implements ActionListener {

    // 显示区域
    JTextField display;
    // 记录输入的数字和符号
    StringBuilder input;

    public CalculatorAPP() {
        input = new StringBuilder();

        // 窗口设置
        setTitle("计算器");
        setSize(320, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // 居中显示

        // 显示栏
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        add(display, BorderLayout.NORTH);

        // 按钮面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // 按钮
        String[] buttons = {
                "C", "←", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "=", "√"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("微软雅黑", Font.PLAIN, 22));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // 清空
        if (command.equals("C")) {
            input.setLength(0);
            display.setText("");
        }

        // 退格
        else if (command.equals("←")) {
            if (input.length() > 0) {
                input.deleteCharAt(input.length() - 1);
                display.setText(input.toString());
            }
        }

        // 等于
        else if (command.equals("=")) {
            try {
                double result = calculate(input.toString());
                display.setText(input + " = " + result);
                input.setLength(0);
            } catch (Exception ex) {
                display.setText("输入错误");
            }
        }

        // 开根号
        else if (command.equals("√")) {
            try {
                double num = Double.parseDouble(input.toString());
                double res = Math.sqrt(num);
                display.setText("√" + num + " = " + res);
                input.setLength(0);
            } catch (Exception ex) {
                display.setText("错误");
            }
        }

        // 其他按钮：数字、符号
        else {
            input.append(command);
            display.setText(input.toString());
        }
    }

    // 简单四则运算计算
    private double calculate(String s) throws Exception {
        // 这里简单处理，实际复杂计算可用 ScriptEngine
        return (double) new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript")
                .eval(s);
    }

    public static void main(String[] args) {
        new CalculatorAPP().setVisible(true);
    }
}
