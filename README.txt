Welcome to Library Management System!!!

At first in order to login in to the library management system as admin, enter username as 'Admin' and password as 'Library'.

Also, first in order to create database uncomment the commented lines in createdatabase class. Then, after the database is created comment the lines so that the database won't be created again.
Admin Functions:-

* In order to view the stock details of the book, click view books
* In order to view the user details, click view users
* For issuing a book, click issue book and enter the bookid of the book to be issued as well as the userid of the user for whom the book has to be issued. Also enter the validity of the book(in days) as well as the issue date
* For withdrawing a book, click withdraw book and enter the issueid of the book which is generated after the book has been issued. Also enter the current date. The book will be withdrawn if there is no fine, else if there is fine, the fine will be displayed and the book will be withdrawn
* In order to view the issued books, click view issued books
* The admin can also add a user by taking the details of the user like name,ussername,password,mobilenumber.
* The admin can also insert a book into the database by giving the book name,genre and author.

User Functions:-

* In order to view the book catalogue, click view books
* The books taken option shows the book taken by the user and its details(bookid, issueid, book name,genre,author) as well as issue date,return date(if returned),fine(if any)


#################################################################################END#####################################################################################