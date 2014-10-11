#!/bin/sh
# inicio....


for F in ./instances/*.tsp
do
    java Main $F -t 60
done
