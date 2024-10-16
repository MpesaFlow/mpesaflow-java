import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.get
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    signAllPublications()
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    this.coordinates(project.group.toString(), project.name, project.version.toString())

    pom {
        name.set("MpesaFlow API")
        description.set("API for managing MpesaFlow transactions, applications, and API keys")
        url.set("https://docs.mpesaflow.com")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("Mpesaflow")
                email.set("support@mpesaflow.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/Mpesaflow/mpesaflow-java.git")
            developerConnection.set("scm:git:git://github.com/Mpesaflow/mpesaflow-java.git")
            url.set("https://github.com/Mpesaflow/mpesaflow-java")
        }
    }
}
