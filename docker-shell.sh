#!/usr/bin/env bash
export IMAGE_NAME=$1
export USER_ID=$2
export PSWD=$3
echo $PSWD | docker login -u $USER_ID --password-stdin
docker-compose -f docker-compose.yaml up --detach
echo "success  in running docker compose"