plugins {
    kotlin("jvm") version "1.6.0"
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    kotlin("stdlib-jdk8")
}

kotlin {
    explicitApi()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest()
        }
    }
}
