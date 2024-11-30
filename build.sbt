import org.scalajs.linker.interface.{ModuleKind, ModuleSplitStyle}

val scala3Version = "3.5.2"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    name := "$name$",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "testvite" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("$name$")))
    },

    libraryDependencies += "com.raquo" %%% "laminar" % "17.0.0",
  )
