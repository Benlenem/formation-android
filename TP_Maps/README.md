#TP Maps

##Contexte

Dans ce TP, nous allons voir les possibilités qu'offre Android en terme de cartographie !

<img src="map.png" width="200px"/>

##Initialisation

Note : les instructions que nous allons suivre sont toutes détaillées dans la documentation officielle <a href="http://developer.android.com/google/play-services/setup.html">ici</a>, et <a href="https://developers.google.com/maps/documentation/android/start#installing_the_google_maps_android_v2_api">ici</a>

1. Créer un nouveau projet Android avec une Activity. Le package name doit <b>absolument</b> être `fr.cleverage.formation.maps`
2. Importer le projet google-play-services_lib qui se trouve dans votre SDK (extras/google/google_play_services/libproject/google-play-services_lib)
3. L'inclure comme bibliothèque utilisée par le projet
4. Configurer Eclipse pour utiliser le keystore de debug <a href="./maps_debug.keystore">suivant</a>.
5. Rajouter les informations suivantes au manifeste 
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

<meta-data
    android:name="com.google.android.gms.version"
    android:value="@integer/google_play_services_version" />
<meta-data
    android:name="com.google.android.maps.v2.API_KEY"
    android:value="AIzaSyB8T3XqnVbVm5Ne9rAOIBb0Vc_7dIva2fA" />
```
4. Dans le layout de la page, ajouter un SupportMapFragment
5. Lancer l'application
6. Prier pour que la carte s'affiche après toute cette configuration !

##Affichage des marqueurs et des lignes
1. Copier le fichier <a href="locations.json">suivant</a> dans le répertoire `raw` des ressources. Il contient une liste de quelques étapes du Tour de France 2014.
2. Récupérez les icones <a href="./res/">suivantes</a> et les placer dans les ressources.
3. Pour chaque étape du tour
  - afficher un marqueur vert pour le départ et un marqueur bleu pour l'arrivée
  - tracer un trait entre les deux marqueurs d'une étape

##Géolocalisation

<img src="geoloc.png" width="200px"/>

###Préambule
Il existe deux méthodes pour récupérer la position du terminal. Google encourage maintenant la plus récente qui utilise les GooglePlayServices.

Nous allons implémenter les deux façons de faire au travers de la petite interface suivante :
```
import android.location.Location;

public interface LocationSource {
    public static interface LocationSourceListener{
        public void newLocation(Location location); 
    }
    public abstract void connect(LocationSourceListener listener);   
    public abstract void disconnect();
}
```

###Méthode traditionnelle : android.location.LocationManager
1. Récupérer la géolocalisation du terminal en se servant du `LocationManager`. Attention aux permissions dans le Manifest !
2. Ecouter à la fois les mises à jour de la position depuis le réseau et le GPS. Pour cela utiliser un `LocationListener` dans les méthodes `onResume()` et `onPause()`
3. Afficher un marqueur personnalisé avec une infobulle "Ma position !" 

###Nouvelle méthode : com.google.android.gms.location.LocationClient
1. Récupérer la géolocalisation du terminal en se servant du `LocationClient`. Attention aux permissions dans le Manifest !
2. Ecouter à la fois les mises à jour de la position. Pour cela utiliser un `LocationListener` dans les méthodes `onResume()` et `onPause()`
3. Afficher un marqueur personnalisé avec une infobulle "Ma position !" 




##Pour aller plus loin
Modifier l'`InfoWindow` affichée au clic sur un `Marker` . Y faire apparaitre les informations "Départ" ou "Arrivée" en fonction du type ainsi que le nom de la ville.

<img src="custom.png" width="200px"/>