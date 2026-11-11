# TP Thermo 2 — application Android

Conception : Pr Hicham MESBAH

Simulation 3D des TP Thermodynamique 2 (SMP3, FS Agadir) : dilatation thermique et pompe à chaleur.
L'application affiche `app/src/main/assets/index.html` dans une WebView.

## Ouvrir et lancer
1. Android Studio → **File › Open** → choisir le dossier `BancThermo2`.
2. Laisser Gradle se synchroniser (connexion Internet nécessaire la première fois).
3. Brancher un téléphone (débogage USB activé) ou lancer un émulateur, puis **Run ▶**.

## Générer l'APK à installer sur les téléphones
**Build › Build Bundle(s) / APK(s) › Build APK(s)**, puis « locate ».
Fichier : `app/build/outputs/apk/debug/app-debug.apk` (à envoyer aux étudiants, installation « sources inconnues »).

## Fonctionnement hors connexion
Copier `three.min.js` et `OrbitControls.js` dans `app/src/main/assets/js/` (voir `LISEZ-MOI.txt` dans ce dossier).

## Modifier la simulation
Tout est dans `app/src/main/assets/index.html` (même fichier que la version HTML).

## Compiler l'APK avec GitHub (sans Android Studio)
1. Créer un dépôt GitHub et y envoyer le **contenu** de ce dossier (le fichier `settings.gradle.kts` et le dossier `.github` doivent être à la racine du dépôt).
2. Onglet **Actions** → « Build APK » se lance tout seul (ou bouton **Run workflow**).
3. Quand le rond devient vert ✔, ouvrir l'exécution → section **Artifacts** → télécharger `TP-Thermo2-APK` (un zip qui contient `app-debug.apk`).
