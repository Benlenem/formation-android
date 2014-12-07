#TP Webviews

##Contexte

Dans ce TP, nous allons voir les possibilités d'Android pour afficher et intéragir avec du contenu issu du Web !

##Initialisation

1. Créer un nouveau projet Android avec une Activity
2. Changer le layout pour y inclure une webview en plein écran

##Ouverture d'une page distante

1. Accorder la permission pour accéder à internet
2. Utiliser la webview et sa méthode `loadUrl()` pour afficher la page http://officialandroid.blogspot.fr/ ? Que se passe t'il ?
3. Corriger le code précédent pour ouvrir la page proprement dans l'app

##Progression du chargement

1. Ajouter un composant ProgressBar au dessus de la Webview. Il est masqué par défaut.
3. Afficher la progression avec la ProgressBar dès lors que la WebView charge une page
4. Masquer la ProgressBar dès que le chargement est terminé

##Gestion du back

1. Naviguer dans le blog de l'équipe Android
2. Appuyer sur le bouton physique retour. Que se passe t'il ?
3. Gérer l'appui sur le bouton retour pour revenir à la page précédente.
4. Faire en sorte de terminer l'application lorsqu'on est revenu à la première page visitée

##Ouverture d'une page locale

1. Récupérer le code html (index.html) ci-dessous ainsi que <a href="./kitten.jpg">l'image associée</a>.
2. Les placer les dans le répertoire assets du projet.
3. Afficher la page dans la webview
```
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
	
	<figure style ="width:50%;margin:10px;float:left;">
		<img style ="width:100%;" src="./kitten.jpg"/>
		<figcaption>Cliquez pour partager</figcaption>
		</figure>
		<p>
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer aliquam dapibus purus. Pellentesque dolor nisl, hendrerit ut mi id, interdum feugiat felis. Proin hendrerit lacinia eleifend. Suspendisse lorem felis, varius sit amet aliquet nec, posuere quis ante. Donec sagittis pretium sapien. Morbi vehicula in sapien vehicula consectetur. Ut quis ornare magna. Nam ultricies libero nec mi eleifend, nec consectetur metus mollis.
		</p>
		<p>
		Phasellus eget luctus est, eget molestie sem. Maecenas vestibulum feugiat enim, ut finibus erat cursus at. Morbi dui augue, suscipit ut sapien nec, consequat tincidunt mauris. Vestibulum nisi ipsum, commodo quis eros at, porttitor interdum enim. Aenean ultricies nulla ex, sed elementum turpis dictum quis. Proin sed orci mauris. Nunc leo tortor, mattis eu sem nec, finibus porta tellus. Nullam scelerisque ipsum quis dapibus tincidunt. Integer vel maximus metus. Fusce augue arcu, sollicitudin vel enim ac, laoreet mattis mauris. Quisque in ultrices massa. Fusce sed magna vehicula, vulputate odio a, elementum felis. In purus nunc, maximus in volutpat at, tincidunt et orci. Sed libero orci, porttitor suscipit nibh et, tristique vulputate odio. Mauris malesuada consequat hendrerit. Donec est felis, venenatis vel neque pellentesque, faucibus dignissim libero.
		</p>
		<p id="contact_name">Aucun contact</p>
		<p><a href="">Choisir un contact</a></p>
	</body>
</html>
```

##Interactions JS<->Natif
1. Afficher cette page avec la webview
2. Ajouter une <a href="http://developer.android.com/reference/android/webkit/WebView.html#addJavascriptInterface(java.lang.Object, java.lang.String)">interface Javascript</a> à la webview. L'interface doit contenir une méthode public void `doSharing(String toShare){}`.
3. Faire en sorte que cette méthode partage via un Intent la chaine de caractères `toShare`.
4. Modifier le code de la page HTML pour qu'un clic sur l'image déclenche le partage de la chaine 'Un chat!'
5. Tout en bas de la page, se trouve un lien `Choisir un contact`. En utilisant l'attribut href, faire en sorte qu'un clic sur le lien ouvre la page native de sélection d'un contact. Une fois le contact choisi, le label `Aucun contact` est remplacé par le nom du contact choisi.

```
```