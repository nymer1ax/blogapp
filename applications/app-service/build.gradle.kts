apply(plugin = "org.springframework.boot")

dependencies {
	implementation(project(":api-rest"))
	implementation("org.reactivecommons.utils:object-mapper:0.1.0")
	implementation(project(":jpa-repository"))
    implementation(project(":model"))
    implementation(project(":usecase"))
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.getByName<Jar>("jar") {
    // To disable the *-plain.jar
    enabled = false
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    // Sets output jar name
    archiveFileName.set("${project.parent?.name}.${archiveExtension.get()}")}