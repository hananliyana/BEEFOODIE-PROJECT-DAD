<?php
// Establish connection to database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "groupprojectdad"; // Replace with your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve POST data for customer order
$orderId = $_POST['Order_ID'];
$customerName = $_POST['Name'];
$quantity = $_POST['Quantity'];
$price = $_POST['Price'];
$status = $_POST['Status'];

// Prepare and bind the statement for customer order
$stmt = $conn->prepare("INSERT INTO itemorder (Order_ID, Name, Quantity, Price, Status) VALUES (?, ?, ?, ?, ?)");
$stmt->bind_param("ssdis", $orderId, $customerName, $quantity, $price, $status);

// Execute the statement
if ($stmt->execute()) {
    echo "New record created successfully";
} else {
    echo "Error: " . $stmt->error;
}

$stmt->close();
$conn->close();
?>
