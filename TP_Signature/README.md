#TP Signature

##Contexte

Nous allons voir comment générer et utiliser un keystore.

##Initialisation

- Localiser les utilitaires keytool et jarsigner
```
C:\Program Files\<"Emplacement JDK">\<"Version du JDK">\bin
```
- Récupérer le fichier MyApp.apk <a href="./MyApp.apk">suivant</a>. Il est non signé, non zip-aligné.

##Avec Eclipse

###Localiser le keystore de debug

```
Préférences > Android > Build
```
- Les premiers champs affichent le keystore d'Eclipse utilisé en debug pour chaque projet
- Les champs suivants permettent d'ajouter un autre keystore de debug. Nous utiliserons cette fonctionnalité dans le TP sur les Maps

###Créer un autre keystore et signer une application avec

- Clic droit sur un projet
- Android Tools
- Choisir `Export signed Application package`
- Sélectionner le projet
- Choisir `Create new keystore`
- Saisir le mot de passe et et les champs obligatoires
- Valider et attendre la génération de l'apk. Cela prend environ 30 secondes. 

##En ligne de commande

###Créer un keystore
- Executer la commande
```
keytool -genkey -v -keystore NOM_KEYSTORE.keystore -alias NOM_ALIAS -keyalg RSA -keysize 2048 -validity 10000
```
- Saisir un mot de passe pour l'alias
- Renseigner les champs facultatifs
- Retaper le mot de passe

###Signer l'application

- Exécuter la commande sur le fichier .apk récupéré.
```
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore NOM_KEYSTORE.keystore MON_APPLICATION.apk NOM_ALIAS
```

###Vérifier la signature

- Exécuter la commande sur le fichier .apk signé
```
jarsigner -verify -verbose -certs MON_APPLICATION.apk - keystore NOM_KEYSTORE.keystore
```

##Pour aller plus loin : zipalign
Zip-aligner le fichier avec la commande zipalign

##Pour aller plus loin : avec Android Studio
- Suivre les instructions fournies à cette adresse : http://developer.android.com/tools/publishing/app-signing.html#studio