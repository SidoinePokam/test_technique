//////////////////////////////////////////
quelques étapes de test de l'API
/////////////////////////////////////////

l'environnement de test chois est "heroku"

le lien de l'api est : https://crud-app-deploy-sp.herokuapp.com/api/v1/places

Afin de réaliser les tâches, j'ai opté pour les technologies Java et Spring
On demandait une API afin de gérer les lieux
avec les options : "Créer", "Modifier", "Consulter" et "Supprimer"

Je rappelle ici que les paramètres d'un lieu sont : "nom", "ville", "état", "créé le", "mis à jour le"
(tous les paramètres sont nommés en anglais dans le code)

Déjà à la création du projet spring, j'ai opté pour les dépendances : "Spring web", "H2 Database", "Spring data JPA"

Et pour les tests de création, suppression, modification, j'ai utilisé l'outil "Postman"
La suppression et la modification d'un lieu se font grâce à son "id" : 
exemple : https://crud-app-deploy-sp.herokuapp.com/api/v1/places/1

