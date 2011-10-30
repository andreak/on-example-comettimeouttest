package bootstrap.liftweb

import net.liftweb.http._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.common._
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.jquery.JQuery14Artifacts


class Boot {
	def boot() {
		// Do nothing. We don't want Lift to try to mess up our logging. Having log4j.xml in classpath is sufficient
		Logger.setup = Full(() => ())

		LiftRules.addToPackages("no.officenet.example.comettimeouttest")

		LiftRules.ajaxStart =
		      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

		    // Make the spinny image go away when it ends
		    LiftRules.ajaxEnd =
		      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

		LiftRules.ajaxPostTimeout = (5 minutes).toInt

		LiftRules.jsArtifacts = JQuery14Artifacts

	}

}
