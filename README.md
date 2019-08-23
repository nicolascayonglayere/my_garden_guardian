# my_garden_guardian

Cette application propose une gestion de jardins collectifs. Pour plus de détails concernant les fonctionnalités, merci de vous réferrer au fichier

```Description_user_story.md```

présent dans ce repository.

Ce projet est une application web écrite en Java.

## Getting Started

Cette section vous explique comment récupérer le projet et comment l'installer sur votre machine à des fins de développement ou de tests.
Merci de consulter la section "Déploiement" pour voir comment déployer l'application sur un serveur.

### Prérequis

Vous avez besoin de java version 1.8. : [java](https://www.java.com/fr/download/manual.jsp) (Si vous utilisez Windows, veuillez télécharger la version Hors Ligne).
Vous aurez aussi besoin de Maven pour compiler les sources du projet : [maven](https://maven.apache.org/download.cgi)
Enfin, si vous souhaitez utiliser le fichier ```docker-compose.yml``` pour tester le déploiement, vous aurez besoin de Docker : [docker](https://hub.docker.com/)

### Installation

* cloner le projet depuis ce repository gitHub
* compiler les sources du projet : ```mvn clean package```
* déploiement

## Tests

Si vous souhaitez éxecuter les tests il vous suffit de compiler le projet avec la commande :
```mvn clean verify```

## Déploiement

### En local

Pour déployer l'application sur votre serveur local :

* Compiler les sources du projet : ```mvn clean package```
* Exécuter la commande suivante : ```java -jar my_garden_gardian_[version]-RELEASE.jar```
* Ouvir votre naviagteur avec l'url : ```http:\\localhost:8181\login```

### Avec Docker

Pour déployer avec Docker :

* Compiler les sources du projet : ```mvn clean package```
* Exécuter la commande suivante : ```docker-compose up```
* Ouvir votre naviagteur avec l'url : ```http:\\localhost:8181\login```

## Contribuer

Merci de lire le fichier ```contribuer.md```

## Auteur

Nicolas CAYON-GLAYERE [nicolas.cayon.glayerer@gmail.com](nicolas.cayon.glayerer@gmail.com)
