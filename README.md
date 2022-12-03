# Inventory Management
> CCET IA 2

## Inventory Management Application that users can use to maintain inventory, update inventory and get a detailed report of their inventories at the end of the day.

### Overview
- We have two services: inventory and inventory items manager.
- Inventory Manager is used to perform CRUD operations on the inventory that is creating, reading, upadating and deleting an inventory and also mapping inventory items to a specific inventory.
- Inventory Item Manager is used to perform CRUD operations on the inventory items that is creating, reading, upadating and deleting inventory items.
- Each inventory item has a field quantity which is used to define the quantity of the item and is displayed in the report at the end of the day.

### HOW DOES IT WORK?
- Using spring boot we create API endpoints which can be accessed by the user to manage their inventory.
- Using the Mailing Service we mail the reports at the end of the day.

### Team
- 1911089 - Vedant Mahadik
- 1911093 - Neelansh Mathur
- 1911109 - Burhanuddin Rangwala
