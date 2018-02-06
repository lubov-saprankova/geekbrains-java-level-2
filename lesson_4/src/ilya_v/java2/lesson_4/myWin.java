package ilya_v.java2.lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myWin extends JFrame {

    myWin(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(550, 260, 666, 666);
        setLayout(new FlowLayout());

        JButton jBtn1 = new JButton("Button #1");
        JButton jBtn2 = new JButton("Button #2");

        add(jBtn1);
        add(jBtn2);

        jBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yo!");
            }
        });


        JTextField jTextInput = new JTextField(20);
        add(jTextInput);

        jBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jTextInput.getText());
            }
        });

        setVisible(true);
    }
}
