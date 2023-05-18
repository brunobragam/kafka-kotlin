import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.serialization") version "1.4.21" // <-- (1)
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka
	implementation("org.springframework.kafka:spring-kafka:3.0.7")

	// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
	implementation("org.apache.kafka:kafka-streams:3.4.0")

	// https://mvnrepository.com/artifact/org.apache.avro/avro
	implementation("org.apache.avro:avro:1.11.1")

	// https://mvnrepository.com/artifact/io.confluent/kafka-avro-serializer
	implementation("io.confluent:kafka-avro-serializer:5.3.0")

	// https://mvnrepository.com/artifact/io.confluent/kafka-streams-avro-serde
	implementation("io.confluent:kafka-streams-avro-serde:7.3.3")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}



java.sourceSets["main"].java.srcDir("$buildDir/generated-main-avro-java")
java.sourceSets["test"].java.srcDir("$buildDir/generated-test-avro-java")