# Estacionamento API 🚀

## About 📘

![Gif-2](https://github.com/KaueSanchesG/Estacionamento_API/assets/95658722/2b19e31f-a88e-4cac-ada8-896a2385b453)

This project is divided into 2 parts: the [front end](https://github.com/KaueSanchesG/estacionamento_client) and the back end (this repository). In short, it's a parking lot application made with Spring Boot in the back end and Vue.js as the front-end framework. The main goal was to create a REST API so the client could interact with it and extract data in the same way.

## Status ✅

This project has been completed, but there is still room for improvement. Below is a list of upgradable items:

* Implement the `@Validate` annotation instead of using `if` conditions for easy validations.
* Add the Delete methods to the service and clean up the controllers.
* Apply clean code principles to the service package; I know it is a little messy, lmao.
* Re-do the config package in the right way.
* Review the repository package.

## How to use 📋

As mentioned earlier, this project is divided into 2 parts. If you want to see it 100% working, you need to check the [estacionamento_client](https://github.com/KaueSanchesG/estacionamento_client) repository. Alternatively, you can just run the backend and test the endpoints with Postman (it's cooler when working 100% so you can see it in your browser). For running the back end, you'll need a Java IDE and a database to run. I'm using **[IntelliJ](https://www.jetbrains.com/idea/)** as the IDE and **[PostgreSQL](https://www.postgresql.org/)** as the database (you'll need to open pgAdmin4 and create a database called "estacionamento" and a schema called "estacionamento" inside the "estacionamento" database, you'll also need an audit schema for the `@Audited` annotation).

Next, follow this code sequence in your local directory:

```bash
# Clone the repository
git clone https://github.com/KaueSanchesG/Estacionamento_API.git

# Open the IDE by typing
idea
# After that, navigate to the directory where you've cloned the project and open it.
```

To run the project, open **src/java/br.com.uniamerica.estacionamento/EstacionamentoApplication** file and click the run button or use the shortcut Shift+F10.
## Technologies 🛠️

|      Technology      | Version |
|:--------------------:|:-------:|
| SpringFramework Boot |  3.0.4  |
|         Java         |   19    |
|       Hibernate      |  6.1.7  |
