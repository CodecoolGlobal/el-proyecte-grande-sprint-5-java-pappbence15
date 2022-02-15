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
#npm run-script build
#cd build/
#python3 -m http.server
