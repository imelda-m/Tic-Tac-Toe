import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel tittle_panel = new JPanel();
    JPanel btn_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    Tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(Color.pink);
        textField.setFont(new Font("PT Serif",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TIC-TAC-TOE");
        textField.setOpaque(true);

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0,0,800,100);
        tittle_panel.add(textField);

        btn_panel.setLayout(new GridLayout(3,3));
        btn_panel.setBackground(new Color(215, 197, 222));
       // btn_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            btn_panel.add(buttons[i]);
            buttons[i].setFont(new Font("PT Serif", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        frame.add(tittle_panel,BorderLayout.NORTH);
        frame.add(btn_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        if (random.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("X turn");
        }
        else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }
    public void check(){
        //check if X wins
        if ((buttons[0].getText() == "X") &&(buttons[1].getText() == "X") && (buttons[2].getText() == "X")){
            Xwins(0,1,2);
        }
        if ((buttons[3].getText() == "X") &&(buttons[4].getText() == "X") && (buttons[5].getText() == "X")){
            Xwins(3,4,5);
        }
        if ((buttons[6].getText() == "X") &&(buttons[7].getText() == "X") && (buttons[8].getText() == "X")){
            Xwins(6,7,8);
        }
        if ((buttons[0].getText() == "X") &&(buttons[3].getText() == "X") && (buttons[6].getText() == "X")){
            Xwins(0,3,6);
        }
        if ((buttons[1].getText() == "X") &&(buttons[4].getText() == "X") && (buttons[7].getText() == "X")){
            Xwins(1,4,7);
        }
        if ((buttons[2].getText() == "X") &&(buttons[5].getText() == "X") && (buttons[8].getText() == "X")){
            Xwins(2,5,8);
        }
        if ((buttons[0].getText() == "X") &&(buttons[4].getText() == "X") && (buttons[8].getText() == "X")){
            Xwins(0,4,8);
        }
        if ((buttons[2].getText() == "X") &&(buttons[4].getText() == "X") && (buttons[6].getText() == "O")){
            Xwins(2,4,6);
        }

        //check if O wins
        if ((buttons[0].getText() == "O") &&(buttons[1].getText() == "O") && (buttons[2].getText() == "O")){
            Owins(0,1,2);
        }
        if ((buttons[3].getText() == "O") &&(buttons[4].getText() == "O") && (buttons[5].getText() == "O")){
            Owins(3,4,5);
        }
        if ((buttons[6].getText() == "O") &&(buttons[7].getText() == "O") && (buttons[8].getText() == "O")){
            Owins(6,7,8);
        }
        if ((buttons[0].getText() == "O") &&(buttons[3].getText() == "O") && (buttons[6].getText() == "O")){
            Owins(0,3,6);
        }
        if ((buttons[1].getText() == "O") &&(buttons[4].getText() == "O") && (buttons[7].getText() == "O")){
            Owins(1,4,7);
        }
        if ((buttons[2].getText() == "O") &&(buttons[5].getText() == "O") && (buttons[8].getText() == "O")){
            Owins(2,5,8);
        }
        if ((buttons[0].getText() == "O") &&(buttons[4].getText() == "O") && (buttons[8].getText() == "O")){
            Owins(0,4,8);
        }
        if ((buttons[2].getText() == "O") &&(buttons[4].getText() == "O") && (buttons[6].getText() == "O")){
            Owins(2,4,6);
        }
    }
    public void Xwins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }
    public void Owins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");

    }

}
