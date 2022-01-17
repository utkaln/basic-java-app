#!/usr/bin/env bash
export IMAGE_NAME=$1
docker-compose -f docker-compose.yaml up --detach
echo "success  in running docker compose"