# Estacionamento API 🚀

## About 📘

![Gif-1](https://github.com/KaueSanchesG/Desafio-api/assets/95658722/b13f1d83-2b8c-4757-bd82-54846d462370)

This project is separated in 2 parts, the [front end](https://github.com/KaueSanchesG/estacionamento_client) and the back end (this repo), in resume it's a parking lot application made with spring boot in the back and Vue.js in as the front framework. The main goal were to make it an API Rest so the client could inject data in it and extract in the same way.

## Status ✅

This project has been completed but it surely have to be improved, I'll do a list of upgradable itens right below:

* Implement the @Validate annotation instead of using if conditions in easy validations
* Add the Delete methods to the service and clean the controllers
* Apply clean code in the service package, I know it is a little messy lmao
* Re-do the config package in the right way
* Review the repository package

## How to use 📋

As said earlier, this project is divided in 2 parts so if you want to see it 100% working you need to check the [estacionamento_client](https://github.com/KaueSanchesG/estacionamento_client) repo, or you can just run the backend and test the endpoints with postman (it's cooler when working 100% so you can see it in your browser).
For running the back end, you'll need a Java IDE and a database to run. I'm using **[IntelliJ](https://www.jetbrains.com/idea/)** as the IDE and **[PostgreSQL](https://www.postgresql.org/)** as the database (you'll need to open pgAdmin4 and create a database called "estacionamento" and a schema called "estacionamento" inside the "estacionamento" database, you'll also need a audit schema for the @Audited annotation).

Next, follow this code sequence in your local directory:

```bash
# Clone the repository
git clone https://github.com/KaueSanchesG/Estacionamento_API.git

# Open the IDE by typing
idea
After that, navigate to the directory where you've cloned the project and open it.
```

To run the project, open **src/java/br.com.uniamerica.estacionamento/EstacionamentoApplication** file and click the run button or use the shortcut Shift+F10.
## Technologies 🛠️

|      Technology      | Version |
|:--------------------:|:-------:|
| SpringFramework Boot |  3.0.4  |
|         Java         |   19    |
|       Hibernate      |  6.1.7  |
