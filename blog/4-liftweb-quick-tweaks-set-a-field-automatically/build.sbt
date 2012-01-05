// see https://github.com/siasia/xsbt-web-plugin for more information on the
// jetty plugin

// import web settings
seq(webSettings :_*)

name := "taxi"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "net.liftweb" % "lift-mapper_2.9.1" % "2.4-RC1" % "compile",
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile",
  "org.apache.httpcomponents" % "httpclient" % "4.1.2" % "compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "org.eclipse.jetty" % "jetty-servlets" % "8.0.1.v20110908" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "com.h2database" % "h2" % "1.2.138" % "container",
  "mysql" % "mysql-connector-java" % "5.1.18" % "container"
)
