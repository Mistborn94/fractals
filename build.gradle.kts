plugins {
    kotlin("js") version "1.3.50"
}

group = "za.org.renette.demos.kotlin-js-demo"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin.target.browser {
}


