FROM alpine
RUN apk add nginx
#RUN ngix
CMD ["nginx", "-g", "daemon off;"]
EXPOSE 80
#COPY C:/users/xxx/17349/despliegue /var/lib/nginx/html
COPY ./despliegue /var/lib/nginx/html
COPY ./rafael.conf /etc/nginx/http.d/default.conf