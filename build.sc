import $ivy.`com.disneystreaming.smithy4s::smithy4s-mill-codegen-plugin::0.18.20`

import smithy4s.codegen.mill._

import mill._, mill.scalalib._

object Config {
  val smithy4sVersion = smithy4s.codegen.BuildInfo.version

  def sharedDependencies = Agg(
    ivy"com.disneystreaming.smithy4s::smithy4s-core::${smithy4sVersion}",
    ivy"com.disneystreaming.smithy4s::smithy4s-http4s::${smithy4sVersion}",
  )
}

object shared extends ScalaModule with Smithy4sModule {
    def scalaVersion = "3.4.2"
    override def ivyDeps = super.ivyDeps() ++ Config.sharedDependencies

}
