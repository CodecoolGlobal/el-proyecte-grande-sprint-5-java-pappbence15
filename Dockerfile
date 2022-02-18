# syntax=docker/dockerfile:1
FROM node:16.13-alpine as builder

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . ./
RUN npm run build

FROM nginx:1.19.0

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

RUN rm -rf /etc/nginx/sites-enabled/default

COPY ./cutom_server.conf /etc/nginx/sites-available/

COPY --from=builder /app/build .

ENTRYPOINT ["nginx", "-g", "daemon off;"]

#docker build -t planner:latest .
#docker run -p 3000:3000 planner:latest
#npm run-script build
#cd build/
#python3 -m http.server
