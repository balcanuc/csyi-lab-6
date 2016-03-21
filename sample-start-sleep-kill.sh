#!/bin/bash
java -jar ./target/cloudshape-1.0.0.jar&
SERVER_PID=$!
echo "Server PID=$SERVER_PID"
sleep 20
echo "killing PID $SERVER_PID"
kill $SERVER_PID