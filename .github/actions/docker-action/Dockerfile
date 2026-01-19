FROM eclipse-temurin:21-jdk

# Install tools
RUN apt-get update && apt-get install -y bash unzip

# Set workdir
WORKDIR /workspace

# Copy entrypoint
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]