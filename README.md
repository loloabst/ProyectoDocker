# 🐳 Instrucciones para levantar el proyecto con Docker

1. Clona el repositorio:
   ```bash
   git clone https://github.com/loloabst/ProyectoDocker.git
   cd ProyectoDocker
   ```

2. Levanta los contenedores:
   ```bash
   docker compose up 
   ```

3. Accede a la aplicación:
   - API REST base: `http://localhost:8081/api/v1/proyectos/`

---


## 📮 Uso de Postman para probar la API

Puedes usar Postman para enviar solicitudes REST:

- `GET http://localhost:8081/api/v1/proyectos/` – Obtener todos los proyectos
- `GET http://localhost:8081/api/v1/proyectos/1` – Obtener proyecto por ID
- `POST http://localhost:8081/api/v1/proyectos/` – Crear nuevo proyecto (usa JSON)
- `PUT http://localhost:8081/api/v1/proyectos/1` – Reemplazar proyecto
- `PATCH http://localhost:8081/api/v1/proyectos/1` – Actualización parcial
- `DELETE http://localhost:8081/api/v1/proyectos/1` – Eliminar proyecto

