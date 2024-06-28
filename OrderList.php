<?php

// Function to establish a database connection
function dbConnect() {
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "groupprojectdad";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    return $conn;
}

// Function to fetch order list from database
function getOrders() {
    $conn = dbConnect(); // Establish database connection

    $orders = array();

   
    $query = "SELECT order_id, name, order_details, quantity, total_price, status FROM orders";
    $result = $conn->query($query);

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $orders[] = $row;
        }
    }

    $conn->close(); // Close connection

    return $orders;
}

// Check if it's a GET request
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    // Fetch orders
    $orders = getOrders();

    // Output JSON response
    header("Content-Type: application/json");
    echo json_encode($orders);
} else {
    // Handle other HTTP methods if needed
    http_response_code(405); // Method Not Allowed
    echo json_encode(array("message" => "Method not allowed"));
}
?>
