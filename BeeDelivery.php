<?php
header('Content-Type: application/json');

// Database connection settings
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

// Check if POST parameters are received for status update
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['Order_ID']) && isset($_POST['Status'])) {
    $orderId = $_POST['Order_ID'];
    $newStatus = $_POST['Status'];

    // Update order status in the database (using prepared statement)
    $updateSql = "UPDATE itemorder SET Status = ? WHERE Order_ID = ?";
    $stmt = $conn->prepare($updateSql);

    // Verify data types and bind parameters
    $stmt->bind_param("si", $newStatus, $orderId);

    if (!$stmt->execute()) {
        $error = $stmt->error;
        echo json_encode(array("error" => "Failed to update order status: $error"));
    } else {
        $response = array("message" => "Order status updated successfully");
        echo json_encode($response);
    }

    $stmt->close();
    exit();
}

// Default: Fetch incomplete orders
$sql = "SELECT * FROM itemorder WHERE Status = 'incomplete'";
$result = $conn->query($sql);

$orders = array();
if ($result->num_rows > 0) {
    // Fetch all orders
    while ($row = $result->fetch_assoc()) {
        $orders[] = $row;
    }
}

echo json_encode($orders);

$conn->close();
?>
