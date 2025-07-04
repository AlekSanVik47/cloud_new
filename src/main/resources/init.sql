-- Создание базы данных
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'cloud-db') THEN
            EXECUTE 'CREATE DATABASE "cloud-db"';
        END IF;
    END $$;

-- Создание роли
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'cloud-storage') THEN
            CREATE ROLE "cloud-storage" WITH LOGIN PASSWORD 'cloud-storage';
        END IF;
    END $$;

-- Установка прав для роли
GRANT ALL PRIVILEGES ON DATABASE "cloud-db" TO "cloud-storage";

-- Создание схемы
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = 'cloud_schema') THEN
            CREATE SCHEMA cloud_schema;
        END IF;
    END $$;

-- Предоставление прав на схему
GRANT ALL PRIVILEGES ON SCHEMA cloud_schema TO "cloud-storage";