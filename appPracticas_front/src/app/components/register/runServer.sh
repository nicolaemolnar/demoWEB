#!/bin/bash

# Run backend server
cd ~/apppracticas_back/
mvn spring-boot:run > /tmp/spring_log &

# Run frontend server
cd ~/apppracticas_front/
ng serve > /tmp/angular_log &