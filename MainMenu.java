import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainMenu {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu window = new MainMenu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome To BeeFoodie!!!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(81, 20, 298, 41);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Please Choose:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(176, 127, 70, 13);
        frame.getContentPane().add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Customer");
        rdbtnNewRadioButton.setBounds(176, 146, 103, 21);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Delivery");
        rdbtnNewRadioButton_1.setBounds(176, 171, 103, 21);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JButton btnNewButton = new JButton("Ok");
        btnNewButton.setBounds(166, 200, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                CustomerOrder window = new CustomerOrder();
                                window.frame.setVisible(true);
                                frame.dispose(); // Close the main menu
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else if (rdbtnNewRadioButton_1.isSelected()) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                Courier window = new Courier();
                                window.frame.setVisible(true);
                                frame.dispose(); // Close the main menu
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    System.out.println("Please select an option.");
                }
            }
        });
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(151, 36, 100, 100);
        frame.getContentPane().add(lblNewLabel_2);
        //Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\export202406272114333550.png"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_2.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
