plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
    pmd
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:all,-serial")
}

javafx {
    version = "21"
    modules("javafx.controls")
}

application {
    mainClass = "edu.curtin.filesearcher.FileSearcher"
}

pmd {
    setConsoleOutput(true)
    toolVersion = "7.26.0"
    rulesMinimumPriority = 5
    ruleSets = listOf()
    ruleSetFiles = files("saed-pmd-rules.xml")
}
