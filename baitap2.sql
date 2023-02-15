create database quanlybanhang;
use quanlybanhang;
Create Table Customer(
	cID Int Auto_Increment Primary Key Not Null ,
    cName Varchar(50) Not Null,
    cAge Int Not Null
);

Create Table Orders(
	oID Int  Auto_Increment Primary Key Not Null,
    cID Int Not Null,
    oDate Date,
    oTotalPrice Int
);

Create Table Product(
	pID Int Not Null Auto_Increment Primary Key,
    pName Varchar(50),
    pPrice Int
);

Create Table OrderDetail(
	oID Int Not Null,
    pID Int Not Null,
    Primary Key(oID,pID),
    odQTY Int Not Null 
);

alter table OrderDetail
  add  Foreign Key(oID)References Orders (oID),
  add Foreign Key(pID)References Product (pID);
  
alter table Orders
add  Foreign Key(cID)References Customer(cID);