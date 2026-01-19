#!/bin/bash
set -e

echo "Running Spring Boot Gradle build..."

# GitHub automatically mounts the repo at /github/workspace
cd /github/workspace

# Validate wrapper (recommended by Spring team)[ B](https://github.com/spring-io/spring-gradle-build-action?copilot_analytics_metadata=eyJldmVudEluZm9fY2xpY2tTb3VyY2UiOiJjaXRhdGlvbkxpbmsiLCJldmVudEluZm9fY29udmVyc2F0aW9uSWQiOiJ0dURTNDNjdW9ON0xmWkQ3RjdhdHciLCJldmVudEluZm9fbWVzc2FnZUlkIjoib3prbTFlREJIa1VteXd2MW5WYmhyIiwiZXZlbnRJbmZvX2NsaWNrRGVzdGluYXRpb24iOiJodHRwczpcL1wvZ2l0aHViLmNvbVwvc3ByaW5nLWlvXC9zcHJpbmctZ3JhZGxlLWJ1aWxkLWFjdGlvbiJ9&citationMarker=9F742443-6C92-4C44-BF58-8F5A7C53B6F1)
./gradlew wrapper --gradle-version 8.7

# Build Spring Boot app
./gradlew clean build --no-daemon

echo "Build completed."

# Expose artifact path for workflow
ARTIFACT_PATH=$(find build/libs -name "*.jar" | head -n 1)
echo "artifact_path=$ARTIFACT_PATH" >> $GITHUB_OUTPUT