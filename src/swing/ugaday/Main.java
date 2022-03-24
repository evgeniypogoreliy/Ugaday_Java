package swing.ugaday;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {
        static String varWord;
        static String workWord;
        static char[] varArrWord;
        static char[] varSArrWord;
        static double varRandom;
        static int word_position;
        static int chances;
        static char varEnter;
        static String[] arrDB = {"Яблоко", "Банан", "Манго", "Апельсин", "Арбуз", "Груша"};

    public static void main(String[] args) {
        JFrame okno = new JFrame();
        game();

        JButton accept = new JButton("Accept");
        JButton reset = new JButton("Reset");

        JLabel word = new JLabel();
        word.setText("  " + workWord);

        JLabel output1 = new JLabel();
        output1.setText("Отгадай фрукт");

        JLabel output2 =new JLabel();
        output2.setText("Осталось: " + chances);

        JTextField enter = new JTextField(5);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(accept);
        buttonPanel.add(reset);

        JPanel workPanel = new JPanel(new FlowLayout());
        workPanel.setLayout(new GridLayout(2, 3));
        workPanel.add(word);
        workPanel.add(enter);
        workPanel.add(output1);
        workPanel.add(output2);


        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char a = enter.getText().charAt(0);
                for(int i = 0; i < varSArrWord.length; i++){
                    if(varSArrWord[i] == a){
                        varArrWord[i] = a;
                        workWord = String.valueOf(varArrWord);
                    }
                }
                if(Character.isDigit(a) == true || enter.getText() == null)
                    output1.setText("Пиши буквы!");
                else   output1.setText("Отгадай фрукт");

                
                word.setText("  " + workWord);
                enter.setText(null);

                if(e.getSource() == accept)
                chances = chances - 1;
                output2.setText("Осталось: " + chances);

                if(chances <= 0)
                    output1.setText("Ты проебал!");

                int index = workWord.indexOf('-');
                if(index == -1)
                    output1.setText("Ты молодец!");

            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == reset)
                    main(null);

            }
        });

        okno.add(workPanel, BorderLayout.NORTH);
        okno.add(buttonPanel, BorderLayout.SOUTH);
        okno.setTitle("Угадай слово");
        okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
        okno.setBounds(500, 200, 300, 200);
        okno.setVisible(true);

    }

    private static void game() {
        varRandom = Math.random()*(5 - 0) + 0;
        word_position = Integer.valueOf((int) varRandom);

        varWord = arrDB[word_position];
        varArrWord = varWord.toCharArray();
        varSArrWord = varWord.toCharArray();
        for(int i = 0; i < varArrWord.length; i++) {
            varArrWord[i] = '-';
        }
        workWord = String.valueOf(varArrWord);

        chances = varArrWord.length + 2;
    }
}
