# Real Estate Microservice

## Setup

```bash
docker-compose up -d
```

Then you need to create a custom schema, in order to do this you need to get into the bash of the postgres container:

```bash
docker exec -it realEstateDB bash
```

Then you need to get into the postgres console:

```bash
psql -d real_estate -U admin
```

Then you need to create the schema:

```bash
CREATE SCHEMA sc_estate
AUTHORIZATION admin;
```
