# Account Management Tool
Sales teams  need a POS interface for making business happen!
This CLI application allows us to  manage customer accounts, make sales orders, access inventory, and schedule
deliveries.

# Actors & Features
- A Sales team member can:
	- create a sales order
	- create a new customer entry
	- schedule a sales order for delivery or pickup
	- look up inventory information
	- take a credit card payment


# POS Structure Description
- I've conceptualized the POS as consisting of two main menus. 
- The **Main Menu** contains information not specific to a given order: inventory, customer accounts, miscellaneous.  
- The **Order Menu** allows for viewing/editing one order at a time.  So if you've selected a particular order in it, then when selecting a given menu option, you will typically be presented with information for that specific order, like customer info.


Main Menu
1. Order        ---> brings you to Order Menu
2. Inventory    ---> look up products by name & size to view (quantity & soonest delivery day: ATP Date)
3. Customer     ---> look up customer info from inputting (name and/or phone # and/or address)
5. System       ---> NA 
6. Exit         ---> exit program

Order Menu
1. View Order     ---> view current invoice, which combines info from Inventory, Customer, Delivery
2. Inventory      ---> look up and add products and their prices to order
3. Customer       ---> view and edit current customer info
4. Delivery       ---> view and edit delivery day for current order (at most, 30 days out)
5. Load           ---> load an existing order into the Order Menu, populating View Order, Customer, etc.
6. New            ---> reset Order Menu (wipe it) without saving, thus starting a new order
<<<<<<< HEAD
7. Exit           ---> return to Main Menu
=======
7. Exit           ---> return to Main Menu
>>>>>>> origin/main
