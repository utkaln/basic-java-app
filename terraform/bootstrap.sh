#!/bin/bash
sudo yum update -y && sudo yum install -y docker
sudo service docker start
sudo usermod -aG docker ec2-user

# install docker compose
sudo curl -L "https://github.com/docker/compose/releases/download/v1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod 755 /usr/local/bin/docker-compose
sudo docker-compose version

