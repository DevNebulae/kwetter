# Kwetter
:rooster: De S62 Twitter clone gemaakt met Spring Boot en Docker.

## Setup

### Keycloak
* `docker-compose up -d` to start the containers.
* Create a new realm with the name `kwetter`.
* Create a new client with the name `kwetter-app`.
* Create three roles: `user`, `moderator` and `administrator`.
* Turn on user registration.
