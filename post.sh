#!/usr/bin/env bash
curl localhost:3000/questions -X POST -H "Content-Type: application/json" -d $1