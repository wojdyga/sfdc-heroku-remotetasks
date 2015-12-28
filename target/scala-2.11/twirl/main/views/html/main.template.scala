
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <title>Remote Tasks</title>
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*12.55*/routes/*12.61*/.Assets.at("stylesheets/main.css")),format.raw/*12.95*/("""" />
    </head>
    <body>
        """),_display_(/*15.10*/nav()),format.raw/*15.15*/("""
        """),_display_(/*16.10*/content),format.raw/*16.17*/("""
    """),format.raw/*17.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 15 22:24:51 CET 2015
                  SOURCE: /home/alek/Git/sfdc-heroku-remotetasks/sfdc-heroku-remotetasks/app/views/main.scala.html
                  HASH: 4991b905f48c51782663dd58045d08d67e2b9bc6
                  MATRIX: 509->1|627->31|655->33|732->84|757->89|1218->523|1233->529|1288->563|1352->600|1378->605|1415->615|1443->622|1475->627
                  LINES: 19->1|22->1|24->3|28->7|28->7|33->12|33->12|33->12|36->15|36->15|37->16|37->16|38->17
                  -- GENERATED --
              */
          