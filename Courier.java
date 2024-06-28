import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Courier {

    JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Courier window = new Courier();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Courier() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 106, 402, 91);
        frame.getContentPane().add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JLabel lblNewLabel = new JLabel("BeeFoodie Delivery");
        lblNewLabel.setBounds(156, 11, 138, 14);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Incomplete Order List:");
        lblNewLabel_1.setBounds(24, 76, 161, 14);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Display Incomplete Order");
        btnNewButton.setBounds(24, 42, 174, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet("http://localhost/GroupProject/BeeDelivery.php");

                try {
                    HttpResponse response = httpClient.execute(httpGet);
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String result = EntityUtils.toString(entity);
                        JSONArray orders = new JSONArray(result);
                        StringBuilder displayText = new StringBuilder();
                        for (int i = 0; i < orders.length(); i++) {
                            JSONObject order = orders.getJSONObject(i);
                            Iterator<String> keys = order.keys();
                            while (keys.hasNext()) {
                                String key = keys.next();
                                displayText.append(key).append(": ").append(order.getString(key)).append("\n");
                            }
                            displayText.append("\n");
                        }
                        textArea.setText(displayText.toString());
                    }
                } catch (IOException | JSONException e1) {
                    JOptionPane.showMessageDialog(frame, "Error fetching orders: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Insert OrderId:");
        lblNewLabel_2.setBounds(24, 208, 104, 14);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        frame.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(119, 206, 96, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Change Status");
        btnNewButton_1.setBounds(221, 205, 114, 23);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderId = textField.getText().trim();
                if (orderId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter an order ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://localhost/GroupProject/BeeDelivery.php");

                // Parameters to send in POST request
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("Order_ID", orderId));
                params.add(new BasicNameValuePair("Status", "complete"));

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                    HttpResponse response = httpClient.execute(httpPost);

                    // Handle response
                    int statusCode = response.getStatusLine().getStatusCode();
                    HttpEntity entity = response.getEntity();
                    String responseBody = EntityUtils.toString(entity);

                    JSONObject jsonResponse = new JSONObject(responseBody);

                    if (statusCode == 200 && jsonResponse.has("message")) {
                        // Success! Order status likely updated
                        String message = jsonResponse.getString("message");
                        JOptionPane.showMessageDialog(frame, message, "Status Update", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Handle error
                        String errorMessage = "Error updating order status: " + jsonResponse.optString("error", "Unknown error");
                        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException | JSONException e1) {
                    JOptionPane.showMessageDialog(frame, "Error updating order status: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.getContentPane().add(btnNewButton_1);
    }
}
