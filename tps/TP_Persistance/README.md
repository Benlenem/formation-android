#TP Persistance

##Contexte

Nous allons réutiliser l'application créée au TP précédent et y ajouter une persistance de données.

##Initialisation

1. Depuis Eclipse, copier le projet précédent
2. Ne garder que les appels réseaux faits avec Retrofit ainsi que la communication via EventBus.
3. Créer une interface `Storage`. Toutes nos prochaines classes vont l'implémenter.
```
public interface Storage {
	public void store(List<Repository> repositories);
	public List<Repository> retrieve();
}
```
4. Modifier le `GithubApimanager` pour
  - qu'il accepte une instance de `Storage` dans son constructeur
  - qu'il maintienne un cache persistant grâce à ce `Storage`

##Persistance avec SharedPreferences

1. Créer une classe de persistance qui utilise les SharedPreferences et qui implémente Storage
2. Tester en mode avion et en éteignant / réouvrant l'application. Sympathique non ?!

##Persistance avec stockage interne

1. Créer une classe de persistance qui utilise le stockage interne du téléphone et qui implémente Storage. La classe Context vous fournit des méthodes pratiques pour le stockage dans des fichiers.
2. Tester votre application

##Persistance avec stockage externe

1. Créer une classe de persistance qui utilise le stockage externe du téléphone et qui implémente Storage. La classe Context vous fournit des méthodes pratiques pour le stockage sur la méoire externe.
2. Passez en debug pour trouver l'URI du fichier édité sur la carte externe. (exemple : 
/storage/emulated/0/Android/data/fr.cleverage.formation.databases/files)
3. Retrouvez et ouvrez ce fichier depuis un navigateur Android (ex: Astro) ou votre ordinateur

##Persistance avec SQLiteOpenHelper

1. Créer une classe de persistance qui étend SQLiteOpenHelper et qui implémente Storage. 
2. Tester votre application
3. Rajouter une transaction pour sécuriser les insertions

##Pour aller plus loin

###Persistance avec un ORM : GreenDao

1. Créer un projet Java standard
2. Y inclure le <a href="http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.greenrobot%22%20AND%20a%3A%22greendao-generator%22">jar du générateur de GreenDao 1.3.1</a> et le <a href="http://freemarker.org/freemarkerdownload.html">jar de la bibliothèque freemarker</a>. 
3. Créez votre schéma de base en y ajoutant une entité GithubRepo. Elle contient les champs `repoId`, `name`, `fullName`, `ownerName`
4. Générez les 4 classes `DaoMaster`, `DaoSession`, `GithubRepo`, `GithubRepoDao`
5. Copiez ces classes dans votre projet Android.
6. Ca ne compile pas, c'est normal il manque le <a href="http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.greenrobot%22%20AND%20a%3A%22greendao%22">jar de Greendao</a> ! Ajoutez le. 
7. Créer une classe de persistance qui utilise les classes générées de GreenDao et qui implémente Storage. 
8. Tester votre application


