# syntax=docker/dockerfile:1
FROM node:16.13-alpine as builder

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . ./
RUN npm run build

#RUN npm ci --only=production

#Stage 2

FROM nginx:1.19.0

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

#COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build .

EXPOSE 8080

ENTRYPOINT ["bash", "run-app.sh"]

#docker build -t planner:latest .
#docker run -p 3000:3000 planner:latest
#npm run-script build
#cd build/
#python3 -m http.server
