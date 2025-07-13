# Dockerfile for board-ui (Vue 3 + Vite frontend)
FROM node:20-alpine as build
WORKDIR /app
COPY board-ui/package.json board-ui/package-lock.json ./
RUN npm install
COPY board-ui/ ./
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY board-ui/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
