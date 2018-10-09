#!/bin/bash

docker build -t templebase:latest .
docker tag templebase:latest localhost:5000/templebase:latest
docker push localhost:5000/templebase:latest
