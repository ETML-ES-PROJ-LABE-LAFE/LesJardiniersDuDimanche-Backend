# AuctionApp - Backend

//TODO Le but est de favoriser la collaboration. Le readme doit permettre à un développeur de préparer son environnement et de savoir comment s'intégrer à votre équipe.

//TODO Sans le [template livré](https://github.com/NGY-TEMPLATE/MASTER-README) il va vous être difficile de produire le document que j'attends.


## Description

//TODO Le but de cette description est de décrire l'objectif de l'application. Il faut avoir une orientation métier en rédigeant cela.

Ce projet est une application Web en Java Spring Boot qui fournit une API RESTful afin de gérer la vente d'enchères.

L'application inclut les fonctionnalités suivantes :

- Opérations CRUD pour les catégories et les lots
- Gestion des exceptions pour les entités non trouvées
- Chargement initial des données
- Initialisation d'utilisateurs tests. 

## Structure des Fichiers

//TODO tree /f. Ainsi vous aurez la structure "visuelle" et vous n'aurez plus qu'à commenter le schéma.

Le projet est composé des fichiers suivants :

### Configuration
- **CorsConfig.java** : Configuration CORS pour permettre les requêtes cross-origin.

### Contrôleurs
- **CategoryController.java** : Gère les requêtes HTTP pour les catégories.
- **LotController.java** : Gère les requêtes HTTP pour les lots.
- **UserController.java** : Gère les requêtes HTTP pour les utilisateurs.

### Modèles
- **Category.java** : Représente l'entité Catégorie.
- **Lot.java** : Représente l'entité Lot.
- **User.java** : Représente l'entité Utilisateur.

### Répertoires
- **CategoryRepository.java** : Interface pour l'accès aux données des catégories.
- **LotRepository.java** : Interface pour l'accès aux données des lots.
- **UserRepository.java** : Interface pour l'accès aux données des utilisateurs.
- **LoadDatabase.java** : Classe pour charger les données initiales dans la base de données.

### Exceptions
- **CategoryNotFoundException.java** : Exception personnalisée pour catégorie non trouvée.
- **LotNotFoundException.java** : Exception personnalisée pour lot non trouvé.
- **UserNotFoundException.java** : Exception personnalisée pour utilisateur non trouvé.

### Conseils
- **LotNotFoundAdvice.java** : Gestionnaire d'exception pour LotNotFoundException.

### Application Principale
- **AuctionApp.java** : Classe principale pour démarrer l'application Spring Boot.

### Configuration de l'application
- **application.properties** : Fichier de configuration pour l'application Spring Boot.

## Comment Exécuter

//TODO Il est important de ne livrer que l'essentiel. L'url est déjà présent. Ne le répétez pas.
//TODO Nous avons besoin de savoir comment l'exécuter pour le dév, mais aussi pour le déploiement en prod.

1. Clonez le dépôt.
   ```sh
   git clone [URL du dépôt]

2. Assurez-vous d'avoir Java et Maven installés.
   Téléchargez Maven à partir de ce lien :
   ```sh
   https://maven.apache.org/download.cgi 
   
3. Décompressez le fichier téléchargé à l'emplacement souhaité. 
   Ajoutez le chemin bin de Maven aux variables d'environnement. Par exemple :
   ```sh
   C:\Program Files\apache-maven-3.8.6\bin
3. Naviguez jusqu'au répertoire du projet
   ```sh
   cd [nom_du_répertoire choisi]
4. Exécutez l'application AuctionApp avec la commande suivante :
   ```sh
   mvn spring-boot:run
5. Lancer le projet BackEnd avant le projet FrontEnd afin de faire venir les données 
   ```sh
   run AuctionApp
   
