package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import play.api.libs.json._
import play.api.libs.functional.syntax._

import play.api.data._
import play.api.data.Forms._
import scala.slick.driver.PostgresDriver.simple._
import models.Secret
import models.Secrets
import models.RemoteTask
import models.RemoteTasks

import java.sql.Timestamp

object Application extends Controller {

  case class TaskIds(result: Boolean, error: Option[String], ids: List[Long])
  implicit val TaskIdsFormat = Json.format[TaskIds]

  case class TaskReply(result: Boolean, error: Option[String], task: Option[RemoteTask])
  implicit val rds: Reads[Timestamp] = (__ \ "time").read[Long].map{ long => new Timestamp(long) }
  implicit val wrs: Writes[Timestamp] = (__ \ "time").write[Long].contramap{ (a: Timestamp) => a.getTime }
  implicit val fmt: Format[Timestamp] = Format(rds, wrs)

  implicit val RemoteTaskFormat = Json.format[RemoteTask]
  implicit val TaskReplyFormat = Json.format[TaskReply]

  def index = Action {
    Ok(views.html.index(null))
  }

  def postTask = Action {
    Ok(views.html.index("POST Task successfull"))
  }

  def getAllTaskIds = Action { request =>
    request.headers.get("secret").map(secret =>
      Secrets.find(secret).map { s =>
        Ok(Json.toJson(TaskIds(true, None, RemoteTasks.find(secret).map(t => t.id).toList)))
      }.getOrElse(NotFound(Json.toJson(TaskIds(false, Some("No such secret"), List()))))
    ).getOrElse (Unauthorized(Json.toJson(TaskIds(false, Some("No secret given"), List()))))
  }

  def getTask(id: Long) = Action { request =>
    request.headers.get("secret").map(secret =>
      RemoteTasks.get(secret, id).map( task =>
        Ok(Json.toJson(TaskReply(true, None, Some(task))))
      ).getOrElse(NotFound(Json.toJson(TaskReply(false, Some(s"No task found for id $id"), None))))
    ).getOrElse (Unauthorized(Json.toJson(TaskReply(false, Some("No secret given"), None))))
  }

  def db = Action {
    var out = ""
    val conn = DB.getConnection()
    try {
      val stmt = conn.createStatement

      stmt.executeUpdate("CREATE TABLE Secrets (ClientSecret VARCHAR(256) UNIQUE NOT NULL, Description VARCHAR(1000) NOT NULL)")
      stmt.executeUpdate("CREATE TABLE RemoteTask (ID SERIAL PRIMARY KEY, URL VARCHAR(2000) NOT NULL, Created TIMESTAMP, Resolved TIMESTAMP, IsResolved BOOLEAN, ClientSecret VARCHAR(256) REFERENCES Secrets(ClientSecret))")
    } finally {
      conn.close()
    }
    Ok(out)
  }
}
/*
CREATE TABLE Secrets (
ClientSecret VARCHAR(256) UNIQUE NOT NULL,
Description VARCHAR(1000) NOT NULL
);

CREATE TABLE RemoteTask (
ID SERIAL PRIMARY KEY,
URL VARCHAR(2000) NOT NULL,
Created TIMESTAMP,
Resolved TIMESTAMP,
IsResolved BOOLEAN,
ClientSecret VARCHAR(256) REFERENCES Secrets(ClientSecret)
);

INSERT INTO Secrets VALUES('test-1234', 'Test description for a test secret');

INSERT INTO RemoteTask(URL,Created,ClientSecret) VALUES ('https://www.apache.org/', NOW(), '1234-test');
INSERT INTO RemoteTask(URL,Created,ClientSecret) VALUES ('https://www.google.com/', NOW(), '1234-test');
*/

