# 🧪 Practice Login Automation

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-Automation-green?logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-lightgreen?logo=cucumber)
![JUnit](https://img.shields.io/badge/JUnit-5-red?logo=junit5)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven)

---

## 💡 Descripción

**Practice Login Automation** es un proyecto de automatización de pruebas funcionales desarrollado con  
**Java + Selenium + Cucumber (BDD)**.  
El objetivo es demostrar la creación de un framework **limpio, mantenible y extensible**  
para pruebas de interfaz gráfica web, usando un flujo real:  
el **login** en la web de práctica [Practice Test Automation](https://practicetestautomation.com/practice-test-login/).

---

## 🧰 Tecnologías principales

| Componente | Versión / Detalle |
|-------------|-------------------|
| **Java** | 17 (JDK 17 recomendado) |
| **Selenium WebDriver** | 4.x |
| **Cucumber BDD** | 7.x |
| **JUnit** | 5 |
| **Maven** | 3.9+ |
| **Web** | [Practice Test Automation](https://practicetestautomation.com/) |

🧰 Tecnologías y herramientas usadas

Lenguaje: Java

Frameworks: Selenium, Cucumber (BDD con Gherkin)

Gestor de dependencias: Maven

IDE: IntelliJ IDEA 2024.3.1.1 (Community Edition)

Evidencias: Capturas automáticas por escenario

Ejecución: desde IntelliJ

---

## ⚙️ Estructura del proyecto

```
practice-login-automation/
│
├── src/
│ └── test/
│ ├── java/
│ │ ├── hooks/ # Configuración global (Before/After)
│ │ ├── pages/ # Page Objects
│ │ ├── steps/ # Step Definitions
│ │ └── support/ # Utilidades: Driver, Config, Evidence...
│ └── resources/
│ └── features/ # Archivos .feature (Gherkin)
│
├── pom.xml # Dependencias y configuración de Maven
└── 
```
💡 Resumen de carpetas clave:

hooks/ → contiene la configuración global (Before/After Hooks de Cucumber).

pages/ → implementa el patrón Page Object (cada página web tiene su clase).

steps/ → traduce los pasos Gherkin a código ejecutable.

support/ → utilidades generales (manejo del driver, capturas, configuración, etc.).

features/ → define los escenarios de prueba en lenguaje BDD (Gherkin).

---

## 🚀 Ejecución de pruebas

### ▶️ Desde la línea de comandos
```PowerShell
mvn clean
mvn -D"test=runners.CucumberTest" test
```

Para cambiar el navegador:
```PowerShell
mvn -D"test=runners.CucumberTest" -D"browser=firefox" test
```



