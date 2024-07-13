BeeFoodie 

Apps Involved
  1. Customer

      Customers can see every product with its price and picture.Each product has an "Add To Cart" button next to it. Customers can put items they want in their cart by clicking this button. Every click updates the cart showing the item's name and price in the "Cart" section. The cart shows the total price of every order a customer makes. Customers can check their selections in the cart section. If they want to start over, they can click the "Cancel" button. This empties the cart and resets the total price to zero. When customers are happy with what they've picked, they can place their order by clicking "Submit Order." This brings up a box asking for their name. If they type in a name, the system sends their order to a PHP script on the server.This order has a unique order ID, the number of items bought, and the total price. If everything looks good and the customer sends the order, they'll see a message saying it worked, and the Order ID box displays the new ID number. But if something doesn't go as planned, the system will show a message telling the customer the order wasn't successful.

3. Courier

   The Courier app helps delivery staff handle unfinished orders and bring their statuses up to date. When someone starts the app, they can hit the "Display Incomplete Order" button to get and show a list of unfinished orders from a server. The app displays the orders and their details in a text box. To mark an order as done, the courier types the Order ID into a text field and clicks the "Change Status" button. This action sends a POST request to the server with the Order ID and updates the order's status to "complete." The courier gets a success message if the update works or an error message if it doesn't.

Tables in Database

In our gorup project we forms a database known as groupprojectdad and then populates it with one table, itemorder, which keeps information regarding item orders. The itemorder table has five columns: Order_ID (a primary key), Name, Quantity, Price and the ‘Status’ column that takes its default value to be 'incomplete'. 

List URL end points
1.	GET /GroupProject/BeeDelivery.php
2.	POST /GroupProject/BeeDelivery.php
3.	POST /GroupProject/CustomerOrder.php
4.	GET /GroupProject/GetOrders.php
