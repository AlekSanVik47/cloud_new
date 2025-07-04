-- Создание базы данных
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'cloud-db-test') THEN
            EXECUTE 'CREATE DATABASE "cloud-db-test"';
        END IF;
    END $$;

-- Создание роли
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'test-user') THEN
            CREATE ROLE "test-user" WITH LOGIN PASSWORD 'test-user';
        END IF;
    END $$;

-- Установка прав для роли
GRANT ALL PRIVILEGES ON DATABASE "cloud-db-test" TO "test-user";

-- Создание схемы
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = 'cloud_test_schema') THEN
            CREATE SCHEMA cloud_test_schema;
        END IF;
    END $$;

-- Предоставление прав на схему
GRANT ALL PRIVILEGES ON SCHEMA cloud_test_schema TO "test-user";