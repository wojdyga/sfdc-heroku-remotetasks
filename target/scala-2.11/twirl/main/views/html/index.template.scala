
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("GettingStarted")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""

"""),format.raw/*5.1*/("""<div class="jumbotron text-center">
  <div class="container">
    <a href="/" class="lang-logo">
      <img src=""""),_display_(/*8.18*/routes/*8.24*/.Assets.at("images/lang-logo.png")),format.raw/*8.58*/("""">
    </a>
    <h1>Remote Tasks</h1>
  </div>
</div>
<div class="container">
   <div class="alert alert-info text-center" role="alert">
    Connect to this app from your SFDC org
  </div>
  """),_display_(/*17.4*/if(message != null)/*17.23*/{_display_(Seq[Any](format.raw/*17.24*/("""
  """),format.raw/*18.3*/("""<div class="alert alert-success text-center" role="alert">
    """),_display_(/*19.6*/message),format.raw/*19.13*/("""
  """),format.raw/*20.3*/("""</div>
  """)))}),format.raw/*21.4*/("""
"""),format.raw/*22.1*/("""</div>

""")))}),format.raw/*24.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 15 22:24:51 CET 2015
                  SOURCE: /home/alek/Git/sfdc-heroku-remotetasks/sfdc-heroku-remotetasks/app/views/index.scala.html
                  HASH: 18219a8794cd61aca20c5c77679a8cf364d763a8
                  MATRIX: 505->1|610->18|638->21|668->43|707->45|735->47|875->161|889->167|943->201|1161->393|1189->412|1228->413|1258->416|1348->480|1376->487|1406->490|1446->500|1474->501|1513->510
                  LINES: 19->1|22->1|24->3|24->3|24->3|26->5|29->8|29->8|29->8|38->17|38->17|38->17|39->18|40->19|40->19|41->20|42->21|43->22|45->24
                  -- GENERATED --
              */
          