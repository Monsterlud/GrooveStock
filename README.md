![groovestock applogo](images/groovestock_applogo.png)
# GrooveStock
GrooveStock is a simple, clean app to keep track of your vinyl, cd's, cassettes, & mp3's. This app is being built in stages to showcase various libraries and frameworks. Each stage will add additional functionality to the application.

## Design & Navigation.
![groovestock wireframe](images/groovestock_wireframe.png)
The basic navigational flow of the app is simple: after the user logs in they are taken to the AlbumList view of their music collection. There they can add additional items to their collection by tapping the add button (not shown here). The AlbumDetail page allows the user to edit properties such as album release date, label, media, etc. An appbar-level button will allow the user to quickly find out which record stores are in their vicinity. This will be added at a later stage.

This app uses a single Activity with three Fragments that get swapped out within a single Fragment Container. The Jetpack Navigation Graph, NavHost, and NavController were used to achieve this functionality.

## User Interface.
![groovestock material themes](images/groovestock_materialthemes.png) ![groovestock_color demo](images/groovestock_materialdemo.png)

Google's Material Design is the main guiding force behind all design UI decisions. Here is the process of choosing color palettes.

## Stage One.
In this stage I am building the basic skeleton of the app: Model, UI, XML layouts, Activities, Fragments, ViewModels, and Adapters. 


![groovestock architecture](images/groovestock_architecture.png)


