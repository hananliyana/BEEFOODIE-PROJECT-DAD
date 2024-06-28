import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.swing.JOptionPane;
import java.awt.Font;

public class CustomerOrder {

    JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private int totalPrice = 0;
    private JTextField textField_1;
    private JTextField textField_2;
    private String orderId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerOrder window = new CustomerOrder();
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
    public CustomerOrder() {
     
            initialize();
            // Generate the order ID upon application start
            orderId = generateOrderId();
            textField_1.setText(orderId); // Set Order ID in text field
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 731, 773);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("BeeFoodie Order");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(345, 0, 193, 49);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(44, 54, 100, 100);
        frame.getContentPane().add(lblNewLabel_1);
        // Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\OIP (17).jpeg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_1.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_2 = new JLabel("Nasi Goreng");
        lblNewLabel_2.setBounds(63, 146, 103, 49);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_20 = new JLabel("RM10");
        lblNewLabel_20.setBounds(73, 187, 45, 13);
        frame.getContentPane().add(lblNewLabel_20);

        JButton btnNewButton = new JButton("Add To Cart");
        btnNewButton.setBounds(44, 205, 118, 28);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Nasi Goreng", 10);
            }
        });
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(248, 54, 100, 100);
        frame.getContentPane().add(lblNewLabel_3);
        // Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\R (4).jpeg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_3.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_4 = new JLabel("Nasi Lemak");
        lblNewLabel_4.setBounds(264, 155, 93, 31);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_21 = new JLabel("RM10");
        lblNewLabel_21.setBounds(274, 187, 45, 13);
        frame.getContentPane().add(lblNewLabel_21);

        JButton btnNewButton_1 = new JButton("Add To Cart");
        btnNewButton_1.setBounds(234, 205, 118, 28);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Nasi Lemak", 10);
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_5 = new JLabel("Bubur Ayam");
        lblNewLabel_5.setBounds(435, 164, 86, 13);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(421, 54, 100, 100);
        frame.getContentPane().add(lblNewLabel_6);
        // Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\bubur.jpg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_6.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_22 = new JLabel("RM8");
        lblNewLabel_22.setBounds(445, 187, 35, 13);
        frame.getContentPane().add(lblNewLabel_22);

        JButton btnNewButton_1_1 = new JButton("Add To Cart");
        btnNewButton_1_1.setBounds(409, 205, 118, 28);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Bubur Ayam", 8);
            }
        });
        frame.getContentPane().add(btnNewButton_1_1);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setBounds(575, 54, 100, 100);
        frame.getContentPane().add(lblNewLabel_7);
        // Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\ayam gepok.jpg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_7.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_8 = new JLabel("Ayam Gepuk");
        lblNewLabel_8.setBounds(600, 164, 93, 13);
        frame.getContentPane().add(lblNewLabel_8);

        JLabel lblNewLabel_23 = new JLabel("RM15");
        lblNewLabel_23.setBounds(610, 187, 45, 13);
        frame.getContentPane().add(lblNewLabel_23);

        JButton btnNewButton_1_2 = new JButton("Add To Cart");
        btnNewButton_1_2.setBounds(575, 205, 118, 28);
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Ayam Gepuk", 15);
            }
        });
        frame.getContentPane().add(btnNewButton_1_2);

        JLabel lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setBounds(44, 271, 100, 100);
        frame.getContentPane().add(lblNewLabel_9);
        // Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\boba.jpg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_9.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_10 = new JLabel("Boba Milk Tea");
        lblNewLabel_10.setBounds(63, 384, 81, 20);
        frame.getContentPane().add(lblNewLabel_10);

        JLabel lblNewLabel_24 = new JLabel("RM10");
        lblNewLabel_24.setBounds(73, 414, 45, 13);
        frame.getContentPane().add(lblNewLabel_24);

        JButton btnNewButton_2 = new JButton("Add To Cart");
        btnNewButton_2.setBounds(44, 433, 118, 28);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Boba Milk Tea", 10);
            }
        });
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setBounds(248, 283, 100, 100);
        frame.getContentPane().add(lblNewLabel_11);
        //Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\kopi o.png"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_11.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_12 = new JLabel("Kopi O");
        lblNewLabel_12.setBounds(274, 376, 52, 37);
        frame.getContentPane().add(lblNewLabel_12);


        JLabel lblNewLabel_25 = new JLabel("RM3");
        lblNewLabel_25.setBounds(274, 414, 45, 13);
        frame.getContentPane().add(lblNewLabel_25);

        JButton btnNewButton_3 = new JButton("Add To Cart");
        btnNewButton_3.setBounds(234, 433, 118, 28);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Kopi O", 3);
            }
        });
        frame.getContentPane().add(btnNewButton_3);

        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setBounds(421, 283, 100, 100);
        frame.getContentPane().add(lblNewLabel_13);
        //Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\teh o.jpeg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_13.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        JLabel lblNewLabel_14 = new JLabel("Teh O");
        lblNewLabel_14.setBounds(454, 388, 45, 13);
        frame.getContentPane().add(lblNewLabel_14);

        JLabel lblNewLabel_26 = new JLabel("RM3");
        lblNewLabel_26.setBounds(454, 414, 45, 13);
        frame.getContentPane().add(lblNewLabel_26);

        JButton btnNewButton_4 = new JButton("Add To Cart");
        btnNewButton_4.setBounds(409, 433, 118, 28);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Teh O", 3);
            }
        });
        frame.getContentPane().add(btnNewButton_4);

        JLabel lblNewLabel_15 = new JLabel("Limau Ais");
        lblNewLabel_15.setBounds(600, 388, 73, 16);
        frame.getContentPane().add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel("");
        lblNewLabel_16.setBounds(575, 283, 100, 100);
        frame.getContentPane().add(lblNewLabel_16);
        //Resize image
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\USER\\eclipse-workspace\\GroupProjectDAD\\src\\limau ais.jpg"));
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            lblNewLabel_16.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }



        JLabel lblNewLabel_27 = new JLabel("RM3");
        lblNewLabel_27.setBounds(610, 414, 45, 13);
        frame.getContentPane().add(lblNewLabel_27);

        JButton btnNewButton_5 = new JButton("Add To Cart");
        btnNewButton_5.setBounds(575, 433, 118, 28);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToCart("Limau Ais", 3);
            }
        });
        frame.getContentPane().add(btnNewButton_5);

        textArea = new JTextArea();
        textArea.setBounds(44, 559, 326, 85);
        frame.getContentPane().add(textArea);

    
        
        JLabel lblNewLabel_17 = new JLabel("Cart:");
        lblNewLabel_17.setBounds(44, 536, 45, 13);
        frame.getContentPane().add(lblNewLabel_17);
        
        JLabel lblNewLabel_18 = new JLabel("Order ID:");
        lblNewLabel_18.setBounds(435, 565, 64, 13);
        frame.getContentPane().add(lblNewLabel_18);
        
        textField_1 = new JTextField();
        textField_1.setBounds(509, 562, 96, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_19 = new JLabel("Total:");
        lblNewLabel_19.setBounds(234, 654, 45, 13);
        frame.getContentPane().add(lblNewLabel_19);
        
        textField_2 = new JTextField();
        textField_2.setBounds(274, 651, 96, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton_6 = new JButton("Cancel");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   clearCart();
        	}
        });
        btnNewButton_6.setBounds(435, 610, 85, 21);
        
        frame.getContentPane().add(btnNewButton_6);
        
        JButton btnNewButton_6_1 = new JButton("Submit Order");
        btnNewButton_6_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 submitOrder();
        	}
        });
        btnNewButton_6_1.setBounds(548, 610, 118, 21);
        frame.getContentPane().add(btnNewButton_6_1);
    }

 // Update the addItemToCart method to track total quantity
    private int totalQuantity = 0;

    private void addItemToCart(String itemName, int itemPrice) {
        totalQuantity++;

        totalPrice += itemPrice;
        textArea.append(itemName + " - RM" + itemPrice + "\n");
        textField_2.setText(String.valueOf(totalPrice)); // Update total text field
    }



    private void submitOrder() {
        // Prompt user for name
        String customerName = JOptionPane.showInputDialog(frame, "Please enter your name:");

        if (customerName == null || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty. Order not submitted.");
            return;
        }

        // Generate Order ID 
        orderId = generateOrderId(); // Generate orderId here

        // Create a new Runnable for the network operation
        Runnable submitOrderTask = new Runnable() {
            @Override
            public void run() {
                try {
                    // URL of the PHP 
                    URL url = new URL("http://localhost/GroupProject/CustomerOrder.php");

                    // Establish a connection to the server
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);

                    // Prepare the data to be sent
                    StringBuilder data = new StringBuilder();
                    data.append("Order_ID=").append(URLEncoder.encode(orderId, "UTF-8"));
                    data.append("&Name=").append(URLEncoder.encode(customerName, "UTF-8"));
                    data.append("&Quantity=").append(URLEncoder.encode(String.valueOf(totalQuantity), "UTF-8"));
                    data.append("&Price=").append(URLEncoder.encode(String.valueOf(totalPrice), "UTF-8"));
                    data.append("&Status=").append(URLEncoder.encode("uncompleted", "UTF-8"));

                    // Write the data to the connection
                    try (OutputStream outputStream = connection.getOutputStream()) {
                        outputStream.write(data.toString().getBytes(StandardCharsets.UTF_8));
                    }

                    // Get the response from the server
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        EventQueue.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame, "Order is successful!");
                            textField_1.setText(orderId); // Set Order ID in text field
                        });
                    } else {
                        EventQueue.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame, "Failed to submit order. Response code: " + responseCode);
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    EventQueue.invokeLater(() -> {
                        JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
                    });
                }
            }
        };

        
        Thread submitOrderThread = new Thread(submitOrderTask);
        submitOrderThread.start();
    }



    private String generateOrderId() {
        Random random = new Random();
        int orderId = 10000 + random.nextInt(90000); //random generation of orderId
        return String.valueOf(orderId);
    }



    private void clearCart() {
        textArea.setText("");
        textField_2.setText("");
        totalPrice = 0;
    }
}
