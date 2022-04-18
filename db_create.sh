#!/usr/bin/env bash
psql postgres -c "CREATE USER ram WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION PASSWORD 'password'"
psql postgres -c "CREATE DATABASE quizzical_db WITH OWNER = ram ENCODING = 'UTF8' CONNECTION LIMIT = -1;"
psql quizzical_db -f db/questions-table.sql