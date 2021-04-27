import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {



    private String title = "Tuner";
    private String buttonText = "Click to Tune";

    //create window
    private JFrame frame = new JFrame(title);
    private JPanel panel = new JPanel();

    //create elements
    private JButton button = new JButton(buttonText);
    public GUI(){



            //window setup
            panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
            panel.setLayout(new GridLayout(0,1));
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            button.addActionListener(this);


}

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo code to start microphone listener
    }


}
