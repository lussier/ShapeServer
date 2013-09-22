ShapeServer
===========

Service qui répond à deux commandes sur le port TCP 10000.


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
ID <FORME> COORDONNÉES COULEUR </FORME>
````

### ID

Le `ID` est un champ numérique compris entre 0 et 99999 utilisé pour la correction des travaux.

### Formes et coordonnées

Le champ `FORME` prend une des valeurs suivantes, associée à des `COORDONNÉES`:

* `CARRE`: `x1, y1, x2, y2`.
    Les coordonnées du point supérieur gauche `x1, y1`, et du point inférieur droit `x2, y2`.
* `RECTANGLE`: `x1, y1, x2, y2`. 
    Les coordonnées du point supérieur gauche `x1, y1`, et du point inférieur droit `x2, y2`.
* `ELLIPSE`: `cx, cy, w, h`. 
    Les coordonnées du point central `cx, cy`, de la largeur `w` et de la hauteur `h`.
* `CERCLE`: `cx, cy, r`. 
    Les coordonnées du point central `cx, cy` et du rayon `r`.
* `LIGNE`: `x1, y1, x2, y2`:
    Les coordonnées du point de départ `x1, y1`, et du point d'arrivée `x2, y2`.

### Couleurs

Les valeurs que peut prendre le champ `COULEUR` sont:

* `ROUGE`
* `VERT`
* `BLEU`
* `JAUNE`
* `ORANGE`
* `GRIS`
* `NOIR`
* `BLANC`

### Exemple de réponse

Carré de couleur rouge dont le coin supérieur gauche est au point (10,15) et le point inférieur droit au point (100,150).

````
12345 <RECTANGLE> 10 15 100 150 ROUGE </RECTANGLE>
````


