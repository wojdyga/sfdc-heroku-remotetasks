package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.Play.current
import play.api.data.Forms._
case class Secret(clientSecret: String, description: Option[String] = None)
class Secrets(tag: Tag) extends Table[Secret](tag, "SECRETS") {
  def clientSecret = column[String]("ClientSecret", O.NotNull)
  def description = column[String]("Description")
  // the * projection (e.g. select * ...) auto-transforms the tupled
  // column values to / from a User
  def * = (clientSecret, description.?) <> (User.tupled, User.unapply)
}

object Secrets {
  val db = play.api.db.slick.DB
  val secrets = TableQuery[Secrets]

  def find(secret: String): Secret= db.withSession{ implicit session =>
    secrets.filter(_.clientSecret === secret).first
  }
}