package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.Play.current
import play.api.data.Forms._
import java.sql.Timestamp

case class RemoteTask(id: Long, url: String, created: Option[Timestamp] = None, resolved: Option[Timestamp] = None, isResolved: Option[Boolean], clientSecret: String)
class RemoteTasks(tag: Tag) extends Table[RemoteTask](tag, "remotetask") {
  def id = column[Long]("id", O.NotNull)
  def url = column[String]("url", O.NotNull)
  def created = column[Timestamp]("created")
  def resolved = column[Timestamp]("resolved")
  def isResolved = column[Boolean]("isresolved")
  def clientSecret = column[String]("clientsecret", O.NotNull)
  // the * projection (e.g. select * ...) auto-transforms the tupled
  // column values to / from a User
  def * = (id, url, created.?, resolved.?, isResolved.?, clientSecret) <> (RemoteTask.tupled, RemoteTask.unapply)
}

object RemoteTasks {
  val db = play.api.db.slick.DB
  val remoteTasks = TableQuery[RemoteTasks]

  def find(secret: String): Seq[RemoteTask] = db.withSession{ implicit session =>
    remoteTasks.filter(_.clientSecret === secret).run
  }
}