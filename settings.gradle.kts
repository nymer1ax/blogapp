rootProject.name = "blogapp"

include(":app-service")
include(":model")
include(":usecase")
project(":app-service").projectDir = file("./applications/app-service")
project(":model").projectDir = file("./domain/model")
project(":usecase").projectDir = file("./domain/usecase")
include(":jpa-repository")
project(":jpa-repository").projectDir = file("./infrastructure/driven-adapters/jpa-repository")
include(":api-rest")
project(":api-rest").projectDir = file("./infrastructure/entry-points/api-rest")