# Projet Technique de Tests : Pokedex API

## Informations personnelles

- **Nom** : Beye
- **Prénom** : Ndeye
- **Groupe** : Master 1 ILSEN classique, groupe 1

---

## Badges

- [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Ndeye-Beye/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Ndeye-Beye/ceri-m1-techniques-de-test/tree/master)
- [![codecov](https://codecov.io/gh/Ndeye-Beye/ceri-m1-techniques-de-test/graph/badge.svg?token=HPB0N67IYG)](https://codecov.io/gh/Ndeye-Beye/ceri-m1-techniques-de-test)

---

## Description du Projet

Ce projet a pour objectif de vous initier aux différentes **techniques de tests** utilisées en génie logiciel, en réalisant une application logicielle simple.  
À travers une série de travaux pratiques, nous apprendrons à :

- Configurer un environnement de développement ;
- Intégrer des outils d'intégration continue ;
- Écrire et valider des tests unitaires ;
- Utiliser des mocks pour simuler des comportements complexes.

Nous appliquerons également le **développement orienté par les tests (TDD)**, rédigerons une documentation claire, suivrons des conventions de style, et testerons des implémentations existantes pour assurer la qualité et la robustesse du code.  
Ce projet mettra en œuvre des outils modernes tels que **Git**, **Maven**, **CircleCI** et **Codecov**, afin de nous familiariser avec les meilleures pratiques de développement logiciel.

---

## Choix Techniques

Le projet repose sur des choix techniques adaptés pour garantir la qualité et la robustesse du code :

### Langage et Frameworks

1. **Langage** :
   - **Java** : Choisi pour sa robustesse et son écosystème riche.

2. **Build et Dépendances** :
   - **Maven** : Pour une gestion centralisée des dépendances et des builds.

3. **Intégration Continue** :
   - **CircleCI** : Automatisation des tests et validations après chaque commit.

4. **Couverture de Tests** :
   - **JaCoCo** : Pour mesurer la couverture des tests, générer des rapports détaillés, et identifier les parties du code couvertes.
   - **Codecov** : Pour héberger et visualiser les rapports de couverture en ligne.

5. **Tests Unitaires et Mocks** :
   - **JUnit** : Pour écrire les tests unitaires.
   - **Mockito** : Pour créer des mocks et simuler des dépendances externes.

6. **Gestion des Versions** :
   - **Git** : Pour le contrôle de version.
   - **GitHub** : Pour l’hébergement du code et la collaboration.

---

## Structure du Projet

Voici la structure des principaux répertoires du projet :

- **src/main/java** : Contient le code source principal de l'application.
- **src/test/java** : Contient les tests unitaires pour le projet.
- **target/site/jacoco** : Répertoire généré contenant les rapports de couverture JaCoCo.
- **target/site/surefire-reports** : Répertoire généré contenant les rapports de tests Maven Surefire.

---

## Objectifs des Travaux Pratiques

Le projet est divisé en plusieurs travaux pratiques pour couvrir les étapes clés du développement logiciel avec tests :

1. **TP1 : Setup du projet**
   - Initialisation du dépôt Git et configuration de Maven.

2. **TP2 : Intégration Continue**
   - Configuration de CircleCI et intégration avec Codecov.

3. **TP3 : Écriture des tests unitaires**
   - Création de tests couvrant les interfaces principales.

4. **TP4 : Validation avec Mocks**
   - Utilisation de Mockito pour simuler des comportements complexes.

5. **TP5 : Documentation et Style**
   - Génération de la Javadoc et suivi des conventions Checkstyle.

6. **TP6 : Finalisation**
   - Validation de la couverture, revue du code, et présentation des résultats.

---

## Liens Utiles

- [Documentation CircleCI](https://circleci.com/docs/)
- [Documentation Codecov](https://docs.codecov.com/)
- [Guide JaCoCo](https://www.eclemma.org/jacoco/)
- [Mockito](https://site.mockito.org/)
- [JUnit 5](https://junit.org/junit5/)

---

**Auteur** : Ndeye Beye  
**Groupe** : Master 1 ILSEN classique, groupe 1  
