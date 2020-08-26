#!/bin/bash

find -name *.java > sources.txt
javac @sources.txt
java simulator.Simulator $1