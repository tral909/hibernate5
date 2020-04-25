plugins { 
  java
  eclipse
}

allprojects {
   group = "it.discovery"
}

subprojects {  
   apply(plugin = "java")

   java.sourceCompatibility = JavaVersion.VERSION_13
   java.targetCompatibility = JavaVersion.VERSION_13

   repositories {
     jcenter()
   }
   
   dependencies {
        val hibernateVersion : String by project
        compile("org.hibernate:hibernate-core:$hibernateVersion")
        runtime("org.hsqldb:hsqldb:2.4.1")
        runtime("com.h2database:h2:1.4.200")
        runtime("mysql:mysql-connector-java:8.0.19")
        runtime("org.postgresql:postgresql:42.2.12")                

        compileOnly("org.projectlombok:lombok:1.18.12")
        annotationProcessor("org.projectlombok:lombok:1.18.12")
   } 
}

