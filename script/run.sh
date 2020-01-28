export PGPASSWORD=postgres
psql -h 127.0.0.1 -p 5432 -U postgres -d postgres -a -w -f create-db.sql
