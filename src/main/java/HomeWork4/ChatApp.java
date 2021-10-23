package HomeWork4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApp extends JFrame{
    public ChatApp() throws HeadlessException {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 600);

        Font font = new Font("Arial Black", Font.BOLD, 15);

        JTextArea textArea = new JTextArea();
        textArea.setFont(font);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        add(textArea, BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JTextField field = new JTextField(25);
        field.addActionListener(actionEvent -> {
            textArea.setText(field.getText());
            field.setText(null);
        });

        panel.add(field);

        JButton button = new JButton("Send");
        button.addActionListener(actionEvent -> {
            textArea.setText(field.getText());
            field.setText(null);
        });
        panel.add(button);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChatApp();
    }
}
