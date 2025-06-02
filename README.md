# Contact Manager Application

A Java-based contact management system that demonstrates JDBC connectivity with both MySQL and H2 databases using HikariCP connection pooling.

## Features

- User management with basic CRUD operations
- Support for both MySQL and H2 databases
- Connection pooling with HikariCP
- Environment-based configuration

## Prerequisites

- Java 8 or higher
- Maven
- MySQL Server (for MySQL mode)

## Setup

1. Clone the repository:
2. bash git clone Perfect! Now I'll help you push your project to GitHub. First, let's create the necessary files and then push everything. Run these commands in your project's root directory:

1. First, create the `.gitignore` file:

```plain text
# Maven
target/
!.mvn/wrapper/maven-wrapper.jar
!**/src/main/**/target/
!**/src/test/**/target/

# IDE files
.idea/
*.iws
*.iml
*.ipr
.settings/
.project
.classpath

# Environment files
.env*
!.env.*.example

# H2 database files
*.db
contactsdb*

# OS-specific files
.DS_Store
Thumbs.db
```


2. Create the example environment files:

```plain text
DB_TYPE=mysql
DB_URL=jdbc:mysql://localhost:3306/contactsdb
DB_USER=your_username
DB_PASS=your_password
```


3. Create README.md:

```markdown
# Contact Manager Application

A Java-based contact management system with MySQL database support using HikariCP connection pooling.

## Features

- User management with basic CRUD operations
- MySQL database support
- Connection pooling with HikariCP
- Environment-based configuration

## Prerequisites

- Java 8 or higher
- Maven
- MySQL Server

## Setup

1. Clone the repository:
```
bash
git clone https://github.com/itsWaqar963/1.---DTOContactManager.git
```
2. Copy the example environment file and configure your database:
```
bash
cp .env.mysql.example .env.mysql
```
3. Edit `.env.mysql` with your database credentials

4. Build the project:
```
bash
mvn clean install
```
## Running the Application
```
bash
mvn exec:java -Dexec.mainClass="app.vercel.waqar963.App"
```
## Dependencies

- HikariCP for connection pooling
- MySQL Connector/J
- dotenv-java for environment configuration
```


4. Now run these Git commands (copy and paste each line one at a time):

```shell script
git init
git add .
git commit -m "Initial commit: Contact Manager with MySQL support"
git branch -M main
git remote add origin https://github.com/itsWaqar963/1.---DTOContactManager.git
git push -u origin main
```


If you're prompted for credentials, you'll need to:
1. Enter your GitHub username: itsWaqar963
2. For the password, you'll need to use a GitHub Personal Access Token (PAT). If you don't have one:
    - Go to GitHub.com → Settings → Developer Settings → Personal Access Tokens → Tokens (classic)
    - Generate a new token with 'repo' access
    - Use this token as your password when pushing

Let me know if you need help with any of these steps or if you encounter any issues!
3.Copy the example environment files and configure your database:
4.bash cp .env.mysql.example .env.mysql cp .env.h2.example .env.h2
5.Edit `.env.mysql` and `.env.h2` with your database credentials
6.Build the project:

bash mvn clean install

## Configuration

- The application can work with either MySQL or H2 database
- Database configuration is managed through environment files:
    - `.env.mysql` for MySQL configuration
    - `.env.h2` for H2 configuration
- Switch between databases by modifying `ACTIVE_ENV` in `DatabaseConfig.java`

## Running the Application

bash mvn exec:java -Dexec.mainClass="app.vercel.waqar963.App"
## Dependencies

- HikariCP for connection pooling
- MySQL Connector/J
- H2 Database Engine
- dotenv-java for environment configuration

5. 1. Now, to push to GitHub:
      First, go to GitHub and create a new repository (don't initialize it with any files).
      Then, assuming your repository is created, run these commands (replace `YOUR_USERNAME` and `REPOSITORY_NAME` with your actual GitHub username and repository name):

git remote add origin https://github.com/YOUR_USERNAME/REPOSITORY_NAME.git
git branch -M main
git push -u origin main

Important Security Notes:
1. Make sure your and files are listed in to prevent pushing sensitive credentials `.env.mysql``.env.h2``.gitignore`
2. Only push the `.env.*.example` files with placeholder credentials
3. In the actual `.env` files that you keep locally, maintain your real database credentials