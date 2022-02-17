# syntax=docker/dockerfile:1
FROM node:16.13-alpine as builder

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . ./
RUN npm run build

#RUN npm ci --only=production

#Stage 2
#######################################
#pull the official nginx:1.19.0 base image
FROM nginx:1.19.0
#copies React to the container directory
# Set working directory to nginx resources directory
WORKDIR /usr/share/nginx/html
# Remove default nginx static resources
RUN rm -rf ./*
# Copies static resources from builder stage
#COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build .
# Containers run nginx with global directives and daemon off
EXPOSE 8080
CMD [ "/bin/bash", "-c", "sudo nginx -g 'daemon off;'" ]

#docker build -t planner:latest .
#docker run -p 3000:3000 planner:latest
#npm run-script build
#cd build/
#python3 -m http.server
