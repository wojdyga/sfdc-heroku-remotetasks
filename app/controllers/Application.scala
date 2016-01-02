package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import play.api.data._
import play.api.data.Forms._
import scala.slick.driver.PostgresDriver.simple._
import models.Secret
import models.Secrets

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(null))
  }

  def postTask = Action {
    Ok(views.html.index("POST Task successfull"))
  }

  def getAllTaskIds = Action { request =>
    request.headers.get("secret").map { secret =>
      Secrets.find(secret) match {
        case Some(s) => Ok("Hello " + s.description)
        case None => NotFound("No such secret")
      }
    }.getOrElse {
      Unauthorized("No secret given")
    }
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
      stmt.executeUpdate("CREATE TABLE RemoteTask (URL VARCHAR(2000) NOT NULL, Created TIMESTAMP, Resolved TIMESTAMP, IsResolved BOOLEAN, ClientSecret VARCHAR(256) REFERENCES Secrets(ClientSecret))")
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
URL VARCHAR(2000) NOT NULL,
Created TIMESTAMP,
Resolved TIMESTAMP,
IsResolved BOOLEAN,
ClientSecret VARCHAR(256) REFERENCES Secrets(ClientSecret)
);

INSERT INTO Secrets VALUES('test-1234', 'Test description for a test secret');
*/

