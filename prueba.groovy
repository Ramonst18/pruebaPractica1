job('practicaPDS1'){
    description('Tarea que nos dejo el profe')
    scm {
        git('https://github.com/Ramonst18/pruebaPractica1.git', '*/main') { node ->
      	    node / gitConfigName('Ramonst18')
      	    node / gitConfigEmail('Ramonst18@hotmail.com')
	      }
    }
    steps {
        shell("/opt/juegoPuertas.sha")
    }
    publishers{
        mailer("ramonlopezpracticas2@gmail.com", true, true)
        mailer("ericaguzmanpdsi@gmail.com", true, true)
        slackNotifier{
            notifyAborted(true)
            notifyEveryFailure(true)
            notifyNotBuilt(true)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(true)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
	      }
    }
}
