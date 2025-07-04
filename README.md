Шаги по запуску проекта

1. Склонировать проект  
   Скачайте репозиторий проекта с помощью следующей команды:

   git clone https://github.com/AlekSanVik47/cloud_new.git

2. Запустить Docker Compose  
   Если необходимо, запустите Docker с помощью файла compose.yaml:
   docker-compose -f compose.yaml up -d


3. Инициализация базы данных  
   Для настройки базы данных, таблиц и тестовых пользователей выполните следующие действия:

   • Для разработки используйте файл src/main/resources/init.sql.

   • Для тестового профиля используйте файл src/test/resources/init-test.sql.

   • Запустите changelog Liquibase для применения изменений в базе данных.

4. Доступ к API через Swagger  
   Откройте Swagger UI по следующему адресу:  
   http://localhost:8087/swagger-ui/index.html