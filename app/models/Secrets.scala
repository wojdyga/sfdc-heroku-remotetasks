package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.Play.current
import play.api.data.Forms._
case class Secret(clientSecret: String, description: Option[String] = None)
class Secrets(tag: Tag) extends Table[Secret](tag, "secrets") {
  def clientSecret = column[String]("clientsecret", O.NotNull)
  def description = column[String]("description")
  // the * projection (e.g. select * ...) auto-transforms the tupled
  // column values to / from a User
  def * = (clientSecret, description.?) <> (Secret.tupled, Secret.unapply)
}

object Secrets {
  val db = play.api.db.slick.DB
  val secrets = TableQuery[Secrets]

  def find(secret: String): Option[Secret] = db.withSession{ implicit session =>
    secrets.filter(_.clientSecret === secret).firstOption
  }
}