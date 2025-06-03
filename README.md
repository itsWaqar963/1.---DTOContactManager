# DTO Contact Manager 📘

> A sophisticated Java application showcasing clean architecture principles and DTO pattern implementation with dual database support. Built with performance and scalability in mind.

[![Java Version](https://img.shields.io/badge/Java-8%2B-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Portfolio](https://img.shields.io/badge/Portfolio-waqar963.vercel.app-purple)](https://waqar963.vercel.app/)

## 🌟 Key Features

- **Dual Database Support**: Seamless integration with MySQL and H2 databases
- **HikariCP Integration**: High-performance JDBC connection pooling
- **DTO Pattern**: Clean separation of data transfer and business logic
- **Environment Management**: Flexible configuration using .env files
- **Complete CRUD Operations**: Full user management functionality
- **Comprehensive Logging**: Robust system monitoring and debugging

## 🛠️ Technology Stack

- Java 8+
- Maven
- HikariCP
- MySQL/H2 Database
- dotenv-java

## 🚀 Quick Start

### 1. Clone & Setup

bash git clone [https://github.com/itsWaqar963/DTOContactManager.git](https://github.com/itsWaqar963/DTOContactManager.git) cd DTOContactManager

### 2. Database Configuration
For MySQL:

bash cp .env.mysql.example .env.mysql
# Edit .env.mysql with your credentials

For H2:
```bash
cp .env.h2.example .env.h2
# Edit .env.h2 if needed

### 3. Build & Run
mvn clean install
mvn exec:java -Dexec.mainClass="app.vercel.waqar963.App"

## 📁 Project Architecture

src/
├── main/java/app/vercel/waqar963/
    ├── config/       # Database configurations
    ├── dto/         # Data Transfer Objects
    ├── repository/  # Data access layer
    ├── service/     # Business logic
    └── App.java     # Entry point

## ⚙️ Configuration Templates
### MySQL Setup
DB_TYPE=mysql
DB_URL=jdbc:mysql://localhost:3306/contactsdb
DB_USER=your_username
DB_PASS=your_password

### H2 Setup
DB_TYPE=h2
DB_URL=jdbc:h2:file:./contactsdb
DB_USER=your_username
DB_PASS=your_password

## 🔒 Security Guidelines
1. Never commit files with real credentials `.env`
2. Use `.env.example` files as templates
3. Keep sensitive data in local files `.env`
4. Regular security updates for dependencies

## 🌐 API Features
- Create new contacts
- Retrieve contact information
- Update existing contacts
- Delete contact records
- List all contacts
- Database switching capability

## 🤝 Contributing
1. Fork the repository
2. Create feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

## 📞 Contact & Support
- **Developer**: Waqar Ahmed
- **Portfolio**: [waqar963.vercel.app](https://waqar963.vercel.app/)
- **GitHub**: [itsWaqar963](https://github.com/itsWaqar963)
- **Project Repository**: [DTOContactManager](https://github.com/itsWaqar963/DTOContactManager)

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
## 💡 Acknowledgments
- HikariCP for the excellent connection pooling implementation
- The Java community for continuous support
- All contributors and users of this project

Developed with ❤️ by [Waqar Ahmed](https://waqar963.vercel.app/)
