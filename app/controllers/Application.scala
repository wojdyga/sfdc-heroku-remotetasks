package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import play.api.libs.json._

import play.api.data._
import play.api.data.Forms._
import scala.slick.driver.PostgresDriver.simple._
import models.Secret
import models.Secrets
import models.RemoteTask
import models.RemoteTasks

object Application extends Controller {

  case class TaskIds(result: Boolean, error: Option[String], ids: List[Long])
  implicit val TaskIdsFormat = Json.format[TaskIds]

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

  def getTask(id: Long) = Action {
    Ok(views.html.index("GET Task successfull"))
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
*/

