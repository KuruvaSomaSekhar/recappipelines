#!/bin/bash
echo $@
echo $#

IPs=$(echo $@ | tr "," "\n")
for ip in $IPs
do
echo "My IP is: $ip"
done

# IN="bla@some.com;john@home.com"

# mails=$(echo $IN | tr ";" "\n")

# for addr in $mails
# do
#     echo "> [$addr]"
# done