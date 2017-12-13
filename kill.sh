docker-compose down
docker rm appcore -f
docker rmi ejb-core

# parar app jsf

#docker stop appjsf
docker rm appjsf -f
docker rmi ejb-jsf
