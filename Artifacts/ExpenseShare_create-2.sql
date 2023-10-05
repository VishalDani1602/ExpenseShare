-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-10-02 06:08:46.947

-- tables
-- Table: Expense
CREATE TABLE Expense (
    Expense_ID int  NOT NULL AUTO_INCREMENT,
    description varchar(1000)  NOT NULL,
    amount int  NULL,
    date datetime  NULL,
    User_UId int  NOT NULL,
    Group_GId int  NOT NULL,
    CONSTRAINT Expense_pk PRIMARY KEY (Expense_ID)
);

-- Table: Group
CREATE TABLE `GroupList` (
    Group_ID int  NOT NULL AUTO_INCREMENT,
    Name varchar(50)  NULL,
    CreatorID int  NOT NULL,
    CONSTRAINT GroupList_pk PRIMARY KEY (Group_ID)
);

-- Table: GroupParticipant
CREATE TABLE GroupParticipant (
    GroupParticipant_ID int  NOT NULL AUTO_INCREMENT,
    Group_GId int  NOT NULL,
    User_UId int  NOT NULL,
    CONSTRAINT GroupParticipant_pk PRIMARY KEY (GroupParticipant_ID)
);

-- Table: Settlement
CREATE TABLE Settlement (
    Settlement_ID int  NOT NULL AUTO_INCREMENT,
    User_From int  NOT NULL,
    User_To int  NOT NULL,
    amount int  NULL,
    Date datetime  NULL,
    CONSTRAINT Settlement_pk PRIMARY KEY (Settlement_ID)
);

-- Table: Transaction
CREATE TABLE Transaction (
    Transaction_ID int  NOT NULL AUTO_INCREMENT,
    Amount int  NULL,
    User_From int  NOT NULL,
    User_To int  NOT NULL,
    Expense_EID int  NOT NULL,
    Group_GId int  NOT NULL,
    CONSTRAINT Transaction_pk PRIMARY KEY (Transaction_ID)
);

-- Table: User
CREATE TABLE User (
    User_ID int  NOT NULL AUTO_INCREMENT,
    Email varchar(100)  NULL,
    Password varchar(50)  NULL,
    CONSTRAINT User_pk PRIMARY KEY (User_ID)
);

-- foreign keys
-- Reference: ExpenseParticipant_Expense (table: Transaction)
ALTER TABLE Transaction ADD CONSTRAINT ExpenseParticipant_Expense FOREIGN KEY ExpenseParticipant_Expense (Expense_EID)
    REFERENCES Expense (Expense_ID);

-- Reference: ExpenseParticipant_User (table: Transaction)
ALTER TABLE Transaction ADD CONSTRAINT ExpenseParticipant_User FOREIGN KEY ExpenseParticipant_User (User_From)
    REFERENCES User (User_ID);

-- Reference: Expense_Group (table: Expense)
ALTER TABLE Expense ADD CONSTRAINT Expense_Group FOREIGN KEY Expense_Group (Group_GId)
    REFERENCES `GroupList` (Group_ID);

-- Reference: Expense_User (table: Expense)
ALTER TABLE Expense ADD CONSTRAINT Expense_User FOREIGN KEY Expense_User (User_UId)
    REFERENCES User (User_ID);

-- Reference: Group_User (table: Group)
ALTER TABLE `GroupList` ADD CONSTRAINT Group_User FOREIGN KEY Group_User (CreatorID)
    REFERENCES User (User_ID);

-- Reference: ParticipantMap_Group (table: GroupParticipant)
ALTER TABLE GroupParticipant ADD CONSTRAINT ParticipantMap_Group FOREIGN KEY ParticipantMap_Group (Group_GId)
    REFERENCES `GroupList` (Group_ID);

-- Reference: ParticipantMap_User (table: GroupParticipant)
ALTER TABLE GroupParticipant ADD CONSTRAINT ParticipantMap_User FOREIGN KEY ParticipantMap_User (User_UId)
    REFERENCES User (User_ID);

-- Reference: Settlement_UserFrom (table: Settlement)
ALTER TABLE Settlement ADD CONSTRAINT Settlement_UserFrom FOREIGN KEY Settlement_UserFrom (User_From)
    REFERENCES User (User_ID);

-- Reference: Settlement_UserTo (table: Settlement)
ALTER TABLE Settlement ADD CONSTRAINT Settlement_UserTo FOREIGN KEY Settlement_UserTo (User_To)
    REFERENCES User (User_ID);

-- Reference: Transaction_Group (table: Transaction)
ALTER TABLE Transaction ADD CONSTRAINT Transaction_Group FOREIGN KEY Transaction_Group (Group_GId)
    REFERENCES `GroupList` (Group_ID);

-- Reference: Transaction_User (table: Transaction)
ALTER TABLE Transaction ADD CONSTRAINT Transaction_User FOREIGN KEY Transaction_User (User_To)
    REFERENCES User (User_ID);

-- End of file.

