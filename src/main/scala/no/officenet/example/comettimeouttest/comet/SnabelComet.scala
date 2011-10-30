package no.officenet.example.comettimeouttest.comet

import net.liftweb._
import util._
import util.Helpers._
import http.js._
import http.js.JsCmds._
import actor.LiftActor
import java.util.Date
import net.liftweb.http.{SHtml, CometActor, ListenerManager}
import xml.Text


case class SnabelMessage(name: String)

class SnabelComet extends CometActor {

	def render = {
		".stuff *" #> new Date().toString &
		".click" #> SHtml.a(() => {
			Thread.sleep(6000L)
			Alert("Woke up!")
		}, Text("Click here")
		)
	}
}

object SnabelCometServer extends LiftActor with ListenerManager {

	protected def createUpdate = {
		SnabelMessage("Fisk")
	}

}