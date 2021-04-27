import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {



    private String title = "Tuner";
    private String buttonText = "Click to Tune";

    //create window
    private JFrame frame;
    private JPanel panel;

    //create elements
    private JButton button;

    public GUI(){

        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();

        title = "Tuner";

        button = new JButton(buttonText);
        buttonText = "Click to Tune";

            //panel setup
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
            panel.setLayout(new GridLayout(0,1));
            panel.add(button);


        //frame setup
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();


            button.addActionListener(this);

            //make everything visible
            panel.setVisible(true);
            button.setVisible(true);
            frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo code to start microphone listener

        new AudioListener();
    }


}
