# Concurrent Banking Transaction Processor (Java Multithreading)

![Java](https://img.shields.io/badge/Java-Multithreading-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Apache_Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![UI](https://img.shields.io/badge/GUI-Java_Swing-2563EB?style=flat-square)

## Executive Summary

A **Java & Apache Maven** desktop application built for *Advanced Programming I* at **Universidad Tecnológica de Honduras (UTH)** demonstrating **asynchronous multithreaded execution**, safe concurrent balance updates, custom domain exception handling, and non-blocking Swing UI updates.

---

## Engineering Highlights

- **Concurrent Transaction Processing:** Executes account operations asynchronously off the Event Dispatch Thread (EDT) to prevent UI freezing.
- **Domain Modeling & Custom Exceptions:**
  - `Modelo/CuentaBancaria.java` encapsulates account state and thread-safe transaction logic.
  - `Excepciones/SaldoInsuficienteException.java` enforces strict domain invariants when withdrawal amounts exceed available balance.
- **Interactive Desktop Interface:** `frontend/TransaccionForm.java` provides real-time feedback on concurrent transactions.

---

## Project Structure

```text
ProcesamientoAsinconoPAI/
├── pom.xml
└── src/main/java/
    ├── Excepciones/SaldoInsuficienteException.java
    ├── Modelo/CuentaBancaria.java
    ├── frontend/TransaccionForm.java
    └── com/mycompany/procesamientoasincrono/ProcesamientoAsincrono.java
```

---

## Getting Started

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.mycompany.procesamientoasincrono.ProcesamientoAsincrono"
```

---

## Author & Contact

**Héctor Joann Murillo Mejía** — Mobile & Full-Stack Software Engineer (React Native · TypeScript · Node.js)

- **Email:** [joannmurillo@icloud.com](mailto:joannmurillo@icloud.com)
- **LinkedIn:** [linkedin.com/in/hector-joann-murillo-mejia](https://www.linkedin.com/in/hector-joann-murillo-mejia/)
- **GitHub:** [github.com/jomudev](https://github.com/jomudev)
- **Portfolio:** [joannmurillo.com](https://www.joannmurillo.com)
