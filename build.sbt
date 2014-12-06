val commonSettings = Seq(
  organization := "org.scalajs",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.2",
  normalizedName ~= { _.replace("scala-js", "scalajs") },
  scalacOptions ++= Seq(
    "-deprecation",           
    "-encoding", "UTF-8",
    "-feature",                
    "-unchecked",
    "-language:reflectiveCalls",
    "-Yno-adapted-args",       
    "-Ywarn-numeric-widen",   
    "-Xfuture",
    "-Xlint"
  )
)

lazy val root = project.in(file("."))
  .settings(commonSettings: _*)
  .aggregate(transportJavascript, transportNetty, /*transportPlay,*/ transportTyrus,
    transportAutowireJs, transportAutowireJvm)


// Transport

val transportShared = commonSettings ++ Seq(
  unmanagedSourceDirectories in Compile += baseDirectory.value / "../shared")

lazy val transportJavascript = project.in(file("transport/javascript"))
  .enablePlugins(ScalaJSPlugin)
  .settings(transportShared: _*)
  .settings(libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.7.0"))

lazy val transportNetty = project.in(file("transport/netty"))
  .settings(transportShared: _*)
  .settings(libraryDependencies ++= Seq(
    "io.netty" % "netty-all" % "4.0.24.Final"))

lazy val transportPlay = project.in(file("transport/play"))
  .settings(transportShared: _*)
  .settings(libraryDependencies ++= Seq(
    "com.github.fdimuccio" %% "play2-sockjs" % "0.3.0",
    "com.typesafe.akka" %% "akka-actor" % "2.3.6",
    "com.typesafe.play" %% "play" % "2.3.5"))

lazy val transportTyrus = project.in(file("transport/tyrus"))
  .settings(transportShared: _*)
  .settings(libraryDependencies ++= Seq(
    "org.glassfish.tyrus.bundles" % "tyrus-standalone-client" % "1.8.3"))


val autowireShared = transportShared ++ Seq(
  unmanagedSourceDirectories in Compile += baseDirectory.value / "../autowire",
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "upickle" % "0.2.6-M1",
    "com.lihaoyi" %%% "autowire" % "0.2.4-M1"))

lazy val transportAutowireJs = project.in(file("transport/autowirejs"))
  .enablePlugins(ScalaJSPlugin)
  .settings(autowireShared: _*)

lazy val transportAutowireJvm = project.in(file("transport/autowirejvm"))
  .settings(autowireShared: _*)
  .settings(
    resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"
  )



lazy val playTwoBrowsersTest = project.in(file("transport/playTwoBrowsersTest"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala)
  .settings(libraryDependencies ++= Seq(
    "org.seleniumhq.selenium" % "selenium-java" % "2.43.1",
    "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.0.4" % "test"))
  
lazy val transportTest = project.in(file("transport/test"))
  .settings(commonSettings: _*)
  .dependsOn(transportNetty)
  .dependsOn(transportTyrus)
  .settings(libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"))


// Examples

lazy val examples = project.settings(commonSettings: _*).aggregate(
    transportTest, chatWebSocket, chatWebSocketJs, chatWebRTC, chatWebRTCJs, autowire, autowireJs)

parallelExecution in Global := false

val playWithScalaJs = Seq(
  unmanagedSourceDirectories in Compile += baseDirectory.value / "../shared",
  unmanagedResourceDirectories in Compile += baseDirectory.value / "../js/src")

def scalaJsOfPlayProject(p: Project) = Seq(
  unmanagedSourceDirectories in Compile += (baseDirectory in p).value / "../shared",
  fastOptJS in Compile <<= (fastOptJS in Compile) triggeredBy (compile in (p, Compile)),
  crossTarget in (Compile, fastOptJS) := (baseDirectory in p).value / "public/javascripts",
  crossTarget in (Compile, fullOptJS) := (baseDirectory in p).value / "public/javascripts")


lazy val webRTCExample = project.in(file("examples/webrtc"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings: _*)
  .dependsOn(transportJavascript)


lazy val autowire = project.in(file("examples/autowire/jvm"))
  .enablePlugins(PlayScala)
  .settings((commonSettings ++ playWithScalaJs): _*)
  .dependsOn(transportPlay, transportAutowireJvm, playTwoBrowsersTest % "test->test")
  .settings(libraryDependencies ++= Seq(
    "org.webjars" % "sockjs-client" % "0.3.4",
    "org.webjars" %% "webjars-play" % "2.3.0",
    "org.webjars" % "bootstrap" % "3.2.0"))

lazy val autowireJs = project.in(file("examples/autowire/js"))
  .settings((commonSettings ++ scalaJsOfPlayProject(autowire)): _*)
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(transportJavascript, transportAutowireJs)
  .settings(libraryDependencies ++= Seq(
    "com.scalatags" %%% "scalatags" % "0.4.0"))


lazy val chatWebSocket = project.in(file("examples/chat-websocket/jvm"))
  .enablePlugins(PlayScala)
  .settings((commonSettings ++ playWithScalaJs): _*)
  .dependsOn(transportPlay, playTwoBrowsersTest % "test->test")
  .settings(libraryDependencies ++= Seq(
    "org.webjars" %% "webjars-play" % "2.3.0",
    "org.webjars" % "sockjs-client" % "0.3.4",
    "org.webjars" % "jquery" % "2.1.1"))

lazy val chatWebSocketJs = project.in(file("examples/chat-websocket/js"))
  .enablePlugins(ScalaJSPlugin)
  .settings((commonSettings ++ scalaJsOfPlayProject(chatWebSocket)): _*)
  .dependsOn(transportJavascript)
  .settings(libraryDependencies ++= Seq(
    "org.scala-lang.modules.scalajs" %%% "scalajs-jquery" % "0.6"))


lazy val chatWebRTC = project.in(file("examples/chat-webrtc/jvm"))
  .enablePlugins(PlayScala)
  .dependsOn(transportPlay, playTwoBrowsersTest % "test->test")
  .settings((commonSettings ++ playWithScalaJs): _*)
  .settings(libraryDependencies ++= Seq(
    "org.webjars" %% "webjars-play" % "2.3.0",
    "org.webjars" % "sockjs-client" % "0.3.4",
    "org.webjars" % "jquery" % "2.1.1"))

lazy val chatWebRTCJs = project.in(file("examples/chat-webrtc/js"))
  .enablePlugins(ScalaJSPlugin)
  .settings((commonSettings ++ scalaJsOfPlayProject(chatWebRTC)): _*)
  .dependsOn(transportJavascript)
  .settings(libraryDependencies ++= Seq(
    "org.scala-lang.modules.scalajs" %%% "scalajs-jquery" % "0.6"))
