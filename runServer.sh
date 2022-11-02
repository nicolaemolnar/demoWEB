#!/bin/bash

# Run backend server
cd ~/appPracticas_back/
mvn spring-boot:run > /tmp/spring_log &

# Run frontend server
cd ~/appPracticas_front/
ng serve > /tmp/angular_log &
