# get nginx
FROM nginx
# remove existing nginx conf file
RUN rm /etc/nginx/conf.d/default.conf
# copy user defined nginx conf file
COPY nginx.conf /etc/nginx/conf.d/default.conf