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
    public JLabel label;

    public GUI(){

         frame = new JFrame(title);
         panel = new JPanel();

        title = "Tuner";

        label = new JLabel("asher behmer is a very cool dude");

        button = new JButton(buttonText);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);

        //panel setup
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,100));
        panel.setLayout(new GridLayout(0,2));
        panel.setBackground(Color.orange);
        panel.add(button);
        panel.add(label);

        //frame setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBackground(Color.ORANGE);
        frame.setTitle("Tuner");

        //make button listen for clicks
        button.addActionListener(this);

        //make everything visible
        panel.setVisible(true);
        button.setVisible(true);
        label.setVisible(true);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //starts listening
       // new AudioListener();
        new AudioProcessor();
    }


}
