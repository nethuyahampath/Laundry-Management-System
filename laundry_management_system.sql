CREATE DATABASE laundry_management_system

DROP TABLE user
DROP TABLE orders
DROP TABLE wash_fold_orders
DROP TABLE dry_clean_orders
DROP TABLE wash_fold_status
DROP TABLE dry_clean_status
DROP TABLE dry_clean_rates
DROP TABLE wash_fold_rates
DROP TABLE review
DROP TABLE deposit
DROP TABLE payment


CREATE TABLE user
(
	userID VARCHAR(20) NOT NULL,
    firstName VARCHAR(20),
    lastName VARCHAR(20),
    password VARCHAR(40),
    no INT,
    street VARCHAR(20),
    city VARCHAR(20),
    contact VARCHAR(10),
    email VARCHAR(50),
    type VARCHAR(20),
    
	CONSTRAINT user_pk PRIMARY KEY(userID)
);

  CREATE TABLE wash_fold_rates
  (
	rate_id VARCHAR(20) NOT NULL,
    package VARCHAR(20),
    small_weight_price INT,
    medium_weight_price INT,
    large_weight_price INT,
    
    CONSTRAINT wfr_pk PRIMARY KEY(rate_id)
  );
  
  
  CREATE TABLE dry_clean_rates
  (
	rate_id VARCHAR(20) NOT NULL,
    item VARCHAR(20),
    price_per_unit INT,
    
    CONSTRAINT dcr_pk PRIMARY KEY(rate_id)
  );


SELECT *  FROM  orders

  CREATE TABLE orders
  (
	order_id VARCHAR(20)  NOT NULL,
    drop_date DATE,
    pick_date DATE,
    user_id VARCHAR(20) NOT NULL,
    
    CONSTRAINT o_pk  PRIMARY KEY(order_id),
	CONSTRAINT o_fk  FOREIGN KEY( user_id) REFERENCES user(userID)
  );


  CREATE TABLE  wash_fold_orders
  (
	order_id VARCHAR(20) NOT NULL,
    rate_id VARCHAR(20) NOT NULL,
    weight INT,
    
    CONSTRAINT wfo_pk PRIMARY KEY(order_id),
    CONSTRAINT wfo_fk FOREIGN KEY(rate_id) REFERENCES wash_fold_rates(rate_id)
    
  );

  
  CREATE TABLE dry_clean_orders
  (
	order_id VARCHAR(20) NOT NULL,
    rate_id VARCHAR(20) NOT NULL,
    quantity INT,
    
    CONSTRAINT dco_pk PRIMARY KEY(order_id, rate_id )
  );
  
  
  
  CREATE TABLE wash_fold_status
  (
	order_id VARCHAR(20) NOT NULL,
    status VARCHAR(20),
    
    CONSTRAINT wfs_pk PRIMARY KEY(order_id)
  );
  
  
  CREATE TABLE dry_clean_status
  (
	order_id VARCHAR(20) NOT NULL,
    status VARCHAR(20),
    
    CONSTRAINT dcs_pk PRIMARY KEY(order_id)
  );


