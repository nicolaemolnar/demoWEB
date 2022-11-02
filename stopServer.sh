#!/bin/bash

# Stop backend server 
killall "java"

# Stop frontend server
kill -9 $(ps | grep "ng server" | cut -d " " -f 3)

