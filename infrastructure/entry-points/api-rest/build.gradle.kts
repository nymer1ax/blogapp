dependencies {
	implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation(project(":usecase"))
    implementation(project(":model"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}


configurations{
	configurations {
	all {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
	}
}
}