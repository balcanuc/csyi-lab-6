#!/bin/bash

echo "echo after install" >> /tmp/csyi_log.txt
echo "working directory = $(pwd)" >> /tmp/csyi_log.txt
echo "date = $(date)" >> /tmp/csyi_log.txt
echo "whoami = $(whoami)" >> /tmp/csyi_log.txt
echo >> /tmp/csyi_log.txt

#java -jar /tmp/cloudshape-1.0.0.jar&
nohup sleep 60&
server_pid=$!
echo "Server PID=$server_pid"
echo -n $server_pid > /tmp/csyi.pid
sleep 10