CREATE TABLE payment
(
	payment_id VARCHAR(20) NOT NULL,
    payment_date DATE,
    amount REAL,
    order_type VARCHAR(20),
    user_id VARCHAR(20) NOT NULL,
    order_id VARCHAR(20) NOT NULL,
    
    CONSTRAINT pay_pk PRIMARY KEY(payment_id),
    CONSTRAINT pay_fk1 FOREIGN KEY(user_id) REFERENCES user(userID),
    CONSTRAINT pay_fk2 FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

CREATE TABLE deposit
(
	user_id VARCHAR(20) NOT NULL,
    amount REAL,
    
    CONSTRAINT deposit_pk PRIMARY KEY(user_id)
);


CREATE TABLE review
(
	review_id VARCHAR(20) NOT NULL,
    user_id VARCHAR(20) NOT NULL,
    fname VARCHAR(30),
    grade VARCHAR(20),
    date DATE,
    comment VARCHAR(200),
    
    CONSTRAINT rev_pk PRIMARY KEY(review_id),
    CONSTRAINT rev_fk FOREIGN KEY(user_id) REFERENCES user(userID)
);


SELECT * FROM user
SELECT * FROM orders
SELECT * FROM wash_fold_orders
SELECT * FROM  dry_clean_orders
SELECT * FROM wash_fold_status
SELECT * FROM dry_clean_status
SELECT * FROM  dry_clean_rates
SELECT * FROM  wash_fold_rates
SELECT * FROM review
SELECT * FROM deposit
SELECT * FROM payment

/*insert into users */
INSERT INTO user VALUES('U10002', 'Pasindu', 'Sandaruwan', 'Pasindu@123', 137, 'Pahalamapitigama', 'Malwana', '0776055017', 'pasindu@gmail.com', 'User');
INSERT INTO user VALUES('U10001', 'Nadeesha', 'Madusanka', 'Nadeesha@123', 317, 'katubadda', 'Moratuwa', '0717518092', 'nadeeshamadusanka1996@gmail.com', 'User');
INSERT INTO user VALUES('U10051', 'Chamara', 'Madusanka', 'Chamara@123', 37, 'Mabola', 'Wattala', '0717518092', 'chamara@gmail.com', 'Admin');
INSERT INTO user VALUES('U10091', 'Helanka', 'Yahampath', 'Helanka@123', 37, 'Mabola', 'Wattala', '0717518092', 'helanka@gmail.com', 'Admin');

/*insert into orders*/
INSERT INTO orders VAlUES('DCO520', '2018-05-20', '2018-05-29', 'U10001');
INSERT INTO orders VAlUES('DCO521', '2018-05-20', '2018-05-30', 'U10002');
INSERT INTO orders VAlUES('WFO520', '2018-05-20', '2018-05-25', 'U10001');
INSERT INTO orders VAlUES('WFO521', '2018-05-20', '2018-05-26', 'U10002');
INSERT INTO orders VAlUES('WFO522', '2018-05-20', '2018-05-31', 'U10002');
INSERT INTO orders VAlUES('WFO524', '2018-05-20', '2018-05-23', 'U10001');
INSERT INTO orders VAlUES('WFO525', '2018-05-20', '2018-05-23', 'U10001');

/*insert into wash_fold_orders*/
INSERT INTO wash_fold_orders VALUES('WFO520', 'WFR210', 14);
INSERT INTO wash_fold_orders VALUES('WFO521', 'WFR211', 5);
INSERT INTO wash_fold_orders VALUES('WFO522', 'WFR213', 9);
INSERT INTO wash_fold_orders VALUES('WFO524', 'WFR210', 0);
INSERT INTO wash_fold_orders VALUES('WFO525', 'WFR210', 0);

/*inser into dry_clean_orders*/
INSERT INTO dry_clean_orders VALUES('DCO520', 'DCR210', 2);
INSERT INTO dry_clean_orders VALUES('DCO520', 'DCR211', 3);
INSERT INTO dry_clean_orders VALUES('DCO520', 'DCR212', 0);
INSERT INTO dry_clean_orders VALUES('DCO520', 'DCR213', 2);
INSERT INTO dry_clean_orders VALUES('DCO520', 'DCR214', 0);
INSERT INTO dry_clean_orders VALUES('DCO521', 'DCR210', 0);
INSERT INTO dry_clean_orders VALUES('DCO521', 'DCR211', 2);
INSERT INTO dry_clean_orders VALUES('DCO521', 'DCR212', 4);
INSERT INTO dry_clean_orders VALUES('DCO521', 'DCR213', 1);
INSERT INTO dry_clean_orders VALUES('DCO521', 'DCR214', 0);

/*insert into wash_fold_status*/
INSERT INTO wash_fold_status VALUES('WFO520', 'Washing');
INSERT INTO wash_fold_status VALUES('WFO521', 'Completed');
INSERT INTO wash_fold_status VALUES('WFO522', 'Pending');
INSERT INTO wash_fold_status VALUES('WFO524', 'Completed');
INSERT INTO wash_fold_status VALUES('WFO525', 'Pending');

/*insert into dry_clean_status*/
INSERT INTO dry_clean_status VALUES('DCO520', 'Cleaning');
INSERT INTO dry_clean_status VALUES('DCO520', 'Cleaning');

/*insert into dry clean rates*/
INSERT INTO dry_clean_rates VALUES('DCR210', 'T-Shirt', 100);
INSERT INTO dry_clean_rates VALUES('DCR211', 'Trouser', 150);
INSERT INTO dry_clean_rates VALUES('DCR212', 'Short', 80);
INSERT INTO dry_clean_rates VALUES('DCR213', 'Shirt', 150);
INSERT INTO dry_clean_rates VALUES('DCR214', 'Frock', 120);

/*insert into wash_fold_rates*/
INSERT INTO wash_fold_rates VALUES('WFR210', 'Regular Laundry', 50, 45, 40);
INSERT INTO wash_fold_rates VALUES('WFR211', 'Bedding', 100, 95, 90);
INSERT INTO wash_fold_rates VALUES('WFR212', 'Decoration Curtains', 300, 280, 250);
INSERT INTO wash_fold_rates VALUES('WFR213', 'Wedding', 250, 220, 200);

/*insert into review*/
INSERT INTO review VALUES('REV201', 'U10002', 'Pasindu', 'Excellent', '2018-05-20', 'Very Good Service');
INSERT INTO review VALUES('REV202', 'U10002', 'Pasindu', 'Very Bad', '2018-05-20', 'Poor Service');

/*insert into deposit*/
INSERT INTO deposit VALUE('U10001', 2700);
INSERT INTO deposit VALUE('U10002', 6460);
INSERT INTO deposit VALUE('U10092', 0);

/*insert into payment*/
INSERT INTO payment VAlUES('P140', '2018-05-20', 770, 'Dry-Clean', 'U10002', 'DCO521');
INSERT INTO payment VAlUES('P141', '2018-05-20', 950, 'Dry-Clean', 'U10001', 'DCO520');
INSERT INTO payment VAlUES('P142', '2018-05-20', 700, 'Wash-Fold', 'U10001', 'WFO520');