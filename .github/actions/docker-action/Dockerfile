FROM alpine:3.19

# Install dependencies
RUN apk add --no-cache bash

# Copy your script
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]