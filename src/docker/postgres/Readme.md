## Create instance of postgres

### background
docker run -d --name postgres_16 \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v ./src/docker/postgres/data:/var/lib/postgresql/data \
    -p 5433:5432 postgres:16

### mode interactive
docker run -it --name postgres_16 \
    -e POSTGRES_PASSWORD=mysecretpassword \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v ./src/docker/postgres/data:/var/lib/postgresql/data \
    -p 5433:5432 postgres:16

## view logs

docker logs -f postgres_16

## stop container

docker stop postgres_16

## start container

docker start postgres_16

## delete container

docker rm postgres_16

Note: avant de supprimer un container il faut l'arreter sinon on peut utiliser la commande docker rm -f pour forcer la suppression d'un container demarré

docker rm -f postgres_16


## start container using docker compose
docker compose -f src/docker/postgres/docker-compose.yml up
