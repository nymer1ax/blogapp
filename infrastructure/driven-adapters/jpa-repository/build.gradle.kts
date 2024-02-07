dependencies {
    implementation(project(":model"))


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.reactivecommons.utils:object-mapper-api:0.1.0")

    runtimeOnly("com.h2database:h2")
    testImplementation("org.reactivecommons.utils:object-mapper:0.1.0")
}
