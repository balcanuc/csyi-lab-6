#!/bin/bash

echo "echo application-stop" >> /tmp/csyi_log.txt
echo "working directory = $(pwd)" >> /tmp/csyi_log.txt
echo "date = $(date)" >> /tmp/csyi_log.txt
echo "whoami = $(whoami)" >> /tmp/csyi_log.txt
echo >> /tmp/csyi_log.txt


kill_pid=$(cat /tmp/csyi.pid)
echo "killing PID $kill_pid"
kill $kill_pid
exit 0