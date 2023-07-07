USER-API

<b>pre-requisitos</b>:

Instalar docker en Ubuntu 20.04, seguir los paso que están en el siguiente link: https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-22-04

--------------------------------------------------------

<b>Como iniciar la aplicacion</b>

ejecutar el siguiente commando en consola de linux:

    docker-compose up -d

para ver log de los servidores y monitorizar, ejecute el siguiente comando:

    docker logs -f --tail 10000 mygamemmo-be-spring-container
