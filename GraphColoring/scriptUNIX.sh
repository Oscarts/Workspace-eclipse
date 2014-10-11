#!/bin/bash

#To execute the script :
# move this file in the folder containing the project
# run, in a terminal, the command : sh scriptUNIX.sh

#You can add the argument "-g" in the command line to add the visualization

rm -f result.txt
rm -f err.txt

for i in ./data/*;do
	sleep 1;
	java  Solver -t 60 $"-file="$i >> result.txt 2>> err.txt &
done
