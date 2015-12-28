
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object nav extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<nav class="navbar navbar-default navbar-static-top navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
      <li class="active">
        <a href="/"><span class="glyphicon glyphicon-home"></span> Home</a>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-info-sign"></span> Header <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href=""></a></li>
            <li><a href=""></a></li>
          </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="navbar-right">
        <a href="https://www.salesforce.com"><span class="glyphicon glyphicon-book"></span> Salesforce</a>
      </li>
    </ul>
  </div>
</nav>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 15 22:24:51 CET 2015
                  SOURCE: /home/alek/Git/sfdc-heroku-remotetasks/sfdc-heroku-remotetasks/app/views/nav.scala.html
                  HASH: 4bf25065ef5b7a767494beb6170ccee5851b7599
                  MATRIX: 578->0
                  LINES: 22->1
                  -- GENERATED --
              */
          