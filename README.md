ShapeServer
===========

Service sur le port TCP 10000 qui répond à deux commandes:


## Commandes

### GET

Demander les spécifications d'une forme géométrique.

````
GET
````

### END

Demander de fermer la connexion.

````
END
````

## Réponses

Renvoie les spécifications d'une forme lorsque la commande `GET` est reçue:

````
00000 <FORME> x1 y1 x2 y2 COULEUR </FORME>
````

### Formes et coordonnées

Le champ `FORME` prend une des valeurs suivantes:

* `CARRE`: `x1, y1, x2, y2`. Les coordonnées du point supérieur gauche `x1, y1`, et du point inférieur droit `x2, y2`.
* `RECTANGLE`: `x1, y1, x2, y2`. Les coordonnées du point supérieur gauche `x1, y1`, et du point inférieur droit `x2, y2`.
* `ELLIPSE`: `cx, cy, w, h`. Les coordonnées du point central `cx, cy`, de la largeur `w` et de la hauteur `h`.
* `CERCLE`: `cx, cy, r`. Les coordonnées du point central `cx, cy` et du rayon `r`.
* `LIGNE`: `x1, y1, x2, y2`: Les coordonnées du point de départ `x1, y1`, et du point d'arrivée `x2, y2`.

### Couleur

* ROUGE
* VERT
* BLEU
* JAUNE
* ORANGE
* GRIS
* NOIR
* BLANC
