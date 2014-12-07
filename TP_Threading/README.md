#TP Threading

##Contexte

Nous allons utiliser différentes approches propres à Java et Android afin réaliser une opération coûteuse dans un processus séparé (threading).

##Initialisation

- Depuis Eclipse, créer un projet simple avec une Activity.
- Sur l'écran principal, ajouter
  - une ProgressBar infinie
  - deux TextView

<img src="thread.png" width="200px"/>

- Récupérer la classe <a href="Prime.java">Prime</a>. Sa méthode statique `public static int compute50000th(PrimeListener listener)` réalise une opération longue : elle calcule naïvement le 50000 ème nombre premier. D'ailleurs, ce n'est pas un secret, c'est 611253 ! Le `PrimeListener` passé en paramètre recoit des notifications lorsque le calcul avance de 5% en 5%.
- L'idée va être de lancer le calcul du nombre premier tout en gardant l'interface réactive (i.e. pas de saccades lorsque la ProgressBar tourne). Le premier TextView va afficher l'avancement du calcul tandis que le second va afficher le résultat final.

##Calcul sur le thread UI
- Lancer le calcul sur le thread principal
- Ne pas oublier d'afficher la progression du calcul et le résultat final
- Exécuter l'application
- Appuyer sur le bouton back pendant le calcul. Que se passe t'il ?

##Calcul avec un thread
- Lancer le calcul avec une instance de `Thread`

##Calcul avec un Executor
- Lancer le calcul avec un `Executor`

##Calcul avec une AsyncTask
- Lancer le calcul avec une `AsyncTask<Void, Integer, Integer>`

##Pour aller plus loin
- Lancer le calcul depuis un `Service`. Ce dernier notifie l'Activity appelante en envoyant un broadcast depuis le `LocalBroadcastManager`.

