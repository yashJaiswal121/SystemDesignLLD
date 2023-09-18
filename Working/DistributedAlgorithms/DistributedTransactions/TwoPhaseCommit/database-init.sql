--Step1: docker pull oracleinanutshell/oracle-xe-11g
--Step2: Using Docker-Desktop, Start 3 Containers of oracle-db, mapped on system ports: a)OrderMs:- 1520 b)DeliveryMs-1622 c)StoreMs-1722
--Step3: Create Following Tables in the respective MS dbs:
--User/Passwd : system/oracle
--a)OrderMs:
CREATE TABLE Orders (
    id NUMBER(19,0) PRIMARY KEY,
    customer_email VARCHAR2(255) NOT NULL
);


--b)DeliveryMs:
CREATE TABLE AGENT (
    is_reserved CHAR(1), -- See Packet Table Info and Same applies here
    id NUMBER(19,0), -- Assuming "long" refers to a large integer
    order_id NUMBER(19,0) -- Assuming "long" refers to a large integer
);

INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 1, 101); -- cURRENTLY sERVING sOME ORDER 101

-- Inserting an agent entry with is_reserved set to false
INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 2, NULL);

-- Inserting another agent entry with is_reserved set to false
INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 3, NULL);

INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 4, NULL);

INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 5, NULL);

INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 6, NULL);

INSERT INTO AGENT (is_reserved, id, order_id)
VALUES ('N', 7, NULL);


--reset : UPDATE AGENT SET IS_RESERVED = 'N' , ORDER_ID = NULL WHERE ORDER != 101;


--c)StoreMs:
CREATE TABLE Food (
    id NUMBER(19,0) PRIMARY KEY,
    name VARCHAR2(255)
);

INSERT INTO Food (id, name)
VALUES (1, 'Burger');

CREATE TABLE Packets (
    id NUMBER(19,0) PRIMARY KEY,
    food_id NUMBER(19,0),
    is_reserved CHAR(1),  -- is_reserved=N means Packet is already either been assigned to an order or not been touched yet by any order request.
                            --is_reserved=Y means Packet is about to be assigned to an order(i.e touched by PREPARE phase)
    order_id NUMBER(19,0),
    FOREIGN KEY (food_id) REFERENCES Food(id)
);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (1, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (2, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (3, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (4, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (5, 1, 'N', 101);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (6, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (7, 1, 'N', NULL);

INSERT INTO Packets (id, food_id, is_reserved, order_id)
VALUES (8, 1, 'N', NULL);

-- reset: UPDATE Packets SET IS_RESERVED = 'N' , ORDER_ID = NULL  WHERE ORDER != 101;;



