Flipkart Daily 
Description: Flipkart wants to build a product to deliver groceries and daily essentials by next morning. In the initial release we want to build a browsing feature for Users where they can search for items from inventory using some filters and sorting criterias. This will give them the idea of how rich the inventory is before they can go ahead and place an order.
Features: 
Define items in the inventory along with the price. Category & brand defines the item.   [category → milk, bread / brand → Amul milk or Britannia bread]
AddItem(category, brand, price) 
Add items to inventory with available quantity for each of them
AddInventory(category, brand, quantity)
Search items in inventory using one of the filters like. 
Brand or Category (search can be on multiple categories / brands)
Price range (price From , price To) etc. (from and to price parameters can be optional)
Searching should be extensible to support more filters in future.
Searched items / results can be ordered using any of the below criteria.
Items with lowest price first (this would be default criteria)
Items with highest price first
Items with least no of of quantity
We might add more such options in the future. 

  Bonus:
1. User should be able to search items in inventory using combination of multiple filter criterias like 
Search by both category and brand
Search by both category and price range (price From , price To)
Search by both brand and price range (price From , price To)

Other Details:
Write a driver class for demo purposes. Which will execute all the commands at one place in the code and have test cases.
Do not use any database or NoSQL store, use in-memory data-structure for now. 
Do not create any UI for the application.
Please prioritize code compilation, execution and completion. 
Work on the expected output first and then add good-to-have features of your own.

Expectations:
Make sure that you have working and demonstrable code.
Make sure that code is functionally correct.
Use of proper abstraction, modelling, separation of concerns is required.
Code should be modular, readable and unit-testable.
Code should easily accommodate new requirements with minimal changes.
Proper exception handling is required.
Test cases: (You need not follow the same method signatures and output) 
Add Item (brand, category, price) 
Add inventory (brand, category, quantity) 
SearchItems(“category”=[“categoryValue”]) / SearchItems(“brand”=[“brandValue”]) / SearchItems(“price”=[fromPrice, toPrice])
SearchItems(“category”=[“categoryValue”], Order_By=[Price, asc]) / SearchItems(“category”=[“categoryValue”], Order_By=[ItemQty, desc])
