# Employees backend

## Scope
- App stores **Employess** (id / first name / last name / min allowed temperature / max allowed termperature) in DB;
  **CRUD** operations are available on Products via REST endpoint,
- It enables sending **Measurements** (product / temperature / measurement type) via REST endpoint,
- When recorded, **measurements are marked** as OK (inside allowed temperature range) or NOT OK,
- **Measurements history** for last 10 days is available via REST endpoint. 
	
## Running
- build & run *or*
- docker-compose build & docker-compose up

## Usage
- http://127.0.0.1:8480/api/v1/swagger-ui.html
- http://127.0.0.1:8480/api/v1/v3/api-docs

- http://127.0.0.1:8480/api/v1/employess
- http://127.0.0.1:8480/api/v1/employe/1
- http://127.0.0.1:8480/api/v1/history
- http://127.0.0.1:8480/api/v1/product_measurement

