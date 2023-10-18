                                                                                                                                                                                                                                                                                                                                                                                                                  
-- Create the Admin table
CREATE TABLE Admin (
    UserID VARCHAR2(50),
    Password VARCHAR2(50)
);

-- Create the Customer table
CREATE TABLE Customer (
    ID NUMBER(10) PRIMARY KEY,
    Name VARCHAR2(100),
    Mobile VARCHAR2(20),
    Password VARCHAR2(50),
    OrderCount NUMBER(5)
);

-- Create the Items table
CREATE TABLE Items (
    ID NUMBER(10) PRIMARY KEY,
    ItemName VARCHAR2(100),
    ItemDescription VARCHAR2(255),
    ItemType VARCHAR2(50),
);

-- Create the Inventory table
CREATE TABLE Inventory (
    ID NUMBER(10) PRIMARY KEY,
	ItemID NUMBER(10) REFERENCES Items(ID)
    QuantityInStock NUMBER(10),
    MarketPrice NUMBER(10, 2),
    SellingPrice NUMBER(10, 2),
    CostPrice NUMBER(10, 2),
    Expired CHAR(1),
    StockInDate DATE,
    StockEndDate DATE,
    DistributorID NUMBER(10) REFERENCES Distributor(ID)
);

-- Create the Distributor table
CREATE TABLE Distributor (
    ID NUMBER(10) PRIMARY KEY,
    RegisteredName VARCHAR2(100),
    Address VARCHAR2(255),
    GSTNumber VARCHAR2(15),
    Phone VARCHAR2(20),
    Email VARCHAR2(100)
);

-- Create the Order table
CREATE TABLE Order (
    ID NUMBER(10) PRIMARY KEY,
    OrderType VARCHAR2(50),
    OrderStatus VARCHAR2(50),
    CustomerID NUMBER(10) REFERENCES Customer(ID),
	DistributorID NUMBER(10) REFERENCES Distributor(ID),
    OrderDetailID NUMBER(10) REFERENCES OrderDetail(ID),
    OrderDate DATE,
    TotalAmount NUMBER(10, 2),
    NumberOfItems NUMBER(5)
);

-- Create the OrderDetail table
CREATE TABLE OrderDetail (
	ID NUMBER(10) PRIMARY KEY,
    ItemID NUMBER(10) REFERENCES Items(ID),
    NumberOfItems NUMBER(5)
);
