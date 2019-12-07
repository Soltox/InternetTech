# Bonus Points Pascal Schaller FT2A

This is a documentation about the bonus project of the module Internet Technology.



#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [Use Case](#use-case)
- [Design](#design)
  - [Endpoint Prototype](#endpoint-prototype)
  - [Data Access / Persistence Layer](#data-access--persistence-layer)
  - [Business Layer](#business-layer)
  - [Service Layer / API](#service-layer--api)
- [Deployment](#deployment)

## Analysis

### Scenario

A little football association kept track of their leagues on an Excel Sheet. This led to inconsistency in the data. Neither was it possible to communicate to different football associations digitally, which is a requirement for participating in bigger tournaments. A solution is wished, where the different services can be accessed via different interfaces and which is accessible and consistent all the time.

### Use Case
![](images/Football.jpg)
- UC01 [Login on A-CRM]: Agents can log-in by entering an email address and password. As an extension, new agents my register first.
- UC-2 [Register on A-CRM]: Agents can register to get an account (profile) to access the A-CRM system.
- UC-3 [Edit a customer]: Agents can create, update and delete customers.
- UC-4 [Show a customer list]: Agents can get an overview over their customers based on a customer list. As an extension they can create, update and delete customers (UC-3).

## Design

### Endpoint Prototype
**Path**: [`/api/customer`](/api/customer) 

**Method:** `POST`

**Sample Request**  • *Header:* `Content-Type: application/json` • *Body:*

```JSON
{
  "agent": {
    "customers": [
      null
    ],
    "email": "string",
    "id": 0,
    "name": "string",
    "password": "string",
    "remember": "string"
  },
  "email": "string",
  "id": 0,
  "mobile": "string",
  "name": "string"
}
```

• *Optional:* `...`
  
**Success Response**  • *Code:* `200 OK` • *Sample Body:*

```JSON
{
  "agent": {
    "customers": [
      null
    ],
    "email": "string",
    "id": 0,
    "name": "string",
    "password": "string",
    "remember": "string"
  },
  "email": "string",
  "id": 0,
  "mobile": "string",
  "name": "string"
}
```

**Error Response** • *Code:* `404 NOT FOUND`

### Data Access / Persistence Layer

The `rocks.process.acrm.data.domain` package contains the following domain objects / entities including getters and setters:

![](images/A-CRM-Domain-Model.png)

This would be the ERD representation of the domain model:

![](images/A-CRM-ERD.png)

### Business Layer

The `rocks.process.acrm.business.service` package contains classes of the following business services:

![](images/business-service.png)


### Service Layer / API

On the service layer, the API for customer management has been realised using the REST style as depicted in the following:

![](images/api-endpoint-vp.png)

Further can be seen using the Swagger-UI.

## Deployment

This spring boot application can be deployed to Heroku by adding the following `Procfile` to the project root:
```console
web: java -Dserver.port=$PORT $JAVA_OPTS -jar /target/*.jar
```

Finally the Swagger-UI can be access using the Heroku app specific address such as: `https://***.herokuapp.com/swagger-ui.html`
