# syntax=docker/dockerfile:1
FROM node:16.13-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

#RUN npm ci --only=production

COPY ./src /app

EXPOSE 3000

CMD ["npm", "start"]
#docker build -t planner:latest .
#docker run -p 3000:3000 planner:latest
#npm run-script build
#cd build/
#python3 -m http.server
