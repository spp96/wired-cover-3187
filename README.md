
<h1>The Mahatma Gandhi National Rural Employment Guarantee Act Backend Application</h1>
 
<h1>Project Logo:</h1>

![logo-no-background](https://user-images.githubusercontent.com/102204260/201484111-42a43ecc-b151-4bf2-bba6-2164429bdc22.png)

# The Basic Prerequisites of this Applications are.
- [x] Should Have a MySQL Server and a Database Created.
- [x] Should have created folllowing tables into the database WITH SAME DATATYPES.


- [X] TABLE BDO

| Field    | Type        | Null | Key | Default | Extra          |
|----------|-------------|------|-----|---------|----------------|
| id       | int         | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | YES  |     | NULL    |                |
| password | varchar(20) | YES  |     | NULL    |                |

<hr />

- [X] TABLE GPM

| Field    | Type        | Null | Key | Default | Extra          |
|----------|-------------|------|-----|---------|----------------|
| id       | int         | NO   | PRI | NULL    | auto_increment |
| name     | varchar(20) | NO   |     | NULL    |                |
| address  | varchar(20) | NO   |     | NULL    |                |
| phone    | varchar(20) | NO   |     | NULL    |                |
| username | varchar(20) | NO   | UNI | NULL    |                |
| password | varchar(20) | NO   |     | NULL    |                |

<hr />

- [x] TABLE EMPLOYEE

| Field        | Type        | Null | Key | Default | Extra          |
|--------------|-------------|------|-----|---------|----------------|
| id           | int         | NO   | PRI | NULL    | auto_increment |
| name         | varchar(20) | NO   |     | NULL    |                |
| gender       | varchar(20) | NO   |     | NULL    |                |
| address      | varchar(20) | NO   |     | NULL    |                |
| phone        | varchar(20) | NO   |     | NULL    |                |
| no_duty_day  | int         | NO   |     | NULL    |                |
| projAssigned | int         | YES  | MUL | NULL    |                |
| gpossigned   | int         | YES  | MUL | NULL    |                |
| wages        | int         | NO   |     | NULL    |                |

<hr />

- [x] TABLE PROJECTS

| Field        | Type        | Null | Key | Default | Extra |
|--------------|-------------|------|-----|---------|-------|
| name         | varchar(20) | YES  |     | NULL    |       |
| projectNo    | int         | NO   | PRI | NULL    |       |
| address      | varchar(20) | YES  |     | NULL    |       |
| noOfEmployee | int         | YES  |     | NULL    |       |
| totalwages   | int         | YES  |     | NULL    |       |
| id           | int         | YES  |     | NULL    |       |

<hr />

- [x] TABLE ALLOCATE_PROJECT

|Field  | Type | Null | Key | Default | Extra |
|-------|------|------|-----|---------|-------|
| gid   | int  | YES  | MUL | NULL    |       |
| pid   | int  | YES  | MUL | NULL    |       |

<hr />

<h2>Features:</h2>
  <h3>BDO:</h3>

- BDO can Login into their account
- BDO can Create a project
- BDO can provide the confirmation of the seat to the Customer
- BDO can View List Of Project
- BDO can Create new Gram Panchayat Member(GPM)
- BDO can View all the GPM
- BDO can Allocate  Project to GPM
- BDO can See List of Employee working on that Project and their wages

<h3>Gram Panchayat Member(GPM):</h3>

- GPM can Login into their Account
- GPM can Create Employee
- GPM can View the Details of Employee
- GPM can Assign Employee to a Project
- GPM can View total number of days Employee worked in a project and also their wages

# Technology used 

- Java
- MySQL
- Git & GitHub

# Lessons Learned

- Gain excessive knowledge on application of Java and MySQL.
- Enjoyed the process of learning and creating the application.

# Feedback
> Valuable feedback will be appreciated.
> You can reach out to me via below medium.
- [Email](shubhamppatil1996@gmail.com)
- [Linkedin](https://www.linkedin.com/in/shubham-patil-045478206/)
# Contributor
#### Shubham Patil
>[GitHub](https://github.com/spp96)
