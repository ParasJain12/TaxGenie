# 🧾 TaxGenie — Streamlined Tax Analysis & Savings Platform

> Simplifying tax management with personalized ITR form suggestions, tax regime recommendations, financial tools, and more.

---

## 🚀 Features

- 📋 **ITR Form Selector** — Enter your income details and get a personalized recommendation on which ITR form to file
- 💰 **Tax Regime Selector** — Compare Old vs New tax regime based on your income and investments
- 📰 **Financial News** — Stay updated with the latest finance and tax-related news
- 📖 **Tax Glossary** — A-Z glossary of tax and finance terms
- 🧮 **Financial Calculators** — NSC, HRA, 80C, 80DD, 80TTA, 80U, TDS, Crypto Tax, Simple Interest, Compound Interest, Gratuity, SSY, Transport Allowance, House Property calculators
- 📬 **Contact & Callback Form** — Get in touch or request a callback via email
- 🔐 **User Authentication** — Register, Login, Forgot Password with email reset link
- 📧 **Newsletter** — Subscribe via Medium for financial tips and insights

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 2.7.18 |
| Frontend | HTML, CSS, Bootstrap 5, Thymeleaf |
| Database | MySQL 8.0 |
| Security | Spring Security 5 |
| ORM | Spring Data JPA / Hibernate |
| Email | Spring Mail (SMTP) + EmailJS |
| Build Tool | Maven |
| Language | Java 17 |
| Containerization | Docker, Docker Compose |
| Other | Lombok, Gson, PDFBox |

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven 3.8+
- MySQL 8.0+
- Docker & Docker Compose (optional, for containerized setup)
- Git

---

## 🏃 Running Locally (Without Docker)

### Step 1 — Clone the repository

```bash
git clone https://github.com/ParasJain12/TaxGenie.git
cd TaxGenie
```

### Step 2 — Create the database

Open MySQL and run:

```sql
CREATE DATABASE taxgenie;
```

### Step 3 — Configure environment

Create `src/main/resources/application-local.properties`:

```properties
DB_PASSWORD=your_mysql_password
MAIL_PASSWORD=your_gmail_app_password
NEWS_API_KEY=your_newsapi_key
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET_ID=your_google_clientsecret_id
```

> **Gmail App Password:** Go to Google Account → Security → 2-Step Verification → App Passwords → Generate for "Mail"

> **News API Key:** Get a free key from [newsapi.org](https://newsapi.org)

### Step 4 — Create EmailJS config file

Create `src/main/resources/static/js/config.js`:

```javascript
const EMAILJS_PUBLIC_KEY = "your_public_key";
const EMAILJS_SERVICE_ID = "your_service_id";
const EMAILJS_TEMPLATE_ID = "your_template_id";
const EMAILJS_CONTACT_TEMPLATE_ID = "your_contact_template_id";
```

> Get these from [emailjs.com](https://www.emailjs.com) after creating a free account.

### Step 5 — Build and run

```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

### Step 6 — Open in browser

```
http://localhost:8080
```

---

## 🐳 Running with Docker

### Step 1 — Clone the repository

```bash
git clone https://github.com/ParasJain12/TaxGenie.git
cd TaxGenie
```

### Step 2 — Create `.env` file in project root

```env
MAIL_PASSWORD=your_gmail_app_password
NEWS_API_KEY=your_newsapi_key
```

### Step 3 — Create EmailJS config file

Create `src/main/resources/static/js/config.js`:

```javascript
const EMAILJS_PUBLIC_KEY = "your_public_key";
const EMAILJS_SERVICE_ID = "your_service_id";
const EMAILJS_TEMPLATE_ID = "your_template_id";
const EMAILJS_CONTACT_TEMPLATE_ID = "your_contact_template_id";
```

### Step 4 — Copy docker-compose example

```bash
cp docker-compose.example.yml docker-compose.yml
```

### Step 5 — Build and start containers

```bash
docker-compose up --build
```

### Step 6 — Open in browser

```
http://localhost:8080
```

### Useful Docker commands

```bash
# Run in background
docker-compose up --build -d

# View logs
docker-compose logs -f

# Stop containers
docker-compose down

# Stop and remove database volume
docker-compose down -v
```

---

## 📁 Project Structure

```
TaxGenie/
├── src/
│   ├── main/
│   │   ├── java/com/taxgenie/
│   │   │   ├── configuration/     # Security & filter config
│   │   │   ├── controller/        # MVC controllers
│   │   │   ├── model/             # Entity classes
│   │   │   ├── repository/        # JPA repositories
│   │   │   └── services/          # Business logic
│   │   │   └── dto/               # Data Transfer Object
│   │   └── resources/
│   │       ├── templates/         # Thymeleaf HTML templates
│   │       ├── static/            # CSS, JS, images
│   │       └── application.properties
├── Dockerfile
├── docker-compose.example.yml
├── pom.xml
└── README.md
```

---

## 🔐 Environment Variables

| Variable                      | Description                                     |
|-------------------------------|-------------------------------------------------|
| `DB_PASSWORD`                 | MySQL database password                         |
| `MAIL_PASSWORD`               | Gmail App Password for sending emails           |
| `NEWS_API_KEY`                | API key from newsapi.org                        |
| `EMAILJS_PUBLIC_KEY`          | EmailJS public key (frontend)                   |
| `EMAILJS_SERVICE_ID`          | EmailJS service ID (frontend)                   |
| `EMAILJS_TEMPLATE_ID`         | EmailJS callback template ID (frontend)         |
| `EMAILJS_CONTACT_TEMPLATE_ID` | EmailJS contact template ID (frontend)          |
| `GOOGLE_CLIENT_ID`            | Google client id for Sign in with Google        |
| `GOOGLE_CLIENT_SECRET_ID`     | Google client secret id for Sign in with Google |


---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Make your changes and commit: `git commit -m "Add your feature"`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 👨‍💻 Author

**Paras Jain**

[![GitHub](https://img.shields.io/badge/GitHub-ParasJain12-black?style=flat&logo=github)](https://github.com/ParasJain12)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-paras--jain--8103pj-blue?style=flat&logo=linkedin)](https://linkedin.com/in/paras-jain-8103pj)
[![Twitter](https://img.shields.io/badge/Twitter-parasjain8103-1DA1F2?style=flat&logo=twitter)](https://x.com/parasjain8103)
[![Medium](https://img.shields.io/badge/Medium-TheQuietLedger-black?style=flat&logo=medium)](https://medium.com/@TheQuietLedger)

**Manas Rathore**

[![GitHub](https://img.shields.io/badge/GitHub-manas--rathore-black?style=flat&logo=github)](https://github.com/manas-rathore)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-manas--rathore1-blue?style=flat&logo=linkedin)](https://linkedin.com/in/manas-rathore1)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 📬 Contact

For any queries, reach out at **parasjain8103@gmail.com** or use the [Contact Us](https://parasjain12.github.io/parasjain.github.io/) page on the website.

---

<p align="center">Made with ❤️ by Paras Jain</p>