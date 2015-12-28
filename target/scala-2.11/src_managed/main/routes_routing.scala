// @SOURCE:/home/alek/Git/sfdc-heroku-remotetasks/sfdc-heroku-remotetasks/conf/routes
// @HASH:3b54f8c4458c885e71afe5ad2d83390ebdfebeb7
// @DATE:Tue Dec 15 22:24:50 CET 2015


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_postTask1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks"))))
private[this] lazy val controllers_Application_postTask1_invoker = createInvoker(
controllers.Application.postTask,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "postTask", Nil,"POST", """""", Routes.prefix + """tasks"""))
        

// @LINE:8
private[this] lazy val controllers_Application_getAllTaskIds2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/all"))))
private[this] lazy val controllers_Application_getAllTaskIds2_invoker = createInvoker(
controllers.Application.getAllTaskIds,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getAllTaskIds", Nil,"GET", """""", Routes.prefix + """tasks/all"""))
        

// @LINE:9
private[this] lazy val controllers_Application_getTask3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_getTask3_invoker = createInvoker(
controllers.Application.getTask(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getTask", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tasks/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks""","""controllers.Application.postTask"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/all""","""controllers.Application.getAllTaskIds"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>""","""controllers.Application.getTask(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_postTask1_route(params) => {
   call { 
        controllers_Application_postTask1_invoker.call(controllers.Application.postTask)
   }
}
        

// @LINE:8
case controllers_Application_getAllTaskIds2_route(params) => {
   call { 
        controllers_Application_getAllTaskIds2_invoker.call(controllers.Application.getAllTaskIds)
   }
}
        

// @LINE:9
case controllers_Application_getTask3_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_getTask3_invoker.call(controllers.Application.getTask(id))
   }
}
        

// @LINE:12
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     