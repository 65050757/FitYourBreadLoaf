# Use a base image with Java (JRE or JDK) pre-installed
FROM openjdk:11

# Install X11 utilities
RUN apt-get update && apt-get install -y x11-apps

# Set the DISPLAY environment variable
ENV DISPLAY=host.docker.internal:0

# Create a directory for your JAR file and copy it to the container
WORKDIR /app
COPY fityourpan.jar .

# Command to run your GUI application
CMD ["java", "-jar", "fityourpan.jar"]
