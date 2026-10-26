# Lab 6 – Calculator REST API

Service REST Spring Boot (Kotlin) qui fait les quatre opérations de base, avec la documentation OpenAPI générée par springdoc.

## Routes

| Méthode | Route | Exemple |
|---|---|---|
| GET | `/calculator/add/{a}/{b}` | `/calculator/add/10/2` → `12.0` |
| GET | `/calculator/subtract/{a}/{b}` | `/calculator/subtract/10/2` → `8.0` |
| GET | `/calculator/multiply/{a}/{b}` | `/calculator/multiply/10/2` → `20.0` |
| GET | `/calculator/divide/{a}/{b}` | `/calculator/divide/10/2` → `5.0` |

Une division par zéro renvoie `400 Bad Request`.

## Lancer le projet

Prérequis : JDK 21.

```bash
git clone https://github.com/SEG3502Lab/Lab6_Calculator-Api.git
cd Lab6_Calculator-Api
./gradlew bootRun        # Windows : gradlew.bat bootRun
```

Le serveur démarre sur http://localhost:8080.

- Swagger UI : http://localhost:8080/swagger-ui.html
- OpenAPI JSON : http://localhost:8080/v3/api-docs
- OpenAPI YAML : http://localhost:8080/v3/api-docs.yaml

## Tests

```bash
./gradlew test
```
