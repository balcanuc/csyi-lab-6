#!/bin/bash
java -jar ./target/cloudshape-1.0.0.jar&
server_pid=$!
echo "Server PID=$server_pid"
echo -n $server_pid > /tmp/csyi.pid
sleep 20

kill_pid=$(cat /tmp/csyi.pid)
echo "killing PID $kill_pid"
kill $kill_pid
